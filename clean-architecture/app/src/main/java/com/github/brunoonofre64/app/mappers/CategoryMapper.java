package com.github.brunoonofre64.app.mappers;

import com.github.brunoonofre64.app.dtos.CategoryDTO;
import com.github.brunoonofre64.domain.entities.Category;

public interface CategoryMapper {
    Category toDomain(CategoryDTO dto);
    CategoryDTO toDTO(Category category);
}
