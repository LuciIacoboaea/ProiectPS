package com.example.siteWeb.controller;

import com.example.siteWeb.service.RecenziiService;
import com.example.siteWeb.tabele.Recenzii;
import com.example.siteWeb.tabele.Restaurante;
import com.example.siteWeb.service.RestauranteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Clasa controller responsabilă pentru gestionarea cererilor HTTP legate de Restaurante.
 * Oferă puncte terminale pentru obținerea, crearea, actualizarea și ștergerea restaurantelor.
 */

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/restaurante")
public class RestauranteController {
    /**
     * Serviciu pentru manipularea restaurantelor.
     */
    private final RestauranteService restauranteService;
    private final RecenziiService recenziiService;
    /**
     * Constructor pentru RestauranteController.
     *
     * @param restauranteService Serviciul pentru manipularea restaurantelor.
     * @param recenziiService
     */
    @Autowired
    public RestauranteController(RestauranteService restauranteService, RecenziiService recenziiService) {
        this.restauranteService = restauranteService;
        this.recenziiService = recenziiService;
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
        Restaurante restaurante = restauranteService.getRestauranteById(id);
        if (restaurante != null) {
            return new ResponseEntity<>(restaurante, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
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

    /**
     * Caută restaurantele care conțin un anumit șir în nume.
     *
     * @param query Șirul de căutare pentru nume.
     * @return Lista de restaurante care conțin șirul specificat în nume.
     */
    /**
     * Metodă pentru obținerea tuturor numelor restaurantelor.
     * @return Lista de nume de restaurante.
     */
    @GetMapping("/searchByLetter")
    public ResponseEntity<List<String>> searchRestauranteByLetter(@RequestParam char letter) {
        List<String> numeRestaurante = restauranteService.getAllRestaurante().stream()
                .filter(restaurante -> restaurante.getNume().contains(String.valueOf(letter)))
                .map(Restaurante::getNume)
                .collect(Collectors.toList());
        return new ResponseEntity<>(numeRestaurante, HttpStatus.OK);
    }

    @GetMapping("/{id}/recenzii")
    public ResponseEntity<List<Recenzii>> getReviewsByRestaurantId(@PathVariable("id") int restaurantId) {
        List<Recenzii> recenziiList = recenziiService.getReviewsByRestaurantId(restaurantId);
        if (recenziiList != null && !recenziiList.isEmpty()) {
            return new ResponseEntity<>(recenziiList, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/{restaurantId}/reviews")
    public ResponseEntity<Recenzii> createReview(@PathVariable("restaurantId") int restaurantId, @RequestBody Recenzii review) {
        Recenzii createdReview = recenziiService.createReview(restaurantId, review);
        return new ResponseEntity<>(createdReview, HttpStatus.CREATED);
    }

}
