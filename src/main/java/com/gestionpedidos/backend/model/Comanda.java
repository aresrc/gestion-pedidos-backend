package com.gestionpedidos.backend.model;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Comanda")
public class Comanda {

    @Id
    @Column(name = "codigoComanda")
    private String codigoComanda;

    @ManyToOne
    @JoinColumn(name = "idUsuario")
    private Usuario usuario;

    @Column(name = "numMesa")
    private int numMesa;

    @Column(name = "fechaPedido")
    private LocalDate fechaPedido;

    @Column(name = "horaPedido")
    private LocalTime horaPedido;

    @Enumerated(EnumType.STRING)
    @Column(name = "estado")
    private Estado estado;

    @ManyToMany(mappedBy = "comandas")
    private Set<ComprobantePago> comprobantes = new HashSet<>();

    public String getCodigoComanda() {
        return codigoComanda;
    }

    // Getters y Setters

    public void setCodigoComanda(String codigoComanda) {
        this.codigoComanda = codigoComanda;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public int getNumMesa() {
        return numMesa;
    }

    public void setNumMesa(int numMesa) {
        this.numMesa = numMesa;
    }

    public LocalDate getFechaPedido() {
        return fechaPedido;
    }

    public void setFechaPedido(LocalDate fechaPedido) {
        this.fechaPedido = fechaPedido;
    }

    public LocalTime getHoraPedido() {
        return horaPedido;
    }

    public void setHoraPedido(LocalTime horaPedido) {
        this.horaPedido = horaPedido;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public Set<ComprobantePago> getComprobantes() {
        return comprobantes;
    }

    public void setComprobantes(Set<ComprobantePago> comprobantes) {
        this.comprobantes = comprobantes;
    }

    public enum Estado {
        Pendiente, En_preparación, Entregado, Cancelada
    }
}
