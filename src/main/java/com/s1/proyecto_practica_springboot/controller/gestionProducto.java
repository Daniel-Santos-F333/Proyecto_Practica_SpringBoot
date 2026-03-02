package com.s1.proyecto_practica_springboot.controller;

import com.s1.proyecto_practica_springboot.dto.request.ProductoRequestDTO;
import com.s1.proyecto_practica_springboot.dto.response.ProductoResponseDTO;
import com.s1.proyecto_practica_springboot.service.impl.ProductoServiceImpl;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Gestion Producto", description = "gestiona los productos")

@RestController
@RequestMapping("/api/producto")
@RequiredArgsConstructor
public class gestionProducto {
    private final ProductoServiceImpl ProductoService;
    @PostMapping
    public ResponseEntity<ProductoResponseDTO> guardar(@RequestBody ProductoRequestDTO dto){
        return ResponseEntity.status(HttpStatus.CREATED).body(ProductoService.guardarProducto(dto));
    }
    @PutMapping("/{id}")
    public ResponseEntity<ProductoResponseDTO> actualizar (@RequestBody ProductoRequestDTO dto, @PathVariable Long id){
        return ResponseEntity.ok().body(ProductoService.actualizarProducto(dto, id));
    }
    @GetMapping
    public ResponseEntity<List<ProductoResponseDTO>> ListarTodoProducto(){
        return ResponseEntity.ok().body(ProductoService.buscarTodos());
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarProducto(@PathVariable Long id){
        ProductoService.eliminarProducto(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
