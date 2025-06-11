package com.gestionpedidos.backend.repository;

import com.gestionpedidos.backend.model.Menu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MenuRepository extends JpaRepository<Menu, Long> {
}
