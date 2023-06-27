package com.github.brunoonofre64.infra.data.enums;

public enum ErrorInfraDataMessage {
    CATEGORY_NOT_FOUND("CATEGORY_NOT_FOUND"),
    PRODUCT_NOT_FOUND("PRODUCT_NOT_FOUND"),
    USER_NOT_FOUND("USER_NOT_FOUND");

    final String value;

    ErrorInfraDataMessage(String value) {
        this.value = value;
    }
}
