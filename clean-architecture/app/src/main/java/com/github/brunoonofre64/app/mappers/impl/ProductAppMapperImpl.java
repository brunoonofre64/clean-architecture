package com.github.brunoonofre64.app.mappers.impl;

import com.github.brunoonofre64.app.dtos.CategoryDTO;
import com.github.brunoonofre64.app.dtos.ProductDTO;
import com.github.brunoonofre64.app.mappers.CategoryAppMapper;
import com.github.brunoonofre64.app.mappers.ProductAppMapper;
import com.github.brunoonofre64.domain.entities.Category;
import com.github.brunoonofre64.domain.entities.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductAppMapperImpl implements ProductAppMapper {

    private final CategoryAppMapper categoryAppMapper;

    public ProductAppMapperImpl(CategoryAppMapper categoryAppMapper) {
        this.categoryAppMapper = categoryAppMapper;
    }

    @Override
    public Product toDomain(ProductDTO dto) {
        return new Product(dto.getName(), dto.getDescription(), dto.getPrice(), dto.getStock(), dto.getImage());
    }

    @Override
    public ProductDTO toDTO(Product product, Category category) {
        CategoryDTO categoryDTO = categoryAppMapper.toDTO(category);
        ProductDTO productDTO = new ProductDTO(product.getUuid(), product.getName(), product.getDescription(),
                product.getPrice(), product.getStock(), product.getImage(), product.getCategory().getUuid());

        productDTO.setCategoryDTO(categoryDTO);

        return productDTO;
    }
}
