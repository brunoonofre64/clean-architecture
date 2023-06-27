package com.github.brunoonofre64.app.mappers;

import com.github.brunoonofre64.app.dtos.ProductDTO;
import com.github.brunoonofre64.domain.entities.Category;
import com.github.brunoonofre64.domain.entities.Product;

public interface ProductAppMapper {
    Product toDomain(ProductDTO dto);
    ProductDTO toDTO(Product product, Category category);
}
