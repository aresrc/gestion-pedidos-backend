package com.gestionpedidos.backend.repository;

import com.gestionpedidos.backend.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    // UsuarioRepository.java
    Optional<Usuario> findByCorreo(String correo);
}

