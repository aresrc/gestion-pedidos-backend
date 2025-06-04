package com.gestionpedidos.backend.repository;

import com.gestionpedidos.backend.model.Comanda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComandaRepository extends JpaRepository<Comanda, String> {
}
