package com.example.siteWeb.contracte;

import com.example.siteWeb.tabele.Comenzi;

import java.util.List;
import java.util.Optional;
/**
 * Interfața care definește operațiile disponibile pentru gestionarea comenzilor.
 */

public interface ComenziContract {
    /**
     * Returnează o listă de comenzi.
     *
     * @return Lista de comenzi.
     */
    List<Comenzi> findAll();
    /**
     * Returnează o comandă cu un anumit ID, dacă există.
     *
     * @param id ID-ul comenzii căutate.
     * @return Un obiect Optional care conține comanda sau null dacă nu a fost găsită.
     */
    Optional<Comenzi> findById(int id);
    /**
     * Salvează o comandă în baza de date.
     *
     * @param comanda Comanda care trebuie salvată.
     * @return Comanda salvată.
     */
    Comenzi save(Comenzi comanda);
    /**
     * Șterge o comandă cu un anumit ID.
     *
     * @param comandaId ID-ul comenzii care trebuie ștearsă.
     */
    void deleteById(int comandaId);
}
