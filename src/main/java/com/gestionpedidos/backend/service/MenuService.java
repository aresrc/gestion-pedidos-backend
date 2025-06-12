package com.gestionpedidos.backend.service;

import com.gestionpedidos.backend.model.Menu;
import com.gestionpedidos.backend.model.MenuDTO;
import com.gestionpedidos.backend.model.Platillo;
import com.gestionpedidos.backend.repository.MenuRepository;
import com.gestionpedidos.backend.repository.PlatilloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class MenuService {

    @Autowired
    private MenuRepository menuRepository;

    @Autowired
    private PlatilloRepository platilloRepository;

    public List<Menu> findAll() {
        List<Menu> menus = menuRepository.findAll();
        menus.forEach(menu -> menu.getPlatillos().size());
        return menus;
    }

    public Optional<Menu> findById(String codigoMenu) {
        return menuRepository.findById(codigoMenu);
    }

    public Menu save(Menu menu) {
        return menuRepository.save(menu);
    }

    public void deleteById(String codigoMenu) {
        menuRepository.deleteById(codigoMenu);
    }
    public Menu actualizarMenu(MenuDTO dto) {
        Menu menuExistente = menuRepository.findById(dto.getCodigoMenu())
                .orElseThrow(() -> new RuntimeException("Menu no encontrado: " + dto.getCodigoMenu()));

        menuExistente.setIdUsuario(dto.getIdUsuario());
        menuExistente.setCategoria(dto.getCategoria());

        Set<Platillo> nuevosPlatillos = dto.getPlatillos().stream()
                .map(codigo -> platilloRepository.findById(codigo)
                        .orElseThrow(() -> new RuntimeException("Platillo no encontrado: " + codigo)))
                .collect(Collectors.toSet());

        menuExistente.setPlatillos(nuevosPlatillos);

        return menuRepository.save(menuExistente);
    }

    public Menu saveMenuWithPlatillos(MenuDTO dto) {
        Menu menu = new Menu(dto.getCodigoMenu(), dto.getIdUsuario(), dto.getCategoria());

        Set<Platillo> platillos = new HashSet<>();
        for (String codigoPlatillo : dto.getPlatillos()) {
            Platillo platillo = platilloRepository.findById(codigoPlatillo)
                    .orElseThrow(() -> new RuntimeException("Platillo no encontrado: " + codigoPlatillo));
            platillos.add(platillo);
        }

        menu.setPlatillos(platillos);
        return menuRepository.save(menu);
    }
}
