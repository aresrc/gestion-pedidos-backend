package com.gestionpedidos.backend.model;

import jakarta.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class PlatilloIngredienteId implements Serializable {
    private Integer idPlatillo;
    private Integer idIngrediente;

    // hashCode, equals, getters y setters

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PlatilloIngredienteId)) return false;
        PlatilloIngredienteId that = (PlatilloIngredienteId) o;
        return java.util.Objects.equals(idPlatillo, that.idPlatillo) &&
                java.util.Objects.equals(idIngrediente, that.idIngrediente);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(idPlatillo, idIngrediente);
    }

    public Integer getIdPlatillo() {
        return idPlatillo;
    }

    public void setIdPlatillo(Integer idPlatillo) {
        this.idPlatillo = idPlatillo;
    }

    public Integer getIdIngrediente() {
        return idIngrediente;
    }

    public void setIdIngrediente(Integer idIngrediente) {
        this.idIngrediente = idIngrediente;
    }
}
