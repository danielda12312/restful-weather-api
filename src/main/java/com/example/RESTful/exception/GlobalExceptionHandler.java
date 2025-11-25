package com.example.RESTful.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpClientErrorException;

@RestControllerAdvice // Tells spring to watch all controllers for errors.
public class GlobalExceptionHandler {

    // Catch 404 not found or 401 Unauthorized from the weather API
    @ExceptionHandler(HttpClientErrorException.class)
    public ResponseEntity<String> handleApiErrors(HttpClientErrorException e) {
        // If OpenWeatherMap says "City not found", we send that message to our user
        return ResponseEntity.status(e.getStatusCode()).body("API Error: " + e.getMessage());
    }

    // Catch everything else that will cause generic crash.
    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleGeneralErrors(Exception e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("Something went wrong internally " + e.getMessage());
    }
}
