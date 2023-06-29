package com.github.brunoonofre64.app.mappers;

import com.github.brunoonofre64.app.dtos.UserDTO;
import com.github.brunoonofre64.app.dtos.UserResponseDTO;
import com.github.brunoonofre64.domain.entities.User;

public interface UserAppMapper {
    User toEntity(UserDTO userDTO, String bcryptPasswordEncoded);
    UserResponseDTO toDTO(User user);
}
