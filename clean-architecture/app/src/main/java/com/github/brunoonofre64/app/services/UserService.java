package com.github.brunoonofre64.app.services;

import com.github.brunoonofre64.app.dtos.PasswordDTO;
import com.github.brunoonofre64.app.dtos.UserDTO;
import com.github.brunoonofre64.app.dtos.UserResponseDTO;
import com.github.brunoonofre64.app.dtos.UserUpdateDTO;
import com.github.brunoonofre64.app.enums.ErrorAppMessage;
import com.github.brunoonofre64.app.interfaces.ISecurityService;
import com.github.brunoonofre64.app.interfaces.IUserService;
import com.github.brunoonofre64.app.mappers.impl.UserMapper;
import com.github.brunoonofre64.app.validations.AppExceptionValidations;
import com.github.brunoonofre64.domain.entities.User;
import com.github.brunoonofre64.domain.interfaces.IUserRepository;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService implements IUserService {
    private IUserRepository userRepository;
    private ISecurityService securityService;
    private UserMapper userMapper;

    public UserService(IUserRepository userRepository, ISecurityService securityService, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.securityService = securityService;
        this.userMapper = userMapper;
    }

    public UserService() {
    }

    @Override
    public UserResponseDTO save(UserDTO userDTO) {
        if (userDTO.getUsername() != null && userRepository.existsByUsername(userDTO.getUsername())) {
            throw new AppExceptionValidations(ErrorAppMessage.USERNAME_ALREADY_EXISTS);
        }
        String bcryptPasswordEncoded = securityService.encode(userDTO.getPassword());

        User user = userMapper.toEntity(userDTO, bcryptPasswordEncoded);

        userRepository.save(user);

        return userMapper.toDTO(user);
    }

    @Override
    public UserResponseDTO update(String username, UserUpdateDTO updateDTO) {
        if (updateDTO.getUsername() != null && userRepository.existsByUsername(updateDTO.getUsername())) {
            throw new AppExceptionValidations(ErrorAppMessage.USERNAME_ALREADY_EXISTS);
        }

        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new AppExceptionValidations(ErrorAppMessage.USER_NOT_FOUND));

        if (securityService.matches(updateDTO.getCurrentPassword(), user.getPassword())) {
            throw new AppExceptionValidations(ErrorAppMessage.CURRENT_PASSWORD_INCORRECT);
        }

        String bcryptPasswordEncoded = securityService.encode(updateDTO.getNewPassword());

        user.update(username, bcryptPasswordEncoded, updateDTO.getRoles());

        userRepository.save(user);

        return userMapper.toDTO(user);
    }

    @Override
    public void delete(String username, PasswordDTO password) {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new AppExceptionValidations(ErrorAppMessage.USER_NOT_FOUND));

        if (securityService.matches(password.getCurrentPassword(), user.getPassword())) {
            throw new AppExceptionValidations(ErrorAppMessage.CURRENT_PASSWORD_INCORRECT);
        }

        userRepository.delete(user);
    }

    @Override
    public List<UserResponseDTO> findAll() {
        List<User> users = userRepository.findAll();

        if (CollectionUtils.isEmpty(users)) {
            throw new AppExceptionValidations(ErrorAppMessage.USER_LIST_IS_EMPTY);
        }

        return users
                .stream()
                .map(user -> userMapper.toDTO(user))
                .collect(Collectors.toList());
    }
}
