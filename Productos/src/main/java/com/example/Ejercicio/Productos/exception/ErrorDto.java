package com.example.Ejercicio.Productos.exception;


import lombok.Builder;
import lombok.Data;


@Data
public class ErrorDto {
    private String message;
    private String cod;

    public ErrorDto(String message, String cod) {
        this.message = message;
        this.cod = cod;
    }
}