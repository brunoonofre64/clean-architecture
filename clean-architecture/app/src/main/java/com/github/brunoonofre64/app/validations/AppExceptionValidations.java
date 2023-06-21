package com.github.brunoonofre64.app.validations;

import com.github.brunoonofre64.app.enums.ErrorAppMessage;

public class AppExceptionValidations extends RuntimeException {

    final ErrorAppMessage message;

    public AppExceptionValidations(ErrorAppMessage message) {
        this.message = message;
    }

    public static void when(boolean hasError, ErrorAppMessage message) {
        if (hasError) {
            throw new AppExceptionValidations(message);
        }
    }

    @Override
    public String getMessage() {
        return message.toString();
    }
}
