package com.gestionpedidos.backend.service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.ParameterMode;
import jakarta.persistence.StoredProcedureQuery;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RolService {

    @PersistenceContext
    private EntityManager em;

    public void insertarRol(String nombre) {
        em.createStoredProcedureQuery("sp_insertar_rol")
                .registerStoredProcedureParameter("p_nombre", String.class, ParameterMode.IN)
                .setParameter("p_nombre", nombre)
                .execute();
    }

    public void modificarRol(Byte id, String nombre) {
        em.createStoredProcedureQuery("sp_modificar_rol")
                .registerStoredProcedureParameter("p_id", Byte.class, ParameterMode.IN)
                .registerStoredProcedureParameter("p_nombre", String.class, ParameterMode.IN)
                .setParameter("p_id", id)
                .setParameter("p_nombre", nombre)
                .execute();
    }

    public void eliminarRol(Byte id) {
        em.createStoredProcedureQuery("sp_eliminar_rol")
                .registerStoredProcedureParameter("p_id", Byte.class, ParameterMode.IN)
                .setParameter("p_id", id)
                .execute();
    }
}
