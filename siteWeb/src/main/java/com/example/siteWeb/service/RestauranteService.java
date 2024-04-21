package com.example.siteWeb.service;

import com.example.siteWeb.contracte.*;
import com.example.siteWeb.tabele.*;
import com.example.siteWeb.interfataService.RestauranteServiceInterfata;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
/**
 * Serviciu pentru gestionarea operațiilor legate de restaurante.
 */
@Service
public class RestauranteService implements RestauranteServiceInterfata {

    private final RestauranteContract restauranteContract;
    private final MeniuriContract meniuriContract;
    private final ComenziContract comenziContract;
    private final PromotiiContract promotiiContract;

    private final RecenziiContract recenziiContract;

    @Autowired
    public RestauranteService(RestauranteContract restauranteContract, MeniuriContract meniuriContract,
                              ComenziContract comenziContract, PromotiiContract promotiiContract, RecenziiContract recenziiContract) {
        this.restauranteContract = restauranteContract;
        this.meniuriContract = meniuriContract;
        this.comenziContract = comenziContract;
        this.promotiiContract = promotiiContract;
        this.recenziiContract = recenziiContract;
    }
    /**
     * Returnează o listă cu toate restaurantele din baza de date.
     *
     * @return Lista cu toate restaurantele.
     */
    public List<Restaurante> getAllRestaurante() {
        return restauranteContract.findAll();
    }
    /**
     * Returnează un restaurant după identificatorul său.
     *
     * @param id Identificatorul restaurantului.
     * @return Restaurantul cu identificatorul specificat sau null dacă nu este găsit.
     */
    public Restaurante getRestauranteById(int id) {
        return restauranteContract.findById(id).orElse(null);
    }
    /**
     * Creează un nou restaurant în baza de date.
     *
     * @param restaurante Obiectul Restaurante ce urmează să fie creat.
     * @return Restaurantul creat.
     */
    public Restaurante createRestaurante(Restaurante restaurante) {
        return restauranteContract.save(restaurante);
    }
    /**
     * Actualizează informațiile unui restaurant existent în baza de date.
     *
     * @param id               Identificatorul restaurantului ce urmează să fie actualizat.
     * @param updatedRestaurante Obiectul Restaurante ce conține noile informații ale restaurantului.
     * @return Restaurantul actualizat sau null dacă restaurantul cu identificatorul specificat nu există.
     */
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
    /**
     * Șterge un restaurant din baza de date și datele asociate acestuia.
     *
     * @param restaurantId Identificatorul restaurantului ce urmează să fie șters.
     */
    public void deleteRestaurantAndAssociatedData(int restaurantId) {
        Restaurante existingRestaurant = restauranteContract.findById(restaurantId).orElse(null);

        if (existingRestaurant != null) {
            List<Recenzii> recenzii = existingRestaurant.getRecenzii();
            for (Recenzii recenzie : recenzii) {
                recenziiContract.deleteById(recenzie.getRecenzie_id());
            }

            List<Comenzi> comenzi = existingRestaurant.getComenzi();
            for (Comenzi comanda : comenzi) {
                comenziContract.deleteById(comanda.getComanda_id());
            }

            List<Meniuri> meniuri = existingRestaurant.getMeniuri();
            for (Meniuri meniu : meniuri) {
                meniuriContract.deleteById(meniu.getMeniu_id());
            }

            List<Promotii> promotii = existingRestaurant.getPromotii();
            for (Promotii promotie : promotii) {
                promotiiContract.deleteById(promotie.getPromotie_id());
            }

            restauranteContract.deleteById(restaurantId);
        }
}
}

