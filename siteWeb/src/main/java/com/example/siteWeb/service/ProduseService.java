package com.example.siteWeb.service;

import com.example.siteWeb.contracte.ProduseContract;
import com.example.siteWeb.contracte.StocuriContract;
import com.example.siteWeb.interfataService.ProduseServiceInterfata;
import com.example.siteWeb.repo.MeniuriRepository;
import com.example.siteWeb.tabele.Meniuri;
import com.example.siteWeb.tabele.Produse;
import com.example.siteWeb.tabele.Stocuri;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProduseService implements ProduseServiceInterfata {

    private final ProduseContract produseContract;
    private final MeniuriRepository meniuriRepository;

    private final StocuriContract stocuriContract;

    @Autowired
    public ProduseService(ProduseContract produseContract, MeniuriRepository meniuriRepository, StocuriContract stocuriContract) {
        this.produseContract = produseContract;
        this.meniuriRepository = meniuriRepository;
        this.stocuriContract = stocuriContract;
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
        // Căutăm produsul în baza de date
        Produse produs = produseContract.findById(id).orElse(null);
        if (produs != null) {
            // Căutăm meniul asociat produsului
            Meniuri meniu = produs.getMeniu();
            if (meniu != null) {
                // Ștergem meniul asociat produsului
                meniuriRepository.delete(meniu);
            }

            // Căutăm stocurile asociate produsului
            List<Stocuri> stocuri = produs.getStocuri();
            if (stocuri != null) {
                // Ștergem fiecare stoc asociat produsului
                for (Stocuri stoc : stocuri) {
                    // Ștergem stocul din baza de date
                    stocuriContract.deleteById(stoc.getStoc_id());
                }
            }

            // Ștergem produsul din baza de date
            produseContract.deleteById(id);
        }

    }
}