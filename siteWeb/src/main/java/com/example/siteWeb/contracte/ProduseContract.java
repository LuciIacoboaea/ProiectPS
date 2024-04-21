package com.example.siteWeb.contracte;



import com.example.siteWeb.tabele.Produse;

import java.util.List;
import java.util.Optional;
/**
 * Interfața care definește operațiile disponibile pentru gestionarea produselor.
 */
public interface ProduseContract {
    /**
     * Returnează o listă de produse.
     *
     * @return Lista de produse.
     */
    List<Produse> findAll();
    /**
     * Returnează un produs cu un anumit ID, dacă există.
     *
     * @param id ID-ul produsului căutat.
     * @return Un obiect Optional care conține produsul sau null dacă nu a fost găsit.
     */
    Optional<Produse> findById(int id);
    /**
     * Salvează un produs în baza de date.
     *
     * @param produs Produsul care trebuie salvat.
     * @return Produsul salvat.
     */
    Produse save(Produse produs);
    /**
     * Șterge un produs cu un anumit ID.
     *
     * @param produsId ID-ul produsului care trebuie șters.
     */
    void deleteById(int produsId);
}
