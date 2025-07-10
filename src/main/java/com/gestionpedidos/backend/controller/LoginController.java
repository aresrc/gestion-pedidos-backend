package com.gestionpedidos.backend.controller;

import com.gestionpedidos.backend.config.JwtUtils;
import com.gestionpedidos.backend.model.LoginRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api")
public class LoginController {

    @Autowired
    private AuthenticationManager authManager;

    @Autowired
    private JwtUtils jwtUtils;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest req) {
        UsernamePasswordAuthenticationToken authToken =
                new UsernamePasswordAuthenticationToken(req.getCorreo(), req.getContrasena());

        try {
            Authentication auth = authManager.authenticate(authToken);

            // Generar JWT
            String jwt = jwtUtils.generateToken(auth);

            return ResponseEntity.ok(Map.of(
                    "token", jwt,
                    "type", "Bearer"
            ));
        } catch (BadCredentialsException ex) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body(Map.of("error","Credenciales inválidas"));
        }
    }
}


