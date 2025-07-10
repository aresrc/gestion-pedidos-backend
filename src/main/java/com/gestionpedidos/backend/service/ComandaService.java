package com.gestionpedidos.backend.service;

import com.gestionpedidos.backend.model.Comanda;
import com.gestionpedidos.backend.repository.ComandaRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.ParameterMode;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Service
public class ComandaService {

    private ComandaRepository comandaRepository;

    public List<Comanda> listarTodas() {
        return comandaRepository.findAll();
    }

    @PersistenceContext
    private EntityManager em;

    public void insertarComanda(String codigo, Integer clienteId, Integer meseroId,
                                Short mesaId, LocalDate fecha, LocalTime hora, String estado) {
        em.createStoredProcedureQuery("sp_insertar_comanda")
                .registerStoredProcedureParameter("p_codigo", String.class, ParameterMode.IN)
                .registerStoredProcedureParameter("p_cliente", Integer.class, ParameterMode.IN)
                .registerStoredProcedureParameter("p_mesero", Integer.class, ParameterMode.IN)
                .registerStoredProcedureParameter("p_mesa", Short.class, ParameterMode.IN)
                .registerStoredProcedureParameter("p_fecha", LocalDate.class, ParameterMode.IN)
                .registerStoredProcedureParameter("p_hora", LocalTime.class, ParameterMode.IN)
                .registerStoredProcedureParameter("p_estado", String.class, ParameterMode.IN)
                .setParameter("p_codigo", codigo)
                .setParameter("p_cliente", clienteId)
                .setParameter("p_mesero", meseroId)
                .setParameter("p_mesa", mesaId)
                .setParameter("p_fecha", fecha)
                .setParameter("p_hora", hora)
                .setParameter("p_estado", estado)
                .execute();
    }

    public void insertarComandaCSV(Integer clienteId, Integer meseroId,
                                Short mesaId, String estado, String ids_platillo, String cantidades) {
        em.createStoredProcedureQuery("sp_insertar_comanda_csv")
                .registerStoredProcedureParameter("p_cliente_id", Integer.class, ParameterMode.IN)
                .registerStoredProcedureParameter("p_mesero_id", Integer.class, ParameterMode.IN)
                .registerStoredProcedureParameter("p_mesa_id", Short.class, ParameterMode.IN)
                .registerStoredProcedureParameter("p_estado", String.class, ParameterMode.IN)
                .registerStoredProcedureParameter("p_ids_platillo", String.class, ParameterMode.IN)
                .registerStoredProcedureParameter("p_cantidades", String.class, ParameterMode.IN)
                .setParameter("p_cliente_id", clienteId)
                .setParameter("p_mesero_id", meseroId)
                .setParameter("p_mesa_id", mesaId)
                .setParameter("p_estado", estado)
                .setParameter("p_ids_platillo", ids_platillo)
                .setParameter("p_cantidades", cantidades)
                .execute();
    }

    public void modificarComanda(Integer id, String estado) {
        em.createStoredProcedureQuery("sp_modificar_comanda")
                .registerStoredProcedureParameter("p_id", Integer.class, ParameterMode.IN)
                .registerStoredProcedureParameter("p_estado", String.class, ParameterMode.IN)
                .setParameter("p_id", id)
                .setParameter("p_estado", estado)
                .execute();
    }

    public void eliminarComanda(Integer id) {
        em.createStoredProcedureQuery("sp_eliminar_comanda")
                .registerStoredProcedureParameter("p_id", Integer.class, ParameterMode.IN)
                .setParameter("p_id", id)
                .execute();
    }
}
