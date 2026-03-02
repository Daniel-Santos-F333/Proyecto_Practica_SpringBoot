package com.s1.proyecto_practica_springboot.service;

import com.s1.proyecto_practica_springboot.dto.request.DetalleVentaRequestDTO;
import com.s1.proyecto_practica_springboot.dto.response.DetalleVentaResponseDTO;

import java.util.List;

public interface DetalleVentaService {
    DetalleVentaResponseDTO guardarDetalle(DetalleVentaRequestDTO dto);
    DetalleVentaResponseDTO actualizarDetalleventa(DetalleVentaRequestDTO dto,Long id);
    void eliminarDetalleventa (Long id);
    List<DetalleVentaResponseDTO> vertodo();
}
