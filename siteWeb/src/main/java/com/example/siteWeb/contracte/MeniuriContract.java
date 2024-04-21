package com.example.siteWeb.contracte;

import com.example.siteWeb.tabele.Meniuri;


import java.util.List;
import java.util.Optional;
/**
 * Interfața care definește operațiile disponibile pentru gestionarea meniurilor.
 */
public interface MeniuriContract {
    /**
     * Returnează o listă de meniuri.
     *
     * @return Lista de meniuri.
     */
    List<Meniuri> findAll();
    /**
     * Returnează un meniu cu un anumit ID, dacă există.
     *
     * @param id ID-ul meniului căutat.
     * @return Un obiect Optional care conține meniul sau null dacă nu a fost găsit.
     */
    Optional<Meniuri> findById(int id);
    /**
     * Salvează un meniu în baza de date.
     *
     * @param meniu Meniul care trebuie salvat.
     * @return Meniul salvat.
     */
    Meniuri save(Meniuri meniu);
    /**
     * Șterge un meniu cu un anumit ID.
     *
     * @param meniuId ID-ul meniului care trebuie șters.
     */
    void deleteById(int meniuId);
}
