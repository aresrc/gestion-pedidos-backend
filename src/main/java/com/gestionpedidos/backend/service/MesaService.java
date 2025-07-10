package com.gestionpedidos.backend.service;

import com.gestionpedidos.backend.model.Mesa;
import com.gestionpedidos.backend.repository.MesaRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.ParameterMode;
import jakarta.persistence.StoredProcedureQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
public class MesaService {

    @Autowired
    private MesaRepository mesaRepository;

    public List<Mesa> getAllMesas() {
        return mesaRepository.findAll();
    }


    @PersistenceContext
    private EntityManager em;



    public void insertarMesa(Short numero, String estado, Byte capacidad) {
        em.createStoredProcedureQuery("sp_insertar_mesa")
                .registerStoredProcedureParameter("p_numero", Short.class, ParameterMode.IN)
                .registerStoredProcedureParameter("p_estado", String.class, ParameterMode.IN)
                .registerStoredProcedureParameter("p_capacidad", Byte.class, ParameterMode.IN)
                .setParameter("p_numero", numero)
                .setParameter("p_estado", estado)
                .setParameter("p_capacidad", capacidad)
                .execute();
    }

    public void modificarMesa(Short id, String estado, Byte capacidad) {
        em.createStoredProcedureQuery("sp_modificar_mesa")
                .registerStoredProcedureParameter("p_id", Short.class, ParameterMode.IN)
                .registerStoredProcedureParameter("p_estado", String.class, ParameterMode.IN)
                .registerStoredProcedureParameter("p_capacidad", Byte.class, ParameterMode.IN)
                .setParameter("p_id", id)
                .setParameter("p_estado", estado)
                .setParameter("p_capacidad", capacidad)
                .execute();
    }

    public void eliminarMesa(Short id) {
        em.createStoredProcedureQuery("sp_eliminar_mesa")
                .registerStoredProcedureParameter("p_id", Short.class, ParameterMode.IN)
                .setParameter("p_id", id)
                .execute();
    }
}

