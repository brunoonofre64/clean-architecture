package com.github.brunoonofre64.infra.data.mappers.impl;

import com.github.brunoonofre64.domain.entities.Product;
import com.github.brunoonofre64.infra.data.entities.ProductEntity;
import com.github.brunoonofre64.infra.data.mappers.ProductDataMapper;
import org.springframework.stereotype.Component;

@Component
public class ProductDataMapperImpl implements ProductDataMapper {

    @Override
    public Product toDomain(ProductEntity prod) {
        return new Product(prod.getUuid(), prod.getName(), prod.getDescription(), prod.getPrice(), prod.getStock(), prod.getImage());
    }

    @Override
    public ProductEntity toEntity(Product prod) {
        return new ProductEntity(prod.getUuid(), prod.getName(), prod.getDescription(), prod.getPrice(), prod.getStock(), prod.getImage(), null);
    }
}
