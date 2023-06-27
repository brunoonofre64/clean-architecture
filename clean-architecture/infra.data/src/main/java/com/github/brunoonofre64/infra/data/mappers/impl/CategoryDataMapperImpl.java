package com.github.brunoonofre64.infra.data.mappers.impl;

import com.github.brunoonofre64.domain.entities.Category;
import com.github.brunoonofre64.infra.data.entities.CategoryEntity;
import com.github.brunoonofre64.infra.data.mappers.CategoryDataMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class CategoryDataMapperImpl implements CategoryDataMapper {

    @Override
    public Category toDomain(CategoryEntity category) {
     return new Category(category.getUuid(), category.getName(), new ArrayList<>());
    }

    @Override
    public CategoryEntity toEntity(Category category) {
        return new CategoryEntity(category.getUuid(), category.getName(), new ArrayList<>());
    }
}
