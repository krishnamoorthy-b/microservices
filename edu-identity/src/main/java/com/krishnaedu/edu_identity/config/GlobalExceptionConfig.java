package com.krishnaedu.edu_identity.config;

import com.krishnaedu.edu_identity.exception.AuthException;
import com.krishnaedu.edu_identity.exception.BusinessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionConfig {

    @ExceptionHandler(value = {AuthException.class})
    protected ResponseEntity<?> businessExceptionHandler(){
        return ResponseEntity.status(HttpStatus.FORBIDDEN.value()).build();
    }
}
