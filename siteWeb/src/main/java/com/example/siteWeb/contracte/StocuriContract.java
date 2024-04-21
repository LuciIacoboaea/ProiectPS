package com.example.siteWeb.contracte;
import com.example.siteWeb.tabele.Stocuri;

import java.util.List;
import java.util.Optional;
/**
 * Interfața care definește operațiile disponibile pentru gestionarea stocurilor.
 */
public interface StocuriContract {
    /**
     * Returnează o listă de stocuri.
     *
     * @return Lista de stocuri.
     */
    List<Stocuri> findAll();
    /**
     * Returnează un stoc cu un anumit ID, dacă există.
     *
     * @param id ID-ul stocului căutat.
     * @return Un obiect Optional care conține stocul sau null dacă nu a fost găsit.
     */
    Optional<Stocuri> findById(int id);
    /**
     * Salvează un stoc în baza de date.
     *
     * @param stocuri Stocul care trebuie salvat.
     * @return Stocul salvat.
     */
    Stocuri save(Stocuri stocuri);
    /**
     * Șterge un stoc cu un anumit ID.
     *
     * @param stocId ID-ul stocului care trebuie șters.
     */
    void deleteById(int stocId);
}
