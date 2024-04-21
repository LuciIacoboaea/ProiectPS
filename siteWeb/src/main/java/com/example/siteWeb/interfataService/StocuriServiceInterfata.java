package com.example.siteWeb.interfataService;

import com.example.siteWeb.tabele.Stocuri;

import java.util.List;
/**
 * Interfața pentru serviciul de gestionare a stocurilor.
 * Definește operațiile disponibile pentru gestionarea stocurilor.
 */
public interface StocuriServiceInterfata {
    /**
     * Returnează o listă cu toate stocurile.
     *
     * @return Lista cu toate stocurile.
     */
    List<Stocuri> getAllStocuri();
    /**
     * Returnează un stoc după id-ul său.
     *
     * @param id Id-ul stocului căutat.
     * @return Stocul cu id-ul specificat.
     */
    Stocuri getStocById(int id);
    /**
     * Creează un nou stoc.
     *
     * @param stocuri Obiectul Stocuri care trebuie creat.
     * @return Stocul creat.
     */
    Stocuri createStoc(Stocuri stocuri);
    /**
     * Actualizează informațiile unui stoc existent.
     *
     * @param id                Id-ul stocului care trebuie actualizat.
     * @param stocuriDetails Obiectul Stocuri cu noile detalii.
     * @return Stocul actualizat.
     */
    Stocuri updateStoc(int id, Stocuri stocuriDetails);
    /**
     * Șterge un stoc identificat prin id-ul său.
     *
     * @param id Id-ul stocului care trebuie șters.
     */
    void deleteStoc(int id);

}
