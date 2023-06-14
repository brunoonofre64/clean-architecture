package com.github.brunoonofre64.domain.validations;

import com.github.brunoonofre64.domain.enums.ErrorMessage;

public class DomainExceptionValidations extends RuntimeException {

    final ErrorMessage message;

    public DomainExceptionValidations(ErrorMessage message) {
        this.message = message;
    }

    public static void when(boolean hasError, ErrorMessage error) {
        if (hasError) {
            throw new DomainExceptionValidations(error);
        }
    }
}
