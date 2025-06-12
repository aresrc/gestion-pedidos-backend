package com.gestionpedidos.backend.repository;

import com.gestionpedidos.backend.model.Platillo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlatilloRepository extends JpaRepository<Platillo, String> {
}