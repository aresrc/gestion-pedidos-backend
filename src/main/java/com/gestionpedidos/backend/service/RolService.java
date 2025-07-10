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

    @Transactional
    public void createRole(String nombre) {
        StoredProcedureQuery sp = em.createStoredProcedureQuery("sp_insertar_rol");
        sp.registerStoredProcedureParameter("p_nombre", String.class, ParameterMode.IN);
        sp.setParameter("p_nombre", nombre);
        sp.execute();
    }

    @Transactional
    public void updateRole(Integer id, String nombre) {
        StoredProcedureQuery sp = em.createStoredProcedureQuery("sp_modificar_rol");
        sp.registerStoredProcedureParameter("p_id", Integer.class, ParameterMode.IN);
        sp.registerStoredProcedureParameter("p_nombre", String.class, ParameterMode.IN);
        sp.setParameter("p_id", id);
        sp.setParameter("p_nombre", nombre);
        sp.execute();
    }

    @Transactional
    public void deleteRole(Integer id) {
        StoredProcedureQuery sp = em.createStoredProcedureQuery("sp_eliminar_rol");
        sp.registerStoredProcedureParameter("p_id", Integer.class, ParameterMode.IN);
        sp.setParameter("p_id", id);
        sp.execute();
    }
}