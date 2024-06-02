package com.example.siteWeb.interfataService;

import com.example.siteWeb.tabele.Meniuri;

import java.util.List;
/**
 * Interfață pentru operații de gestionare a meniurilor.
 */
public interface MeniuriServiceInterfata {
    /**
     * Returnează toate meniurile din baza de date.
     * @return Lista de meniuri.
     */
    List<Meniuri> getAllMeniuri();

    /**
     * Returnează un meniu după ID.
     * @param meniuId ID-ul meniului căutat.
     * @return Meniul cu ID-ul specificat, sau null dacă nu există.
     */
    Meniuri getMeniuById(int meniuId);

    /**
     * Creează un nou meniu și îl asociază cu un restaurant dat.
     * @param meniu Obiectul Meniuri care reprezintă meniul de creat.
     * @return Meniul creat, sau null dacă restaurantul nu există.
     */
    Meniuri createMeniu(Meniuri meniu, int restaurantId);

    /**
     * Actualizează un meniu existent.
     * @param meniuId ID-ul meniului de actualizat.
     * @param meniu Obiectul Meniuri care reprezintă datele cu care se actualizează meniul.
     * @return Meniul actualizat, sau null dacă meniul inițial nu există.
     */
    Meniuri updateMeniu(int meniuId, Meniuri meniu);

    /**
     * Șterge un meniu după ID.
     * @param id ID-ul meniului de șters.
     */
    void deleteMeniu(int id);

    /**
     * Returnează toate meniurile asociate unui anumit restaurant.
     * @param restaurantId ID-ul restaurantului pentru care se caută meniurile.
     * @return Lista de meniuri asociate restaurantului dat.
     */
    List<Meniuri> getAllMeniuriByRestaurant(int restaurantId);

}
