package com.github.brunoonofre64.app.services;

import com.github.brunoonofre64.app.dtos.CategoryDTO;
import com.github.brunoonofre64.app.enums.ErrorAppMessage;
import com.github.brunoonofre64.app.interfaces.ICategoryService;
import com.github.brunoonofre64.app.mappers.CategoryMapper;
import com.github.brunoonofre64.app.validations.AppExceptionValidations;
import com.github.brunoonofre64.domain.entities.Category;
import com.github.brunoonofre64.domain.interfaces.ICategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryService implements ICategoryService {

    private ICategoryRepository categoryRepository;
    private CategoryMapper categoryMapper;

    public CategoryService(ICategoryRepository categoryRepository, CategoryMapper categoryMapper) {
        this.categoryRepository = categoryRepository;
        this.categoryMapper = categoryMapper;
    }

    public CategoryService() {
    }

    @Override
    public CategoryDTO save(CategoryDTO dto) {
        AppExceptionValidations.when(dto == null,
                ErrorAppMessage.OBJECT_NULL);

        Category category = categoryMapper.toDomain(dto);
        categoryRepository.save(category);
        return categoryMapper.toDTO(category);
    }

    @Override
    public List<CategoryDTO> findAll() {
        List<Category> categories = categoryRepository.findAll();

        AppExceptionValidations.when(categories.isEmpty(),
                ErrorAppMessage.CATEGORIES_LIST_IS_EMPTY);

        return categories
                .stream()
                .map(category -> categoryMapper.toDTO(category))
                .collect(Collectors.toList());
    }

    @Override
    public CategoryDTO update(String uuid, CategoryDTO dto) {
        AppExceptionValidations.when(dto == null,
                ErrorAppMessage.OBJECT_NULL);

        Category category = categoryRepository.findByUuid(uuid)
                .orElseThrow(() -> new AppExceptionValidations(ErrorAppMessage.CATEGORY_NOT_FOUND));

        category.update(dto.getName());

        categoryRepository.save(category);

        return categoryMapper.toDTO(category);
    }

    @Override
    public void deleteByUuid(String uuid) {
        try {
            categoryRepository.deleteByUuid(uuid);
        } catch (Exception ex) {
            throw new AppExceptionValidations(ErrorAppMessage.CATEGORY_NOT_FOUND);
        }
    }
}
