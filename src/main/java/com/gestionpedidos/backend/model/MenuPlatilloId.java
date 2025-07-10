package com.gestionpedidos.backend.model;

import jakarta.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class MenuPlatilloId implements Serializable {
    private Integer idMenu;
    private Integer idPlatillo;

    public Integer getIdMenu() {
        return idMenu;
    }

    public void setIdMenu(Integer idMenu) {
        this.idMenu = idMenu;
    }

    public Integer getIdPlatillo() {
        return idPlatillo;
    }

    public void setIdPlatillo(Integer idPlatillo) {
        this.idPlatillo = idPlatillo;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        MenuPlatilloId that = (MenuPlatilloId) o;
        return Objects.equals(idMenu, that.idMenu) && Objects.equals(idPlatillo, that.idPlatillo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idMenu, idPlatillo);
    }
// hashCode, equals, getters y setters
}
