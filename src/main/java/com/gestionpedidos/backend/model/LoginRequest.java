package com.gestionpedidos.backend.model;

public class LoginRequest {
    private String nombre;       // Usuario
    private String contrasena;   // Contraseña sin cifrar

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getContrasena() { return contrasena; }
    public void setContrasena(String contrasena) { this.contrasena = contrasena; }
}

