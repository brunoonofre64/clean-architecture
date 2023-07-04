package com.github.brunoonofre64.test.domain.entities;

import com.github.brunoonofre64.domain.entities.User;
import com.github.brunoonofre64.domain.validations.DomainExceptionValidations;
import com.github.brunoonofre64.test.stubs.UserStubs;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;

import static com.github.brunoonofre64.test.UnitTestConstants.TEXT_DEFAULT;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class UserTest {

    @Test
    void ShouldCreateUser_WithValidParameters_ResultObjectValid() {
        User user = UserStubs.buildUser();

        assertNotNull(user);
        assertEquals(TEXT_DEFAULT, user.getUsername());
        assertEquals(TEXT_DEFAULT, user.getPassword());
    }

    @Test
   void ShouldThrowErrorWhen_TryCreateWithInvalidUsername_ResultException() {
        Throwable ex = assertThrows(DomainExceptionValidations.class,
                () -> new User(null, TEXT_DEFAULT, new ArrayList<>()));

        assertEquals(DomainExceptionValidations.class, ex.getClass());
    }

    @Test
    void ShouldThrowErrorWhen_TryCreateWithInvalidPassword_ResultException() {
        Throwable ex = assertThrows(DomainExceptionValidations.class,
                () -> new User(TEXT_DEFAULT, null, new ArrayList<>()));

        assertEquals(DomainExceptionValidations.class, ex.getClass());
    }
}
