package com.gestionpedidos.backend.repository;

import com.gestionpedidos.backend.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    // UsuarioRepository.java
    Optional<Usuario> findByCorreo(String correo);

    @Query("SELECT u FROM Usuario u JOIN u.roles r WHERE r.nombreRol = :rol")
    List<Usuario> findByRolesNombreRol(@Param("rol") String rol);
}

