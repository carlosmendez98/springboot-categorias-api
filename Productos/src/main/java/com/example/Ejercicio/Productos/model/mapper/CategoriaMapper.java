package com.example.Ejercicio.Productos.model.mapper;


import com.example.Ejercicio.Productos.model.Categoria;
import com.example.Ejercicio.Productos.model.dto.RequestDTO.CategoriaRequestDTO;
import com.example.Ejercicio.Productos.model.dto.ResponseDTO.CategoriaResponseDTO;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class CategoriaMapper {


     // crear mapper para entidad de categoria
    public static Categoria toEntity(CategoriaRequestDTO categoriaRequest){
        Categoria categoria = new Categoria();

        categoria.setNombre((categoriaRequest.getNombre()));
        categoria.setDescripcion(categoriaRequest.getDescripcion());
        return categoria;
    }

    // Crear Mapper para la respuesta hacia el front
    public static CategoriaResponseDTO toDto(Categoria categoria){
        return new CategoriaResponseDTO(categoria.getNombre(), categoria.getDescripcion());


    }



}
