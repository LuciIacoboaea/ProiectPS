package com.example.siteWeb.Service;

import com.example.siteWeb.Repo.ComenziRepository;
import com.example.siteWeb.Repo.MeniuriRepository;
import com.example.siteWeb.Tabele.Meniuri;
import com.example.siteWeb.Tabele.Restaurante;
import com.example.siteWeb.Repo.RestauranteRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RestauranteService {

    @Autowired
    private ComenziRepository comenziRepository;
    @Autowired
    private MeniuriRepository meniuriRepository;
    private final RestauranteRepository restauranteRepository;

    @Autowired
    public RestauranteService(RestauranteRepository restauranteRepository) {
        this.restauranteRepository = restauranteRepository;
    }

    public List<Restaurante> getAllRestaurante() {
        return restauranteRepository.findAll();
    }

    public Optional<Restaurante> getRestauranteById(int id) {
        return restauranteRepository.findById(id);
    }

    public Restaurante createRestaurante(Restaurante restaurante) {
        return restauranteRepository.save(restaurante);
    }

    public Restaurante updateRestaurante(int id, Restaurante updatedRestaurante) {
        Restaurante existingRestaurante = restauranteRepository.findById(id).orElse(null);
        if (existingRestaurante != null) {
            existingRestaurante.setNume(updatedRestaurante.getNume());
            existingRestaurante.setAdresa(updatedRestaurante.getAdresa());
            existingRestaurante.setOras(updatedRestaurante.getOras());
            existingRestaurante.setTelefon(updatedRestaurante.getTelefon());
            existingRestaurante.setEmail(updatedRestaurante.getEmail());
            existingRestaurante.setRating(updatedRestaurante.getRating());
            return restauranteRepository.save(existingRestaurante);
        }
        return null;
    }

    public void deleteRestaurantAndAssociatedData(int restaurantId) {
        Restaurante restaurant = restauranteRepository.findById(restaurantId).orElse(null);
        if (restaurant != null) {
            restauranteRepository.delete(restaurant);
        }
    }
}
