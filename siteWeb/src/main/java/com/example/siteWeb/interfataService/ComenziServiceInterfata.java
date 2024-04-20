package com.example.siteWeb.interfataService;

import com.example.siteWeb.tabele.Comenzi;

import java.util.List;

/**
        * Interfață pentru serviciul de gestionare a comenzilor.
        */
public interface ComenziServiceInterfata {

    /**
     * Returnează o listă cu toate comenzile din baza de date.
     *
     * @return Lista cu toate comenzile.
     */
    List<Comenzi> getAllComenzi();

    /**
     * Returnează o comandă după identificatorul său.
     *
     * @param id Identificatorul comenzii.
     * @return Comanda cu identificatorul specificat sau null dacă nu este găsită.
     */
    Comenzi getComandaById(int id);

    /**
     * Creează o nouă comandă în baza de date.
     *
     * @param comanda Obiectul Comenzi ce urmează să fie creat.
     * @return Comanda creată.
     */
    Comenzi createComanda(Comenzi comanda);

    /**
     * Actualizează informațiile unei comenzi existente în baza de date.
     *
     * @param id             Identificatorul comenzii ce urmează să fie actualizată.
     * @param comandaDetails Obiectul Comenzi ce conține noile informații ale comenzii.
     * @return Comanda actualizată sau null dacă comanda cu identificatorul specificat nu există.
     */
    Comenzi updateComanda(int id, Comenzi comandaDetails);

    /**
     * Șterge o comandă din baza de date după identificatorul său.
     *
     * @param id Identificatorul comenzii ce urmează să fie ștearsă.
     */
    void deleteComanda(int id);
}