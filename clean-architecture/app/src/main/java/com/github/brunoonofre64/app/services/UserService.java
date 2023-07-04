package com.github.brunoonofre64.app.services;

import com.github.brunoonofre64.app.dtos.PasswordDTO;
import com.github.brunoonofre64.app.dtos.UserDTO;
import com.github.brunoonofre64.app.dtos.UserResponseDTO;
import com.github.brunoonofre64.app.dtos.UserUpdateDTO;
import com.github.brunoonofre64.app.enums.ErrorAppMessage;
import com.github.brunoonofre64.app.interfaces.ISecurityService;
import com.github.brunoonofre64.app.interfaces.IUserService;
import com.github.brunoonofre64.app.mappers.UserAppMapper;
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
    private UserAppMapper userAppMapper;

    public UserService(IUserRepository userRepository, ISecurityService securityService, UserAppMapper userAppMapper) {
        this.userRepository = userRepository;
        this.securityService = securityService;
        this.userAppMapper = userAppMapper;
    }

    public UserService() {
    }

    @Override
    public UserResponseDTO save(UserDTO userDTO) {
        if (userDTO.getUsername() != null && userRepository.existsByUsername(userDTO.getUsername())) {
            throw new AppExceptionValidations(ErrorAppMessage.USERNAME_ALREADY_EXISTS);
        }

        String bcryptPasswordEncoded = securityService.encode(userDTO.getPassword());
        User user = userAppMapper.toEntity(userDTO, bcryptPasswordEncoded);

        user = userRepository.save(user);

        return userAppMapper.toDTO(user);
    }

    @Override
    public UserResponseDTO update(String username, UserUpdateDTO updateDTO) {
        if (updateDTO.getUsername() != null && userRepository.existsByUsername(updateDTO.getUsername())) {
            throw new AppExceptionValidations(ErrorAppMessage.USERNAME_ALREADY_EXISTS);
        }

        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new AppExceptionValidations(ErrorAppMessage.USER_NOT_FOUND));

        if (!securityService.matchesPassword(updateDTO.getCurrentPassword(), user.getPassword())) {
            throw new AppExceptionValidations(ErrorAppMessage.CURRENT_PASSWORD_INCORRECT);
        }

        String bcryptPasswordEncoded = securityService.encode(updateDTO.getNewPassword());

        user.update(username, bcryptPasswordEncoded, updateDTO.getRoles());

        userRepository.save(user);

        return userAppMapper.toDTO(user);
    }

    @Override
    public void delete(String username, PasswordDTO password) {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new AppExceptionValidations(ErrorAppMessage.USER_NOT_FOUND));

        if (!securityService.matchesPassword(password.getCurrentPassword(), user.getPassword())) {
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
                .map(user -> userAppMapper.toDTO(user))
                .collect(Collectors.toList());
    }
}
