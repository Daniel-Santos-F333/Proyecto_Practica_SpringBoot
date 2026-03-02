package com.s1.proyecto_practica_springboot.service;

import com.s1.proyecto_practica_springboot.dto.request.VentaRequestDTO;
import com.s1.proyecto_practica_springboot.dto.response.VentaResponseDTO;

import java.math.BigDecimal;
import java.util.List;

public interface VentaService {
    VentaResponseDTO guardarVentas(VentaRequestDTO dto);

    VentaResponseDTO actualizarVentas(VentaRequestDTO dto, Long id);
    void eliminarVentas(Long id);
    List<VentaResponseDTO> buscarTodos();
    List<VentaResponseDTO> buscarventasMayores(BigDecimal limiter);
}
