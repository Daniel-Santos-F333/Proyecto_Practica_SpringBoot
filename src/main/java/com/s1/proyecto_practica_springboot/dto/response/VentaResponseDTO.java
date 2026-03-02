package com.s1.proyecto_practica_springboot.dto.response;

import java.math.BigDecimal;

public record VentaResponseDTO(
        Long id,
        BigDecimal total
) {

}
