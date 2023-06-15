package com.github.brunoonofre64.domain.entities;

import com.github.brunoonofre64.domain.enums.ErrorMessage;
import com.github.brunoonofre64.domain.validations.DomainExceptionValidations;

import java.util.ArrayList;
import java.util.List;

public final class Category extends EntityBase {

    private List<Product> products = new ArrayList<>();

    public Category(String name) {
        this.validateName(name);
    }

    public Category(String uuid, String name) {
        this.validateName(name);
        this.validateUuid(uuid);
    }

    public void update(String name) {
        this.validateName(name);
    }

    public List<Product> getProducts() {
        return products;
    }

    private void setProducts(List<Product> products) {
        this.products = products;
    }

    private void validateName(String name) {
        DomainExceptionValidations.when(name.isBlank(), ErrorMessage.NAME_REQUIRED);
        DomainExceptionValidations.when(name.length() <= 3, ErrorMessage.NAME_INVALID);
        super.setName(name);
    }

    private void validateUuid(String uuid) {
        DomainExceptionValidations.when(uuid == null || uuid.isBlank(), ErrorMessage.UUID_INVALID);
        super.setUuid(uuid);
    }
}
