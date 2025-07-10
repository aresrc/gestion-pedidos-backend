package com.gestionpedidos.backend.service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.ParameterMode;
import jakarta.persistence.StoredProcedureQuery;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ComprobanteService {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void insertarComprobante(String codigo, Integer clienteId, java.sql.Date fecha, java.sql.Time hora, Double monto) {
        StoredProcedureQuery query = entityManager.createStoredProcedureQuery("sp_insertar_comprobante")
                .registerStoredProcedureParameter("p_codigo", String.class, ParameterMode.IN)
                .registerStoredProcedureParameter("p_cliente", Integer.class, ParameterMode.IN)
                .registerStoredProcedureParameter("p_fecha", java.sql.Date.class, ParameterMode.IN)
                .registerStoredProcedureParameter("p_hora", java.sql.Time.class, ParameterMode.IN)
                .registerStoredProcedureParameter("p_monto", Double.class, ParameterMode.IN)
                .setParameter("p_codigo", codigo)
                .setParameter("p_cliente", clienteId)
                .setParameter("p_fecha", fecha)
                .setParameter("p_hora", hora)
                .setParameter("p_monto", monto);
        query.execute();
    }

    @Transactional
    public void modificarComprobante(Integer id, Double monto) {
        StoredProcedureQuery query = entityManager.createStoredProcedureQuery("sp_modificar_comprobante")
                .registerStoredProcedureParameter("p_id", Integer.class, ParameterMode.IN)
                .registerStoredProcedureParameter("p_monto", Double.class, ParameterMode.IN)
                .setParameter("p_id", id)
                .setParameter("p_monto", monto);
        query.execute();
    }

    @Transactional
    public void eliminarComprobante(Integer id) {
        StoredProcedureQuery query = entityManager.createStoredProcedureQuery("sp_eliminar_comprobante")
                .registerStoredProcedureParameter("p_id", Integer.class, ParameterMode.IN)
                .setParameter("p_id", id);
        query.execute();
    }
}
