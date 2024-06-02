package com.example.siteWeb.service;

import com.example.siteWeb.contracte.RecenziiContract;
import com.example.siteWeb.contracte.RestauranteContract;
import com.example.siteWeb.interfataService.RecenziiInterfataService;
import com.example.siteWeb.tabele.Recenzii;
import com.example.siteWeb.tabele.Restaurante;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
/**
 * Serviciu pentru gestionarea operațiilor legate de recenzii.
 */
@Service
public class RecenziiService implements RecenziiInterfataService {
    private final RecenziiContract recenziiContract;
    private final RestauranteService restauranteService;

    @Autowired
    public RecenziiService(RecenziiContract recenziiContract, RestauranteService restauranteService) {
        this.recenziiContract = recenziiContract;
        this.restauranteService = restauranteService;
    }

    /**
     * Returnează o listă cu toate recenziile din baza de date.
     *
     * @return Lista cu toate recenziile.
     */
    public List<Recenzii> getAllRecenzii() {
        return recenziiContract.findAll();
    }

    /**
     * Returnează o recenzie după identificatorul său.
     *
     * @param id Identificatorul recenziei.
     * @return Recenzia cu identificatorul specificat sau null dacă nu este găsită.
     */
    public Recenzii getRecenzieById(int id) {
        return recenziiContract.findById(id).orElse(null);
    }

    /**
     * Creează o nouă recenzie în baza de date.
     *
     * @param recenzie Obiectul Recenzii ce urmează să fie creat.
     * @return Recenzia creată.
     */
    public Recenzii createRecenzie(Recenzii recenzie) {
        return recenziiContract.save(recenzie);
    }

    /**
     * Actualizează informațiile unei recenzii existente în baza de date.
     *
     * @param id             Identificatorul recenziei ce urmează să fie actualizată.
     * @param recenzieDetails Obiectul Recenzii ce conține noile informații ale recenziei.
     * @return Recenzia actualizată sau null dacă recenzia cu identificatorul specificat nu există.
     */
    public Recenzii updateRecenzie(int id, Recenzii recenzieDetails) {
        Recenzii recenzie = recenziiContract.findById(id).orElse(null);
        if (recenzie != null) {
            recenzie.setClient_id(recenzieDetails.getClient_id());
            recenzie.setRating(recenzieDetails.getRating());
            recenzie.setComentariu(recenzieDetails.getComentariu());
            recenzie.setData(recenzieDetails.getData());
            recenzie.setRestaurant(recenzieDetails.getRestaurant());
            return recenziiContract.save(recenzie);
        }
        return null;
    }

    /**
     * Șterge o recenzie din baza de date după identificatorul său.
     *
     * @param id Identificatorul recenziei ce urmează să fie ștearsă.
     */
    public void deleteRecenzie(int id) {
        recenziiContract.deleteById(id);
    }

    public List<Recenzii> getReviewsByRestaurantId(int restaurantId) {
        return recenziiContract.findByRestaurantId(restaurantId);
    }

    public Recenzii createReview(int restaurantId, Recenzii review) {
        Restaurante restaurant = restauranteService.getRestauranteById(restaurantId);
        review.setRestaurant(restaurant);
        return recenziiContract.save(review);
    }

}
