package com.s1.proyecto_practica_springboot.dto.request;

import java.math.BigDecimal;

public record DetalleVentaRequestDTO(
        Long productoId,
        Long ventaId,
        Integer cantidad,
        BigDecimal subtotal
) {
}
