package com.gestionpedidos.backend.service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.ParameterMode;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

@Service
public class ComprobanteService {

    @PersistenceContext
    private EntityManager em;

    public void insertarComprobante(String codigo, Integer clienteId, LocalDate fecha,
                                    LocalTime hora, BigDecimal monto) {
        em.createStoredProcedureQuery("sp_insertar_comprobante")
                .registerStoredProcedureParameter("p_codigo", String.class, ParameterMode.IN)
                .registerStoredProcedureParameter("p_cliente", Integer.class, ParameterMode.IN)
                .registerStoredProcedureParameter("p_fecha", LocalDate.class, ParameterMode.IN)
                .registerStoredProcedureParameter("p_hora", LocalTime.class, ParameterMode.IN)
                .registerStoredProcedureParameter("p_monto", BigDecimal.class, ParameterMode.IN)
                .setParameter("p_codigo", codigo)
                .setParameter("p_cliente", clienteId)
                .setParameter("p_fecha", fecha)
                .setParameter("p_hora", hora)
                .setParameter("p_monto", monto)
                .execute();
    }

    public void modificarComprobante(Integer id, BigDecimal monto) {
        em.createStoredProcedureQuery("sp_modificar_comprobante")
                .registerStoredProcedureParameter("p_id", Integer.class, ParameterMode.IN)
                .registerStoredProcedureParameter("p_monto", BigDecimal.class, ParameterMode.IN)
                .setParameter("p_id", id)
                .setParameter("p_monto", monto)
                .execute();
    }

    public void eliminarComprobante(Integer id) {
        em.createStoredProcedureQuery("sp_eliminar_comprobante")
                .registerStoredProcedureParameter("p_id", Integer.class, ParameterMode.IN)
                .setParameter("p_id", id)
                .execute();
    }
}

