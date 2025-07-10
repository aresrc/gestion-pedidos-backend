package com.gestionpedidos.backend.controller;

import com.gestionpedidos.backend.service.RolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/roles")
public class RolController {
    @Autowired private RolService roleService;

    @PostMapping
    public ResponseEntity<?> create(@RequestParam String nombre) {
        roleService.createRole(nombre);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(
            @PathVariable Integer id,
            @RequestParam String nombre
    ) {
        roleService.updateRole(id, nombre);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        roleService.deleteRole(id);
        return ResponseEntity.noContent().build();
    }
}
