package com.gestionpedidos.backend.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Platillo_Ingrediente")
public class PlatilloIngrediente {
    @EmbeddedId
    private PlatilloIngredienteId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("idPlatillo")
    @JoinColumn(name = "id_platillo")
    private Platillo platillo;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("idIngrediente")
    @JoinColumn(name = "id_ingrediente")
    private Ingrediente ingrediente;

    @Column(name = "cantidad")
    private String cantidad;

    // Getters y Setters
    public PlatilloIngredienteId getId() { return id; }
    public void setId(PlatilloIngredienteId id) { this.id = id; }

    public Platillo getPlatillo() { return platillo; }
    public void setPlatillo(Platillo platillo) { this.platillo = platillo; }

    public Ingrediente getIngrediente() { return ingrediente; }
    public void setIngrediente(Ingrediente ingrediente) { this.ingrediente = ingrediente; }

    public String getCantidad() { return cantidad; }
    public void setCantidad(String cantidad) { this.cantidad = cantidad; }
}
