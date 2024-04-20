package com.example.siteWeb.service;

import com.example.siteWeb.contracte.ProduseContract;
import com.example.siteWeb.interfataService.ProduseServiceInterfata;
import com.example.siteWeb.repo.MeniuriRepository;
import com.example.siteWeb.tabele.Meniuri;
import com.example.siteWeb.tabele.Produse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProduseService implements ProduseServiceInterfata {

    private final ProduseContract produseContract;
    private final MeniuriRepository meniuriRepository;

    @Autowired
    public ProduseService(ProduseContract produseContract, MeniuriRepository meniuriRepository) {
        this.produseContract = produseContract;
        this.meniuriRepository = meniuriRepository;
    }

    public List<Produse> getAllProduse() {
        return produseContract.findAll();
    }

    public Produse getProdusById(int id) {
        return produseContract.findById(id).orElse(null);
    }

    public Produse createProdus(Produse produs, int meniuId) {
        // Căutăm meniul în baza de date folosind meniuId
        Meniuri meniu = meniuriRepository.findById(meniuId)
                .orElseThrow(() -> new RuntimeException("Meniul nu a fost găsit în baza de date."));

        // Setăm meniul asociat produsului
        produs.setMeniu(meniu);

        // Salvăm produsul în baza de date utilizând repository-ul ProduseContract
        return produseContract.save(produs);
    }

    public Produse updateProdus(int id, Produse produsDetails) {
        Produse produs = produseContract.findById(id).orElse(null);
        if (produs != null) {
            produs.setNume(produsDetails.getNume());
            produs.setDescriere(produsDetails.getDescriere());
            produs.setPret(produsDetails.getPret());
            return produseContract.save(produs);
        } else {
            return null;
        }
    }

    public void deleteProdus(int id) {
        produseContract.deleteById(id);
    }

}