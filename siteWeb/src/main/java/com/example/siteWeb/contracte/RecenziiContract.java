package com.example.siteWeb.contracte;

import com.example.siteWeb.tabele.Recenzii;

import java.util.List;
import java.util.Optional;
/**
 * Interfața care definește operațiile disponibile pentru gestionarea recenziilor.
 */
public interface RecenziiContract {
    /**
     * Returnează o listă de recenzii.
     *
     * @return Lista de recenzii.
     */
    List<Recenzii> findAll();
    /**
     * Returnează o recenzie cu un anumit ID, dacă există.
     *
     * @param id ID-ul recenziei căutate.
     * @return Un obiect Optional care conține recenzia sau null dacă nu a fost găsită.
     */
    Optional<Recenzii> findById(int id);
    /**
     * Salvează o recenzie în baza de date.
     *
     * @param recenzii Recenzia care trebuie salvată.
     * @return Recenzia salvată.
     */
    Recenzii save(Recenzii recenzii);
    /**
     * Șterge o recenzie cu un anumit ID.
     *
     * @param recenzieId ID-ul recenziei care trebuie ștearsă.
     */
    void deleteById(int recenzieId);

    /**
     * Returnează o listă de recenzii pentru un anumit restaurant.
     *
     * @param restaurantId ID-ul restaurantului.
     * @return Lista de recenzii pentru restaurantul specificat.
     */
    List<Recenzii> findByRestaurantId(int restaurantId);
}
