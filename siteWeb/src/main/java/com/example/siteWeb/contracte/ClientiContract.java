package com.example.siteWeb.contracte;
import com.example.siteWeb.tabele.Clienti;

import java.util.List;
import java.util.Optional;
/**
 * Interfața care definește operațiile disponibile pentru gestionarea clienților.
 */
public interface ClientiContract {
    /**
     * Returnează o listă de clienți.
     *
     * @return Lista de clienți.
     */
    List<Clienti> findAll();
    /**
     * Returnează un client cu un anumit ID, dacă există.
     *
     * @param id ID-ul clientului căutat.
     * @return Un obiect Optional care conține clientul sau null dacă nu a fost găsit.
     */
    Optional<Clienti> findById(int id);
    /**
     * Salvează un client în baza de date.
     *
     * @param client Clientul care trebuie salvat.
     * @return Clientul salvat.
     */
    Clienti save(Clienti client);
    /**
     * Șterge un client cu un anumit ID.
     *
     * @param clientId ID-ul clientului care trebuie șters.
     */
    void deleteById(int clientId);
}
