package com.example.siteWeb.Controller;

import com.example.siteWeb.Tabele.Restaurante;
import com.example.siteWeb.Service.RestauranteService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
/**
 * Clasa controller responsabilă pentru gestionarea cererilor HTTP legate de Restaurante.
 * Oferă puncte terminale pentru obținerea, crearea, actualizarea și ștergerea restaurantelor.
 */

@RestController
@RequestMapping("/restaurante")
public class RestauranteController {
    /**
     * Serviciu pentru manipularea restaurantelor.
     */
    private final RestauranteService restauranteService;
    /**
     * Constructor pentru RestauranteController.
     * @param restauranteService Serviciul pentru manipularea restaurantelor.
     */
    @Autowired
    public RestauranteController(RestauranteService restauranteService) {
        this.restauranteService = restauranteService;
    }
    /**
     * Metodă pentru obținerea tuturor restaurantelor.
     * @return Lista de restaurante.
     */
    @GetMapping
    public ResponseEntity<List<Restaurante>> getAllRestaurante() {
        List<Restaurante> restauranteList = restauranteService.getAllRestaurante();
        return new ResponseEntity<>(restauranteList, HttpStatus.OK);
    }
    /**
     * Metodă pentru obținerea unui restaurant după ID.
     * @param id ID-ul restaurantului căutat.
     * @return Restaurantul cu ID-ul specificat sau un răspuns de eroare dacă nu este găsit.
     */
    @GetMapping("/{id}")
    public ResponseEntity<Restaurante> getRestauranteById(@PathVariable("id") int id) {
        Optional<Restaurante> restauranteOptional = restauranteService.getRestauranteById(id);
        return restauranteOptional.map(restaurante -> new ResponseEntity<>(restaurante, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    /**
     * Metodă pentru crearea unui restaurant nou.
     * @param restaurante Restaurantul de creat.
     * @return Restaurantul creat sau un răspuns de eroare în cazul unei probleme.
     */
    @PostMapping
    public ResponseEntity<Restaurante> createRestaurante(@RequestBody Restaurante restaurante) {
        Restaurante createdRestaurante = restauranteService.createRestaurante(restaurante);
        return new ResponseEntity<>(createdRestaurante, HttpStatus.CREATED);
    }
    /**
     * Metodă pentru actualizarea unui restaurant existent.
     * @param id ID-ul restaurantului de actualizat.
     * @param restaurante Detaliile actualizate ale restaurantului.
     * @return Restaurantul actualizat sau un răspuns de eroare dacă nu este găsit.
     */
    @PutMapping("/{id}")
    public ResponseEntity<Restaurante> updateRestaurante(@PathVariable("id") int id, @RequestBody Restaurante restaurante) {
        Restaurante updatedRestaurante = restauranteService.updateRestaurante(id, restaurante);
        if (updatedRestaurante != null) {
            return new ResponseEntity<>(updatedRestaurante, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    /**
     * Metodă pentru ștergerea unui restaurant și datelor asociate acestuia.
     * @param restaurantId ID-ul restaurantului de șters.
     * @return Răspuns de confirmare a ștergerii.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteRestaurant(@PathVariable("id") int restaurantId) {
        restauranteService.deleteRestaurantAndAssociatedData(restaurantId);
        return ResponseEntity.ok("Restaurantul și datele asociate au fost șterse cu succes.");
    }
}
