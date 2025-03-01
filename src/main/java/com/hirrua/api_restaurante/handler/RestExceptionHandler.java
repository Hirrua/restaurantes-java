package com.hirrua.api_restaurante.handler;

import com.hirrua.api_restaurante.exceptions.CustomerNotFoundException;
import com.hirrua.api_restaurante.exceptions.NoDataAvailableException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(CustomerNotFoundException.class)
    private ResponseEntity<String> customerNotFoundHandler(CustomerNotFoundException exception) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception.getMessage());
    }

    private ResponseEntity<String> noDataAvailableHandler(NoDataAvailableException exception) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception.getMessage());
    }
}
