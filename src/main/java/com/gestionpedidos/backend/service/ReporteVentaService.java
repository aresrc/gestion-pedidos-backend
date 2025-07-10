package com.gestionpedidos.backend.service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.ParameterMode;
import jakarta.persistence.StoredProcedureQuery;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Service
public class ReporteVentaService {

    @PersistenceContext
    private EntityManager entityManager;

    // 6. Reportes
    public List<Object[]> reporteVentasPlatillo(Date fechaIni, Date fechaFin) {
        StoredProcedureQuery query = entityManager.createStoredProcedureQuery("sp_reporte_ventas_platillo")
                .registerStoredProcedureParameter("p_fecha_ini", Date.class, ParameterMode.IN)
                .registerStoredProcedureParameter("p_fecha_fin", Date.class, ParameterMode.IN)
                .setParameter("p_fecha_ini", fechaIni)
                .setParameter("p_fecha_fin", fechaFin);
        query.execute();
        return query.getResultList();
    }

    public List<Object[]> reporteDetalladoVentas(Date fechaIni, Date fechaFin) {
        StoredProcedureQuery query = entityManager.createStoredProcedureQuery("sp_reporte_detallado_ventas")
                .registerStoredProcedureParameter("p_fecha_ini", Date.class, ParameterMode.IN)
                .registerStoredProcedureParameter("p_fecha_fin", Date.class, ParameterMode.IN)
                .setParameter("p_fecha_ini", fechaIni)
                .setParameter("p_fecha_fin", fechaFin);
        query.execute();
        return query.getResultList();
    }

    public List<Object[]> reporteVentasPorCategoria(Date fechaIni, Date fechaFin) {
        StoredProcedureQuery query = entityManager.createStoredProcedureQuery("sp_reporte_ventas_por_categoria")
                .registerStoredProcedureParameter("p_fecha_ini", Date.class, ParameterMode.IN)
                .registerStoredProcedureParameter("p_fecha_fin", Date.class, ParameterMode.IN)
                .setParameter("p_fecha_ini", fechaIni)
                .setParameter("p_fecha_fin", fechaFin);
        query.execute();
        return query.getResultList();
    }
}