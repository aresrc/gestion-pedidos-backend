package com.gestionpedidos.backend.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import java.util.Set;

@Entity
public class Platillo {

    @Id
    private String codigoPlatillo;

    @NotBlank(message = "El nombre es obligatorio")
    private String nombre;

    private String detalle;

    @NotNull(message = "El precio es obligatorio")
    @Positive(message = "El precio debe ser mayor a 0")
    private Double precio;

    @ManyToMany(mappedBy = "platillos")
    private Set<Menu> menus;

    public Platillo() {}

    public Platillo(String codigoPlatillo, String nombre, String detalle, double precio) {
        this.codigoPlatillo = codigoPlatillo;
        this.nombre = nombre;
        this.detalle = detalle;
        this.precio = precio;
    }

    // Getters y Setters
    public String getCodigoPlatillo() {
        return codigoPlatillo;
    }

    public void setCodigoPlatillo(String codigoPlatillo) {
        this.codigoPlatillo = codigoPlatillo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public Set<Menu> getMenus() {
        return menus;
    }

    public void setMenus(Set<Menu> menus) {
        this.menus = menus;
    }
}
