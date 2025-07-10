package com.gestionpedidos.backend.model;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private Integer idUsuario;

    @Column(name = "correo", nullable = false, unique = true)
    private String correo;

    @Column(name = "password_hash", nullable = false)
    @JsonIgnore
    private String contrasena;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "apellido_pat", nullable = false)
    private String apellidoPat;

    @Column(name = "apellido_mat")
    private String apellidoMat;

    @Column(name = "dni", nullable = false, unique = true, length = 8)
    private String dni;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "Usuario_Rol",
            joinColumns = @JoinColumn(name = "id_usuario"),
            inverseJoinColumns = @JoinColumn(name = "id_rol")
    )
    @JsonManagedReference // Maneja la referencia directa
    private Set<Rol> roles = new HashSet<>();

    // Getters y Setters
    public Integer getIdUsuario() { return idUsuario; }
    public void setIdUsuario(Integer idUsuario) { this.idUsuario = idUsuario; }

    public String getCorreo() { return correo; }
    public void setCorreo(String correo) { this.correo = correo; }

    public String getContrasena() { return contrasena; }
    public void setContrasena(String contrasena) { this.contrasena = contrasena; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getApellidoPat() { return apellidoPat; }
    public void setApellidoPat(String apellidoPat) { this.apellidoPat = apellidoPat; }

    public String getApellidoMat() { return apellidoMat; }
    public void setApellidoMat(String apellidoMat) { this.apellidoMat = apellidoMat; }

    public String getDni() { return dni; }
    public void setDni(String dni) { this.dni = dni; }

    public Set<Rol> getRoles() { return roles; }
    public void setRoles(Set<Rol> roles) { this.roles = roles; }
}
