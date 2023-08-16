package com.OnlineBookStore.OnlineBookStore.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class globalExceptionHandler {

    @ExceptionHandler(userNotFoundException.class)
    public ResponseEntity<String> handleUserNotFoundException(userNotFoundException ex){
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(bookNotFounException.class)
    public ResponseEntity<String> handelBookNotFounException(bookNotFounException ex){
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(romoveFromTheOrderException.class)
    public ResponseEntity<String> handelbookNotFounException(romoveFromTheOrderException ex){
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }
}
