package com.example.siteWeb.data;
import com.example.siteWeb.contracte.RestauranteContract;
import com.example.siteWeb.repo.RestauranteRepository;
import com.example.siteWeb.tabele.Restaurante;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Clasa responsabilă pentru gestionarea datelor referitoare la restaurante.
 * Implementează operațiile specificate în contractul RestauranteContract.
 */
@Repository
public class RestauranteData implements RestauranteContract {
    private final RestauranteRepository restauranteRepository;

    @Autowired
    public RestauranteData(RestauranteRepository restauranteRepository) {
        this.restauranteRepository = restauranteRepository;
    }
    /**
     * Returnează toate restaurantele din repository.
     *
     * @return Lista de restaurante.
     */
    @Override
    public List<Restaurante> findAll() {
        return restauranteRepository.findAll();
    }
    /**
     * Returnează un restaurant după id-ul său.
     *
     * @param id Id-ul restaurantului căutat.
     * @return Restaurantul cu id-ul specificat, încapsulat într-un obiect Optional, sau Optional.empty() dacă nu este găsit.
     */
    @Override
    public Optional<Restaurante> findById(int id) {
        return restauranteRepository.findById(id);
    }
    /**
     * Salvează un restaurant în repository.
     *
     * @param restaurant Restaurantul care trebuie salvat.
     * @return Restaurantul salvat.
     */
    @Override
    public Restaurante save(Restaurante restaurant) {
        return restauranteRepository.save(restaurant);
    }
    /**
     * Șterge un restaurant din repository după id-ul său.
     *
     * @param restaurantId Id-ul restaurantului care trebuie șters.
     */
    @Override
    public void deleteById(int restaurantId) {
        restauranteRepository.deleteById(restaurantId);
    }
}
