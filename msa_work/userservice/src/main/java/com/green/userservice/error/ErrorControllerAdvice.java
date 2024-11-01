package com.green.userservice.error;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@ControllerAdvice
public class ErrorControllerAdvice {

    @ExceptionHandler(UserException.class)
    public ResponseEntity<String> userException(UserException e){
        return ResponseEntity.badRequest().body(e.getMessage());
    }
}
