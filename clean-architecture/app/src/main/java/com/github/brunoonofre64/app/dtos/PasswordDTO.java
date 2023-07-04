package com.github.brunoonofre64.app.dtos;

public class PasswordDTO {
    private String currentPassword;

    public PasswordDTO(String currentPassword) {
        this.currentPassword = currentPassword;
    }

    public String getCurrentPassword() {
        return currentPassword;
    }
}
