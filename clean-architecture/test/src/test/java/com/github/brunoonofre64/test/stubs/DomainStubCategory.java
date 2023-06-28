package com.github.brunoonofre64.test.stubs;

import com.github.brunoonofre64.app.dtos.CategoryDTO;
import com.github.brunoonofre64.domain.entities.Category;
import com.github.brunoonofre64.infra.data.entities.CategoryEntity;

import java.util.ArrayList;

import static com.github.brunoonofre64.test.UnitTestConstants.TEXT_DEFAULT;
import static com.github.brunoonofre64.test.UnitTestConstants.UUID_DEFAULT;

public class DomainStubCategory {

    public static Category buildCategory() {
        return new Category(UUID_DEFAULT, TEXT_DEFAULT, new ArrayList<>());
    }

    public static CategoryDTO buildCategoryDTO() {
        return new CategoryDTO(UUID_DEFAULT, TEXT_DEFAULT);
    }

    public static CategoryEntity buildCategoryEntity() {
        return new CategoryEntity(UUID_DEFAULT, TEXT_DEFAULT, new ArrayList<>());
    }
}
