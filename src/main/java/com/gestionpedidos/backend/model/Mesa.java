package com.gestionpedidos.backend.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Mesa")
public class Mesa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // Indica autoincremento
    @Column(name = "numMesa")
    private int numMesa;

    @Column(name = "estadoMesa")
    private String estadoMesa;

    @Column(name = "cupos")
    private int cupos;

    // Getters y Setters
    public int getNumMesa() {
        return numMesa;
    }

    public void setNumMesa(int numMesa) {
        this.numMesa = numMesa;
    }

    public String getEstadoMesa() {
        return estadoMesa;
    }

    public void setEstadoMesa(String estadoMesa) {
        this.estadoMesa = estadoMesa;
    }

    public int getCupos() {
        return cupos;
    }

    public void setCupos(int cupos) {
        this.cupos = cupos;
    }
}
