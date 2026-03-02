package com.s1.proyecto_practica_springboot.dto.request;

import java.math.BigDecimal;

public record ProductoRequestDTO(
        String nombre,
        BigDecimal precio,
        Integer stock
) {
}
