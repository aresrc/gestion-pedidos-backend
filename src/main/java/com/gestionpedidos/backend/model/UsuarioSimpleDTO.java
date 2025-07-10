package com.gestionpedidos.backend.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Set;
import java.util.stream.Collectors;

@Getter
@Setter
public class UsuarioSimpleDTO {
    private Integer idUsuario;
    private String nombre;
    private Set<String> roles;

    public UsuarioSimpleDTO(Usuario usuario) {
        this.idUsuario = usuario.getIdUsuario();
        this.nombre = usuario.getNombre();
        this.roles = usuario.getRoles().stream()
                .map(Rol::getNombreRol)
                .collect(Collectors.toSet());
    }
}