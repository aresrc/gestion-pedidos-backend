package com.gestionpedidos.backend.controller;

import com.gestionpedidos.backend.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalTime;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/menus")
public class MenuController {

    @Autowired
    private MenuService menuService;

    @PostMapping
    public ResponseEntity<Void> insertar(@RequestBody Map<String, String> body) {
        menuService.insertarMenu(
                body.get("nombre"),
                LocalTime.parse(body.get("hora_inicio")),
                LocalTime.parse(body.get("hora_fin"))
        );
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> modificar(@PathVariable Byte id, @RequestBody Map<String, String> body) {
        menuService.modificarMenu(
                id,
                body.get("nombre"),
                LocalTime.parse(body.get("hora_inicio")),
                LocalTime.parse(body.get("hora_fin"))
        );
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Byte id) {
        menuService.eliminarMenu(id);
        return ResponseEntity.ok().build();
    }
}
