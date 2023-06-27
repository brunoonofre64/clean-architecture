package com.github.brunoonofre64.app.services;

import com.github.brunoonofre64.app.dtos.CategoryDTO;
import com.github.brunoonofre64.app.enums.ErrorAppMessage;
import com.github.brunoonofre64.app.interfaces.ICategoryService;
import com.github.brunoonofre64.app.mappers.CategoryAppMapper;
import com.github.brunoonofre64.app.validations.AppExceptionValidations;
import com.github.brunoonofre64.domain.entities.Category;
import com.github.brunoonofre64.domain.entities.Product;
import com.github.brunoonofre64.domain.interfaces.ICategoryRepository;
import com.github.brunoonofre64.domain.interfaces.IProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryService implements ICategoryService {

    private final ICategoryRepository categoryRepository;
    private final IProductRepository productRepository;
    private final CategoryAppMapper categoryAppMapper;

    public CategoryService(ICategoryRepository categoryRepository, IProductRepository productRepository, CategoryAppMapper categoryAppMapper) {
        this.categoryRepository = categoryRepository;
        this.productRepository = productRepository;
        this.categoryAppMapper = categoryAppMapper;
    }

    @Override
    public CategoryDTO save(CategoryDTO dto) {
        AppExceptionValidations.when(dto == null,
                ErrorAppMessage.OBJECT_NULL);

        Category category = categoryAppMapper.toDomain(dto);

        category = categoryRepository.save(category);

        return categoryAppMapper.toDTO(category);
    }

    @Override
    public List<CategoryDTO> findAll() {
        List<Category> categories = categoryRepository.findAll();

        AppExceptionValidations.when(categories.isEmpty(),
                ErrorAppMessage.CATEGORIES_LIST_IS_EMPTY);

        return categories
                .stream()
                .map(categoryAppMapper::toDTO)
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

        return categoryAppMapper.toDTO(category);
    }

    @Override
    public void deleteByUuid(String uuid) {
        List<Product> productsOfCategory = productRepository.findProductsByCategoryUuid(uuid);

        if (!CollectionUtils.isEmpty(productsOfCategory)) {
            throw new AppExceptionValidations(ErrorAppMessage.CONSTRAINT_VIOLATION);
        }

        try {
            categoryRepository.deleteByUuid(uuid);
        } catch (Exception ex) {
            throw new AppExceptionValidations(ErrorAppMessage.CATEGORY_NOT_FOUND);
        }
    }
}
