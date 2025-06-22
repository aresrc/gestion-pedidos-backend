package com.gestionpedidos.backend.service;

import com.gestionpedidos.backend.model.Comanda;
import com.gestionpedidos.backend.repository.ComandaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ComandaService {

    private final ComandaRepository comandaRepository;

    public List<Comanda> listarTodas() {
        return comandaRepository.findAll();
    }

    public Comanda buscarPorId(String codigo) {
        return comandaRepository.findById(codigo).orElse(null);
    }

    public Comanda guardarComanda(Comanda comanda) {
        if (comanda.getCodigoComanda() == null || comanda.getCodigoComanda().isEmpty()) {
            throw new IllegalArgumentException("El código de la comanda no puede estar vacío");
        }
        return comandaRepository.save(comanda);
    }

    public Comanda cambiarEstado(String codigoComanda, Comanda.Estado nuevoEstado) {
        Comanda comanda = buscarPorId(codigoComanda);
        if (comanda != null) {
            comanda.setEstado(nuevoEstado);
            return comandaRepository.save(comanda);
        }
        throw new RuntimeException("Comanda no encontrada con código: " + codigoComanda);
    }
}
