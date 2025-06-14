package com.gestionpedidos.backend.service;

import com.gestionpedidos.backend.model.Platillo;
import com.gestionpedidos.backend.repository.PlatilloRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class PlatilloServiceTest {

    @Test
    void testBuscarPorId() {
        PlatilloRepository repo = mock(PlatilloRepository.class);
        PlatilloService service = new PlatilloService(repo);

        Platillo platillo = new Platillo();
        platillo.setCodigoPlatillo("P001");
        platillo.setNombre("Pizza");

        when(repo.findById("P001")).thenReturn(Optional.of(platillo));

        Platillo resultado = service.buscarPorId("P001").orElse(null);
        assertNotNull(resultado);
        assertEquals("Pizza", resultado.getNombre());
    }
}