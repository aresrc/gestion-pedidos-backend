package com.gestionpedidos.backend.model;

import java.util.List;

public class MenuDTO {

    private String codigoMenu;
    private int idUsuario;
    private String categoria;
    private List<String> platillos; // Solo los códigos de platillo

    public MenuDTO() {}

    public MenuDTO(String codigoMenu, int idUsuario, String categoria, List<String> platillos) {
        this.codigoMenu = codigoMenu;
        this.idUsuario = idUsuario;
        this.categoria = categoria;
        this.platillos = platillos;
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

    public List<String> getPlatillos() {
        return platillos;
    }

    public void setPlatillos(List<String> platillos) {
        this.platillos = platillos;
    }
}
