package com.gestionpedidos.backend.controller;

import com.gestionpedidos.backend.model.Comanda;
import com.gestionpedidos.backend.service.ComandaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

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

    @PutMapping("/{codigo}/estado")
    public ResponseEntity<Comanda> cambiarEstado(
            @PathVariable String codigo,
            @RequestBody Map<String, String> request) {
        String estadoString = request.get("estado");

        try {
            // Convertir string a enum
            Comanda.Estado nuevoEstado = Comanda.Estado.valueOf(estadoString);

            // Validar que solo se permitan ciertos estados
            if (nuevoEstado != Comanda.Estado.Entregado && nuevoEstado != Comanda.Estado.Cancelada) {
                return ResponseEntity.badRequest().build();
            }

            Comanda comandaActualizada = comandaService.cambiarEstado(codigo, nuevoEstado);
            return ResponseEntity.ok(comandaActualizada);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().build();
        }
    }
}
