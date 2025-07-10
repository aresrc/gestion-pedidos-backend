package com.gestionpedidos.backend.model;

import jakarta.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class ComprobanteComandaId implements Serializable {
    private Integer comprobanteId;
    private Integer comandaId;

    // hashCode, equals, getters y setters
}
