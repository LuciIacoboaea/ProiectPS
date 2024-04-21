package com.example.siteWeb.service;

import com.example.siteWeb.contracte.ComenziContract;
import com.example.siteWeb.contracte.MeniuriContract;
import com.example.siteWeb.contracte.PromotiiContract;
import com.example.siteWeb.contracte.RestauranteContract;
import com.example.siteWeb.repo.ComenziRepository;
import com.example.siteWeb.repo.MeniuriRepository;
import com.example.siteWeb.tabele.Comenzi;
import com.example.siteWeb.tabele.Meniuri;
import com.example.siteWeb.tabele.Promotii;
import com.example.siteWeb.tabele.Restaurante;
import com.example.siteWeb.repo.RestauranteRepository;
import com.example.siteWeb.interfataService.RestauranteServiceInterfata;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RestauranteService implements RestauranteServiceInterfata {

    private final RestauranteContract restauranteContract;
    private final MeniuriContract meniuriContract;
    private final ComenziContract comenziContract;
    private final PromotiiContract promotiiContract;

    @Autowired
    public RestauranteService(RestauranteContract restauranteContract, MeniuriContract meniuriContract,
                              ComenziContract comenziContract, PromotiiContract promotiiContract) {
        this.restauranteContract = restauranteContract;
        this.meniuriContract = meniuriContract;
        this.comenziContract = comenziContract;
        this.promotiiContract = promotiiContract;
    }

    public List<Restaurante> getAllRestaurante() {
        return restauranteContract.findAll();
    }

    public Restaurante getRestauranteById(int id) {
        return restauranteContract.findById(id).orElse(null);
    }

    public Restaurante createRestaurante(Restaurante restaurante) {
        return restauranteContract.save(restaurante);
    }

    public Restaurante updateRestaurante(int id, Restaurante updatedRestaurante) {
        Restaurante existingRestaurante = restauranteContract.findById(id).orElse(null);
        if (existingRestaurante != null) {
            existingRestaurante.setNume(updatedRestaurante.getNume());
            existingRestaurante.setAdresa(updatedRestaurante.getAdresa());
            existingRestaurante.setOras(updatedRestaurante.getOras());
            existingRestaurante.setTelefon(updatedRestaurante.getTelefon());
            existingRestaurante.setEmail(updatedRestaurante.getEmail());
            existingRestaurante.setRating(updatedRestaurante.getRating());
            return restauranteContract.save(existingRestaurante);
        }
        return null;
    }

    public void deleteRestaurantAndAssociatedData(int restaurantId) {
        // Găsim restaurantul după ID
        Restaurante existingRestaurant = restauranteContract.findById(restaurantId).orElse(null);

        if (existingRestaurant != null) {
            // Ștergem toate comenzile asociate restaurantului
            List<Comenzi> comenzi = existingRestaurant.getComenzi();
            for (Comenzi comanda : comenzi) {
                comenziContract.deleteById(comanda.getComanda_id());
            }
            // Ștergem toate meniurile asociate restaurantului
            List<Meniuri> meniuri = existingRestaurant.getMeniuri();
            for (Meniuri meniu : meniuri) {
                meniuriContract.deleteById(meniu.getMeniu_id());
            }


            // Ștergem toate promoțiile asociate restaurantului
            List<Promotii> promotii = existingRestaurant.getPromotii();
            for (Promotii promotie : promotii) {
                promotiiContract.deleteById(promotie.getPromotie_id());
            }

            // Ștergem restaurantul
            restauranteContract.deleteById(restaurantId);
        }
}
}

