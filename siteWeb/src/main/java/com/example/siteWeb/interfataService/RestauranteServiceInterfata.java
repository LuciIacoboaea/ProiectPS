package com.example.siteWeb.interfataService;
import com.example.siteWeb.tabele.Restaurante;

import java.util.List;
/**
 * Interfața pentru serviciul de gestionare a restaurantelor.
 * Definește operațiile disponibile pentru gestionarea restaurantelor.
 */
public interface RestauranteServiceInterfata {
    /**
     * Returnează o listă cu toate restaurantele.
     *
     * @return Lista cu toate restaurantele.
     */
    List<Restaurante> getAllRestaurante();
    /**
     * Returnează un restaurant după id-ul său.
     *
     * @param id Id-ul restaurantului căutat.
     * @return Restaurantul cu id-ul specificat.
     */
    Restaurante getRestauranteById(int id);
    /**
     * Creează un nou restaurant.
     *
     * @param restaurante Obiectul Restaurante care trebuie creat.
     * @return Restaurantul creat.
     */
    Restaurante createRestaurante(Restaurante restaurante);
    /**
     * Actualizează informațiile unui restaurant existent.
     *
     * @param id                Id-ul restaurantului care trebuie actualizat.
     * @param updatedRestaurante Obiectul Restaurante cu noile detalii.
     * @return Restaurantul actualizat.
     */
    Restaurante updateRestaurante(int id, Restaurante updatedRestaurante);
    /**
     * Șterge un restaurant și datele asociate acestuia, identificate prin id-ul restaurantului.
     *
     * @param restaurantId Id-ul restaurantului care trebuie șters.
     */
    void deleteRestaurantAndAssociatedData(int restaurantId);
}
