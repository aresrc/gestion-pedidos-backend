package com.gestionpedidos.backend.model;

public class LoginRequest {
    private String correo;       // Usuario
    private String contrasena;   // Contraseña sin cifrar

    public String getCorreo() { return correo; }
    public void setCorreo(String correo) { this.correo = correo; }

    public String getContrasena() { return contrasena; }
    public void setContrasena(String contrasena) { this.contrasena = contrasena; }
}

