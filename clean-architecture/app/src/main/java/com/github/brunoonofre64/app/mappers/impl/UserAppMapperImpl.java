package com.github.brunoonofre64.app.mappers.impl;

import com.github.brunoonofre64.app.dtos.UserDTO;
import com.github.brunoonofre64.app.dtos.UserResponseDTO;
import com.github.brunoonofre64.app.mappers.UserAppMapper;
import com.github.brunoonofre64.domain.entities.User;
import org.springframework.stereotype.Component;

@Component
public class UserAppMapperImpl implements UserAppMapper {

    @Override
    public User toEntity(UserDTO userDTO, String bcryptPasswordEncoded) {
        return new User(userDTO.getUsername(), bcryptPasswordEncoded, userDTO.getRoles());
    }

    @Override
    public UserResponseDTO toDTO(User user) {
        return new UserResponseDTO(user.getUuid(), user.getUsername());
    }
}
