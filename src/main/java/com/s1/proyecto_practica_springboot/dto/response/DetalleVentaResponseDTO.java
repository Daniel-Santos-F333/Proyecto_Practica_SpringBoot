package com.s1.proyecto_practica_springboot.dto.response;

import java.math.BigDecimal;

public record DetalleVentaResponseDTO(
        Long id,
        Integer cantidad,
        Long productoId,
        Long ventaId,
        BigDecimal subtotal
) {

}
