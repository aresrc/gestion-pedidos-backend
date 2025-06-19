package com.gestionpedidos.backend.controller;

import com.gestionpedidos.backend.model.ReporteVentaDTO;
import com.gestionpedidos.backend.model.ResumenReporteDTO;
import com.gestionpedidos.backend.service.ReporteVentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/reportes") // Ruta base opcional
public class ReporteController {

    @Autowired
    private ReporteVentaService reporteService;

    @GetMapping("/ventas")
    public ResponseEntity<List<ReporteVentaDTO>> obtenerReporteVentas(
            @RequestParam("inicio") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate inicio,
            @RequestParam("fin") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fin) {

        List<ReporteVentaDTO> reporte = reporteService.generarReporteVenta(inicio, fin);
        return ResponseEntity.ok(reporte);
    }

    @GetMapping("/resumen")
    public ResponseEntity<ResumenReporteDTO> obtenerResumenVentas(
            @RequestParam("inicio") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate inicio,
            @RequestParam("fin") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fin) {

        ResumenReporteDTO resumen = reporteService.generarResumenVentas(inicio, fin);
        return ResponseEntity.ok(resumen);
    }

}