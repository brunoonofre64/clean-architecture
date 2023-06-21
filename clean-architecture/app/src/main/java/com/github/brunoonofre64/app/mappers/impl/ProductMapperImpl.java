package com.github.brunoonofre64.app.mappers.impl;

import com.github.brunoonofre64.app.dtos.ProductDTO;
import com.github.brunoonofre64.app.mappers.ProductMapper;
import com.github.brunoonofre64.domain.entities.Product;

public class ProductMapperImpl implements ProductMapper {
    @Override
    public Product toDomain(ProductDTO dto) {
        return new Product(dto.getName(), dto.getDescription(), dto.getPrice(), dto.getStock(), dto.getImage());
    }

    @Override
    public ProductDTO toDTO(Product product) {
        return new ProductDTO(product.getName(), product.getDescription(), product.getPrice(), product.getStock(), product.getImage(), null);
    }
}
