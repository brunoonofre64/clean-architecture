package com.github.brunoonofre64.app.dtos;

public class UserResponseDTO {
    private String uuidUser;
    private String username;

    public UserResponseDTO(String uuidUser, String username) {
        this.uuidUser = uuidUser;
        this.username = username;
    }
}
