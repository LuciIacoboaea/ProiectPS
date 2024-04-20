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

@Service
public class PromotiiService implements PromotiiServiceInterfata {
    private final RestauranteRepository restauranteRepository;
    @Autowired
    private PromotiiContract promotiiContract;

    public PromotiiService(PromotiiContract promotiiContract,RestauranteRepository restauranteRepository) {
        this.restauranteRepository = restauranteRepository;
        this.promotiiContract=promotiiContract;
    }

    public List<Promotii> getAllPromotii() {
        return promotiiContract.findAll();
    }

    public Optional<Promotii> getPromotiiById(int id) {
        return promotiiContract.findById(id);
    }

    public Promotii createPromotii(Promotii promotii,int restaurantId) {
        // Căutăm restaurantul în baza de date folosind restaurantId
        Restaurante restaurant = restauranteRepository.findById(restaurantId)
                .orElseThrow(() -> new RuntimeException("Restaurantul nu a fost găsit în baza de date."));

        // Setăm restaurantul asociat promoției
        promotii.setRestaurant(restaurant);

        // Salvăm promoția în baza de date
        return promotiiContract.save(promotii);
    }

    public Promotii updatePromotii(int id, Promotii updatedPromotii) {
        Promotii existingPromotii = promotiiContract.findById(id)
                .orElseThrow(() -> new RuntimeException("Promoția nu a fost găsită"));

        existingPromotii.setCod_promotional(updatedPromotii.getCod_promotional());
        existingPromotii.setDescriere(updatedPromotii.getDescriere());
        existingPromotii.setReducere(updatedPromotii.getReducere());

        return promotiiContract.save(existingPromotii);
    }


    public void deletePromotii(int id) {
        promotiiContract.deleteById(id);
    }

    public List<Promotii> getPromotiiByCodPromotional(String codPromotional) {
        return promotiiContract.findByCod_promotionalStartingWith(codPromotional);
    }

    public List<Promotii> getPromotiiByReducere(int reducere) {
        return promotiiContract.findByReducere(reducere);
    }
}