package com.github.brunoonofre64.infra.data.validations;

import com.github.brunoonofre64.infra.data.enums.ErrorInfraDataMessage;

public class InfraDataExceptionValidations extends RuntimeException {

    final ErrorInfraDataMessage message;

    public InfraDataExceptionValidations(ErrorInfraDataMessage message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message.toString();
    }
}
