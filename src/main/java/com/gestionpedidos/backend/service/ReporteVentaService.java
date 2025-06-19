package com.gestionpedidos.backend.service;

import com.gestionpedidos.backend.model.ReporteVentaDTO;
import com.gestionpedidos.backend.model.ResumenReporteDTO;
import com.gestionpedidos.backend.repository.VentaRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Service
public class ReporteVentaService {

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private VentaRepository ventaRepository;

    // Método 1: Reporte detallado
    public List<ReporteVentaDTO> generarReporteVenta(LocalDate fechaInicio, LocalDate fechaFin) {
        Query query = entityManager.createNativeQuery("CALL GenerarReporteVenta(:inicio, :fin)");
        query.setParameter("inicio", fechaInicio);
        query.setParameter("fin", fechaFin);

        List<Object[]> resultados = query.getResultList();

        return resultados.stream()
                .map(obj -> new ReporteVentaDTO(
                        (String) obj[0],                       // codigoComprobante
                        (String) obj[1],                       // codigoComanda
                        (BigDecimal) obj[2],                   // totalVenta
                        ((Number) obj[3]).intValue(),          // idUsuario
                        (String) obj[4],                       // tipoReporte
                        ((java.sql.Date) obj[5]).toLocalDate(), // fechaInicio
                        ((java.sql.Date) obj[6]).toLocalDate()  // fechaFin
                ))
                .toList();
    }

    // Método 2: Resumen de ventas
    public ResumenReporteDTO generarResumenVentas(LocalDate inicio, LocalDate fin) {
        BigDecimal totalVentas = ventaRepository.getTotalVentas(inicio, fin);
        String masVendido = ventaRepository.getPlatoMasVendido(inicio, fin);
        String menosVendido = ventaRepository.getPlatoMenosVendido(inicio, fin);

        return new ResumenReporteDTO(totalVentas, masVendido, menosVendido, inicio, fin);
    }
}