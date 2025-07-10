package com.gestionpedidos.backend.controller;

import com.gestionpedidos.backend.service.RolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/roles")
public class RolController {

    @Autowired
    private RolService rolService;

    @PostMapping
    public ResponseEntity<Void> insertar(@RequestBody Map<String, String> body) {
        rolService.insertarRol(body.get("nombre"));
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> modificar(@PathVariable Byte id, @RequestBody Map<String, String> body) {
        rolService.modificarRol(id, body.get("nombre"));
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Byte id) {
        rolService.eliminarRol(id);
        return ResponseEntity.ok().build();
    }
}

