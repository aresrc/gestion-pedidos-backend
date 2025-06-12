package com.gestionpedidos.backend.model;

public class PlatilloDTO {
    private String codigoPlatillo;
    private String nombre;
    private String detalle;
    private double precio;

    public PlatilloDTO(String codigoPlatillo, String nombre, String detalle, double precio) {
        this.codigoPlatillo = codigoPlatillo;
        this.nombre = nombre;
        this.detalle = detalle;
        this.precio = precio;
    }

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
}