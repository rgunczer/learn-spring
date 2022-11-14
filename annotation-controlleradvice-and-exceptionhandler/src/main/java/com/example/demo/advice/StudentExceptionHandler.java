package com.example.demo.advice;

import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.demo.AppError;
import com.example.demo.StudentNotFoundException;

@RestControllerAdvice
public class StudentExceptionHandler {

    @ExceptionHandler(StudentNotFoundException.class)
    public ResponseEntity<AppError> handleException(StudentNotFoundException ex) {
        System.out.println("create error obj");

        AppError err = new AppError(
            UUID.randomUUID().toString(),
            ex.getMessage(),
            HttpStatus.INTERNAL_SERVER_ERROR
        );

        return new ResponseEntity<>(err, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
