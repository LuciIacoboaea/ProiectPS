package com.example.siteWeb.Controller;
import com.example.siteWeb.Service.StocuriService;
import com.example.siteWeb.Tabele.Stocuri;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/stocuri")
public class StocuriController {

    @Autowired
    private StocuriService stocuriService;

    @GetMapping
    public List<Stocuri> getAllStocuri() {
        return stocuriService.getAllStocuri();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Stocuri> getStocById(@PathVariable int id) {
        Stocuri stocuri = stocuriService.getStocById(id);
        return stocuri != null ? ResponseEntity.ok(stocuri) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Stocuri> createStoc(@RequestBody Stocuri stocuri) {
        Stocuri createdStoc = stocuriService.createStoc(stocuri);
        return ResponseEntity.ok(createdStoc);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Stocuri> updateStoc(@PathVariable int id, @RequestBody Stocuri stocuriDetails) {
        Stocuri updatedStoc = stocuriService.updateStoc(id, stocuriDetails);
        return updatedStoc != null ? ResponseEntity.ok(updatedStoc) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStoc(@PathVariable int id) {
        stocuriService.deleteStoc(id);
        return ResponseEntity.ok().build();
    }
}