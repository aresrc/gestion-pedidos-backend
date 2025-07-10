package com.gestionpedidos.backend.model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public class ComandaDTO {
    private String codigo;
    private Integer clienteId;
    private Integer meseroId;
    private Integer mesaId;
    private LocalDate fechaPedido;
    private LocalTime horaPedido;
    private String estado;
    private List<DetalleComandaDTO> detalles;

    // Getters y Setters
    public String getCodigo() { return codigo; }
    public void setCodigo(String codigo) { this.codigo = codigo; }

    public Integer getClienteId() { return clienteId; }
    public void setClienteId(Integer clienteId) { this.clienteId = clienteId; }

    public Integer getMeseroId() { return meseroId; }
    public void setMeseroId(Integer meseroId) { this.meseroId = meseroId; }

    public Integer getMesaId() { return mesaId; }
    public void setMesaId(Integer mesaId) { this.mesaId = mesaId; }

    public LocalDate getFechaPedido() { return fechaPedido; }
    public void setFechaPedido(LocalDate fechaPedido) { this.fechaPedido = fechaPedido; }

    public LocalTime getHoraPedido() { return horaPedido; }
    public void setHoraPedido(LocalTime horaPedido) { this.horaPedido = horaPedido; }

    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }

    public List<DetalleComandaDTO> getDetalles() { return detalles; }
    public void setDetalles(List<DetalleComandaDTO> detalles) { this.detalles = detalles; }
}
