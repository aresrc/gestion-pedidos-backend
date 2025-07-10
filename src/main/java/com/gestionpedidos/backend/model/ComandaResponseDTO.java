package com.gestionpedidos.backend.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
public class ComandaResponseDTO {
    private String codigoComanda;
    private UsuarioSimpleDTO cliente;
    private UsuarioSimpleDTO mesero;
    private Integer numMesa;
    private String estado;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate fechaPedido;

    @JsonFormat(pattern = "HH:mm:ss")
    private LocalTime horaPedido;

    public ComandaResponseDTO(Comanda comanda) {
        this.codigoComanda = comanda.getCodigo();
        this.cliente = new UsuarioSimpleDTO(comanda.getCliente());
        this.mesero = new UsuarioSimpleDTO(comanda.getMesero());
        this.numMesa = comanda.getMesa().getNumero();
        this.estado = comanda.getEstado();
        this.fechaPedido = comanda.getFechaPedido();
        this.horaPedido = comanda.getHoraPedido();
    }
}
