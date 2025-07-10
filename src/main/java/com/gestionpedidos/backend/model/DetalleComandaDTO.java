package com.gestionpedidos.backend.model;

import java.math.BigDecimal;

public class DetalleComandaDTO {
    private String codigoPlatillo;
    private Integer cantidad;
    private BigDecimal precioUnitario;

    // Getters y Setters
    public String getCodigoPlatillo() { return codigoPlatillo; }
    public void setCodigoPlatillo(String codigoPlatillo) { this.codigoPlatillo = codigoPlatillo; }

    public Integer getCantidad() { return cantidad; }
    public void setCantidad(Integer cantidad) { this.cantidad = cantidad; }

    public BigDecimal getPrecioUnitario() { return precioUnitario; }
    public void setPrecioUnitario(BigDecimal precioUnitario) { this.precioUnitario = precioUnitario; }
}
