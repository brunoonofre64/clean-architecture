package com.github.brunoonofre64.app.dtos;

public class UserResponseDTO {
    private String uuidUser;
    private String login;

    public UserResponseDTO(String uuidUser, String login) {
        this.uuidUser = uuidUser;
        this.login = login;
    }
}
