package com.gestionpedidos.backend.repository;

import com.gestionpedidos.backend.model.ComprobantePago;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ComprobantePagoRepository extends JpaRepository<ComprobantePago, String> {
    List<ComprobantePago> findByUsuario_IdUsuario(Integer idUsuario);
}
