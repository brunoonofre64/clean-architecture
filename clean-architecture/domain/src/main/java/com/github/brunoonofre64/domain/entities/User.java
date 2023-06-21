package com.github.brunoonofre64.domain.entities;

import com.github.brunoonofre64.domain.enums.ErrorMessage;
import com.github.brunoonofre64.domain.enums.Roles;
import com.github.brunoonofre64.domain.validations.DomainExceptionValidations;

import java.util.List;

public final class User {
    private String uuid;
    private String username;
    private String password;
    private List<Roles> roles;

    public User(String username, String password, List<Roles> roles) {
        this.username = username;
        this.password = password;
        this.roles = roles;
    }

    public User(String uuid, String username, String password, List<Roles> roles) {
        this.validateUser(username, password, roles);
        this.validateUuid(uuid);
    }

    public void update(String username, String password, List<Roles> roles) {
        this.validateUser(username, password, roles);
    }

    public String getUuid() {
        return uuid;
    }

    private void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getUsername() {
        return username;
    }

    private void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    private void setPassword(String password) {
        this.password = password;
    }

    public List<Roles> getRoles() {
        return roles;
    }

    private void setRoles(List<Roles> roles) {
        this.roles = roles;
    }

    private void validateUser(String username, String password, List<Roles> roles) {
        DomainExceptionValidations.when(username == null || username.isBlank() || username.length() < 5, ErrorMessage.USERNAME_INVALID);
        DomainExceptionValidations.when(password == null || password.isBlank() || password.length() < 5, ErrorMessage.PASSWORD_INVALID);
        DomainExceptionValidations.when(roles == null || roles.isEmpty(), ErrorMessage.ROLE_INVALID);

        this.username = username;
        this.password = password;
        this.roles = roles;
    }

    private void validateUuid(String uuid) {
        DomainExceptionValidations.when(uuid == null || uuid.isBlank(), ErrorMessage.UUID_INVALID);
        this.uuid = uuid;
    }
}
