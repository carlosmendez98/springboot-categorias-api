package com.example.Ejercicio.Productos.service;


import com.example.Ejercicio.Productos.model.dto.RequestDTO.CategoriaRequestDTO;
import com.example.Ejercicio.Productos.model.dto.ResponseDTO.CategoriaResponseDTO;
import com.example.Ejercicio.Productos.model.Categoria;
import com.example.Ejercicio.Productos.repository.CategoriaRepository;
import org.springframework.expression.ExpressionException;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

import static com.example.Ejercicio.Productos.model.mapper.CategoriaMapper.toDto;
import static com.example.Ejercicio.Productos.model.mapper.CategoriaMapper.toEntity;

@Service
public class CategoriaServiceImpl implements CategoriaService {


    private final CategoriaRepository categoriaRepository;


    public CategoriaServiceImpl(CategoriaRepository categoriaRepository){
        this.categoriaRepository = categoriaRepository;
    }

    @Override
    public List<CategoriaResponseDTO> listadoCategoria() {

        List<Categoria> Lista_categorias = this.categoriaRepository.findAll();
        return Lista_categorias.stream()
                .map(categoria -> new CategoriaResponseDTO(
                        categoria.getNombre(),
                        categoria.getDescripcion()
                )).collect(Collectors.toList());
    }


    @Override
    public CategoriaResponseDTO guardarCategoria(CategoriaRequestDTO categoriaReq) {
       Categoria categoria = this.categoriaRepository.save(toEntity(categoriaReq));
        return toDto(categoria);
    }


    @Override
    public CategoriaResponseDTO buscarCategoria(int categoriaId) {
        Categoria categoria = this.categoriaRepository.findById(categoriaId).orElseThrow(() -> new RuntimeException("La categoría con ID " + categoriaId + " no fue encontrada"));
        return  toDto(categoria);
    }

    @Override
    public CategoriaResponseDTO actualizarCategoria(CategoriaRequestDTO categoriaReq, int categoriaId) {
        Categoria categoria = this.categoriaRepository.findById(categoriaId).orElseThrow(() -> new RuntimeException("La categoría con ID " + categoriaId + " no fue encontrada"));

        categoria.setNombre(categoriaReq.getNombre());
        categoria.setDescripcion(categoriaReq.getDescripcion());

        Categoria categoriaActualizada = this.categoriaRepository.save(categoria);
        return toDto(categoriaActualizada);
    }
    @Override
    public void eliminarCategoria(int categoriaId) {
        Categoria categoria = this.categoriaRepository.findById(categoriaId).orElseThrow(() -> new RuntimeException("La categoría con ID " + categoriaId + " no fue encontrada"));
        this.categoriaRepository.delete(categoria);
    }
}
