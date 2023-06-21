package com.github.brunoonofre64.app.dtos;

public class CategoryDTO {
    private String productUuid;
    private String name;

    public CategoryDTO(String name) {
        this.name = name;
    }

    public CategoryDTO(String productUuid, String name) {
        this.productUuid = productUuid;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProductUuid() {
        return productUuid;
    }

    public void setProductUuid(String productUuid) {
        this.productUuid = productUuid;
    }
}
