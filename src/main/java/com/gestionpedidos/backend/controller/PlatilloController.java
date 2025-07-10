package com.gestionpedidos.backend.controller;

import com.gestionpedidos.backend.model.PlatilloDTO;
import com.gestionpedidos.backend.repository.PlatilloRepository;
import com.gestionpedidos.backend.service.PlatilloService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/platillos")
public class PlatilloController {

    @Autowired
    private PlatilloService platilloService;

    @Autowired
    private PlatilloRepository platilloRepository;


    @GetMapping
    public List<PlatilloDTO> obtenerTodosLosPlatillos() {
        return platilloRepository.findAll().stream()
                .map(p -> new PlatilloDTO(
                        p.getIdPlatillo(),
                        p.getCodigo(),
                        p.getNombre(),
                        p.getDescripcion(),
                        p.getPrecioUnitario().doubleValue()
                )).collect(Collectors.toList());
    }

    @PostMapping
    public ResponseEntity<Void> insertar(@RequestBody Map<String, String> body) {
        platilloService.insertarPlatillo(
                body.get("codigo"),
                body.get("nombre"),
                body.get("descripcion"),
                new BigDecimal(body.get("precio")),
                Byte.valueOf(body.get("id_categoria"))
        );
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> modificar(@PathVariable Integer id, @RequestBody Map<String, String> body) {
        platilloService.modificarPlatillo(
                id,
                body.get("nombre"),
                body.get("descripcion"),
                new BigDecimal(body.get("precio")),
                Byte.valueOf(body.get("id_categoria"))
        );
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        platilloService.eliminarPlatillo(id);
        return ResponseEntity.ok().build();
    }
}
