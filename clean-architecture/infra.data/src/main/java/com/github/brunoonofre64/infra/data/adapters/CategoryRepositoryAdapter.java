package com.github.brunoonofre64.infra.data.adapters;

import com.github.brunoonofre64.domain.entities.Category;
import com.github.brunoonofre64.domain.interfaces.ICategoryRepository;
import com.github.brunoonofre64.infra.data.entities.CategoryEntity;
import com.github.brunoonofre64.infra.data.enums.ErrorInfraDataMessage;
import com.github.brunoonofre64.infra.data.mappers.CategoryDataMapper;
import com.github.brunoonofre64.infra.data.repositories.CategoryRepository;
import com.github.brunoonofre64.infra.data.validations.InfraDataExceptionValidations;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class CategoryRepositoryAdapter implements ICategoryRepository {

    private final CategoryRepository categoryRepository;
    private final CategoryDataMapper mapper;

    public CategoryRepositoryAdapter(CategoryRepository categoryRepository, CategoryDataMapper mapper) {
        this.categoryRepository = categoryRepository;
        this.mapper = mapper;
    }

    @Override
    @Transactional
    public Category save(Category category) {
        CategoryEntity categoryEntity = mapper.toEntity(category);
        categoryRepository.save(categoryEntity);
        return mapper.toDomain(categoryEntity);
    }

    @Override
    @Transactional
    public Optional<Category> findByUuid(String uuid) {
        CategoryEntity categoryEntity = categoryRepository.findByUuid(uuid)
                .orElseThrow(() -> new InfraDataExceptionValidations(ErrorInfraDataMessage.CATEGORY_NOT_FOUND));

        Category category = mapper.toDomain(categoryEntity);
        return Optional.ofNullable(category);
    }

    @Override
    @Transactional
    public List<Category> findAll() {
        List<CategoryEntity> categoryList = categoryRepository.findAll();

        return categoryList
                .stream()
                .map(mapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public void deleteByUuid(String uuid) {
        try {
            categoryRepository.deleteByUuid(uuid);
        } catch (Exception ex) {
            throw new InfraDataExceptionValidations(ErrorInfraDataMessage.CATEGORY_NOT_FOUND);
        }
    }
}
