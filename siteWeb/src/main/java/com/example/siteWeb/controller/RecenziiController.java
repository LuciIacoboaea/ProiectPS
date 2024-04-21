package com.example.siteWeb.controller;

import com.example.siteWeb.service.RecenziiService;
import com.example.siteWeb.tabele.Recenzii;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
 /**
 * Clasa controller responsabilă pentru gestionarea cererilor HTTP legate de Recenzii.
 * Oferă puncte terminale pentru obținerea, crearea, actualizarea și ștergerea recenziilor.
 */
@RestController
@RequestMapping("/recenzii")
public class RecenziiController {

    @Autowired
    private RecenziiService recenziiService;
     /**
      * Metodă pentru obținerea tuturor recenziilor.
      *
      * @return Lista de recenzii.
      */
    @GetMapping
    public ResponseEntity<List<Recenzii>> getAllRecenzii() {
        List<Recenzii> recenziiList = recenziiService.getAllRecenzii();
        return new ResponseEntity<>(recenziiList, HttpStatus.OK);
    }

    /**
     * Metodă pentru obținerea unei recenzii după identificatorul său.
     * @param id Identificatorul recenziei.
     * @return Recenzia cu identificatorul specificat sau un răspuns HTTP NOT_FOUND dacă nu este găsită.
     */
    @GetMapping("/{id}")
    public ResponseEntity<Recenzii> getRecenzieById(@PathVariable("id") int id) {
        Recenzii recenzie = recenziiService.getRecenzieById(id);
        if (recenzie != null) {
            return new ResponseEntity<>(recenzie, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
     /**
      * Metodă pentru crearea unei recenzii noi.
      *
      * @param recenzie Obiectul Recenzii care trebuie creat.
      * @return Răspunsul HTTP care conține recenzia creată sau un cod de eroare dacă nu s-a putut crea.
      */
    @PostMapping
    public ResponseEntity<Recenzii> createRecenzie(@RequestBody Recenzii recenzie) {
        Recenzii createdRecenzie = recenziiService.createRecenzie(recenzie);
        return new ResponseEntity<>(createdRecenzie, HttpStatus.CREATED);
    }
     /**
      * Metodă pentru actualizarea unei recenzii existente.
      *
      * @param id              Identificatorul recenziei care trebuie actualizată.
      * @param recenzieDetails Obiectul Recenzii cu detaliile actualizate.
      * @return Răspunsul HTTP care conține recenzia actualizată sau un cod de eroare dacă recenzia nu există.
      */
    @PutMapping("/{id}")
    public ResponseEntity<Recenzii> updateRecenzie(@PathVariable("id") int id, @RequestBody Recenzii recenzieDetails) {
        Recenzii updatedRecenzie = recenziiService.updateRecenzie(id, recenzieDetails);
        if (updatedRecenzie != null) {
            return new ResponseEntity<>(updatedRecenzie, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
     /**
      * Metodă pentru ștergerea unei recenzii.
      *
      * @param id Identificatorul recenziei care trebuie ștearsă.
      * @return Răspunsul HTTP care indică rezultatul operației de ștergere.
      */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRecenzie(@PathVariable("id") int id) {
        recenziiService.deleteRecenzie(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
