package com.github.brunoonofre64.app.mappers.impl;

import com.github.brunoonofre64.app.dtos.CategoryDTO;
import com.github.brunoonofre64.app.mappers.CategoryAppMapper;
import com.github.brunoonofre64.domain.entities.Category;
import org.springframework.stereotype.Component;

@Component
public class CategoryAppMapperImpl implements CategoryAppMapper {

    @Override
    public Category toDomain(CategoryDTO dto) {
        return new Category(dto.getName());
    }

    @Override
    public CategoryDTO toDTO(Category category) {
        return new CategoryDTO(category.getUuid(), category.getName());
    }
}
