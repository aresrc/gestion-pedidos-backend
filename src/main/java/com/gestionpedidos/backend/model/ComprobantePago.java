package com.gestionpedidos.backend.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "ComprobantePago")
public class ComprobantePago {

    @Id
    @Column(name = "codigoComprobante")
    private String codigoComprobante;

    @ManyToOne
    @JoinColumn(name = "idUsuario")
    private Usuario usuario;

    @Column(name = "fecha")
    private LocalDate fecha;

    @Column(name = "hora")
    private LocalTime hora;

    @Column(name = "montoTotal")
    private BigDecimal montoTotal;

    @ManyToMany
    @JoinTable(
            name = "Comprobante_Comanda",
            joinColumns = @JoinColumn(name = "codigoComprobante"),
            inverseJoinColumns = @JoinColumn(name = "codigoComanda")
    )
    private Set<Comanda> comandas = new HashSet<>();

    // Getters y Setters

    public String getCodigoComprobante() {
        return codigoComprobante;
    }

    public void setCodigoComprobante(String codigoComprobante) {
        this.codigoComprobante = codigoComprobante;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public LocalTime getHora() {
        return hora;
    }

    public void setHora(LocalTime hora) {
        this.hora = hora;
    }

    public BigDecimal getMontoTotal() {
        return montoTotal;
    }

    public void setMontoTotal(BigDecimal montoTotal) {
        this.montoTotal = montoTotal;
    }

    public Set<Comanda> getComandas() {
        return comandas;
    }

    public void setComandas(Set<Comanda> comandas) {
        this.comandas = comandas;
    }
}
