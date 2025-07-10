package com.gestionpedidos.backend.service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.ParameterMode;
import jakarta.persistence.StoredProcedureQuery;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MesaService {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void insertarMesa(Short numero, String estado, Byte capacidad) {
        StoredProcedureQuery query = entityManager.createStoredProcedureQuery("sp_insertar_mesa")
                .registerStoredProcedureParameter("p_numero", Short.class, ParameterMode.IN)
                .registerStoredProcedureParameter("p_estado", String.class, ParameterMode.IN)
                .registerStoredProcedureParameter("p_capacidad", Byte.class, ParameterMode.IN)
                .setParameter("p_numero", numero)
                .setParameter("p_estado", estado)
                .setParameter("p_capacidad", capacidad);
        query.execute();
    }

    @Transactional
    public void modificarMesa(Short id, String estado, Byte capacidad) {
        StoredProcedureQuery query = entityManager.createStoredProcedureQuery("sp_modificar_mesa")
                .registerStoredProcedureParameter("p_id", Short.class, ParameterMode.IN)
                .registerStoredProcedureParameter("p_estado", String.class, ParameterMode.IN)
                .registerStoredProcedureParameter("p_capacidad", Byte.class, ParameterMode.IN)
                .setParameter("p_id", id)
                .setParameter("p_estado", estado)
                .setParameter("p_capacidad", capacidad);
        query.execute();
    }

    @Transactional
    public void eliminarMesa(Short id) {
        StoredProcedureQuery query = entityManager.createStoredProcedureQuery("sp_eliminar_mesa")
                .registerStoredProcedureParameter("p_id", Short.class, ParameterMode.IN)
                .setParameter("p_id", id);
        query.execute();
    }

}
