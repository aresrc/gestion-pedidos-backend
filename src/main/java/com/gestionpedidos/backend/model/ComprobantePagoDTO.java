package com.gestionpedidos.backend.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public class ComprobantePagoDTO {
    private String codigoComprobante;
    private String nombreUsuario;
    private LocalDate fecha;
    private LocalTime hora;
    private BigDecimal montoTotal;
    private List<String> codigosComanda;

    // Constructor, getters y setters
    public ComprobantePagoDTO() {}

    public ComprobantePagoDTO(String codigoComprobante, String nombreUsuario, LocalDate fecha, LocalTime hora, BigDecimal montoTotal, List<String> codigosComanda) {
        this.codigoComprobante = codigoComprobante;
        this.nombreUsuario = nombreUsuario;
        this.fecha = fecha;
        this.hora = hora;
        this.montoTotal = montoTotal;
        this.codigosComanda = codigosComanda;
    }

    public String getCodigoComprobante() {
        return codigoComprobante;
    }

    public void setCodigoComprobante(String codigoComprobante) {
        this.codigoComprobante = codigoComprobante;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public LocalTime getHora() {
        return hora;
    }

    public void setHora(LocalTime hora) {
        this.hora = hora;
    }

    public BigDecimal getMontoTotal() {
        return montoTotal;
    }

    public void setMontoTotal(BigDecimal montoTotal) {
        this.montoTotal = montoTotal;
    }

    public List<String> getCodigosComanda() {
        return codigosComanda;
    }

    public void setCodigosComanda(List<String> codigosComanda) {
        this.codigosComanda = codigosComanda;
    }
}
