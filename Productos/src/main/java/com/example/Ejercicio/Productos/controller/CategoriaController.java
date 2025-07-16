package com.example.Ejercicio.Productos.controller;

import com.example.Ejercicio.Productos.model.dto.RequestDTO.CategoriaRequestDTO;
import com.example.Ejercicio.Productos.model.dto.ResponseDTO.CategoriaResponseDTO;
import com.example.Ejercicio.Productos.service.CategoriaServiceImpl;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categoria")
public class CategoriaController {

    private final CategoriaServiceImpl CategoriaServiceImpl;

    public CategoriaController(CategoriaServiceImpl categoriaServiceImpl) {
        CategoriaServiceImpl = categoriaServiceImpl;
    }


    @GetMapping
    public ResponseEntity<List<CategoriaResponseDTO>> Listar() {
        return ResponseEntity.ok(this.CategoriaServiceImpl.listadoCategoria());
    }

    @PostMapping
    public ResponseEntity<CategoriaResponseDTO> guardarCategoria(@Valid @RequestBody CategoriaRequestDTO request) {

        CategoriaResponseDTO response = this.CategoriaServiceImpl.guardarCategoria(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);

    }

    @PutMapping("/{id}")
    public ResponseEntity<CategoriaResponseDTO> actualizarCategoria(@Valid @RequestBody CategoriaRequestDTO request, @PathVariable int id) {
        CategoriaResponseDTO response = this.CategoriaServiceImpl.actualizarCategoria(request, id);
        return new ResponseEntity<>(response, HttpStatus.CREATED);


    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoriaResponseDTO> buscarCategoria(@PathVariable int id) {
        CategoriaResponseDTO response = this.CategoriaServiceImpl.buscarCategoria(id);
        return new ResponseEntity<>(response, HttpStatus.OK);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<CategoriaResponseDTO> eliminarCategoria(@PathVariable int id) {
        this.CategoriaServiceImpl.eliminarCategoria(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

