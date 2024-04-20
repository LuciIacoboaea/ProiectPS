package com.example.siteWeb.data;
import com.example.siteWeb.contracte.RestauranteContract;
import com.example.siteWeb.repo.RestauranteRepository;
import com.example.siteWeb.tabele.Restaurante;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public class RestauranteData implements RestauranteContract {
    private final RestauranteRepository restauranteRepository;

    @Autowired
    public RestauranteData(RestauranteRepository restauranteRepository) {
        this.restauranteRepository = restauranteRepository;
    }

    @Override
    public List<Restaurante> findAll() {
        return restauranteRepository.findAll();
    }

    @Override
    public Optional<Restaurante> findById(int id) {
        return restauranteRepository.findById(id);
    }

    @Override
    public Restaurante save(Restaurante restaurant) {
        return restauranteRepository.save(restaurant);
    }

    @Override
    public void deleteById(int restaurantId) {
        restauranteRepository.deleteById(restaurantId);
    }
}
