package com.github.brunoonofre64.test.entities;

import com.github.brunoonofre64.domain.entities.Product;
import com.github.brunoonofre64.domain.validations.DomainExceptionValidations;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static com.github.brunoonofre64.test.UnitTestConstants.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class ProductTest {

    @Test
    void CreateProduct_WithValidParameters_ResultObjectValid() {
        Product response = new Product(UUID_DEFAULT, TEXT_DEFAULT, TEXT_DEFAULT, DOUBLE_DEFAULT, INT_DEFAULT, null);

        assertNotNull(response);
        assertEquals(UUID_DEFAULT, response.getUuid());
        assertEquals(TEXT_DEFAULT, response.getName());
        assertEquals(TEXT_DEFAULT, response.getDescription());
        assertEquals(DOUBLE_DEFAULT, response.getPrice());
        assertEquals(INT_DEFAULT, response.getStock());
    }

    @Test
    void ShouldThrowErrorWhenCreate_NameRequired_ResultAException() {
        Throwable ex = assertThrows(DomainExceptionValidations.class,
                () -> new Product(UUID_DEFAULT, "    ", TEXT_DEFAULT, DOUBLE_DEFAULT, INT_DEFAULT, null));

        assertEquals(DomainExceptionValidations.class, ex.getClass());
    }

    @Test
    void ShouldThrowErrorWhenCreate_NameInvalid_ResultAException() {
        Throwable ex = assertThrows(DomainExceptionValidations.class,
                () -> new Product(UUID_DEFAULT, TEXT_INVALID, TEXT_DEFAULT, DOUBLE_DEFAULT, INT_DEFAULT, null));

        assertEquals(DomainExceptionValidations.class, ex.getClass());
    }

    @Test
    void ShouldThrowErrorWhenCreate_DescriptionRequired_ResultAException() {
        Throwable ex = assertThrows(DomainExceptionValidations.class,
                () -> new Product(UUID_DEFAULT, TEXT_DEFAULT, "    ", DOUBLE_DEFAULT, INT_DEFAULT, null));

        assertEquals(DomainExceptionValidations.class, ex.getClass());
    }

    @Test
    void ShouldThrowErrorWhenCreate_DescriptionInvalid_ResultAException() {
        Throwable ex = assertThrows(DomainExceptionValidations.class,
                () -> new Product(UUID_DEFAULT, TEXT_DEFAULT, TEXT_INVALID, DOUBLE_DEFAULT, INT_DEFAULT, null));

        assertEquals(DomainExceptionValidations.class, ex.getClass());
    }

    @Test
    void ShouldThrowErrorWhenCreate_PriceInvalid_ResultAException() {
        Throwable ex = assertThrows(DomainExceptionValidations.class,
                () -> new Product(UUID_DEFAULT, TEXT_DEFAULT, TEXT_DEFAULT, -1L, INT_DEFAULT, null));

        assertEquals(DomainExceptionValidations.class, ex.getClass());
    }

    @Test
    void ShouldThrowErrorWhenCreate_IntInvalid_ResultAException() {
        Throwable ex = assertThrows(DomainExceptionValidations.class,
                () -> new Product(UUID_DEFAULT, TEXT_DEFAULT, TEXT_DEFAULT, DOUBLE_DEFAULT, -1, null));

        assertEquals(DomainExceptionValidations.class, ex.getClass());
    }

    @Test
    void ShouldThrowErrorWhenCreate_UrlImageRequired_ResultAException() {
        Throwable ex = assertThrows(DomainExceptionValidations.class,
                () -> new Product(UUID_DEFAULT, TEXT_DEFAULT, TEXT_DEFAULT, DOUBLE_DEFAULT, INT_DEFAULT, "    "));

        assertEquals(DomainExceptionValidations.class, ex.getClass());
    }

    @Test
    void ShouldThrowErrorWhenCreate_UrlImageInvalid_ResultAException() {
        String urlImageInvalid = this.buildUrlImageInvalid();

        Throwable ex = assertThrows(DomainExceptionValidations.class,
                () ->  new Product(UUID_DEFAULT, TEXT_DEFAULT, TEXT_DEFAULT, DOUBLE_DEFAULT, INT_DEFAULT, urlImageInvalid));

        assertEquals(DomainExceptionValidations.class, ex.getClass());
    }

    @Test
    void UpdateProduct_WithValidParameters_ResultObjectValid() {
        Product response = new Product(UUID_DEFAULT, TEXT_DEFAULT, TEXT_DEFAULT, DOUBLE_DEFAULT, INT_DEFAULT, null);

        response.update(TEXT_DEFAULT_2, TEXT_DEFAULT_2, DOUBLE_DEFAULT_2, INT_DEFAULT_2, null);

        assertNotNull(response);
        assertEquals(UUID_DEFAULT, response.getUuid());
        assertEquals(TEXT_DEFAULT_2, response.getName());
        assertEquals(TEXT_DEFAULT_2, response.getDescription());
        assertEquals(DOUBLE_DEFAULT_2, response.getPrice());
        assertEquals(INT_DEFAULT_2, response.getStock());
    }

    @Test
    void ShouldThrowErrorWhenUpdate_NameRequired_ResultAException() {
        Product response = new Product(UUID_DEFAULT, TEXT_DEFAULT, TEXT_DEFAULT, DOUBLE_DEFAULT, INT_DEFAULT, null);

        Throwable ex = assertThrows(DomainExceptionValidations.class,
                () -> response.update("    ", TEXT_DEFAULT, DOUBLE_DEFAULT, INT_DEFAULT, null));

        assertEquals(DomainExceptionValidations.class, ex.getClass());
    }

    @Test
    void ShouldThrowErrorWhenUpdate_NameInvalid_ResultAException() {
        Product response = new Product(UUID_DEFAULT, TEXT_DEFAULT, TEXT_DEFAULT, DOUBLE_DEFAULT, INT_DEFAULT, null);

        Throwable ex = assertThrows(DomainExceptionValidations.class,
                () -> response.update(TEXT_INVALID, TEXT_DEFAULT, DOUBLE_DEFAULT, INT_DEFAULT, null));

        assertEquals(DomainExceptionValidations.class, ex.getClass());
    }

    @Test
    void ShouldThrowErrorWhenUpdate_DescriptionRequired_ResultAException() {
        Product response = new Product(UUID_DEFAULT, TEXT_DEFAULT, TEXT_DEFAULT, DOUBLE_DEFAULT, INT_DEFAULT, null);

        Throwable ex = assertThrows(DomainExceptionValidations.class,
                () -> response.update(TEXT_DEFAULT, "    ", DOUBLE_DEFAULT, INT_DEFAULT, null));

        assertEquals(DomainExceptionValidations.class, ex.getClass());
    }

    @Test
    void ShouldThrowErrorWhenUpdate_DescriptionInvalid_ResultAException() {
        Product response = new Product(UUID_DEFAULT, TEXT_DEFAULT, TEXT_DEFAULT, DOUBLE_DEFAULT, INT_DEFAULT, null);

        Throwable ex = assertThrows(DomainExceptionValidations.class,
                () -> response.update(TEXT_DEFAULT, TEXT_INVALID, DOUBLE_DEFAULT, INT_DEFAULT, null));

        assertEquals(DomainExceptionValidations.class, ex.getClass());
    }

    @Test
    void ShouldThrowErrorWhenUpdate_PriceInvalid_ResultAException() {
        Product response = new Product(UUID_DEFAULT, TEXT_DEFAULT, TEXT_DEFAULT, DOUBLE_DEFAULT, INT_DEFAULT, null);

        Throwable ex = assertThrows(DomainExceptionValidations.class,
                () -> response.update(TEXT_DEFAULT, TEXT_DEFAULT, -1L, INT_DEFAULT, null));

        assertEquals(DomainExceptionValidations.class, ex.getClass());
    }

    @Test
    void ShouldThrowErrorWhenUpdate_IntInvalid_ResultAException() {
        Product response = new Product(UUID_DEFAULT, TEXT_DEFAULT, TEXT_DEFAULT, DOUBLE_DEFAULT, INT_DEFAULT, null);

        Throwable ex = assertThrows(DomainExceptionValidations.class,
                () -> response.update(TEXT_DEFAULT, TEXT_DEFAULT, DOUBLE_DEFAULT, -1, null));

        assertEquals(DomainExceptionValidations.class, ex.getClass());
    }

    @Test
    void ShouldThrowErrorWhenUpdate_UrlImageRequired_ResultAException() {
        Product response = new Product(UUID_DEFAULT, TEXT_DEFAULT, TEXT_DEFAULT, DOUBLE_DEFAULT, INT_DEFAULT, null);

        Throwable ex = assertThrows(DomainExceptionValidations.class,
                () -> response.update(TEXT_DEFAULT, TEXT_DEFAULT, DOUBLE_DEFAULT, INT_DEFAULT, "    "));

        assertEquals(DomainExceptionValidations.class, ex.getClass());
    }

    @Test
    void ShouldThrowErrorWhenUpdate_UrlImageInvalid_ResultAException() {
        Product response = new Product(UUID_DEFAULT, TEXT_DEFAULT, TEXT_DEFAULT, DOUBLE_DEFAULT, INT_DEFAULT, null);

        String urlImageInvalid = this.buildUrlImageInvalid();

        Throwable ex = assertThrows(DomainExceptionValidations.class,
                () ->  response.update(TEXT_DEFAULT, TEXT_DEFAULT, DOUBLE_DEFAULT, INT_DEFAULT, urlImageInvalid));

        assertEquals(DomainExceptionValidations.class, ex.getClass());
    }

    private String buildUrlImageInvalid() {
        String urlImageInvalid = "x";
        int count = 0;
        while (count != 251) {
            count++;
            urlImageInvalid = urlImageInvalid.concat("x");
        }
        return urlImageInvalid;
    }
}

