package com.gestionpedidos.backend.service;

import com.gestionpedidos.backend.model.Platillo;
import com.gestionpedidos.backend.repository.PlatilloRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class PlatilloService {

    private final PlatilloRepository platilloRepository;

    public List<Platillo> listarTodos() {
        return platilloRepository.findAll();
    }

    public Optional<Platillo> buscarPorId(String codigoPlatillo) {
        return platilloRepository.findById(codigoPlatillo);
    }

    public Platillo guardarPlatillo(Platillo platillo) {
        return platilloRepository.save(platillo);
    }

    public Platillo actualizarPlatillo(String codigoPlatillo, Platillo platilloActualizado) {
        return platilloRepository.findById(codigoPlatillo)
                .map(platillo -> {
                    platillo.setNombre(platilloActualizado.getNombre());
                    platillo.setDetalle(platilloActualizado.getDetalle());
                    platillo.setPrecio(platilloActualizado.getPrecio());
                    return platilloRepository.save(platillo);
                })
                .orElseThrow(() -> new RuntimeException("Platillo no encontrado: " + codigoPlatillo));
    }

    public void eliminarPlatillo(String codigoPlatillo) {
        platilloRepository.deleteById(codigoPlatillo);
    }
}