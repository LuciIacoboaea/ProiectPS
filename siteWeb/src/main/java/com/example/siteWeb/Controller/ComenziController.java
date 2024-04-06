package com.example.siteWeb.Controller;

import com.example.siteWeb.Tabele.Comenzi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.siteWeb.Service.ComenziService;

import java.util.List;

@RestController
@RequestMapping("/comenzi")
public class ComenziController {

    private final ComenziService comenziService;

    @Autowired
    public ComenziController(ComenziService comenziService) {
        this.comenziService = comenziService;
    }

    @GetMapping
    public ResponseEntity<List<Comenzi>> getAllComenzi() {
        List<Comenzi> comenzi = comenziService.getAllComenzi();
        return ResponseEntity.ok(comenzi);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Comenzi> getComandaById(@PathVariable int id) {
        Comenzi comanda = comenziService.getComandaById(id);
        return comanda != null ? ResponseEntity.ok(comanda) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Comenzi> createComanda(@RequestBody Comenzi comanda) {
        Comenzi createdComanda = comenziService.createComanda(comanda);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdComanda);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Comenzi> updateComanda(@PathVariable int id, @RequestBody Comenzi comanda) {
        Comenzi updatedComanda = comenziService.updateComanda(id, comanda);
        return updatedComanda != null ? ResponseEntity.ok(updatedComanda) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteComanda(@PathVariable int id) {
        comenziService.deleteComanda(id);
        return ResponseEntity.noContent().build();
    }
}