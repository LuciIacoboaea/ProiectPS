package com.example.siteWeb.service;

import com.example.siteWeb.contracte.RestauranteContract;
import com.example.siteWeb.repo.ComenziRepository;
import com.example.siteWeb.repo.MeniuriRepository;
import com.example.siteWeb.tabele.Restaurante;
import com.example.siteWeb.repo.RestauranteRepository;
import com.example.siteWeb.interfataService.RestauranteServiceInterfata;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RestauranteService implements RestauranteServiceInterfata {

    @Autowired
    private ComenziRepository comenziRepository;
    @Autowired
    private MeniuriRepository meniuriRepository;
    private final RestauranteContract restauranteContract;

    @Autowired
    public RestauranteService(RestauranteContract restauranteContract) {
        this.restauranteContract = restauranteContract;
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
        restauranteContract.deleteById(restaurantId);
    }
}
