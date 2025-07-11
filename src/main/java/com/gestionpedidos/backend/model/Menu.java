package com.gestionpedidos.backend.model;

import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Menu {

    @Id
    private String codigoMenu;

    private int idUsuario;

    private String categoria;

    @ManyToMany
    @JoinTable(
            name = "Menu_Platillo",
            joinColumns = @JoinColumn(name = "codigoMenu"),
            inverseJoinColumns = @JoinColumn(name = "codigoPlatillo")
    )
    private Set<Platillo> platillos = new HashSet<>();

    public Menu() {}

    public Menu(String codigoMenu, int idUsuario, String categoria) {
        this.codigoMenu = codigoMenu;
        this.idUsuario = idUsuario;
        this.categoria = categoria;
    }

    // Getters y Setters
    public String getCodigoMenu() {
        return codigoMenu;
    }

    public void setCodigoMenu(String codigoMenu) {
        this.codigoMenu = codigoMenu;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public Set<Platillo> getPlatillos() {
        return platillos;
    }

    public void setPlatillos(Set<Platillo> platillos) {
        this.platillos = platillos;
    }
}
