package com.s1.proyecto_practica_springboot.mapper;

import com.s1.proyecto_practica_springboot.dto.request.DetalleVentaRequestDTO;
import com.s1.proyecto_practica_springboot.dto.response.DetalleVentaResponseDTO;
import com.s1.proyecto_practica_springboot.dto.response.VentaResponseDTO;
import com.s1.proyecto_practica_springboot.model.DetalleVenta;
import com.s1.proyecto_practica_springboot.dto.response.ProductoResponseDTO;
import com.s1.proyecto_practica_springboot.model.Producto;
import com.s1.proyecto_practica_springboot.model.Venta;
import org.springframework.stereotype.Component;

@Component
public class DetalleVentaMapper {
    public DetalleVentaResponseDTO entidadADTO(DetalleVenta detalleVenta, ProductoResponseDTO dtoproducto, VentaResponseDTO dtoventa) {
        if (detalleVenta == null || dtoproducto == null || dtoventa==null) return null;
        return new DetalleVentaResponseDTO(
                detalleVenta.getId(), detalleVenta.getCantidad(),
                detalleVenta.getProducto().getId(),
                detalleVenta.getVenta().getId(),
                detalleVenta.getSubtotal()
        );
    }

    public DetalleVenta DTOAEntidad(DetalleVentaRequestDTO dto, Producto producto, Venta venta) {
        if (dto == null) return null;
        DetalleVenta d = new DetalleVenta();
        d.setCantidad(dto.cantidad());
        d.setSubtotal(dto.subtotal());
        d.setVenta(venta);
        return d;
    }

    public void actualizarEntidadDesdeDTO(DetalleVenta detalleVenta, DetalleVentaRequestDTO dto,Producto producto,Venta venta) {
        if (detalleVenta == null || dto == null) return;
        DetalleVenta d = new DetalleVenta();
        d.setCantidad(dto.cantidad());
        d.setSubtotal(dto.subtotal());
    }
}
