package com.example.siteWeb.controller;


import com.example.siteWeb.service.ProduseService;
import com.example.siteWeb.tabele.Meniuri;
import com.example.siteWeb.service.MeniuriService;
import jakarta.persistence.Id;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
/**
 * Clasa controller responsabilă pentru gestionarea cererilor HTTP legate de Meniuri.
 * Oferă puncte terminale pentru obținerea, crearea, actualizarea și ștergerea meniurilor.
 */
@RestController
@RequestMapping("/meniuri")
public class MeniuriController {

    private final MeniuriService meniuriService;

    @Autowired
    private ProduseService produseService;

    @Autowired
    public MeniuriController(MeniuriService meniuriService) {
        this.meniuriService = meniuriService;
    }

    /**
     * Metodă pentru obținerea tuturor meniurilor.
     * @return Lista de meniuri.
     */
    @GetMapping
    public ResponseEntity<List<Meniuri>> getAllMeniuri() {
        List<Meniuri> meniuriList = meniuriService.getAllMeniuri();
        return new ResponseEntity<>(meniuriList, HttpStatus.OK);
    }
    /**
     * Metodă pentru obținerea unui meniu după ID.
     * @param meniuId ID-ul meniului căutat.
     * @return Meniul cu ID-ul specificat sau un răspuns de eroare dacă nu este găsit.
     */
    @GetMapping("/{id}")
    public ResponseEntity<Meniuri> getMeniuById(@PathVariable("id") int meniuId) {
        Meniuri meniu = meniuriService.getMeniuById(meniuId);
        if (meniu != null) {
            return new ResponseEntity<>(meniu, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    /**
     * Metodă pentru crearea unui meniu nou.
     * @param meniu Meniul de creat.
     * @return Meniul creat sau un răspuns de eroare în cazul unei probleme.
     */
    @PostMapping("/{id}")
    public ResponseEntity<Meniuri> createMeniu(@RequestBody Meniuri meniu, @PathVariable("id") int restaurantId) {
        Meniuri createdMeniu = meniuriService.createMeniu(meniu, restaurantId);
        if (createdMeniu != null) {
            return new ResponseEntity<>(createdMeniu, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    /**
     * Metodă pentru actualizarea unui meniu existent.
     * @param meniuId ID-ul meniului de actualizat.
     * @param meniu Meniul cu detaliile actualizate.
     * @return Meniul actualizat sau un răspuns de eroare dacă nu este găsit.
     */
    @PutMapping("/{id}")
    public ResponseEntity<Meniuri> updateMeniu(@PathVariable("id") int meniuId, @RequestBody Meniuri meniu) {
        Meniuri updatedMeniu = meniuriService.updateMeniu(meniuId, meniu);
        if (updatedMeniu != null) {
            return new ResponseEntity<>(updatedMeniu, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    /**
     * Metodă pentru ștergerea unui meniu.
     * @param meniuId ID-ul meniului de șters.
     * @return Răspuns fără conținut sau un răspuns de eroare dacă meniul nu este găsit sau apare o eroare internă.
     */

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMeniu(@PathVariable("id") int meniuId) {
        try {
            meniuriService.deleteMeniu(meniuId);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (EmptyResultDataAccessException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}
