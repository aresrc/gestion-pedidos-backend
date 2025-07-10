package com.gestionpedidos.backend.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Menu_Platillo")
public class MenuPlatillo {
    @EmbeddedId
    private MenuPlatilloId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("idMenu")
    @JoinColumn(name = "id_menu")
    private Menu menu;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("idPlatillo")
    @JoinColumn(name = "id_platillo")
    private Platillo platillo;

    // Getters y Setters
    public MenuPlatilloId getId() { return id; }
    public void setId(MenuPlatilloId id) { this.id = id; }

    public Menu getMenu() { return menu; }
    public void setMenu(Menu menu) { this.menu = menu; }

    public Platillo getPlatillo() { return platillo; }
    public void setPlatillo(Platillo platillo) { this.platillo = platillo; }
}
