package com.gestionpedidos.backend.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Ingrediente")
public class Ingrediente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_ingrediente")
    private Integer idIngrediente;

    @Column(name = "nombre_ing", nullable = false, unique = true)
    private String nombreIng;

    // Getters y Setters
    public Integer getIdIngrediente() { return idIngrediente; }
    public void setIdIngrediente(Integer idIngrediente) { this.idIngrediente = idIngrediente; }

    public String getNombreIng() { return nombreIng; }
    public void setNombreIng(String nombreIng) { this.nombreIng = nombreIng; }
}
