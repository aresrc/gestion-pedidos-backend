package com.gestionpedidos.backend.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Set;

@Entity
@Table(name = "Comprobante_Pago")
public class ComprobantePago {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_comprobante")
    private Integer idComprobante;

    @Column(name = "codigo", nullable = false, unique = true, length = 8)
    private String codigo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cliente_id", nullable = false)
    private Usuario cliente;

    @Column(name = "fecha_pago", nullable = false)
    private LocalDate fechaPago;

    @Column(name = "hora_pago", nullable = false)
    private LocalTime horaPago;

    @Column(name = "monto_total", nullable = false)
    private BigDecimal montoTotal;

    @OneToMany(mappedBy = "comprobantePago", cascade = CascadeType.ALL)
    private Set<ComprobanteComanda> comandas;

    public Integer getIdComprobante() {
        return idComprobante;
    }

    public void setIdComprobante(Integer idComprobante) {
        this.idComprobante = idComprobante;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Usuario getCliente() {
        return cliente;
    }

    public void setCliente(Usuario cliente) {
        this.cliente = cliente;
    }

    public LocalDate getFechaPago() {
        return fechaPago;
    }

    public void setFechaPago(LocalDate fechaPago) {
        this.fechaPago = fechaPago;
    }

    public LocalTime getHoraPago() {
        return horaPago;
    }

    public void setHoraPago(LocalTime horaPago) {
        this.horaPago = horaPago;
    }

    public BigDecimal getMontoTotal() {
        return montoTotal;
    }

    public void setMontoTotal(BigDecimal montoTotal) {
        this.montoTotal = montoTotal;
    }

    public Set<ComprobanteComanda> getComandas() {
        return comandas;
    }

    public void setComandas(Set<ComprobanteComanda> comandas) {
        this.comandas = comandas;
    }
}
