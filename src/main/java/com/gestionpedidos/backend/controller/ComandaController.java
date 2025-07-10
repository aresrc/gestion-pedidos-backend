package com.gestionpedidos.backend.controller;

import com.gestionpedidos.backend.model.Comanda;
import com.gestionpedidos.backend.model.ComandaDTO;
import com.gestionpedidos.backend.model.ComandaResponseDTO;
import com.gestionpedidos.backend.service.ComandaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
    public ResponseEntity<List<ComandaResponseDTO>> listarComandas() {
        List<ComandaResponseDTO> comandas = comandaService.listarTodasComandasDTO();
        return ResponseEntity.ok(comandas);
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
    public ResponseEntity<?> modificar(@PathVariable String id, @RequestBody Map<String, String> body) {
        comandaService.modificarComanda(id, body.get("estado"));
        return ResponseEntity.status(HttpStatus.CREATED).body(Map.of("message", "Estado cambiado exitosamente a " + body.get("estado")));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        comandaService.eliminarComanda(id);
        return ResponseEntity.ok().build();
    }
}
