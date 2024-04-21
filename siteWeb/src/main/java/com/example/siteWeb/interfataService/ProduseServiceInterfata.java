package com.example.siteWeb.interfataService;

import com.example.siteWeb.tabele.Produse;

import java.util.List;
/**
 * Interfața pentru serviciul de gestionare a produselor.
 * Definește operațiile disponibile pentru gestionarea produselor.
 */
public interface ProduseServiceInterfata {
    /**
     * Returnează o listă cu toate produsele.
     *
     * @return Lista cu toate produsele.
     */
    List<Produse> getAllProduse();
    /**
     * Returnează un produs după id-ul său.
     *
     * @param id Id-ul produsului căutat.
     * @return Produsul cu id-ul specificat.
     */
    Produse getProdusById(int id);
    /**
     * Creează un nou produs.
     *
     * @param produs   Obiectul Produse care trebuie creat.
     * @param meniuId  Id-ul meniului asociat produsului.
     * @return Produsul creat.
     */
    Produse createProdus(Produse produs,int meniuId);
    /**
     * Actualizează informațiile unui produs existent.
     *
     * @param id            Id-ul produsului care trebuie actualizat.
     * @param produsDetails Obiectul Produse cu noile detalii.
     * @return Produsul actualizat.
     */
    Produse updateProdus(int id, Produse produsDetails);
    /**
     * Șterge un produs după id-ul său.
     *
     * @param id Id-ul produsului care trebuie șters.
     */
    void deleteProdus(int id);
}
