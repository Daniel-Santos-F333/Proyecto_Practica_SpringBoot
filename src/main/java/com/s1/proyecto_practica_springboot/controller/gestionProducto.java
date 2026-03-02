package com.s1.proyecto_practica_springboot.controller;

import com.s1.proyecto_practica_springboot.dto.request.ProductoRequestDTO;
import com.s1.proyecto_practica_springboot.dto.response.ProductoResponseDTO;
import com.s1.proyecto_practica_springboot.service.impl.ProductoServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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
    @Operation(summary = "Registrar un nuevo producto", description = "Crea un producto en la base de datos y retorna sus detalles.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Producto creado exitosamente",
                    content = @Content(schema = @Schema(implementation = ProductoResponseDTO.class))),
            @ApiResponse(responseCode = "400", description = "Datos de entrada inválidos")
    })
    @PostMapping
    public ResponseEntity<ProductoResponseDTO> guardar(@RequestBody ProductoRequestDTO dto){
        return ResponseEntity.status(HttpStatus.CREATED).body(ProductoService.guardarProducto(dto));
    }

    @Operation(summary = "Actualizar un producto existente", description = "Modifica los datos de un producto basado en su ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Producto actualizado correctamente"),
            @ApiResponse(responseCode = "404", description = "Producto no encontrado")
    })

    @PutMapping("/{id}")
    public ResponseEntity<ProductoResponseDTO> actualizar (@RequestBody ProductoRequestDTO dto, @PathVariable Long id){
        return ResponseEntity.ok().body(ProductoService.actualizarProducto(dto, id));
    }

    @Operation(summary = "Listar todos los productos", description = "Retorna una lista completa de los productos registrados.")
    @ApiResponse(responseCode = "200", description = "Lista obtenida correctamente")

    @GetMapping
    public ResponseEntity<List<ProductoResponseDTO>> ListarTodoProducto(){
        return ResponseEntity.ok().body(ProductoService.buscarTodos());
    }

    @Operation(summary = "Eliminar un producto", description = "Borra permanentemente un producto de la base de datos por su ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Producto eliminado exitosamente"),
            @ApiResponse(responseCode = "404", description = "ID de producto no encontrado")
    })

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarProducto(@PathVariable Long id){
        ProductoService.eliminarProducto(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
