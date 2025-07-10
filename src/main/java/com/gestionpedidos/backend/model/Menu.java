package com.gestionpedidos.backend.model;

import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.*;
import java.time.LocalTime;
import java.util.Set;

@Entity
@Table(name = "Menu")
public class Menu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_menu")
    private Integer idMenu;

    @Column(name = "nombre_menu", nullable = false, unique = true)
    private String nombreMenu;

    @Column(name = "hora_inicio", nullable = false)
    private LocalTime horaInicio;

    @Column(name = "hora_fin", nullable = false)
    private LocalTime horaFin;

    @OneToMany(mappedBy = "menu", cascade = CascadeType.ALL)
    private Set<MenuPlatillo> platillos;

    // Getters y Setters
    public Integer getIdMenu() { return idMenu; }
    public void setIdMenu(Integer idMenu) { this.idMenu = idMenu; }

    public String getNombreMenu() { return nombreMenu; }
    public void setNombreMenu(String nombreMenu) { this.nombreMenu = nombreMenu; }

    public LocalTime getHoraInicio() { return horaInicio; }
    public void setHoraInicio(LocalTime horaInicio) { this.horaInicio = horaInicio; }

    public LocalTime getHoraFin() { return horaFin; }
    public void setHoraFin(LocalTime horaFin) { this.horaFin = horaFin; }

    public Set<MenuPlatillo> getPlatillos() { return platillos; }
    public void setPlatillos(Set<MenuPlatillo> platillos) { this.platillos = platillos; }
}