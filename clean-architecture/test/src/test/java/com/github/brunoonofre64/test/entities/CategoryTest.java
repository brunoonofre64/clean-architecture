package com.github.brunoonofre64.test.entities;


import com.github.brunoonofre64.domain.entities.Category;
import com.github.brunoonofre64.domain.validations.DomainExceptionValidations;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static com.github.brunoonofre64.test.UnitTestConstants.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class CategoryTest {

    @Test
    void CreateCategory_WithValidParameters_ResultObjectValid() {
        Category response = new Category(UUID_DEFAULT, TEXT_DEFAULT);

        assertNotNull(response);
        assertEquals(UUID_DEFAULT, response.getUuid());
        assertEquals(TEXT_DEFAULT, response.getName());
    }

    @Test
    void ShouldThrowErrorWhenCreate_NameRequired_ResultAException() {
        Throwable ex = assertThrows(DomainExceptionValidations.class,
                () -> new Category(UUID_DEFAULT, "    "));

        assertEquals(DomainExceptionValidations.class, ex.getClass());
    }

    @Test
    void ShouldThrowErrorWhenCreate_InvalidName_ResultAException() {
        Throwable ex = assertThrows(DomainExceptionValidations.class,
                () -> new Category(UUID_DEFAULT, TEXT_INVALID));

        assertEquals(DomainExceptionValidations.class, ex.getClass());
    }

    @Test
    void ShouldThrowErrorWhenCreate_InvalidUuid_ResultAException() {
        Throwable ex = assertThrows(DomainExceptionValidations.class,
                () -> new Category(null, TEXT_DEFAULT));

        assertEquals(DomainExceptionValidations.class, ex.getClass());
    }

    @Test
    void UpdateCategory_WithValidParameters_ResultObjectValid() {
        Category response = new Category(UUID_DEFAULT, TEXT_DEFAULT);
        response.update(TEXT_DEFAULT_2);

        assertNotNull(response);
        assertEquals(UUID_DEFAULT, response.getUuid());
        assertEquals(TEXT_DEFAULT_2, response.getName());
    }

    @Test
    void ShouldThrowErrorWhenUpdate_NameRequired_ResultAException() {
        Category response = new Category(UUID_DEFAULT, TEXT_DEFAULT);

        Throwable ex = assertThrows(DomainExceptionValidations.class,
                () -> response.update("    "));

        assertEquals(DomainExceptionValidations.class, ex.getClass());
    }

    @Test
    void ShouldThrowErrorWhenUpdate_InvalidName_ResultAException() {
        Category response = new Category(UUID_DEFAULT, TEXT_DEFAULT);

        Throwable ex = assertThrows(DomainExceptionValidations.class,
                () -> response.update(TEXT_INVALID));

        assertEquals(DomainExceptionValidations.class, ex.getClass());
    }

    @Test
    void ShouldTestAll_Getters_WithSuccessfully() {
        Category response = new Category(UUID_DEFAULT, TEXT_DEFAULT);

        assertEquals(UUID_DEFAULT, response.getUuid());
        assertEquals(TEXT_DEFAULT, response.getName());
    }
}