package com.github.brunoonofre64.infra.entitiesrelationship;

import com.github.brunoonofre64.domain.enums.Roles;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "TB_USER")
public class UserEntity {

    @Id
    @Column(name = "UUID")
    private String uuid;

    @Column
    private String login;

    @Column
    private String password;

    @Column
    @Enumerated(EnumType.STRING)
    private Roles roles;


    public Roles getRole() {
        return roles;
    }

    public void setRole(Roles role) {
        this.roles = role;
    }

    @PrePersist
    private void prePersist() {
        uuid = UUID.randomUUID().toString();
    }
}
