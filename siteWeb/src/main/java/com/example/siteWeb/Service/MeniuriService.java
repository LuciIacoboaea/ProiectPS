package com.example.siteWeb.Service;

import com.example.siteWeb.Tabele.Meniuri;
import com.example.siteWeb.Repo.MeniuriRepository;
import com.example.siteWeb.Tabele.Restaurante;
import com.example.siteWeb.Repo.RestauranteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MeniuriService {

    private final MeniuriRepository meniuriRepository;
    private final RestauranteRepository restauranteRepository; // Adăugați repository-ul pentru restaurante

    @Autowired
    public MeniuriService(MeniuriRepository meniuriRepository, RestauranteRepository restauranteRepository) {
        this.meniuriRepository = meniuriRepository;
        this.restauranteRepository = restauranteRepository; // Injectați repository-ul pentru restaurante
    }

    public List<Meniuri> getAllMeniuri() {
        return meniuriRepository.findAll();
    }

    public Meniuri getMeniuById(int meniuId) {
        return meniuriRepository.findById(meniuId).orElse(null);
    }

    public Meniuri createMeniu(Meniuri meniu, int restaurantId) { // Adăugați restaurantId ca parametru
        Restaurante restaurant = restauranteRepository.findById(restaurantId).orElse(null); // Folosiți restauranteRepository pentru a accesa restaurantele
        if (restaurant != null) {
            meniu.setRestaurant(restaurant);
            return meniuriRepository.save(meniu);
        }
        return null;
    }

    public Meniuri updateMeniu(int meniuId, Meniuri meniu) {
        Meniuri existingMeniu = meniuriRepository.findById(meniuId).orElse(null);
        if (existingMeniu != null) {
            existingMeniu.setNume(meniu.getNume());
            existingMeniu.setDescriere(meniu.getDescriere());
            existingMeniu.setCategorie(meniu.getCategorie());
            if (meniu.getRestaurant() != null) {
                existingMeniu.setRestaurant(meniu.getRestaurant());
            }
            return meniuriRepository.save(existingMeniu);
        }
        return null;
    }

    public void deleteMeniu(int meniuId) {
        meniuriRepository.deleteById(meniuId);
    }
}
