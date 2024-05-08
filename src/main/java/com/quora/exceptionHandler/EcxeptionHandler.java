package com.quora.exceptionHandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class EcxeptionHandler {
    @ExceptionHandler(CustomException.class)
    public ResponseEntity<ErrorDTO> handleCustomException(CustomException ex) {
        ErrorDTO apiError = new ErrorDTO(HttpStatus.BAD_REQUEST, ex.getMessage());
        return new ResponseEntity<>(apiError, apiError.getStatus());
    }
}
