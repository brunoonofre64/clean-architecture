package com.github.brunoonofre64.infra.data.entities;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import java.util.UUID;

@MappedSuperclass
public class EntityBase {

    @Id
    @Column(name = "UUID")
    private String uuid;

    @Column
    private String name;

    public EntityBase(String uuid, String name) {
        this.uuid = uuid;
        this.name = name;
    }

    public EntityBase() {
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @PrePersist
    private void prePersist() {
        uuid = UUID.randomUUID().toString();
    }
}
