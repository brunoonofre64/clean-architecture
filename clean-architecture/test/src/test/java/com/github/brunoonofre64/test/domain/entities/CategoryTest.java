package com.github.brunoonofre64.test.domain.entities;


import com.github.brunoonofre64.domain.entities.Category;
import com.github.brunoonofre64.domain.validations.DomainExceptionValidations;
import com.github.brunoonofre64.test.stubs.ProductStubs;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static com.github.brunoonofre64.test.UnitTestConstants.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class CategoryTest {

    @Test
    void CreateCategory_WithValidParameters_ResultObjectValid() {
        Category response = new Category(UUID_DEFAULT, TEXT_DEFAULT, List.of(ProductStubs.buildDomainProduct()));

        assertNotNull(response);
        assertEquals(UUID_DEFAULT, response.getUuid());
        assertEquals(TEXT_DEFAULT, response.getName());
    }

    @Test
    void ShouldThrowErrorWhenCreate_NameRequired_ResultAException() {
        Throwable ex = assertThrows(DomainExceptionValidations.class,
                () -> new Category(UUID_DEFAULT, "    ", List.of(ProductStubs.buildDomainProduct())));

        assertEquals(DomainExceptionValidations.class, ex.getClass());
    }

    @Test
    void ShouldThrowErrorWhenCreate_InvalidName_ResultAException() {
        Throwable ex = assertThrows(DomainExceptionValidations.class,
                () -> new Category(UUID_DEFAULT, TEXT_INVALID, List.of(ProductStubs.buildDomainProduct())));

        assertEquals(DomainExceptionValidations.class, ex.getClass());
    }

    @Test
    void ShouldThrowErrorWhenCreate_InvalidUuid_ResultAException() {
        Throwable ex = assertThrows(DomainExceptionValidations.class,
                () -> new Category(null, TEXT_DEFAULT, List.of(ProductStubs.buildDomainProduct())));

        assertEquals(DomainExceptionValidations.class, ex.getClass());
    }

    @Test
    void UpdateCategory_WithValidParameters_ResultObjectValid() {
        Category response = new Category(UUID_DEFAULT, TEXT_DEFAULT, List.of(ProductStubs.buildDomainProduct()));
        response.update(TEXT_DEFAULT_2);

        assertNotNull(response);
        assertEquals(UUID_DEFAULT, response.getUuid());
        assertEquals(TEXT_DEFAULT_2, response.getName());
    }

    @Test
    void ShouldThrowErrorWhenUpdate_NameRequired_ResultAException() {
        Category response = new Category(UUID_DEFAULT, TEXT_DEFAULT, List.of(ProductStubs.buildDomainProduct()));

        Throwable ex = assertThrows(DomainExceptionValidations.class,
                () -> response.update("    "));

        assertEquals(DomainExceptionValidations.class, ex.getClass());
    }

    @Test
    void ShouldThrowErrorWhenUpdate_InvalidName_ResultAException() {
        Category response = new Category(UUID_DEFAULT, TEXT_DEFAULT, List.of(ProductStubs.buildDomainProduct()));

        Throwable ex = assertThrows(DomainExceptionValidations.class,
                () -> response.update(TEXT_INVALID));

        assertEquals(DomainExceptionValidations.class, ex.getClass());
    }

    @Test
    void ShouldTestAll_Getters_WithSuccessfully() {
        Category response = new Category(UUID_DEFAULT, TEXT_DEFAULT, List.of(ProductStubs.buildDomainProduct()));

        assertEquals(UUID_DEFAULT, response.getUuid());
        assertEquals(TEXT_DEFAULT, response.getName());
    }
}
