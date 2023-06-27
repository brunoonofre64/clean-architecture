package com.github.brunoonofre64.api.handles;

import com.github.brunoonofre64.app.validations.AppExceptionValidations;
import com.github.brunoonofre64.domain.validations.DomainExceptionValidations;
import com.github.brunoonofre64.infra.data.validations.InfraDataExceptionValidations;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;
import java.util.Map;

@ControllerAdvice
public class ExceptionHandle {
    private static final String BAD_REQUEST = "BAD REQUEST";
    private static final LocalDateTime TIMESTAMP = LocalDateTime.now();

    private final Map<String, ReloadableResourceBundleMessageSource> messageSources;

    public ExceptionHandle(Map<String, ReloadableResourceBundleMessageSource> messageSources) {
        this.messageSources = messageSources;
    }

    @ExceptionHandler(DomainExceptionValidations.class)
    public ResponseEntity<ErrorResponse> handlerDomainExceptionValidations(DomainExceptionValidations ex) {
        return handleException(ex, "domainException");
    }

    @ExceptionHandler(AppExceptionValidations.class)
    public ResponseEntity<ErrorResponse> handlerAppExceptionValidations(AppExceptionValidations ex) {
        return handleException(ex, "apiException");
    }

    @ExceptionHandler(InfraDataExceptionValidations.class)
    public ResponseEntity<ErrorResponse> handlerInfraDataExceptionValidations(InfraDataExceptionValidations ex) {
        return handleException(ex, "infraDataException");
    }

    private ResponseEntity<ErrorResponse> handleException(Exception ex, String messageSourceQualifier) {
        String message = this.getCodeMessage(ex.getMessage(), messageSourceQualifier);
        ErrorResponse errorResponse = new ErrorResponse(BAD_REQUEST, HttpStatus.BAD_REQUEST.value(), TIMESTAMP, message);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
    }

    private String getCodeMessage(String codigoMensagem, String messageSourceQualifier) {
        ReloadableResourceBundleMessageSource messageSource = messageSources.get(messageSourceQualifier);
        return messageSource.getMessage(codigoMensagem, null, LocaleContextHolder.getLocale());
    }
}
