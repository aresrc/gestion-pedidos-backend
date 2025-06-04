package com.gestionpedidos.backend.service;

import com.gestionpedidos.backend.model.Comanda;
import com.gestionpedidos.backend.repository.ComandaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComandaService {

    @Autowired
    private ComandaRepository comandaRepository;

    public List<Comanda> listarTodas() {
        return comandaRepository.findAll();
    }

    public Comanda buscarPorId(String codigo) {
        return comandaRepository.findById(codigo).orElse(null);
    }
}
