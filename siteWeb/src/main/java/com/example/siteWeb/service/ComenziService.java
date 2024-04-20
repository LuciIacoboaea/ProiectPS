package com.example.siteWeb.service;

import com.example.siteWeb.contracte.ComenziContract;
import com.example.siteWeb.interfataService.ComenziServiceInterfata;
import com.example.siteWeb.repo.ComenziRepository;
import com.example.siteWeb.tabele.Comenzi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Serviciu pentru gestionarea operațiilor legate de comenzile efectuate.
 */
@Service
public class ComenziService implements ComenziServiceInterfata {

    private final ComenziContract comenziContract;

    @Autowired
    public ComenziService(ComenziContract comenziContract) {
        this.comenziContract = comenziContract;
    }

    /**
     * Returnează o listă cu toate comenzile din baza de date.
     *
     * @return Lista cu toate comenzile.
     */
    public List<Comenzi> getAllComenzi() {
        return comenziContract.findAll();
    }

    /**
     * Returnează o comandă după identificatorul său.
     *
     * @param id Identificatorul comenzii.
     * @return Comanda cu identificatorul specificat sau null dacă nu este găsită.
     */
    public Comenzi getComandaById(int id) {
        return comenziContract.findById(id).orElse(null);
    }

    /**
     * Creează o nouă comandă în baza de date.
     *
     * @param comanda Obiectul Comenzi ce urmează să fie creat.
     * @return Comanda creată.
     */
    public Comenzi createComanda(Comenzi comanda) {
        return comenziContract.save(comanda);
    }

    /**
     * Actualizează informațiile unei comenzi existente în baza de date.
     *
     * @param id             Identificatorul comenzii ce urmează să fie actualizată.
     * @param comandaDetails Obiectul Comenzi ce conține noile informații ale comenzii.
     * @return Comanda actualizată sau null dacă comanda cu identificatorul specificat nu există.
     */
    public Comenzi updateComanda(int id, Comenzi comandaDetails) {
        Comenzi comanda = comenziContract.findById(id).orElse(null);
        if (comanda != null) {
            comanda.setClient(comandaDetails.getClient());
            comanda.setRestaurant(comandaDetails.getRestaurant());
            comanda.setMeniu(comandaDetails.getMeniu());
            comanda.setAdresa_livrare(comandaDetails.getAdresa_livrare());
            comanda.setData_ora(comandaDetails.getData_ora());
            comanda.setSuma_totala(comandaDetails.getSuma_totala());
            return comenziContract.save(comanda);
        }
        return null;
    }

    /**
     * Șterge o comandă din baza de date după identificatorul său.
     *
     * @param id Identificatorul comenzii ce urmează să fie ștearsă.
     */
    public void deleteComanda(int id) {
        comenziContract.deleteById(id);
    }
}