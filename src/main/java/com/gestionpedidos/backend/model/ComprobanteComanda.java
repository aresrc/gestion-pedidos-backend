package com.gestionpedidos.backend.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Comprobante_Comanda")
public class ComprobanteComanda {
    @EmbeddedId
    private ComprobanteComandaId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("comprobanteId")
    @JoinColumn(name = "id_comprobante")
    private ComprobantePago comprobantePago;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("comandaId")
    @JoinColumn(name = "id_comanda")
    private Comanda comanda;

    // Getters y Setters
}