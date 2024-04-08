package com.example.siteWeb.Controller;
import com.example.siteWeb.Service.StocuriService;
import com.example.siteWeb.Tabele.Stocuri;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
/**
 * Clasa controller responsabilă pentru gestionarea cererilor HTTP legate de Stocuri.
 * Oferă puncte terminale pentru obținerea, crearea, actualizarea și ștergerea stocurilor.
 */
@RestController
@RequestMapping("/stocuri")
public class StocuriController {
    /**
     * Serviciu pentru manipularea stocurilor.
     */
    @Autowired
    private StocuriService stocuriService;
    /**
     * Metodă pentru obținerea tuturor stocurilor.
     * @return Lista de stocuri.
     */
    @GetMapping
    public List<Stocuri> getAllStocuri() {
        return stocuriService.getAllStocuri();
    }
    /**
     * Metodă pentru obținerea unui stoc după ID.
     * @param id ID-ul stocului căutat.
     * @return Stocul cu ID-ul specificat sau un răspuns de eroare dacă nu este găsit.
     */
    @GetMapping("/{id}")
    public ResponseEntity<Stocuri> getStocById(@PathVariable int id) {
        Stocuri stocuri = stocuriService.getStocById(id);
        return stocuri != null ? ResponseEntity.ok(stocuri) : ResponseEntity.notFound().build();
    }
    /**
     * Metodă pentru crearea unui stoc nou.
     * @param stocuri Stocul de creat.
     * @return Stocul creat sau un răspuns de eroare în cazul unei probleme.
     */
    @PostMapping
    public ResponseEntity<Stocuri> createStoc(@RequestBody Stocuri stocuri) {
        Stocuri createdStoc = stocuriService.createStoc(stocuri);
        return ResponseEntity.ok(createdStoc);
    }
    /**
     * Metodă pentru actualizarea unui stoc existent.
     * @param id ID-ul stocului de actualizat.
     * @param stocuriDetails Detaliile actualizate ale stocului.
     * @return Stocul actualizat sau un răspuns de eroare dacă nu este găsit.
     */
    @PutMapping("/{id}")
    public ResponseEntity<Stocuri> updateStoc(@PathVariable int id, @RequestBody Stocuri stocuriDetails) {
        Stocuri updatedStoc = stocuriService.updateStoc(id, stocuriDetails);
        return updatedStoc != null ? ResponseEntity.ok(updatedStoc) : ResponseEntity.notFound().build();
    }
    /**
     * Metodă pentru ștergerea unui stoc.
     * @param id ID-ul stocului de șters.
     * @return Răspuns fără conținut sau un răspuns de eroare dacă nu este găsit.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStoc(@PathVariable int id) {
        stocuriService.deleteStoc(id);
        return ResponseEntity.ok().build();
    }
}