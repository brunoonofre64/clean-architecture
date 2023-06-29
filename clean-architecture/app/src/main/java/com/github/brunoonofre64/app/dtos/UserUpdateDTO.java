package com.github.brunoonofre64.app.dtos;

import com.github.brunoonofre64.domain.enums.Roles;

import java.util.List;


public class UserUpdateDTO {
    private String username;
    private String newPassword;
    private String currentPassword;
    private List<Roles> roles;

    public String getUsername() {
        return username;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public String getCurrentPassword() {
        return currentPassword;
    }

    public List<Roles> getRoles() {
        return roles;
    }
}
