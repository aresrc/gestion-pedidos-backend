package com.gestionpedidos.backend.controller;

import com.gestionpedidos.backend.model.Mesa;
import com.gestionpedidos.backend.service.MesaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/mesas")
public class MesaController {

    @Autowired
    private MesaService mesaService;

    @GetMapping
    public ResponseEntity<List<Mesa>> getAllMesas() {
        List<Mesa> mesas = mesaService.getAllMesas();
        return new ResponseEntity<>(mesas, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Void> insertar(@RequestBody Map<String, String> body) {
        mesaService.insertarMesa(
                Short.valueOf(body.get("numero")),
                body.get("estado"),
                Byte.valueOf(body.get("capacidad"))
        );
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> modificar(@PathVariable Short id, @RequestBody Map<String, String> body) {
        mesaService.modificarMesa(
                id,
                body.get("estado"),
                Byte.valueOf(body.get("capacidad"))
        );
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Short id) {
        mesaService.eliminarMesa(id);
        return ResponseEntity.ok().build();
    }
}
