package com.example.siteWeb.contracte;
import com.example.siteWeb.tabele.Restaurante;

import java.util.List;
import java.util.Optional;
/**
 * Interfața care definește operațiile disponibile pentru gestionarea restaurantelor.
 */
public interface RestauranteContract {
    /**
     * Returnează o listă de restaurante.
     *
     * @return Lista de restaurante.
     */
    List<Restaurante> findAll();
    /**
     * Returnează un restaurant cu un anumit ID, dacă există.
     *
     * @param id ID-ul restaurantului căutat.
     * @return Un obiect Optional care conține restaurantul sau null dacă nu a fost găsit.
     */
    Optional<Restaurante> findById(int id);
    /**
     * Salvează un restaurant în baza de date.
     *
     * @param restaurant Restaurantul care trebuie salvat.
     * @return Restaurantul salvat.
     */
    Restaurante save(Restaurante restaurant);
    /**
     * Șterge un restaurant cu un anumit ID.
     *
     * @param restaurantId ID-ul restaurantului care trebuie șters.
     */
    void deleteById(int restaurantId);

    /**
     * Caută restaurantele care conțin un șir specificat în nume.
     *
     * @param query Șirul de căutare pentru nume.
     * @return Lista de restaurante care conțin șirul specificat în nume.
     */
    List<Restaurante> findByNumeContaining(String query);
}
