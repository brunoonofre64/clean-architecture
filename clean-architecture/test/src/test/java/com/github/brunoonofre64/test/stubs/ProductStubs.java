package com.github.brunoonofre64.test.stubs;

import com.github.brunoonofre64.app.dtos.ProductDTO;
import com.github.brunoonofre64.domain.entities.Product;

import static com.github.brunoonofre64.test.UnitTestConstants.*;

public class ProductStubs {

    public static Product buildDomainProduct() {
        return new Product(UUID_DEFAULT, TEXT_DEFAULT, TEXT_DEFAULT, DOUBLE_DEFAULT, INT_DEFAULT, TEXT_DEFAULT);
    }

    public static ProductDTO buildProductDTO() {
        return new ProductDTO(UUID_DEFAULT, TEXT_DEFAULT, TEXT_DEFAULT, DOUBLE_DEFAULT, INT_DEFAULT, TEXT_DEFAULT, TEXT_DEFAULT);
    }

    public static ProductDTO buildProductDTOUpdate() {
        return new ProductDTO(UUID_DEFAULT, TEXT_DEFAULT_2, TEXT_DEFAULT_2, DOUBLE_DEFAULT_2, INT_DEFAULT_2, TEXT_DEFAULT_2, TEXT_DEFAULT_2);
    }
}
