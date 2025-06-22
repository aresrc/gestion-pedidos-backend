package com.gestionpedidos.backend.model;

import java.util.Set;

public class RegistroRequest {
    private String nombre;
    private String contrasena;
    private Set<Integer> roles; // IDs de los roles seleccionados

    // Getters y Setters
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getContrasena() { return contrasena; }
    public void setContrasena(String contrasena) { this.contrasena = contrasena; }

    public Set<Integer> getRoles() { return roles; }
    public void setRoles(Set<Integer> roles) { this.roles = roles; }
}

