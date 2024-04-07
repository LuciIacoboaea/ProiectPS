package com.example.siteWeb.Controller;

import com.example.siteWeb.Service.ProduseService;
import com.example.siteWeb.Tabele.Produse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produse")
public class ProduseController {

    @Autowired
    private ProduseService produseService;

    @GetMapping
    public ResponseEntity<List<Produse>> getAllProduse() {
        List<Produse> produseList = produseService.getAllProduse();
        return new ResponseEntity<>(produseList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Produse> getProdusById(@PathVariable("id") int id) {
        Produse produs = produseService.getProdusById(id);
        if (produs != null) {
            return new ResponseEntity<>(produs, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<Produse> createProdus(@RequestBody Produse produs) {
        Produse createdProdus = produseService.createProdus(produs);
        return new ResponseEntity<>(createdProdus, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Produse> updateProdus(@PathVariable("id") int id, @RequestBody Produse produsDetails) {
        Produse updatedProdus = produseService.updateProdus(id, produsDetails);
        if (updatedProdus != null) {
            return new ResponseEntity<>(updatedProdus, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProdus(@PathVariable("id") int id) {
        produseService.deleteProdus(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
