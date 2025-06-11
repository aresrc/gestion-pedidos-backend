package com.gestionpedidos.backend.controller;

import com.gestionpedidos.backend.model.Menu;
import com.gestionpedidos.backend.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/menus")
public class MenuController {

    @Autowired
    private MenuService menuService;

    @GetMapping
    public List<Menu> getAllMenus() {
        return menuService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Menu> getMenuById(@PathVariable Long id) {
        return menuService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Menu createMenu(@Valid @RequestBody Menu menu) {
        return menuService.save(menu);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Menu> updateMenu(@PathVariable Long id, @Valid @RequestBody Menu menuDetails) {
        return menuService.findById(id).map(menu -> {
            menu.setNombre(menuDetails.getNombre());
            menu.setDescripcion(menuDetails.getDescripcion());
            menu.setPrecio(menuDetails.getPrecio());
            return ResponseEntity.ok(menuService.save(menu));
        }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMenu(@PathVariable Long id) {
        if (menuService.findById(id).isPresent()) {
            menuService.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
