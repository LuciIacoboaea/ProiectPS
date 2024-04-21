package com.example.siteWeb.service;

import com.example.siteWeb.contracte.PromotiiContract;
import com.example.siteWeb.interfataService.PromotiiServiceInterfata;
import com.example.siteWeb.repo.RestauranteRepository;
import com.example.siteWeb.tabele.Promotii;
import com.example.siteWeb.tabele.Restaurante;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
/**
 * Clasa de serviciu responsabilă pentru gestionarea operațiilor legate de entitățile Promotii.
 * Implementează interfața PromotiiServiceInterfata.
 */
@Service
public class PromotiiService implements PromotiiServiceInterfata {
    private final RestauranteRepository restauranteRepository;
    @Autowired
    private PromotiiContract promotiiContract;

    public PromotiiService(PromotiiContract promotiiContract,RestauranteRepository restauranteRepository) {
        this.restauranteRepository = restauranteRepository;
        this.promotiiContract=promotiiContract;
    }
    /**
     * Returnează toate entitățile Promotii.
     *
     * @return Lista entităților Promotii.
     */
    public List<Promotii> getAllPromotii() {
        return promotiiContract.findAll();
    }
    /**
     * Returnează o Promotie după ID-ul său.
     *
     * @param id ID-ul Promotiei de recuperat.
     * @return Entitatea Promotiei recuperată, sau Optional.empty() dacă nu este găsită.
     */
    public Optional<Promotii> getPromotiiById(int id) {
        return promotiiContract.findById(id);
    }
    /**
     * Creează o nouă Promotie.
     *
     * @param promotii    Promotia de creat.
     * @param restaurantId ID-ul Restaurantului asociat.
     * @return Entitatea Promotiei creată.
     */
    public Promotii createPromotii(Promotii promotii,int restaurantId) {
        Restaurante restaurant = restauranteRepository.findById(restaurantId)
                .orElseThrow(() -> new RuntimeException("Restaurantul nu a fost găsit în baza de date."));

        promotii.setRestaurant(restaurant);

        return promotiiContract.save(promotii);
    }
    /**
     * Actualizează o Promotie existentă.
     *
     * @param id              ID-ul Promotiei de actualizat.
     * @param updatedPromotii Detaliile actualizate ale Promotiei.
     * @return Entitatea Promotiei actualizată.
     */
    public Promotii updatePromotii(int id, Promotii updatedPromotii) {
        Promotii existingPromotii = promotiiContract.findById(id)
                .orElseThrow(() -> new RuntimeException("Promoția nu a fost găsită"));

        existingPromotii.setCod_promotional(updatedPromotii.getCod_promotional());
        existingPromotii.setDescriere(updatedPromotii.getDescriere());
        existingPromotii.setReducere(updatedPromotii.getReducere());

        return promotiiContract.save(existingPromotii);
    }

    /**
     * Șterge o Promotie după ID-ul său.
     *
     * @param id ID-ul Promotiei de șters.
     */
    public void deletePromotii(int id) {
        promotiiContract.deleteById(id);
    }
    /**
     * Returnează toate Promotiile care încep cu un anumit cod promoțional.
     *
     * @param codPromotional Codul promoțional cu care încep Promotiile căutate.
     * @return Lista Promotiilor care încep cu codul promoțional specificat.
     */
    public List<Promotii> getPromotiiByCodPromotional(String codPromotional) {
        return promotiiContract.findByCod_promotionalStartingWith(codPromotional);
    }
    /**
     * Returnează toate Promotiile cu o anumită reducere.
     *
     * @param reducere Valoarea reducerii căutate.
     * @return Lista Promotiilor cu reducerea specificată.
     */
    public List<Promotii> getPromotiiByReducere(int reducere) {
        return promotiiContract.findByReducere(reducere);
    }
}