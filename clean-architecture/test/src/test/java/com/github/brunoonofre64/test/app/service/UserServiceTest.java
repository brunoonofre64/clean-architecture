package com.github.brunoonofre64.test.app.service;

import com.github.brunoonofre64.app.dtos.PasswordDTO;
import com.github.brunoonofre64.app.dtos.UserDTO;
import com.github.brunoonofre64.app.dtos.UserResponseDTO;
import com.github.brunoonofre64.app.dtos.UserUpdateDTO;
import com.github.brunoonofre64.app.interfaces.ISecurityService;
import com.github.brunoonofre64.app.mappers.UserAppMapper;
import com.github.brunoonofre64.app.services.UserService;
import com.github.brunoonofre64.app.validations.AppExceptionValidations;
import com.github.brunoonofre64.domain.entities.User;
import com.github.brunoonofre64.domain.interfaces.IUserRepository;
import com.github.brunoonofre64.test.stubs.UserStubs;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static com.github.brunoonofre64.test.UnitTestConstants.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @InjectMocks
    private UserService userService;

    @Mock
    private IUserRepository iUserRepository;

    @Mock
    private ISecurityService iSecurityService;

    @Mock
    private UserAppMapper userAppMapper;

    private UserDTO userDTO;
    private User user;
    private UserResponseDTO userResponseDTO;
    private UserResponseDTO userResponseDTOUpdate;
    private UserUpdateDTO userUpdateDTO;
    private PasswordDTO passwordDTO;

    @BeforeEach
    void setUp() {
        this.buildArrangeOfTests();
    }

    @Test
    void ShouldCreateUser_WithValidParameters_ResultObjectValid() {
        when(iUserRepository.existsByUsername(any())).thenReturn(false);
        when(iSecurityService.encode(any())).thenReturn(TEXT_DEFAULT);
        when(iUserRepository.save(any())).thenReturn(user);
        when(userAppMapper.toDTO(any())).thenReturn(userResponseDTO);

        UserResponseDTO response = userService.save(userDTO);

        assertNotNull(response);
        assertEquals(UUID_DEFAULT, response.getUuidUser());
        assertEquals(TEXT_DEFAULT, response.getUsername());

    }

    @Test
    void ShouldThrowErrorWhen_UsernameAlreadyExists_ResultException() {
        when(iUserRepository.existsByUsername(any())).thenReturn(true);

        Throwable ex = assertThrows(AppExceptionValidations.class,
                () -> userService.save(userDTO));

        assertEquals(AppExceptionValidations.class, ex.getClass());
    }

    @Test
    void ShouldUpdateUser_WithValidParameters_ResultObjectValid() {
        when(iUserRepository.existsByUsername(any())).thenReturn(false);
        when(iUserRepository.findByUsername(any())).thenReturn(Optional.ofNullable(user));
        when(iSecurityService.matchesPassword(any(), anyString())).thenReturn(true);
        when(iSecurityService.encode(any())).thenReturn(TEXT_DEFAULT);
        when(iUserRepository.save(any())).thenReturn(user);
        when(userAppMapper.toDTO(any())).thenReturn(userResponseDTOUpdate);

        UserResponseDTO response = userService.update(UUID_DEFAULT, userUpdateDTO);

        assertNotNull(response);
        assertEquals(UUID_DEFAULT, response.getUuidUser());
        assertEquals(TEXT_DEFAULT_2, response.getUsername());

    }

    @Test
    void ShouldThrowErrorWhen_UpdateWithUsernameAlreadyExists_ResultException() {
        when(iUserRepository.existsByUsername(any())).thenReturn(true);

        Throwable ex = assertThrows(AppExceptionValidations.class,
                () -> userService.update(UUID_DEFAULT, userUpdateDTO));

        assertEquals(AppExceptionValidations.class, ex.getClass());
    }

    @Test
    void ShouldThrowErrorWhen_UpdateWithUserNotFound_ResultException() {
        when(iUserRepository.existsByUsername(any())).thenReturn(false);

        Throwable ex = assertThrows(AppExceptionValidations.class,
                () -> userService.update(UUID_DEFAULT, userUpdateDTO));

        assertEquals(AppExceptionValidations.class, ex.getClass());
    }

    @Test
    void ShouldThrowErrorWhen_UpdateWithWithCurrentPasswordIncorrect_ResultException() {
        when(iUserRepository.existsByUsername(any())).thenReturn(false);
        when(iUserRepository.findByUsername(any())).thenReturn(Optional.ofNullable(user));
        when(iSecurityService.matchesPassword(any(), anyString())).thenReturn(false);

        Throwable ex = assertThrows(AppExceptionValidations.class,
                () -> userService.update(UUID_DEFAULT, userUpdateDTO));

        assertEquals(AppExceptionValidations.class, ex.getClass());
    }

    @Test
    void ShouldDeleteUser_WithSuccessfully() {
        doNothing().when(iUserRepository).delete(user);

        iUserRepository.delete(user);

        verify(iUserRepository).delete(user);
        verify(iUserRepository, times(1)).delete(user);
        verify(iUserRepository, atLeastOnce()).delete(user);
    }

    @Test
    void ShouldThrowErrorWhen_TryDeleteWithUserNotFound_ResultException() {
        Throwable ex = assertThrows(AppExceptionValidations.class,
                () -> userService.delete(TEXT_DEFAULT, passwordDTO));

        assertEquals(AppExceptionValidations.class, ex.getClass());
    }

    @Test
    void ShouldThrowErrorWhen_DeleteWithWithCurrentPasswordIncorrect_ResultException() {
        when(iUserRepository.findByUsername(any())).thenReturn(Optional.ofNullable(user));
        when(iSecurityService.matchesPassword(any(), anyString())).thenReturn(false);

        Throwable ex = assertThrows(AppExceptionValidations.class,
                () -> userService.delete(TEXT_DEFAULT, passwordDTO));

        assertEquals(AppExceptionValidations.class, ex.getClass());
    }

    @Test
    void ShouldFindAllUser_WithSuccessfully() {
        when(iUserRepository.findAll()).thenReturn(List.of(user));
        when(userAppMapper.toDTO(any())).thenReturn(userResponseDTO);

        List<UserResponseDTO> response = userService.findAll();

        assertNotNull(response);
        assertEquals(UUID_DEFAULT, response.get(ZERO).getUuidUser());
        assertEquals(TEXT_DEFAULT, response.get(ZERO).getUsername());
    }

    @Test
    void ShouldThrowErrorWhen_FindUserListIsEmpty_ResultException() {
        Throwable ex = assertThrows(AppExceptionValidations.class,
                () -> userService.findAll());

        assertEquals(AppExceptionValidations.class, ex.getClass());
    }

    private void buildArrangeOfTests() {
        user = UserStubs.buildUser();
        userDTO = UserStubs.buildUserDTO();
        userResponseDTO = UserStubs.buildUserResponseDTO();
        userUpdateDTO = UserStubs.buildUserUpdateDTO();
        userResponseDTOUpdate = UserStubs.buildUserResponseDTOUpdate();
        passwordDTO = UserStubs.buildPasswordDTO();
    }
}
