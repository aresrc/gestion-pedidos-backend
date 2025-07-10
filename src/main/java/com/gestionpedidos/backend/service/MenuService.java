package com.gestionpedidos.backend.service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.ParameterMode;
import jakarta.persistence.StoredProcedureQuery;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class MenuService {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void insertarMenu(String nombre, java.sql.Time horaInicio, java.sql.Time horaFin) {
        StoredProcedureQuery query = entityManager.createStoredProcedureQuery("sp_insertar_menu")
                .registerStoredProcedureParameter("p_nombre", String.class, ParameterMode.IN)
                .registerStoredProcedureParameter("p_horaini", java.sql.Time.class, ParameterMode.IN)
                .registerStoredProcedureParameter("p_horafin", java.sql.Time.class, ParameterMode.IN)
                .setParameter("p_nombre", nombre)
                .setParameter("p_horaini", horaInicio)
                .setParameter("p_horafin", horaFin);
        query.execute();
    }

    @Transactional
    public void modificarMenu(Byte id, String nombre, java.sql.Time horaInicio, java.sql.Time horaFin) {
        StoredProcedureQuery query = entityManager.createStoredProcedureQuery("sp_modificar_menu")
                .registerStoredProcedureParameter("p_id", Byte.class, ParameterMode.IN)
                .registerStoredProcedureParameter("p_nombre", String.class, ParameterMode.IN)
                .registerStoredProcedureParameter("p_horaini", java.sql.Time.class, ParameterMode.IN)
                .registerStoredProcedureParameter("p_horafin", java.sql.Time.class, ParameterMode.IN)
                .setParameter("p_id", id)
                .setParameter("p_nombre", nombre)
                .setParameter("p_horaini", horaInicio)
                .setParameter("p_horafin", horaFin);
        query.execute();
    }

    @Transactional
    public void eliminarMenu(Byte id) {
        StoredProcedureQuery query = entityManager.createStoredProcedureQuery("sp_eliminar_menu")
                .registerStoredProcedureParameter("p_id", Byte.class, ParameterMode.IN)
                .setParameter("p_id", id);
        query.execute();
    }
}

