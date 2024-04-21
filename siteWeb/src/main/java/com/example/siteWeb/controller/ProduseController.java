package com.example.siteWeb.controller;

import com.example.siteWeb.service.ProduseService;
import com.example.siteWeb.tabele.Produse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
/**
 * Clasa controller responsabilă pentru gestionarea cererilor HTTP legate de Produse.
 * Oferă puncte terminale pentru obținerea, crearea, actualizarea și ștergerea produselor.
 */
@RestController
@RequestMapping("/produse")
public class ProduseController {

    @Autowired
    private ProduseService produseService;
    /**
     * Metodă pentru obținerea tuturor produselor.
     *
     * @return Lista de produse.
     */
    @GetMapping
    public ResponseEntity<List<Produse>> getAllProduse() {
        List<Produse> produseList = produseService.getAllProduse();
        return new ResponseEntity<>(produseList, HttpStatus.OK);
    }

    /**
     * Metodă pentru obținerea unui produs după ID.
     *
     * @param id ID-ul produsului căutat.
     * @return Răspunsul HTTP care conține produsul sau un cod de eroare dacă produsul nu există.
     */
    @GetMapping("/{id}")
    public ResponseEntity<Produse> getProdusById(@PathVariable("id") int id) {
        Produse produs = produseService.getProdusById(id);
        if (produs != null) {
            return new ResponseEntity<>(produs, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Metodă pentru crearea unui produs nou.
     *
     * @param produs   Obiectul Produs care trebuie creat.
     * @param meniuId ID-ul meniului asociat produsului.
     * @return Răspunsul HTTP care conține produsul creat sau un cod de eroare dacă nu s-a putut crea.
     */
    @PostMapping("/{id}")
    public ResponseEntity<Produse> createProdus(@RequestBody Produse produs, @PathVariable("id") int meniuId) {
        Produse createdProdus = produseService.createProdus(produs, meniuId);
        return new ResponseEntity<>(createdProdus, HttpStatus.CREATED);
    }
    /**
     * Metodă pentru actualizarea unui produs existent.
     *
     * @param id            ID-ul produsului care trebuie actualizat.
     * @param produsDetails Obiectul Produs cu detaliile actualizate.
     * @return Răspunsul HTTP care conține produsul actualizat sau un cod de eroare dacă produsul nu există.
     */

    @PutMapping("/{id}")
    public ResponseEntity<Produse> updateProdus(@PathVariable("id") int id, @RequestBody Produse produsDetails) {
        Produse updatedProdus = produseService.updateProdus(id, produsDetails);
        if (updatedProdus != null) {
            return new ResponseEntity<>(updatedProdus, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    /**
     * Metodă pentru ștergerea unui produs.
     *
     * @param id ID-ul produsului care trebuie șters.
     * @return Răspunsul HTTP care indică rezultatul operației de ștergere.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProdus(@PathVariable("id") int id) {
        produseService.deleteProdus(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
