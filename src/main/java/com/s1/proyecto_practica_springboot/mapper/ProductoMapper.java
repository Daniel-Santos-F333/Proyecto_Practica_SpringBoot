package com.s1.proyecto_practica_springboot.mapper;

import com.s1.proyecto_practica_springboot.dto.request.ProductoRequestDTO;
import com.s1.proyecto_practica_springboot.dto.response.ProductoResponseDTO;
import com.s1.proyecto_practica_springboot.model.Producto;
import org.springframework.stereotype.Component;


@Component
public class ProductoMapper {
    public ProductoResponseDTO entidadADTO(Producto producto) {
        if (producto == null) return null;
        return new ProductoResponseDTO(
                producto.getId(), producto.getNombre(),
                producto.getPrecio(),
                producto.getStock()
        );
    }

    public Producto DTOAEntidad(ProductoRequestDTO dto) {
        if (dto == null) return null;
        Producto p = new Producto();
        p.setNombre(dto.nombre());
        p.setPrecio(dto.precio());
        p.setStock(dto.stock());
        return p;
    }

    public void actualizarEntidadDesdeDTO(Producto producto, ProductoRequestDTO dto) {
        if (producto == null || dto == null) return;
        producto.setNombre(dto.nombre());
        producto.setPrecio(dto.precio());
        producto.setStock(dto.stock());
    }

}
