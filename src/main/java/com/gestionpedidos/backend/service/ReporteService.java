package com.gestionpedidos.backend.service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.ParameterMode;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ReporteService {

    @PersistenceContext
    private EntityManager em;

    @SuppressWarnings("unchecked")
    public List<Object[]> reporteVentasPlatillo(LocalDate fechaIni, LocalDate fechaFin) {
        return em.createStoredProcedureQuery("sp_reporte_ventas_platillo")
                .registerStoredProcedureParameter("p_fecha_ini", LocalDate.class, ParameterMode.IN)
                .registerStoredProcedureParameter("p_fecha_fin", LocalDate.class, ParameterMode.IN)
                .setParameter("p_fecha_ini", fechaIni)
                .setParameter("p_fecha_fin", fechaFin)
                .getResultList();
    }

    @SuppressWarnings("unchecked")
    public List<Object[]> reporteDetalladoVentas(LocalDate fechaIni, LocalDate fechaFin) {
        return em.createStoredProcedureQuery("sp_reporte_detallado_ventas")
                .registerStoredProcedureParameter("p_fecha_ini", LocalDate.class, ParameterMode.IN)
                .registerStoredProcedureParameter("p_fecha_fin", LocalDate.class, ParameterMode.IN)
                .setParameter("p_fecha_ini", fechaIni)
                .setParameter("p_fecha_fin", fechaFin)
                .getResultList();
    }

    @SuppressWarnings("unchecked")
    public List<Object[]> reporteVentasPorCategoria(LocalDate fechaIni, LocalDate fechaFin) {
        return em.createStoredProcedureQuery("sp_reporte_ventas_por_categoria")
                .registerStoredProcedureParameter("p_fecha_ini", LocalDate.class, ParameterMode.IN)
                .registerStoredProcedureParameter("p_fecha_fin", LocalDate.class, ParameterMode.IN)
                .setParameter("p_fecha_ini", fechaIni)
                .setParameter("p_fecha_fin", fechaFin)
                .getResultList();
    }
}
