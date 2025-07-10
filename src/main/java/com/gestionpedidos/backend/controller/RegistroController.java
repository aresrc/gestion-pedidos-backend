package com.gestionpedidos.backend.controller;

import com.gestionpedidos.backend.model.RegistroRequest;
import com.gestionpedidos.backend.model.Rol;
import com.gestionpedidos.backend.model.Usuario;
import com.gestionpedidos.backend.repository.RolRepository;
import com.gestionpedidos.backend.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class RegistroController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private RolRepository rolRepository;

    private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    @PostMapping("/registro")
    public ResponseEntity<?> registrarUsuario(@RequestBody RegistroRequest request) {

        // Validar que el nombre no esté repetido
        if (usuarioRepository.findByCorreo(request.getCorreo()).isPresent()) {
            return ResponseEntity.badRequest().body(Map.of("message", "El correo ya esta registrado."));
        }

        Usuario nuevoUsuario = new Usuario();
        nuevoUsuario.setCorreo(request.getCorreo());
        nuevoUsuario.setContrasena(encoder.encode(request.getContrasena()));

        // Asignar roles
        Set<Rol> rolesAsignados = new HashSet<>();
        for (Integer idRol : request.getRoles()) {
            Rol rol = rolRepository.findById(idRol)
                    .orElseThrow(() -> new RuntimeException("Rol no encontrado con ID: " + idRol));
            rolesAsignados.add(rol);
        }

        nuevoUsuario.setRoles(rolesAsignados);
        usuarioRepository.save(nuevoUsuario);

        return ResponseEntity.ok(Map.of("message", "Usuario registrado con éxito."));
    }
}

