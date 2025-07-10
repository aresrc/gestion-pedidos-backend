package com.gestionpedidos.backend.model;

import jakarta.persistence.*;

import jakarta.persistence.*;

@Entity
@Table(name = "Mesa")
public class Mesa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_mesa")
    private Integer idMesa;

    @Column(name = "numero", nullable = false, unique = true)
    private Integer numero;

    @Column(name = "estado", nullable = false)
    private String estado;

    @Column(name = "capacidad", nullable = false)
    private Integer capacidad;

    // Getters y Setters
    public Integer getIdMesa() { return idMesa; }
    public void setIdMesa(Integer idMesa) { this.idMesa = idMesa; }

    public Integer getNumero() { return numero; }
    public void setNumero(Integer numero) { this.numero = numero; }

    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }

    public Integer getCapacidad() { return capacidad; }
    public void setCapacidad(Integer capacidad) { this.capacidad = capacidad; }
}