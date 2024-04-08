package com.example.siteWeb.Service;

import com.example.siteWeb.Tabele.Meniuri;
import com.example.siteWeb.Repo.MeniuriRepository;
import com.example.siteWeb.Tabele.Restaurante;
import com.example.siteWeb.Repo.RestauranteRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
/**
 * Clasa MeniuriService oferă operații pentru gestionarea meniurilor.
 * Aceste operații includ obținerea, crearea, actualizarea și ștergerea meniurilor din baza de date.
 */
@Service
public class MeniuriService {

    private final MeniuriRepository meniuriRepository;
    private final RestauranteRepository restauranteRepository; // Adăugați repository-ul pentru restaurante

    @Autowired
    private ProduseService produseService;
    /**
     * Constructor pentru injecția dependențelor necesare.
     * @param meniuriRepository Reprezintă repository-ul pentru entitatea Meniuri.
     * @param restauranteRepository Reprezintă repository-ul pentru entitatea Restaurante.
     */
    @Autowired
    public MeniuriService(MeniuriRepository meniuriRepository, RestauranteRepository restauranteRepository) {
        this.meniuriRepository = meniuriRepository;
        this.restauranteRepository = restauranteRepository; // Injectați repository-ul pentru restaurante
    }
    /**
     * Metodă pentru obținerea tuturor meniurilor din baza de date.
     * @return Lista de meniuri.
     */
    public List<Meniuri> getAllMeniuri() {
        return meniuriRepository.findAll();
    }
    /**
     * Metodă pentru obținerea unui meniu după ID.
     * @param meniuId ID-ul meniului căutat.
     * @return Meniul cu ID-ul specificat, sau null dacă nu există.
     */
    public Meniuri getMeniuById(int meniuId) {
        return meniuriRepository.findById(meniuId).orElse(null);
    }
    /**
     * Metodă pentru crearea unui nou meniu și asocierea acestuia cu un restaurant dat.
     * @param meniu Obiectul de tip Meniuri care reprezintă meniul de creat.
     * @param restaurantId ID-ul restaurantului cu care se asociază meniul.
     * @return Meniul creat, sau null dacă restaurantul nu există.
     */
    public Meniuri createMeniu(Meniuri meniu, int restaurantId) { // Adăugați restaurantId ca parametru
        Restaurante restaurant = restauranteRepository.findById(restaurantId).orElse(null); // Folosiți restauranteRepository pentru a accesa restaurantele
        if (restaurant != null) {
            meniu.setRestaurant(restaurant);
            return meniuriRepository.save(meniu);
        }
        return null;
    }
    /**
     * Metodă pentru actualizarea unui meniu existent.
     * @param meniuId ID-ul meniului de actualizat.
     * @param meniu Obiectul de tip Meniuri care reprezintă datele cu care se actualizează meniul.
     * @return Meniul actualizat, sau null dacă meniul inițial nu există.
     */
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
    /**
     * Metodă pentru ștergerea unui meniu după ID.
     * @param id ID-ul meniului de șters.
     */
    public void deleteMeniu(int id) {
        meniuriRepository.deleteById(id);
    }

}
