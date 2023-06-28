package com.github.brunoonofre64.test.app.service;

import com.github.brunoonofre64.app.dtos.ProductDTO;
import com.github.brunoonofre64.app.mappers.ProductAppMapper;
import com.github.brunoonofre64.app.services.ProductService;
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

import java.util.List;
import java.util.Optional;

import static com.github.brunoonofre64.test.UnitTestConstants.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ProductServiceTest {

    @InjectMocks
    private ProductService productService;

    @Mock
    private IProductRepository iProductRepository;

    @Mock
    private ICategoryRepository iCategoryRepository;

    @Mock
    private ProductAppMapper productAppMapper;

    private Product product;
    private Category category;
    private ProductDTO productDTO;
    private ProductDTO productDTOUpdate;

    @BeforeEach
    void setUp() {
        this.buildArrangeOfTests();
    }

    @Test
    void ShouldCreateProduct_WithValidParameters_ResultResponseValid() {
        when(productAppMapper.toDomain(any())).thenReturn(product);
        when(iCategoryRepository.findByUuid(any())).thenReturn(Optional.of(category));
        when(iProductRepository.save(any())).thenReturn(product);
        when(productAppMapper.toDTO(any(), any())).thenReturn(productDTO);

        ProductDTO response = productService.save(productDTO);

        assertNotNull(response);
        assertEquals(UUID_DEFAULT, response.getUuid());
        assertEquals(TEXT_DEFAULT, response.getName());
        assertEquals(DOUBLE_DEFAULT, response.getPrice());
    }

    @Test
    void ShouldThrowErrorWhen_TryCreateWIthProductDtoIsNull_ResultException() {
        Throwable ex = assertThrows(AppExceptionValidations.class,
                () -> productService.save(null));

        assertEquals(AppExceptionValidations.class, ex.getClass());
    }

    @Test
    void ShouldThrowErrorWhen_TryCreateProductWithCategoryNotFound_ResultException() {
        when(productAppMapper.toDomain(any())).thenReturn(product);

        Throwable ex = assertThrows(AppExceptionValidations.class,
                () -> productService.save(productDTO));

        assertEquals(AppExceptionValidations.class, ex.getClass());
    }

    @Test
    void ShouldFindAllProducts_WithSuccessfully() {
        when(iProductRepository.findAll()).thenReturn(List.of(product));
        when(productAppMapper.toDTO(any(), any())).thenReturn(productDTO);

        List<ProductDTO> response = productService.findAll();

        assertNotNull(response);
        assertEquals(UUID_DEFAULT, response.get(ZERO).getUuid());
        assertEquals(TEXT_DEFAULT, response.get(ZERO).getName());
        assertEquals(DOUBLE_DEFAULT, response.get(ZERO).getPrice());
    }

    @Test
    void ShouldThrowErrorWhen_TryFindProductListIsEmpty_ResultException() {
        Throwable ex = assertThrows(AppExceptionValidations.class,
                () -> productService.findAll());

        assertEquals(AppExceptionValidations.class, ex.getClass());
    }

    @Test
    void ShouldUpdateProduct_WithValidParameters_ResultResponseValid() {
        when(iProductRepository.findByUuid(any())).thenReturn(Optional.of(product));
        when(iCategoryRepository.findByUuid(any())).thenReturn(Optional.of(category));
        when(iProductRepository.save(any())).thenReturn(product);
        when(productAppMapper.toDTO(any(), any())).thenReturn(productDTOUpdate);

        ProductDTO response = productService.update(UUID_DEFAULT, productDTOUpdate);

        assertNotNull(response);
        assertEquals(UUID_DEFAULT, response.getUuid());
        assertEquals(TEXT_DEFAULT_2, response.getName());
        assertEquals(DOUBLE_DEFAULT_2, response.getPrice());
    }

    @Test
    void ShouldThrowErrorWhen_TryUpdateWIthProductDtoIsNull_ResultException() {
        Throwable ex = assertThrows(AppExceptionValidations.class,
                () -> productService.update(UUID_DEFAULT, null));

        assertEquals(AppExceptionValidations.class, ex.getClass());
    }

    @Test
    void ShouldThrowErrorWhen_TryUpdateWIthProductNotFound_ResultException() {
        Throwable ex = assertThrows(AppExceptionValidations.class,
                () -> productService.update(UUID_DEFAULT, productDTOUpdate));

        assertEquals(AppExceptionValidations.class, ex.getClass());
    }

    @Test
    void ShouldThrowErrorWhen_TryUpdateProductWIthCategoryNotFound_ResultException() {
        when(iProductRepository.findByUuid(any())).thenReturn(Optional.of(product));

        Throwable ex = assertThrows(AppExceptionValidations.class,
                () -> productService.update(UUID_DEFAULT, productDTOUpdate));

        assertEquals(AppExceptionValidations.class, ex.getClass());
    }

    @Test
    void ShouldDeleteProduct_WithSuccessfully() {
        doNothing().when(iProductRepository).deleteByUuid(UUID_DEFAULT);

        iProductRepository.deleteByUuid(UUID_DEFAULT);

        verify(iProductRepository).deleteByUuid(UUID_DEFAULT);
        verify(iProductRepository, times(1)).deleteByUuid(UUID_DEFAULT);
        verify(iProductRepository, atLeastOnce()).deleteByUuid(UUID_DEFAULT);
    }

    @Test
    void ShouldThrowErrorWhen_TryDeleteByUuid_ResultException() {
        doThrow(new RuntimeException()).when(iProductRepository).deleteByUuid(any());

        Throwable ex = assertThrows(AppExceptionValidations.class,
                () -> productService.deleteByUuid(UUID_DEFAULT));

        assertEquals(AppExceptionValidations.class, ex.getClass());
    }

    @Test
    void ShouldFindProduct_ByUuid_WithSuccessfully() {
        when(iProductRepository.findByUuid(any())).thenReturn(Optional.of(product));
        when(productAppMapper.toDTO(any(), any())).thenReturn(productDTO);

        ProductDTO response = productService.findByUuid(UUID_DEFAULT);

        assertNotNull(response);
        assertEquals(UUID_DEFAULT, response.getUuid());
        assertEquals(TEXT_DEFAULT, response.getName());
        assertEquals(DOUBLE_DEFAULT, response.getPrice());
    }

    @Test
    void ShouldThrowErrorWhen_FindProductByUuid_ResultException() {
        Throwable ex = assertThrows(AppExceptionValidations.class,
                () -> productService.findByUuid(UUID_DEFAULT));

        assertEquals(AppExceptionValidations.class, ex.getClass());
    }

    private void buildArrangeOfTests() {
        product = DomainStubProduct.buildDomainProduct();
        category = DomainStubCategory.buildCategory();
        productDTO = DomainStubProduct.buildProductDTO();
        productDTOUpdate = DomainStubProduct.buildProductDTOUpdate();
    }
}
