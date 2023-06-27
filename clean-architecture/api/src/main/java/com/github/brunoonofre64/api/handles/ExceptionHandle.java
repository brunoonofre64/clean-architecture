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

@ControllerAdvice
public class ExceptionHandle {
    private static final String BAD_REQUEST = "BAD REQUEST";
    private static final LocalDateTime TIMESTAMP = LocalDateTime.now();

    private final ReloadableResourceBundleMessageSource messageSource;

    public ExceptionHandle(ReloadableResourceBundleMessageSource messageSource) {
        this.messageSource = messageSource;
    }

    @ExceptionHandler(DomainExceptionValidations.class)
    public ResponseEntity<ErrorResponse> handlerDomainExceptionValidations(DomainExceptionValidations ex) {
        ErrorResponse errorResponse = new ErrorResponse(BAD_REQUEST, HttpStatus.BAD_REQUEST.value(), TIMESTAMP, this.getCodeMessage(ex.getMessage()));
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
    }

    @ExceptionHandler(AppExceptionValidations.class)
    public ResponseEntity<ErrorResponse> handlerAppExceptionValidations(AppExceptionValidations ex) {
        ErrorResponse errorResponse = new ErrorResponse(BAD_REQUEST, HttpStatus.BAD_REQUEST.value(), TIMESTAMP, this.getCodeMessage(ex.getMessage()));
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
    }

    @ExceptionHandler(InfraDataExceptionValidations.class)
    public ResponseEntity<ErrorResponse> handlerInfraDataExceptionValidations(InfraDataExceptionValidations ex) {
        ErrorResponse errorResponse = new ErrorResponse(BAD_REQUEST, HttpStatus.BAD_REQUEST.value(), TIMESTAMP, this.getCodeMessage(ex.getMessage()));
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
    }

    private String getCodeMessage(String codigoMensagem) {
        return messageSource.getMessage(codigoMensagem, null, LocaleContextHolder.getLocale());
    }
}
