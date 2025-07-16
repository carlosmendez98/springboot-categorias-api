package com.example.Ejercicio.Productos.controller;


import com.example.Ejercicio.Productos.exception.ErrorDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

@RestControllerAdvice
public class ControllerAdvice {

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ErrorDto> responseErrorHandler(RuntimeException ex){
        ErrorDto error = new ErrorDto(ex.getMessage(), "Error = 404");
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<String>> handleValidationErrors(MethodArgumentNotValidException ex){
     List<String> errors = ex.getBindingResult()
             .getFieldErrors()
             .stream()
             .map(fieldError -> fieldError.getField() + ": " + fieldError.getDefaultMessage())
             .toList();
     return ResponseEntity.badRequest().body(errors);







    }

}
