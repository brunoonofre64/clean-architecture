package com.github.brunoonofre64.infra.data.mappers;

import com.github.brunoonofre64.domain.entities.Category;
import com.github.brunoonofre64.infra.data.entities.CategoryEntity;

public interface CategoryDataMapper {
    Category toDomain(CategoryEntity category);
    CategoryEntity toEntity(Category category);
}
