package com.gestionpedidos.backend.service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.ParameterMode;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.StoredProcedureQuery;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlatilloService {

    @PersistenceContext
    private EntityManager entityManager;

    public void insertarPlatillo(String codigo, String nombre, String descripcion, Double precio, Byte idCategoria) {
        StoredProcedureQuery query = entityManager.createStoredProcedureQuery("sp_insertar_platillo")
                .registerStoredProcedureParameter("p_codigo", String.class, ParameterMode.IN)
                .registerStoredProcedureParameter("p_nombre", String.class, ParameterMode.IN)
                .registerStoredProcedureParameter("p_descripcion", String.class, ParameterMode.IN)
                .registerStoredProcedureParameter("p_precio", Double.class, ParameterMode.IN)
                .registerStoredProcedureParameter("p_id_categoria", Byte.class, ParameterMode.IN)
                .setParameter("p_codigo", codigo)
                .setParameter("p_nombre", nombre)
                .setParameter("p_descripcion", descripcion)
                .setParameter("p_precio", precio)
                .setParameter("p_id_categoria", idCategoria);
        query.execute();
    }

    public void modificarPlatillo(Integer id, String nombre, String descripcion, Double precio, Byte idCategoria) {
        StoredProcedureQuery query = entityManager.createStoredProcedureQuery("sp_modificar_platillo")
                .registerStoredProcedureParameter("p_id", Integer.class, ParameterMode.IN)
                .registerStoredProcedureParameter("p_nombre", String.class, ParameterMode.IN)
                .registerStoredProcedureParameter("p_descripcion", String.class, ParameterMode.IN)
                .registerStoredProcedureParameter("p_precio", Double.class, ParameterMode.IN)
                .registerStoredProcedureParameter("p_id_categoria", Byte.class, ParameterMode.IN)
                .setParameter("p_id", id)
                .setParameter("p_nombre", nombre)
                .setParameter("p_descripcion", descripcion)
                .setParameter("p_precio", precio)
                .setParameter("p_id_categoria", idCategoria);
        query.execute();
    }

    public void eliminarPlatillo(Integer id) {
        StoredProcedureQuery query = entityManager.createStoredProcedureQuery("sp_eliminar_platillo")
                .registerStoredProcedureParameter("p_id", Integer.class, ParameterMode.IN)
                .setParameter("p_id", id);
        query.execute();
    }
}