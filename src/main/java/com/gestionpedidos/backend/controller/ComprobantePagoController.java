package com.gestionpedidos.backend.controller;

import com.gestionpedidos.backend.model.ComprobantePagoDTO;
import com.gestionpedidos.backend.service.ComprobantePagoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/comprobantes")
@RequiredArgsConstructor
public class ComprobantePagoController {

    private final ComprobantePagoService comprobantePagoService;

    @GetMapping("/usuario/{idUsuario}")
    public List<ComprobantePagoDTO> filtrarPorUsuario(@PathVariable Integer idUsuario) {
        return comprobantePagoService.filtrarComprobantesPorUsuario(idUsuario);
    }
    /*Test*/
    @GetMapping("/{codigoComprobante}")
    public ComprobantePagoDTO obtenerPorCodigo(@PathVariable String codigoComprobante) {
        return comprobantePagoService.obtenerComprobantePorCodigo(codigoComprobante);
    }
}
