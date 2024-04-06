package com.example.siteWeb.Controller;

import com.example.siteWeb.Tabele.Restaurante;
import com.example.siteWeb.Service.RestauranteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/restaurante")
public class RestauranteController {

    private final RestauranteService restauranteService;

    @Autowired
    public RestauranteController(RestauranteService restauranteService) {
        this.restauranteService = restauranteService;
    }

    @GetMapping
    public ResponseEntity<List<Restaurante>> getAllRestaurante() {
        List<Restaurante> restauranteList = restauranteService.getAllRestaurante();
        return new ResponseEntity<>(restauranteList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Restaurante> getRestauranteById(@PathVariable("id") int id) {
        Optional<Restaurante> restauranteOptional = restauranteService.getRestauranteById(id);
        return restauranteOptional.map(restaurante -> new ResponseEntity<>(restaurante, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<Restaurante> createRestaurante(@RequestBody Restaurante restaurante) {
        Restaurante createdRestaurante = restauranteService.createRestaurante(restaurante);
        return new ResponseEntity<>(createdRestaurante, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Restaurante> updateRestaurante(@PathVariable("id") int id, @RequestBody Restaurante restaurante) {
        Restaurante updatedRestaurante = restauranteService.updateRestaurante(id, restaurante);
        if (updatedRestaurante != null) {
            return new ResponseEntity<>(updatedRestaurante, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRestaurante(@PathVariable("id") int id) {
        boolean deleted = restauranteService.deleteRestaurante(id);
        if (deleted) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
