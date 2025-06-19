package com.gestionpedidos.backend.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.sql.Date;

@Repository
public class VentaRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public BigDecimal getTotalVentas(LocalDate inicio, LocalDate fin) {
        return (BigDecimal) entityManager
                .createNativeQuery("SELECT TotalVentas(:inicio, :fin)")
                .setParameter("inicio", Date.valueOf(inicio))
                .setParameter("fin", Date.valueOf(fin))
                .getSingleResult();
    }

    public String getPlatoMasVendido(LocalDate inicio, LocalDate fin) {
        return (String) entityManager
                .createNativeQuery("SELECT ObtenerPlatoMasVendido(:inicio, :fin)")
                .setParameter("inicio", Date.valueOf(inicio))
                .setParameter("fin", Date.valueOf(fin))
                .getSingleResult();
    }

    public String getPlatoMenosVendido(LocalDate inicio, LocalDate fin) {
        return (String) entityManager
                .createNativeQuery("SELECT ObtenerPlatoMenosVendido(:inicio, :fin)")
                .setParameter("inicio", Date.valueOf(inicio))
                .setParameter("fin", Date.valueOf(fin))
                .getSingleResult();
    }

    public List<Object[]> getReporteVentas(LocalDate inicio, LocalDate fin) {
        return entityManager
                .createNativeQuery("CALL GenerarReporteVenta(:inicio, :fin)")
                .setParameter("inicio", Date.valueOf(inicio))
                .setParameter("fin", Date.valueOf(fin))
                .getResultList();
    }
}
