package com.gestionpedidos.backend.controller;

import com.gestionpedidos.backend.service.ComprobanteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Map;


@RestController
@RequestMapping("/api/comprobantes")
public class ComprobanteController {

    @Autowired
    private ComprobanteService comprobanteService;

    @PostMapping
    public ResponseEntity<Void> insertar(@RequestBody Map<String, String> body) {
        comprobanteService.insertarComprobante(
                body.get("codigo"),
                Integer.valueOf(body.get("cliente_id")),
                LocalDate.parse(body.get("fecha_pago")),
                LocalTime.parse(body.get("hora_pago")),
                new BigDecimal(body.get("monto_total"))
        );
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> modificar(@PathVariable Integer id, @RequestBody Map<String, String> body) {
        comprobanteService.modificarComprobante(id, new BigDecimal(body.get("monto_total")));
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        comprobanteService.eliminarComprobante(id);
        return ResponseEntity.ok().build();
    }
}

