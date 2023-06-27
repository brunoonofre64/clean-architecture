package com.github.brunoonofre64.infra.data.adapters;

import com.github.brunoonofre64.domain.entities.Category;
import com.github.brunoonofre64.domain.entities.Product;
import com.github.brunoonofre64.domain.interfaces.IProductRepository;
import com.github.brunoonofre64.infra.data.entities.CategoryEntity;
import com.github.brunoonofre64.infra.data.entities.ProductEntity;
import com.github.brunoonofre64.infra.data.enums.ErrorInfraDataMessage;
import com.github.brunoonofre64.infra.data.mappers.CategoryDataMapper;
import com.github.brunoonofre64.infra.data.mappers.ProductDataMapper;
import com.github.brunoonofre64.infra.data.repositories.ProductRepository;
import com.github.brunoonofre64.infra.data.validations.InfraDataExceptionValidations;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class ProductRepositoryAdapter implements IProductRepository {

    private final ProductRepository productRepository;
    private final ProductDataMapper productDataMapper;
    private final CategoryDataMapper categoryDataMapper;

    public ProductRepositoryAdapter(ProductRepository productRepository, ProductDataMapper productDataMapper, CategoryDataMapper categoryDataMapper) {
        this.productRepository = productRepository;
        this.productDataMapper = productDataMapper;
        this.categoryDataMapper = categoryDataMapper;
    }

    @Override
    @Transactional
    public Product save(Product product) {
        CategoryEntity categoryEntity = categoryDataMapper.toEntity(product.getCategory());
        ProductEntity productEntity = productDataMapper.toEntity(product);
        productEntity.setCategory(categoryEntity);

        productEntity = productRepository.save(productEntity);

        Category category = categoryDataMapper.toDomain(categoryEntity);
        product = productDataMapper.toDomain(productEntity);
        product.setCategory(category);

        return product;
    }

    @Override
    @Transactional
    public List<Product> findAll() {
        List<ProductEntity> productList = productRepository.findAll();

        if (CollectionUtils.isEmpty(productList)) {
            return new ArrayList<>();
        }

        return productList
                .stream()
                .map(prod -> {
                    Category category = categoryDataMapper.toDomain(prod.getCategory());
                    Product product = productDataMapper.toDomain(prod);
                    product.setCategory(category);
                    return  product;
                })
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public Optional<Product> findByUuid(String uuid) {
        ProductEntity productEntity = productRepository.findByUuid(uuid)
                .orElseThrow(() -> new InfraDataExceptionValidations(ErrorInfraDataMessage.PRODUCT_NOT_FOUND));

        Category category = categoryDataMapper.toDomain(productEntity.getCategory());
        Product product = productDataMapper.toDomain(productEntity);
        product.setCategory(category);
        return Optional.of(product);
    }

    @Override
    @Transactional
    public void deleteByUuid(String uuid) {
        try {
            productRepository.deleteByUuid(uuid);
        } catch (Exception ex) {
            throw new InfraDataExceptionValidations(ErrorInfraDataMessage.PRODUCT_NOT_FOUND);
        }
    }
}
