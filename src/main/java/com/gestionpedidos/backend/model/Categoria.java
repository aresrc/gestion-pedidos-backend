package com.gestionpedidos.backend.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Categoria")
public class Categoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_categoria")
    private Integer idCategoria;

    @Column(name = "nombre_cat", nullable = false, unique = true)
    private String nombreCat;

    // Getters y Setters
    public Integer getIdCategoria() { return idCategoria; }
    public void setIdCategoria(Integer idCategoria) { this.idCategoria = idCategoria; }

    public String getNombreCat() { return nombreCat; }
    public void setNombreCat(String nombreCat) { this.nombreCat = nombreCat; }
}