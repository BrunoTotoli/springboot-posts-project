package com.bruno.myproject.controllers.exceptions;

import com.bruno.myproject.services.exceptions.DatabaseException;
import com.bruno.myproject.services.exceptions.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.time.Instant;

@ControllerAdvice
public class ExceptionsHandler {

    @ExceptionHandler(value = ResourceNotFoundException.class)
    public ResponseEntity<StandardError> resourceNotFound(ResourceNotFoundException e, HttpServletRequest request) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                StandardError.builder()
                        .timestamp(Instant.now())
                        .status(HttpStatus.NOT_FOUND.value())
                        .error("RESOURCE NOT FOUND")
                        .message(e.getMessage())
                        .path(request.getRequestURI())
                        .build());
    }

    @ExceptionHandler(value = DatabaseException.class)
    public ResponseEntity<StandardError> integrityConstraint(DatabaseException e, HttpServletRequest request) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                StandardError.builder()
                        .timestamp(Instant.now())
                        .status(HttpStatus.NOT_FOUND.value())
                        .error("Integrity Violation")
                        .message(e.getMessage())
                        .path(request.getRequestURI())
                        .build());
    }
}
