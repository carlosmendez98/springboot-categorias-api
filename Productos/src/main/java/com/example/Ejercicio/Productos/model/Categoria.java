package com.example.Ejercicio.Productos.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name = "categorias")
@Data
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
public class Categoria {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String descripcion;


}



