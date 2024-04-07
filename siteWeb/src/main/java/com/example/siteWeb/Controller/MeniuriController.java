package com.example.siteWeb.Controller;

import com.example.siteWeb.Service.ProduseService;
import com.example.siteWeb.Tabele.Meniuri;
import com.example.siteWeb.Service.MeniuriService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping
    public ResponseEntity<List<Meniuri>> getAllMeniuri() {
        List<Meniuri> meniuriList = meniuriService.getAllMeniuri();
        return new ResponseEntity<>(meniuriList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Meniuri> getMeniuById(@PathVariable("id") int meniuId) {
        Meniuri meniu = meniuriService.getMeniuById(meniuId);
        if (meniu != null) {
            return new ResponseEntity<>(meniu, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<Meniuri> createMeniu(@RequestBody Meniuri meniu, @RequestParam int restaurantId) {
        Meniuri createdMeniu = meniuriService.createMeniu(meniu, restaurantId);
        if (createdMeniu != null) {
            return new ResponseEntity<>(createdMeniu, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Meniuri> updateMeniu(@PathVariable("id") int meniuId, @RequestBody Meniuri meniu) {
        Meniuri updatedMeniu = meniuriService.updateMeniu(meniuId, meniu);
        if (updatedMeniu != null) {
            return new ResponseEntity<>(updatedMeniu, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
