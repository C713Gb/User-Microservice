package com.gbeedev.userservice.exceptions;

import com.gbeedev.userservice.payload.Error;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<Error> handleException(
            ResourceNotFoundException e) {

        Error error = Error.builder().message(e.getMessage()).build();
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(EmailAlreadyExistsException.class)
    public ResponseEntity<Error> handleException(
            EmailAlreadyExistsException e) {

        Error error = Error.builder().message(e.getMessage()).build();
        return new ResponseEntity<>(error, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(MissingFieldsException.class)
    public ResponseEntity<Error> handleException(
            MissingFieldsException e) {

        Error error = Error.builder().message(e.getMessage()).build();
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

}
