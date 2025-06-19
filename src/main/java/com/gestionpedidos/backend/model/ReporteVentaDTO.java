package com.gestionpedidos.backend.model;

import java.math.BigDecimal;
import java.time.LocalDate;

public class ReporteVentaDTO {
    private String codigoComprobante;
    private String codigoComanda;
    private BigDecimal totalVenta;
    private int idUsuario;
    private String tipoReporte;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;

    // Constructor
    public ReporteVentaDTO(String codigoComprobante, String codigoComanda, BigDecimal totalVenta,
                           int idUsuario, String tipoReporte, LocalDate fechaInicio, LocalDate fechaFin) {
        this.codigoComprobante = codigoComprobante;
        this.codigoComanda = codigoComanda;
        this.totalVenta = totalVenta;
        this.idUsuario = idUsuario;
        this.tipoReporte = tipoReporte;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
    }

    // Getters y Setters
}