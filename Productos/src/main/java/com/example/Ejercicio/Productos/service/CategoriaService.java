package com.example.Ejercicio.Productos.service;

import com.example.Ejercicio.Productos.model.dto.RequestDTO.CategoriaRequestDTO;
import com.example.Ejercicio.Productos.model.dto.ResponseDTO.CategoriaResponseDTO;
import com.example.Ejercicio.Productos.model.Categoria;

import java.util.List;

public interface CategoriaService {

    List<CategoriaResponseDTO> listadoCategoria();
    CategoriaResponseDTO guardarCategoria(CategoriaRequestDTO categoriaReq);
    CategoriaResponseDTO buscarCategoria(int categoriaId);
    CategoriaResponseDTO actualizarCategoria(CategoriaRequestDTO categoriaReq, int categoriaId);
    void eliminarCategoria(int categoriaId);

}
