package com.example.Ejercicio.Productos.model.dto.RequestDTO;



import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class CategoriaRequestDTO {

    @NotBlank(message = "Por favor ingresar un nombre a la categoria")
    @Size(max = 150)
    private String nombre;

    @NotBlank(message = "Por favor ingresar una descripcion a la categoria")
    @Size(max = 250)
    private String descripcion;
}
