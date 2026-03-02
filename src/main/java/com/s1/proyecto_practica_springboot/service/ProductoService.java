package com.s1.proyecto_practica_springboot.service;

import com.s1.proyecto_practica_springboot.dto.request.ProductoRequestDTO;
import com.s1.proyecto_practica_springboot.dto.response.ProductoResponseDTO;

import java.util.List;

public interface ProductoService {
    ProductoResponseDTO guardarProducto(ProductoRequestDTO dto);

    ProductoResponseDTO actualizarProducto(ProductoRequestDTO dto, Long id);
    void eliminarProducto(Long id);
    List<ProductoResponseDTO> buscarTodos();
    List<ProductoResponseDTO> buscarProductoStockBajo(int Stock);
    List<ProductoResponseDTO> buscarProductosLetra (String letra);
}
