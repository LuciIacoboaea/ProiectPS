package com.example.siteWeb.service;

import com.example.siteWeb.contracte.MeniuriContract;
import com.example.siteWeb.interfataService.MeniuriServiceInterfata;
import com.example.siteWeb.tabele.Meniuri;
import com.example.siteWeb.repo.MeniuriRepository;
import com.example.siteWeb.tabele.Restaurante;
import com.example.siteWeb.repo.RestauranteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

/**
 * Clasa MeniuriService oferă operații pentru gestionarea meniurilor.
 * Aceste operații includ obținerea, crearea, actualizarea și ștergerea meniurilor din baza de date.
 */
@Service
public class MeniuriService implements MeniuriServiceInterfata {

    private final MeniuriContract meniuriContract;
    private final RestauranteRepository restauranteRepository;

    @Autowired
    private ProduseService produseService;

    @Autowired
    public MeniuriService(MeniuriContract meniuriContract, RestauranteRepository restauranteRepository) {
        this.meniuriContract = meniuriContract;
        this.restauranteRepository = restauranteRepository;
    }
    /**
     * Metodă pentru obținerea tuturor meniurilor din baza de date.
     * @return Lista de meniuri.
     */
    public List<Meniuri> getAllMeniuri() {
        return meniuriContract.findAll();
    }
    /**
     * Metodă pentru obținerea unui meniu după ID.
     * @param meniuId ID-ul meniului căutat.
     * @return Meniul cu ID-ul specificat, sau null dacă nu există.
     */
    public Meniuri getMeniuById(int meniuId) {
        return meniuriContract.findById(meniuId).orElse(null);
    }

    public Meniuri createMeniu(Meniuri meniu, int restaurantId) {
        Restaurante restaurant = restauranteRepository.findById(restaurantId)
                .orElseThrow(() -> new RuntimeException("Restaurantul nu a fost găsit în baza de date."));

        meniu.setRestaurant(restaurant);

        return meniuriContract.save(meniu);
    }
    /**
     * Metodă pentru actualizarea unui meniu existent.
     * @param meniuId ID-ul meniului de actualizat.
     * @param meniu Obiectul de tip Meniuri care reprezintă datele cu care se actualizează meniul.
     * @return Meniul actualizat, sau null dacă meniul inițial nu există.
     */
    public Meniuri updateMeniu(int meniuId, Meniuri meniu) {
        Meniuri existingMeniu = meniuriContract.findById(meniuId).orElse(null);
        if (existingMeniu != null) {
            existingMeniu.setNume(meniu.getNume());
            existingMeniu.setDescriere(meniu.getDescriere());
            existingMeniu.setCategorie(meniu.getCategorie());
            if (meniu.getRestaurant() != null) {
                existingMeniu.setRestaurant(meniu.getRestaurant());
            }
            return meniuriContract.save(existingMeniu);
        }
        return null;
    }
    /**
     * Metodă pentru ștergerea unui meniu după ID.
     * @param id ID-ul meniului de șters.
     */
    public void deleteMeniu(int id) {
        meniuriContract.deleteById(id);
    }

}
