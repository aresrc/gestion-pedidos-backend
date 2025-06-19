package com.gestionpedidos.backend.service;

import com.gestionpedidos.backend.model.ComprobantePago;
import com.gestionpedidos.backend.model.ComprobantePagoDTO;
import com.gestionpedidos.backend.repository.ComprobantePagoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class ComprobantePagoService {

    private final ComprobantePagoRepository comprobantePagoRepository;

    public List<ComprobantePagoDTO> filtrarComprobantesPorUsuario(Integer idUsuario) {
        List<ComprobantePago> comprobantes = comprobantePagoRepository.findByUsuario_IdUsuario(idUsuario);
        return comprobantes.stream()
                .map(this::convertirADTO)
                .collect(Collectors.toList());
    }

    public ComprobantePagoDTO obtenerComprobantePorCodigo(String codigoComprobante) {
        ComprobantePago comprobante = comprobantePagoRepository.findById(codigoComprobante)
                .orElseThrow(() -> new RuntimeException("Comprobante no encontrado: " + codigoComprobante));
        return convertirADTO(comprobante);
    }

    private ComprobantePagoDTO convertirADTO(ComprobantePago comprobante) {
        return new ComprobantePagoDTO(
                comprobante.getCodigoComprobante(),
                comprobante.getUsuario() != null ? comprobante.getUsuario().getNombre() : null,
                comprobante.getFecha(),
                comprobante.getHora(),
                comprobante.getMontoTotal(),
                comprobante.getComandas().stream()
                        .map(c -> c.getCodigoComanda())
                        .collect(Collectors.toList())
        );
    }
}
