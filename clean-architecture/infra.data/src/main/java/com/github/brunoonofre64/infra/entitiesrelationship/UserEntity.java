package com.github.brunoonofre64.infra.entitiesrelationship;

import com.github.brunoonofre64.infra.enums.Role;

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
    private Role role;


    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @PrePersist
    private void prePersist() {
        uuid = UUID.randomUUID().toString();
    }
}
