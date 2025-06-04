package com.gestionpedidos.backend.model;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "Platillo")
public class Platillo {

    @Id
    @Column(name = "codigoPlatillo")
    private String codigoPlatillo;

    @ManyToOne
    @JoinColumn(name = "idUsuario")
    private Usuario usuario;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "precio")
    private BigDecimal precio;

    @Column(name = "detalle")
    private String detalle;

    // Getters y Setters
    public String getCodigoPlatillo() { return codigoPlatillo; }
    public void setCodigoPlatillo(String codigoPlatillo) { this.codigoPlatillo = codigoPlatillo; }

    public Usuario getUsuario() { return usuario; }
    public void setUsuario(Usuario usuario) { this.usuario = usuario; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public BigDecimal getPrecio() { return precio; }
    public void setPrecio(BigDecimal precio) { this.precio = precio; }

    public String getDetalle() { return detalle; }
    public void setDetalle(String detalle) { this.detalle = detalle; }
}
