package com.s1.proyecto_practica_springboot.dto.response;

import java.math.BigDecimal;

public record ProductoResponseDTO(
        Long id,
        String nombre,
        BigDecimal precio,
        Integer stock
) {
}
