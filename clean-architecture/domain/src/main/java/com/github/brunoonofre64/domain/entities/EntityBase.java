package com.github.brunoonofre64.domain.entities;

public abstract class EntityBase {

    protected String uuid;
    protected String name;

    public String getUuid() {
        return uuid;
    }

    protected void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getName() {
        return name;
    }

    protected void setName(String name) {
        this.name = name;
    }
}
