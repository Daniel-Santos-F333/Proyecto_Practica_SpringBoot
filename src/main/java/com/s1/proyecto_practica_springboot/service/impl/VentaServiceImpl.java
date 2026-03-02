package com.s1.proyecto_practica_springboot.service.impl;

import com.s1.proyecto_practica_springboot.dto.request.VentaRequestDTO;
import com.s1.proyecto_practica_springboot.dto.response.VentaResponseDTO;
import com.s1.proyecto_practica_springboot.mapper.VentaMapper;
import com.s1.proyecto_practica_springboot.model.Venta;
import com.s1.proyecto_practica_springboot.repository.VentaRepository;
import com.s1.proyecto_practica_springboot.service.VentaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
@Service
@RequiredArgsConstructor
public class VentaServiceImpl implements VentaService {
    private final VentaMapper VentaMapper;
    private final VentaRepository VentaRepository;
    @Override
    public VentaResponseDTO guardarVentas(VentaRequestDTO dto) {
        Venta p=VentaMapper.DTOAEntidad(dto);
        Venta p_insertada=VentaRepository.save(p);
        return VentaMapper.entidadADTO(p_insertada);
    }

    @Override
    public VentaResponseDTO actualizarVentas(VentaRequestDTO dto, Long id) {
        Venta p=VentaRepository.findById(id).orElseThrow(()->new RuntimeException("No existe dicha profesion"));
        VentaMapper.actualizarEntidadDesdeDTO(p,dto);
        Venta p_actualizada=VentaRepository.save(p);
        return VentaMapper.entidadADTO(p_actualizada);
    }

    @Override
    public void eliminarVentas(Long id) {
        Venta v=VentaRepository.findById(id).orElseThrow(()->new RuntimeException("No existe dicha profesion"));
        VentaRepository.delete(v);
    }

    @Override
    public List<VentaResponseDTO> buscarTodos() {
        List<Venta> ventas =VentaRepository.findAll();
        return ventas.stream().map(VentaMapper::entidadADTO).toList();
    }

    @Override
    public List<VentaResponseDTO> buscarventasMayores(BigDecimal limiter) {
        List<Venta> ventas =VentaRepository.findByTotalGreaterThan(limiter);
        return ventas.stream().map(VentaMapper::entidadADTO).toList();
    }
}
