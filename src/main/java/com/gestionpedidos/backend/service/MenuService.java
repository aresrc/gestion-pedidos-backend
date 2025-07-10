package com.gestionpedidos.backend.service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.ParameterMode;
import org.springframework.stereotype.Service;

import java.time.LocalTime;


@Service
public class MenuService {

    @PersistenceContext
    private EntityManager em;

    public void insertarMenu(String nombre, LocalTime horaInicio, LocalTime horaFin) {
        em.createStoredProcedureQuery("sp_insertar_menu")
                .registerStoredProcedureParameter("p_nombre", String.class, ParameterMode.IN)
                .registerStoredProcedureParameter("p_horaini", LocalTime.class, ParameterMode.IN)
                .registerStoredProcedureParameter("p_horafin", LocalTime.class, ParameterMode.IN)
                .setParameter("p_nombre", nombre)
                .setParameter("p_horaini", horaInicio)
                .setParameter("p_horafin", horaFin)
                .execute();
    }

    public void modificarMenu(Byte id, String nombre, LocalTime horaInicio, LocalTime horaFin) {
        em.createStoredProcedureQuery("sp_modificar_menu")
                .registerStoredProcedureParameter("p_id", Byte.class, ParameterMode.IN)
                .registerStoredProcedureParameter("p_nombre", String.class, ParameterMode.IN)
                .registerStoredProcedureParameter("p_horaini", LocalTime.class, ParameterMode.IN)
                .registerStoredProcedureParameter("p_horafin", LocalTime.class, ParameterMode.IN)
                .setParameter("p_id", id)
                .setParameter("p_nombre", nombre)
                .setParameter("p_horaini", horaInicio)
                .setParameter("p_horafin", horaFin)
                .execute();
    }

    public void eliminarMenu(Byte id) {
        em.createStoredProcedureQuery("sp_eliminar_menu")
                .registerStoredProcedureParameter("p_id", Byte.class, ParameterMode.IN)
                .setParameter("p_id", id)
                .execute();
    }
}


