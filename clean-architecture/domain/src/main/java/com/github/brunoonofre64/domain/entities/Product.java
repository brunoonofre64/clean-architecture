package com.github.brunoonofre64.domain.entities;

import com.github.brunoonofre64.domain.enums.ErrorMessage;
import com.github.brunoonofre64.domain.validations.DomainExceptionValidations;

public final class Product extends EntityBase {

    private String description;
    private double price;
    private int stock;
    private String image;
    private String categoryUuid;
    private Category category;

    public Product(String uuid, String name, String description, double price,
                   int stock, String image) {

       this.validateUuid(uuid);
       this.validateDomain(name, description, price, stock, image);
    }

    public Product(String name, String description, double price,
                   int stock, String image, String categoryUuid) {

        this.validateDomain(name, description, price, stock, image);
        this.categoryUuid = categoryUuid;
    }

    public void update(String name, String description, double price,
                       int stock, String image) {

       this.validateDomain(name, description, price, stock, image);
    }

    public String getDescription() {
        return description;
    }

    private void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    private void setPrice(double price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    private void setStock(int stock) {
        this.stock = stock;
    }

    public String getImage() {
        return image;
    }

    private void setImage(String image) {
        this.image = image;
    }

    public String getCategoryUuid() {
        return categoryUuid;
    }

    public void setCategoryUuid(String categoryUuid) {
        this.categoryUuid = categoryUuid;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    private void validateDomain(String name, String description, double price, int stock, String image) {
        DomainExceptionValidations.when(name.isBlank(), ErrorMessage.NAME_REQUIRED);
        DomainExceptionValidations.when(name.length() <= 3, ErrorMessage.NAME_INVALID);
        DomainExceptionValidations.when(description.isBlank(), ErrorMessage.DESCRIPTION_REQUIRED);
        DomainExceptionValidations.when(description.length() <= 3, ErrorMessage.DESCRIPTION_INVALID);
        DomainExceptionValidations.when(price < 0, ErrorMessage.PRICE_INVALID);
        DomainExceptionValidations.when(stock < 0, ErrorMessage.STOCK_INVALID);
        DomainExceptionValidations.when(image != null && image.isBlank(), ErrorMessage.URL_IMAGE_REQUIRED);
        DomainExceptionValidations.when(image != null && image.length() > 250, ErrorMessage.URL_IMAGE_INVALID);

        super.setName(name);
        this.description = description;
        this.price = price;
        this.stock = stock;
        this.image = image;
    }

    private void validateUuid(String uuid) {
        DomainExceptionValidations.when(uuid == null || uuid.isBlank(), ErrorMessage.UUID_INVALID);
        super.setUuid(uuid);
    }
}
