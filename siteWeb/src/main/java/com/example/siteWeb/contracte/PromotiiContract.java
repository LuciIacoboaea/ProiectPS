package com.example.siteWeb.contracte;

import com.example.siteWeb.tabele.Promotii;

import java.util.List;
import java.util.Optional;
/**
 * Interfața care definește operațiile disponibile pentru gestionarea promotiilor.
 */
public interface PromotiiContract {
    /**
     * Returnează o listă de promotii.
     *
     * @return Lista de promotii.
     */
    List<Promotii> findAll();
    /**
     * Returnează o promotie cu un anumit ID, dacă există.
     *
     * @param id ID-ul promotiei căutate.
     * @return Un obiect Optional care conține promotia sau null dacă nu a fost găsită.
     */
    Optional<Promotii> findById(int id);
    /**
     * Salvează o promotie în baza de date.
     *
     * @param promotie Promotia care trebuie salvată.
     * @return Promotia salvată.
     */
    Promotii save(Promotii promotie);
    /**
     * Șterge o promotie cu un anumit ID.
     *
     * @param promotieId ID-ul promotiei care trebuie ștearsă.
     */
    void deleteById(int promotieId);
    /**
     * Returnează o listă de promotii care încep cu un anumit cod promțional.
     *
     * @param codPromotional Codul promțional căutat.
     * @return Lista de promotii care încep cu codul promțional dat.
     */
    List<Promotii> findByCod_promotionalStartingWith(String codPromotional);
    /**
     * Returnează o listă de promotii care au o anumită valoare de reducere.
     *
     * @param reducere Valoarea reducerii căutate.
     * @return Lista de promotii care au valoarea reducerii specificată.
     */
    List<Promotii> findByReducere(int reducere);
}
