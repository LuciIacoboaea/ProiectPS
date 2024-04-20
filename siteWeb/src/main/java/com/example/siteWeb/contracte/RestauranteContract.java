package com.example.siteWeb.contracte;
import com.example.siteWeb.tabele.Restaurante;

import java.util.List;
import java.util.Optional;
public interface RestauranteContract {
    List<Restaurante> findAll();
    Optional<Restaurante> findById(int id);
    Restaurante save(Restaurante restaurant);
    void deleteById(int restaurantId);
}
