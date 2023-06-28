package com.github.brunoonofre64.test.app.service;

import com.github.brunoonofre64.app.dtos.CategoryDTO;
import com.github.brunoonofre64.app.mappers.CategoryAppMapper;
import com.github.brunoonofre64.app.services.CategoryService;
import com.github.brunoonofre64.app.validations.AppExceptionValidations;
import com.github.brunoonofre64.domain.entities.Category;
import com.github.brunoonofre64.domain.entities.Product;
import com.github.brunoonofre64.domain.interfaces.ICategoryRepository;
import com.github.brunoonofre64.domain.interfaces.IProductRepository;
import com.github.brunoonofre64.test.stubs.DomainStubCategory;
import com.github.brunoonofre64.test.stubs.DomainStubProduct;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static com.github.brunoonofre64.test.UnitTestConstants.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CategoryServiceTest {

    @InjectMocks
    private CategoryService categoryService;

    @Mock
    private ICategoryRepository iCategoryRepository;

    @Mock
    private IProductRepository iProductRepository;

    @Mock
    private CategoryAppMapper categoryAppMapper;

    private Category category;
    private CategoryDTO categoryDTO;
    private Product product;

    @BeforeEach
    void setup() {
        this.buildArrangeOfTests();
    }

    @Test
    void ShouldCreateCategory_WithValidParameters_ResultResponseValid() {
        when(categoryAppMapper.toDomain(any())).thenReturn(category);
        when(iCategoryRepository.save(any())).thenReturn(category);
        when(categoryAppMapper.toDTO(any())).thenReturn(categoryDTO);


        CategoryDTO response = categoryService.save(categoryDTO);

        assertNotNull(response);
        assertEquals(UUID_DEFAULT, response.getUuid());
        assertEquals(TEXT_DEFAULT, response.getName());
    }

    @Test
    void ShouldThrowErrorWhen_TryCreateWithCategoryDtoIsNull_ResultException() {
        Throwable ex = assertThrows(AppExceptionValidations.class,
                () -> categoryService.save(null));

        assertEquals(AppExceptionValidations.class, ex.getClass());
    }

    @Test
    void ShouldFindAllCategory_ResultResponseValid() {
        when(iCategoryRepository.findAll()).thenReturn(List.of(category));
        when(categoryAppMapper.toDTO(any())).thenReturn(categoryDTO);

        List<CategoryDTO> response = categoryService.findAll();

        assertNotNull(response);
        assertEquals(UUID_DEFAULT, response.get(ZERO).getUuid());
        assertEquals(TEXT_DEFAULT, response.get(ZERO).getName());
    }

    @Test
    void ShouldThrowError_ByCategoryListIsEmpty_ResultException() {
        Throwable ex = assertThrows(AppExceptionValidations.class,
                () -> categoryService.findAll());

        assertEquals(AppExceptionValidations.class, ex.getClass());
    }

    @Test
    void ShouldUpdateCategory_WithValidParameters_ResultResponseValid() {
        when(iCategoryRepository.findByUuid(any())).thenReturn(Optional.of(category));
        when(iCategoryRepository.save(any())).thenReturn(category);
        when(categoryAppMapper.toDTO(any())).thenReturn(categoryDTO);

        CategoryDTO response = categoryService.update(UUID_DEFAULT, categoryDTO);

        assertNotNull(response);
        assertEquals(UUID_DEFAULT, response.getUuid());
        assertEquals(TEXT_DEFAULT, response.getName());
    }

    @Test
    void ShouldThrowErrorWhen_TryUpdateWithCategoryDtoIsNull_ResultException() {
        Throwable ex = assertThrows(AppExceptionValidations.class,
                () -> categoryService.update(UUID_DEFAULT, null));

        assertEquals(AppExceptionValidations.class, ex.getClass());
    }

    @Test
    void ShouldThrowErrorWhen_TryUpdateWithCategoryNotFound_ResultException() {
        Throwable ex = assertThrows(AppExceptionValidations.class,
                () -> categoryService.update(UUID_DEFAULT, categoryDTO));

        assertEquals(AppExceptionValidations.class, ex.getClass());
    }

    @Test
    void ShouldDeleteCategory_WithSuccessfully() {
        doNothing().when(iCategoryRepository).deleteByUuid(UUID_DEFAULT);

        iCategoryRepository.deleteByUuid(UUID_DEFAULT);

        verify(iCategoryRepository).deleteByUuid(UUID_DEFAULT);
        verify(iCategoryRepository, times(1)).deleteByUuid(UUID_DEFAULT);
        verify(iCategoryRepository, atLeastOnce()).deleteByUuid(UUID_DEFAULT);
    }

    @Test
    void ShouldThrowErrorWhen_TryDeleteCategoryViolatingConstraintRule_ResultException() {
        when(iProductRepository.findProductsByCategoryUuid(any())).thenReturn(List.of(product));

        Throwable ex = assertThrows(AppExceptionValidations.class,
                () -> categoryService.deleteByUuid(UUID_DEFAULT));

        assertEquals(AppExceptionValidations.class, ex.getClass());
    }

    @Test
    void ShouldThrowErrorWhen_TryDeleteCategoryButCategoryNotFound_ResultException() {
        when(iProductRepository.findProductsByCategoryUuid(any())).thenReturn(Collections.emptyList());
        doThrow(new RuntimeException()).when(iCategoryRepository).deleteByUuid(any());

        Throwable ex = assertThrows(AppExceptionValidations.class,
                () -> categoryService.deleteByUuid(UUID_DEFAULT));

        assertEquals(AppExceptionValidations.class, ex.getClass());
    }

    private void buildArrangeOfTests() {
        category = DomainStubCategory.buildCategory();
        categoryDTO = DomainStubCategory.buildCategoryDTO();
        product = DomainStubProduct.buildDomainProduct();
    }
}
