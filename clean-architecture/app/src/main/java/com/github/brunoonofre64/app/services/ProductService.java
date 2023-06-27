package com.github.brunoonofre64.app.services;

import com.github.brunoonofre64.app.dtos.ProductDTO;
import com.github.brunoonofre64.app.enums.ErrorAppMessage;
import com.github.brunoonofre64.app.interfaces.IProductService;
import com.github.brunoonofre64.app.mappers.ProductAppMapper;
import com.github.brunoonofre64.app.validations.AppExceptionValidations;
import com.github.brunoonofre64.domain.entities.Category;
import com.github.brunoonofre64.domain.entities.Product;
import com.github.brunoonofre64.domain.interfaces.ICategoryRepository;
import com.github.brunoonofre64.domain.interfaces.IProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService implements IProductService {

    private final IProductRepository productRepository;
    private final ICategoryRepository categoryRepository;
    private final ProductAppMapper productAppMapper;

    public ProductService(IProductRepository productRepository, ICategoryRepository categoryRepository,
                          ProductAppMapper productAppMapper) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
        this.productAppMapper = productAppMapper;
    }

    @Override
    public ProductDTO save(ProductDTO dto) {
        AppExceptionValidations.when(dto == null,
                ErrorAppMessage.OBJECT_NULL);

        Product product = productAppMapper.toDomain(dto);

        Category category = categoryRepository.findByUuid(dto.getCategoryUuid())
                .orElseThrow(() -> new AppExceptionValidations(ErrorAppMessage.CATEGORY_NOT_FOUND));

        product.setCategory(category);
        product = productRepository.save(product);

        return productAppMapper.toDTO(product, product.getCategory());
    }

    @Override
    public List<ProductDTO> findAll() {
        List<Product> products = productRepository.findAll();

        AppExceptionValidations.when(products.isEmpty(), ErrorAppMessage.PRODUCTS_LIST_IS_EMPTY);

        return products
                .stream()
                .map(product -> productAppMapper.toDTO(product, product.getCategory()))
                .collect(Collectors.toList());
    }

    @Override
    public ProductDTO update(String uuid, ProductDTO dto) {
        AppExceptionValidations.when(dto == null, ErrorAppMessage.OBJECT_NULL);

        Product product = productRepository.findByUuid(uuid)
                .orElseThrow(() -> new AppExceptionValidations(ErrorAppMessage.PRODUCT_NOT_FOUND));

        Category category = null;
        if (dto.getCategoryUuid() != null) {
            category = categoryRepository.findByUuid(dto.getCategoryUuid())
                    .orElseThrow(() -> new AppExceptionValidations(ErrorAppMessage.CATEGORY_NOT_FOUND));

            product.setCategory(category);
        }

        product.update(
                dto.getName(),
                dto.getDescription(),
                dto.getPrice(),
                dto.getStock(),
                dto.getImage(),
                category);

        product = productRepository.save(product);

        return productAppMapper.toDTO(product, product.getCategory());
    }

    @Override
    public void deleteByUuid(String uuid) {
        try {
            productRepository.deleteByUuid(uuid);
        } catch (Exception ex) {
            throw new AppExceptionValidations(ErrorAppMessage.PRODUCT_NOT_FOUND);
        }
    }

    @Override
    public ProductDTO findByUuid(String uuid) {
        Product product = productRepository.findByUuid(uuid)
                .orElseThrow(() -> new AppExceptionValidations(ErrorAppMessage.PRODUCT_NOT_FOUND));

         return productAppMapper.toDTO(product, product.getCategory());
    }
}
