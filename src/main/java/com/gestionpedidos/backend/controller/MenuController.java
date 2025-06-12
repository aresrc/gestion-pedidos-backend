package com.gestionpedidos.backend.controller;

import com.gestionpedidos.backend.model.Menu;
import com.gestionpedidos.backend.model.MenuDTO;
import com.gestionpedidos.backend.model.Platillo;
import com.gestionpedidos.backend.service.MenuService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/menus")
public class MenuController {

    private final MenuService menuService;

    public MenuController(MenuService menuService) {
        this.menuService = menuService;
    }

    // Obtener todos los menús
    @GetMapping
    public List<MenuDTO> obtenerTodosLosMenus() {
        return menuService.findAll().stream()
                .map(this::convertirADTO)
                .collect(Collectors.toList());
    }

    // Obtener un menú por código
    @GetMapping("/{codigo}")
    public MenuDTO obtenerMenuPorCodigo(@PathVariable String codigo) {
        Menu menu = menuService.findById(codigo)
                .orElseThrow(() -> new RuntimeException("Menú no encontrado: " + codigo));
        return convertirADTO(menu);
    }

    // Crear un nuevo menú
    @PostMapping
    public MenuDTO crearMenu(@RequestBody MenuDTO dto) {
        Menu menuGuardado = menuService.saveMenuWithPlatillos(dto);
        return convertirADTO(menuGuardado);
    }

    // Actualizar un menú existente
    @PutMapping("/{codigo}")
    public MenuDTO actualizarMenu(@PathVariable String codigo, @RequestBody MenuDTO dto) {
        if (!codigo.equals(dto.getCodigoMenu())) {
            throw new IllegalArgumentException("El código del menú en la URL no coincide con el del cuerpo de la solicitud.");
        }
        Menu menuActualizado = menuService.actualizarMenu(dto);
        return convertirADTO(menuActualizado);
    }

    // Eliminar un menú
    @DeleteMapping("/{codigo}")
    public void eliminarMenu(@PathVariable String codigo) {
        menuService.deleteById(codigo);
    }

    // Convertir entidad a DTO
    private MenuDTO convertirADTO(Menu menu) {
        List<String> codigosPlatillos = menu.getPlatillos().stream()
                .map(Platillo::getCodigoPlatillo)
                .collect(Collectors.toList());

        return new MenuDTO(
                menu.getCodigoMenu(),
                menu.getIdUsuario(),
                menu.getCategoria(),
                codigosPlatillos
        );
    }
}