package com.github.brunoonofre64.test.stubs;

import com.github.brunoonofre64.domain.entities.Product;

import static com.github.brunoonofre64.test.UnitTestConstants.*;

public class DomainStubProduct {

    public static Product buildDomainProduct() {
        return new Product(UUID_DEFAULT, TEXT_DEFAULT, TEXT_DEFAULT, DOUBLE_DEFAULT, INT_DEFAULT, TEXT_DEFAULT);
    }
}
