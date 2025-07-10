package com.gestionpedidos.backend.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public class ComprobantePagoDTO {
    private String codigo;
    private Integer clienteId;
    private LocalDate fechaPago;
    private LocalTime horaPago;
    private BigDecimal montoTotal;
    private List<String> codigosComandas;

    // Getters y Setters
    public String getCodigo() { return codigo; }
    public void setCodigo(String codigo) { this.codigo = codigo; }

    public Integer getClienteId() { return clienteId; }
    public void setClienteId(Integer clienteId) { this.clienteId = clienteId; }

    public LocalDate getFechaPago() { return fechaPago; }
    public void setFechaPago(LocalDate fechaPago) { this.fechaPago = fechaPago; }

    public LocalTime getHoraPago() { return horaPago; }
    public void setHoraPago(LocalTime horaPago) { this.horaPago = horaPago; }

    public BigDecimal getMontoTotal() { return montoTotal; }
    public void setMontoTotal(BigDecimal montoTotal) { this.montoTotal = montoTotal; }

    public List<String> getCodigosComandas() { return codigosComandas; }
    public void setCodigosComandas(List<String> codigosComandas) { this.codigosComandas = codigosComandas; }
}