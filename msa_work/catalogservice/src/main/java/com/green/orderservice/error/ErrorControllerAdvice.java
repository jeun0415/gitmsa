package com.green.orderservice.error;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ErrorControllerAdvice {

    @ExceptionHandler(CatalogException.class)
    public ResponseEntity<String> catalogException(CatalogException e){
        return ResponseEntity.badRequest().body(e.getMessage());
    }
}
