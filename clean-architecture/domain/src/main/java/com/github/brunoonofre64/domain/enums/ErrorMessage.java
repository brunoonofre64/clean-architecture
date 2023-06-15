package com.github.brunoonofre64.domain.enums;

public enum ErrorMessage {

    NAME_REQUIRED("NAME_REQUIRED"),
    NAME_INVALID("NAME_INVALID"),
    UUID_INVALID("UUID_INVALID"),
    DESCRIPTION_REQUIRED("DESCRIPTION_REQUIRED"),
    DESCRIPTION_INVALID("DESCRIPTION_INVALID"),
    PRICE_INVALID("PRICE_INVALID"),
    STOCK_INVALID("STOCK_INVALID"),
    URL_IMAGE_REQUIRED("URL_IMAGE_REQUIRED"),
    URL_IMAGE_INVALID("URL_IMAGE_INVALID");

    final String value;

    ErrorMessage(String value) {
        this.value = value;
    }
}