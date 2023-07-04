package com.github.brunoonofre64.test.stubs;

import com.github.brunoonofre64.app.dtos.PasswordDTO;
import com.github.brunoonofre64.app.dtos.UserDTO;
import com.github.brunoonofre64.app.dtos.UserResponseDTO;
import com.github.brunoonofre64.app.dtos.UserUpdateDTO;
import com.github.brunoonofre64.domain.entities.User;

import java.util.ArrayList;

import static com.github.brunoonofre64.test.UnitTestConstants.*;

public class UserStubs {

    public static User buildUser() {
        return new User(TEXT_DEFAULT, TEXT_DEFAULT, new ArrayList<>());
    }

    public static UserDTO buildUserDTO() {
        return new UserDTO(TEXT_DEFAULT, TEXT_DEFAULT, new ArrayList<>());
    }

    public static UserUpdateDTO buildUserUpdateDTO() {
        return new UserUpdateDTO(TEXT_DEFAULT_2, TEXT_DEFAULT_2, TEXT_DEFAULT, new ArrayList<>());
    }

    public static UserResponseDTO buildUserResponseDTO() {
        return new UserResponseDTO(UUID_DEFAULT, TEXT_DEFAULT);
    }

    public static UserResponseDTO buildUserResponseDTOUpdate() {
        return new UserResponseDTO(UUID_DEFAULT, TEXT_DEFAULT_2);
    }

    public static PasswordDTO buildPasswordDTO() {
        return new PasswordDTO(TEXT_DEFAULT);
    }
}
