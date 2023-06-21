package com.github.brunoonofre64.app.interfaces;

import com.github.brunoonofre64.app.dtos.PasswordDTO;
import com.github.brunoonofre64.app.dtos.UserDTO;
import com.github.brunoonofre64.app.dtos.UserResponseDTO;
import com.github.brunoonofre64.app.dtos.UserUpdateDTO;

import java.util.List;

public interface IUserService {
    UserResponseDTO save(UserDTO dto);
    UserResponseDTO update(String username, UserUpdateDTO updateDTO);
    void delete(String username, PasswordDTO password);
    List<UserResponseDTO> findAll();
}
