package com.gestionpedidos.backend.model;

import java.math.BigDecimal;
import java.time.LocalDate;

public class ResumenReporteDTO {
    private BigDecimal totalVentas;
    private String platoMasVendido;
    private String platoMenosVendido;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;

    public ResumenReporteDTO(BigDecimal totalVentas, String platoMasVendido, String platoMenosVendido,
                             LocalDate fechaInicio, LocalDate fechaFin) {
        this.totalVentas = totalVentas;
        this.platoMasVendido = platoMasVendido;
        this.platoMenosVendido = platoMenosVendido;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
    }

    // Getters y Setters

    public BigDecimal getTotalVentas() {
        return totalVentas;
    }

    public void setTotalVentas(BigDecimal totalVentas) {
        this.totalVentas = totalVentas;
    }

    public String getPlatoMasVendido() {
        return platoMasVendido;
    }

    public void setPlatoMasVendido(String platoMasVendido) {
        this.platoMasVendido = platoMasVendido;
    }

    public String getPlatoMenosVendido() {
        return platoMenosVendido;
    }

    public void setPlatoMenosVendido(String platoMenosVendido) {
        this.platoMenosVendido = platoMenosVendido;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(LocalDate fechaFin) {
        this.fechaFin = fechaFin;
    }
}
