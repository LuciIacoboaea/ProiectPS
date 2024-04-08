package com.example.siteWeb.Controller;

import com.example.siteWeb.Service.PromotiiService;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.siteWeb.Tabele.Promotii;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;
/**
 * Clasa controller responsabilă pentru gestionarea cererilor HTTP legate de Promotii.
 * Oferă puncte terminale pentru obținerea, crearea, actualizarea și ștergerea promoțiilor.
 */
@RestController
@RequestMapping("/promotii")
public class PromotiiController {
    /**
     * Serviciu pentru manipularea promoțiilor.
     */
    @Autowired
    private PromotiiService promotiiService;
    /**
     * Metodă pentru obținerea tuturor promoțiilor.
     * @return Lista de promoții.
     */
    @GetMapping
    public List<Promotii> getAllPromotii() {
        return promotiiService.getAllPromotii();
    }
    /**
     * Metodă pentru obținerea unei promoții după ID.
     * @param id ID-ul promoției căutate.
     * @return Promoția cu ID-ul specificat sau null dacă nu este găsită.
     */
    @GetMapping("/{id}")
    public Optional<Promotii> getPromotiiById(@PathVariable int id) {
        return promotiiService.getPromotiiById(id);
    }
    /**
     * Metodă pentru crearea unei noi promoții sau actualizarea unei promoții existente.
     * @param promotii Promoția de creat sau actualizat.
     * @return Promoția creată sau actualizată.
     */
    @PostMapping
    public Promotii createPromotii(@RequestBody Promotii promotii) {
        return promotiiService.createOrUpdatePromotii(promotii);
    }
    /**
     * Metodă pentru actualizarea unei promoții existente.
     * @param id ID-ul promoției de actualizat.
     * @param promotii Promoția cu detaliile actualizate.
     * @return Promoția actualizată.
     */
    @PutMapping("/{id}")
    public Promotii updatePromotii(@PathVariable int id, @RequestBody Promotii promotii) {
        promotii.setPromotie_id(id);
        return promotiiService.createOrUpdatePromotii(promotii);
    }
    /**
     * Metodă pentru ștergerea unei promoții.
     * @param id ID-ul promoției de șters.
     */
    @DeleteMapping("/{id}")
    public void deletePromotii(@PathVariable int id) {
        promotiiService.deletePromotii(id);
    }
    /**
     * Metodă pentru obținerea promoțiilor după codul promoțional.
     * @param codPromotional Codul promoțional al promoției căutate.
     * @return Lista de promoții cu codul promoțional specificat.
     */
    @GetMapping("/codPromotional/{codPromotional}")
    public List<Promotii> getPromotiiByCodPromotional(@PathVariable String codPromotional) {
        return promotiiService.getPromotiiByCodPromotional(codPromotional);
    }
    /**
     * Metodă pentru obținerea promoțiilor după valoarea reducerii.
     * @param reducere Valoarea reducerii promoției căutate.
     * @return Lista de promoții cu valoarea reducerii specificate.
     */
    @GetMapping("/reducere/{reducere}")
    public List<Promotii> getPromotiiByReducere(@PathVariable int reducere) {
        return promotiiService.getPromotiiByReducere(reducere);
    }
}