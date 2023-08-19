package com.example.hospital.Adivce;


import com.example.hospital.Api.ApiResponse;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.InvalidDataAccessResourceUsageException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.sql.SQLIntegrityConstraintViolationException;

@RestControllerAdvice
public class ControllerAdvice {
    @ExceptionHandler
    public ResponseEntity SQLIntegrityConstraintViolationException( SQLIntegrityConstraintViolationException e){
        String message=e.getMessage();
        return ResponseEntity.status(400).body(new ApiResponse(message));
    }
    @ExceptionHandler
    public ResponseEntity InvalidDataAccessResourceUsageException(InvalidDataAccessResourceUsageException e){
        String message = e.getMessage();
        return ResponseEntity.status(400).body(new ApiResponse(message));

    }
    @ExceptionHandler
    public ResponseEntity DataIntegrityViolationException(DataIntegrityViolationException e){
        String message= e.getMessage();
        return ResponseEntity.status(400).body(new ApiResponse(message));

    }



}
