package com.gestionpedidos.backend.controller;

import com.gestionpedidos.backend.model.RegistroRequest;
import com.gestionpedidos.backend.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {
    @Autowired private UsuarioService usuarioService;

    @PostMapping
    public ResponseEntity<?> create(@RequestBody RegistroRequest req) {
        try {
            usuarioService.createUsuario(
                    req.getCorreo(), req.getContrasena(), req.getNombre(),
                    req.getApellidoPat(), req.getApellidoMat(), req.getDni(), req.getId_rol()
            );
            return ResponseEntity.status(HttpStatus.CREATED).body(Map.of("message", "Usuario creado exitosamente"));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(Map.of("error", e.getMessage()));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(Map.of("error", "Error al crear el usuario: " + e.getMessage()));
        }

    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(
            @PathVariable Integer id,
            @RequestBody RegistroRequest req
    ) {
        usuarioService.updateUsuario(
                id,
                req.getCorreo(), req.getNombre(),
                req.getApellidoPat(), req.getApellidoMat(), req.getDni()
        );
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        usuarioService.deleteUsuario(id);
        return ResponseEntity.noContent().build();
    }
}