package com.github.brunoonofre64.app.services;

import com.github.brunoonofre64.app.dtos.ProductDTO;
import com.github.brunoonofre64.app.enums.ErrorAppMessage;
import com.github.brunoonofre64.app.interfaces.IProductService;
import com.github.brunoonofre64.app.mappers.ProductMapper;
import com.github.brunoonofre64.app.validations.AppExceptionValidations;
import com.github.brunoonofre64.domain.entities.Product;
import com.github.brunoonofre64.domain.interfaces.IProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService implements IProductService {

    private IProductRepository productRepository;
    private ProductMapper productMapper;

    public ProductService(IProductRepository productRepository, ProductMapper productMapper) {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
    }

    public ProductService() {
    }

    @Override
    public ProductDTO save(ProductDTO dto) {
        AppExceptionValidations.when(dto == null,
                ErrorAppMessage.OBJECT_NULL);

        Product product = productMapper.toDomain(dto);

        productRepository.save(product);

        return productMapper.toDTO(product);
    }

    @Override
    public List<ProductDTO> findAll() {
        List<Product> products = productRepository.findAll();

        AppExceptionValidations.when(products.isEmpty(), ErrorAppMessage.PRODUCTS_LIST_IS_EMPTY);

        return products
                .stream()
                .map(product -> productMapper.toDTO(product))
                .collect(Collectors.toList());
    }

    @Override
    public ProductDTO update(String uuid, ProductDTO dto) {
        AppExceptionValidations.when(dto == null, ErrorAppMessage.OBJECT_NULL);

        Product product = productRepository.findByUuid(uuid)
                .orElseThrow(() -> new AppExceptionValidations(ErrorAppMessage.PRODUCT_NOT_FOUND));

        product.update(
                dto.getName(),
                dto.getDescription(),
                dto.getPrice(),
                dto.getStock(),
                dto.getImage());

        productRepository.save(product);

        return productMapper.toDTO(product);
    }

    @Override
    public void deleteByUuid(String uuid) {
        try {
            productRepository.deleteByUuid(uuid);
        } catch (Exception ex) {
            throw new AppExceptionValidations(ErrorAppMessage.PRODUCT_NOT_FOUND);
        }
    }
}
