package com.s1.proyecto_practica_springboot.service.impl;

import com.s1.proyecto_practica_springboot.dto.request.DetalleVentaRequestDTO;
import com.s1.proyecto_practica_springboot.dto.response.DetalleVentaResponseDTO;
import com.s1.proyecto_practica_springboot.dto.response.ProductoResponseDTO;
import com.s1.proyecto_practica_springboot.dto.response.VentaResponseDTO;
import com.s1.proyecto_practica_springboot.mapper.DetalleVentaMapper;
import com.s1.proyecto_practica_springboot.mapper.ProductoMapper;
import com.s1.proyecto_practica_springboot.repository.productoRepository;
import com.s1.proyecto_practica_springboot.mapper.VentaMapper;
import com.s1.proyecto_practica_springboot.model.DetalleVenta;
import com.s1.proyecto_practica_springboot.model.Producto;
import com.s1.proyecto_practica_springboot.model.Venta;
import com.s1.proyecto_practica_springboot.repository.DetalleVentaRepository;
import com.s1.proyecto_practica_springboot.repository.VentaRepository;
import com.s1.proyecto_practica_springboot.service.DetalleVentaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class DetalleVentaServiceImpl implements DetalleVentaService {
    private final DetalleVentaMapper DetalleVentaMapper;
    private final DetalleVentaRepository DetalleVentaRepository;
    private final VentaRepository VentaRepository;
    private final VentaMapper VentaMapper;
    private final productoRepository ProductoRepository;
    private final ProductoMapper ProductoMapper;

    @Override
    public DetalleVentaResponseDTO guardarDetalle(DetalleVentaRequestDTO dto) {
        Venta v= VentaRepository.findById(dto.ventaId()).orElseThrow(()->new RuntimeException("No existe dicha profesion"));
        Producto p= ProductoRepository.findById(dto.productoId()).orElseThrow(()->new RuntimeException("No existe dicha profesion"));
        DetalleVenta dv= DetalleVentaMapper.DTOAEntidad(dto,p,v);
        DetalleVenta dv_insertada= DetalleVentaRepository.save(dv);
        VentaResponseDTO dtoVenta=VentaMapper.entidadADTO(v);
        ProductoResponseDTO dtoproducto= ProductoMapper.entidadADTO(p);
        return DetalleVentaMapper.entidadADTO(dv_insertada,dtoproducto,dtoVenta);
    }

    @Override
    public DetalleVentaResponseDTO actualizarDetalleventa(DetalleVentaRequestDTO dto, Long id) {
        DetalleVenta dv= DetalleVentaRepository.findById(id).orElseThrow(()->new RuntimeException("Error, no existe dicha persona a actualizar"));
        Producto p= ProductoRepository.findById(dto.productoId()).orElseThrow(()->new RuntimeException("Error, no existe dicha persona a actualizar"));
        Venta v = VentaRepository.findById(dto.ventaId()).orElseThrow(()->new RuntimeException("Error, no existe dicha persona a actualizar"));
        DetalleVentaMapper.actualizarEntidadDesdeDTO(dv,dto, p,v);
        DetalleVenta dv_insertada=DetalleVentaRepository.save(dv);
        ProductoResponseDTO dtoProducto= ProductoMapper.entidadADTO(p);
        VentaResponseDTO dtoVenta= VentaMapper.entidadADTO(v);

        return DetalleVentaMapper.entidadADTO(dv_insertada,dtoProducto,dtoVenta);
    }

    @Override
    public void eliminarDetalleventa(Long id) {
        DetalleVenta dv= DetalleVentaRepository.findById(id).orElseThrow(()->new RuntimeException("Error, no existe dicha persona a actualizar"));
        DetalleVentaRepository.delete(dv);
    }

    @Override
    public List<DetalleVentaResponseDTO> vertodo() {
        return DetalleVentaRepository.findAll().stream().map(dv -> DetalleVentaMapper.entidadADTO( dv, ProductoMapper.entidadADTO(dv.getProducto()), VentaMapper.entidadADTO(dv.getVenta()))).toList();
    }
}
