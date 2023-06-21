package com.github.brunoonofre64.app.mappers;

import com.github.brunoonofre64.app.dtos.ProductDTO;
import com.github.brunoonofre64.domain.entities.Product;

public interface ProductMapper {
    Product toDomain(ProductDTO dto);
    ProductDTO toDTO(Product product);
}
