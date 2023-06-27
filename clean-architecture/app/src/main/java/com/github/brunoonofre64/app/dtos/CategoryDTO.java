package com.github.brunoonofre64.app.dtos;

public class CategoryDTO {
    private String uuid;
    private String name;

    public CategoryDTO(String name) {
        this.name = name;
    }

    public CategoryDTO(String uuid, String name) {
        this.name = name;
        this.uuid = uuid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }
}
