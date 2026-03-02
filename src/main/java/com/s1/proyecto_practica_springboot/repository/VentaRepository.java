package com.s1.proyecto_practica_springboot.repository;

import com.s1.proyecto_practica_springboot.model.Venta;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import java.math.BigDecimal;
import java.util.List;

@Repository
public interface VentaRepository extends JpaRepository<Venta, Long> {
    List<Venta> findByTotalGreaterThan(BigDecimal limiter);

}
