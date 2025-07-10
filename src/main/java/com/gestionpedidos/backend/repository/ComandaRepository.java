package com.gestionpedidos.backend.repository;

import com.gestionpedidos.backend.model.Comanda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ComandaRepository extends JpaRepository<Comanda, String> {
    @Query("SELECT DISTINCT c FROM Comanda c " +
            "LEFT JOIN FETCH c.cliente " +
            "LEFT JOIN FETCH c.mesero " +
            "LEFT JOIN FETCH c.mesa " +
            "LEFT JOIN FETCH c.cliente.roles " +
            "LEFT JOIN FETCH c.mesero.roles")
    List<Comanda> findAllWithRelations();
}