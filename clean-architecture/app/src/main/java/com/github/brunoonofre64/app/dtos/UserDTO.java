package com.github.brunoonofre64.app.dtos;

import com.github.brunoonofre64.domain.enums.Roles;

import java.util.List;

public class UserDTO {
    private String username;
    private String password;
    private List<Roles> roles;

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public List<Roles> getRoles() {
        return roles;
    }

    public void setRoles(List<Roles> roles) {
        this.roles = roles;
    }

    public UserDTO(String username, String password, List<Roles> roles) {
        this.username = username;
        this.password = password;
        this.roles = roles;
    }
}
