package com.example.siteWeb.controller;

import com.example.siteWeb.tabele.Comenzi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.siteWeb.service.ComenziService;

import java.util.List;
/**
 * Clasă controller responsabilă pentru gestionarea cererilor HTTP legate de Comenzi.
 * Oferă puncte terminale pentru obținerea, crearea, actualizarea și ștergerea comenzilor.
 */
@RestController
@RequestMapping("/comenzi")
public class ComenziController {

    private final ComenziService comenziService;

    @Autowired
    public ComenziController(ComenziService comenziService) {
        this.comenziService = comenziService;
    }

    /**
     * Metodă pentru obținerea tuturor comenzilor.
     * @return Lista de comenzi.
     */
    @GetMapping
    public ResponseEntity<List<Comenzi>> getAllComenzi() {
        List<Comenzi> comenzi = comenziService.getAllComenzi();
        return ResponseEntity.ok(comenzi);
    }

    /**
     * Metodă pentru obținerea unei comenzi după ID.
     * @param id ID-ul comenzii căutate.
     * @return Comanda cu ID-ul specificat sau un răspuns de eroare dacă nu este găsită.
     */
    @GetMapping("/{id}")
    public ResponseEntity<Comenzi> getComandaById(@PathVariable int id) {
        Comenzi comanda = comenziService.getComandaById(id);
        return comanda != null ? ResponseEntity.ok(comanda) : ResponseEntity.notFound().build();
    }

    /**
     * Metodă pentru crearea unei comenzi noi.
     * @param comanda Comanda de creat.
     * @return Comanda creată sau un răspuns de eroare în cazul unei probleme.
     */
    @PostMapping
    public ResponseEntity<Comenzi> createComanda(@RequestBody Comenzi comanda) {
        Comenzi createdComanda = comenziService.createComanda(comanda);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdComanda);
    }

    /**
     * Metodă pentru actualizarea unei comenzi existente.
     * @param id ID-ul comenzii de actualizat.
     * @param comanda Comanda cu detaliile actualizate.
     * @return Comanda actualizată sau un răspuns de eroare dacă nu este găsită.
     */

    @PutMapping("/{id}")
    public ResponseEntity<Comenzi> updateComanda(@PathVariable int id, @RequestBody Comenzi comanda) {
        Comenzi updatedComanda = comenziService.updateComanda(id, comanda);
        return updatedComanda != null ? ResponseEntity.ok(updatedComanda) : ResponseEntity.notFound().build();
    }

    /**
     * Metodă pentru ștergerea unei comenzi.
     * @param id ID-ul comenzii de șters.
     * @return Răspuns fără conținut sau un răspuns de eroare dacă nu este găsită.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteComanda(@PathVariable int id) {
        comenziService.deleteComanda(id);
        return ResponseEntity.noContent().build();
    }
}