package com.gestionpedidos.backend.controller;

import com.gestionpedidos.backend.model.Platillo;
import com.gestionpedidos.backend.model.PlatilloDTO;
import com.gestionpedidos.backend.repository.PlatilloRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/platillos")
public class PlatilloController {

    private final PlatilloRepository platilloRepository;

    @GetMapping
    public List<PlatilloDTO> obtenerTodosLosPlatillos() {
        return platilloRepository.findAll().stream()
                .map(p -> new PlatilloDTO(
                        p.getCodigoPlatillo(),
                        p.getNombre(),
                        p.getDetalle(),
                        p.getPrecio()
                )).collect(Collectors.toList());
    }
}