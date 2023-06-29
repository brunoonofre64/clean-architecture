package com.github.brunoonofre64.infra.data.entities;

import com.github.brunoonofre64.domain.enums.Roles;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "TB_USER")
public class UserEntity {

    @Id
    @Column(name = "UUID")
    private String uuid;

    @Column
    private String username;

    @Column
    private String password;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "TB_USER_ROLES", joinColumns = @JoinColumn(name = "USER_UUID"))
    @Column(name = "ROLES")
    @Enumerated(EnumType.STRING)
    private List<Roles> roles;

    public UserEntity(String uuid, String username, String password, List<Roles> roles) {
        this.uuid = uuid;
        this.username = username;
        this.password = password;
        this.roles = roles;
    }

    public UserEntity() {

    }

    public String getUuid() {
        return uuid;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public List<Roles> getRoles() {
        return roles;
    }

    @PrePersist
    private void prePersist() {
        uuid = UUID.randomUUID().toString();
    }
}
