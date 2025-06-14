package com.gestionpedidos.backend.model;

import jakarta.persistence.*;
import java.util.Set;

@Entity
public class Platillo {

    @Id
    private String codigoPlatillo;

    private String nombre;

    private String detalle;

    private double precio;

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

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public Set<Menu> getMenus() {
        return menus;
    }

    public void setMenus(Set<Menu> menus) {
        this.menus = menus;
    }
}
