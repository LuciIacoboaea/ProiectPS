package com.example.siteWeb.interfataService;
import com.example.siteWeb.tabele.Restaurante;

import java.util.List;

public interface RestauranteServiceInterfata {
    List<Restaurante> getAllRestaurante();

    Restaurante getRestauranteById(int id);

    Restaurante createRestaurante(Restaurante restaurante);

    Restaurante updateRestaurante(int id, Restaurante updatedRestaurante);

    void deleteRestaurantAndAssociatedData(int restaurantId);
}
