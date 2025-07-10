package com.gestionpedidos.backend.controller;

import com.gestionpedidos.backend.model.Comanda;
import com.gestionpedidos.backend.service.ComandaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/comandas")
public class ComandaController {

    @Autowired
    private ComandaService comandaService;

    @GetMapping
    public List<Comanda> obtenerTodas() {
        return comandaService.listarTodas();
    }

    @PostMapping
    public ResponseEntity<Void> insertar(@RequestBody Map<String, String> body) {
        comandaService.insertarComandaCSV(
                Integer.valueOf(body.get("cliente_id")),
                Integer.valueOf(body.get("mesero_id")),
                Short.valueOf(body.get("mesa_id")),
                body.get("estado"),
                body.get("ids_platillo"),
                body.get("cantidades")
        );
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> modificar(@PathVariable Integer id, @RequestBody Map<String, String> body) {
        comandaService.modificarComanda(id, body.get("estado"));
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        comandaService.eliminarComanda(id);
        return ResponseEntity.ok().build();
    }
}
