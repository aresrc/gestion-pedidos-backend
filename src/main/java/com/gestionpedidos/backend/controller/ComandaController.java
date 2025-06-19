package com.gestionpedidos.backend.controller;

import com.gestionpedidos.backend.model.Comanda;
import com.gestionpedidos.backend.service.ComandaService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/comandas")
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
public class ComandaController {

    private final ComandaService comandaService;

    @GetMapping
    public List<Comanda> obtenerTodas() {
        return comandaService.listarTodas();
    }

    @GetMapping("/{codigo}")
    public Comanda obtenerPorCodigo(@PathVariable String codigo) {
        return comandaService.buscarPorId(codigo);
    }

    @PostMapping
    public Comanda registrarComanda(@RequestBody Comanda comanda) {
        return comandaService.guardarComanda(comanda);
    }
}
