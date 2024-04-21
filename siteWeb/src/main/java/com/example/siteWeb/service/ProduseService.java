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
/**
 * Clasa de serviciu responsabilă pentru gestionarea operațiilor legate de entitățile Produse.
 * Implementează interfața ProduseServiceInterfata.
 */
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
    /**
     * Returnează toate entitățile Produse.
     *
     * @return Lista entităților Produse.
     */
    public List<Produse> getAllProduse() {
        return produseContract.findAll();
    }
    /**
     * Returnează un Produs după ID-ul său.
     *
     * @param id ID-ul Produsului de recuperat.
     * @return Entitatea Produsului recuperată, sau null dacă nu este găsită.
     */
    public Produse getProdusById(int id) {
        return produseContract.findById(id).orElse(null);
    }
    /**
     * Creează un nou Produs.
     *
     * @param produs   Produsul de creat.
     * @param meniuId  ID-ul Meniului asociat.
     * @return Entitatea Produsului creat.
     */
    public Produse createProdus(Produse produs, int meniuId) {
        Meniuri meniu = meniuriRepository.findById(meniuId)
                .orElseThrow(() -> new RuntimeException("Meniul nu a fost găsit în baza de date."));
        produs.setMeniu(meniu);
        return produseContract.save(produs);
    }
    /**
     * Actualizează un Produs existent.
     *
     * @param id            ID-ul Produsului de actualizat.
     * @param produsDetails Detaliile actualizate ale Produsului.
     * @return Entitatea Produsului actualizat, sau null dacă nu este găsit.
     */
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
    /**
     * Șterge un Produs după ID-ul său.
     *
     * @param id ID-ul Produsului de șters.
     */
    public void deleteProdus(int id) {

        Produse produs = produseContract.findById(id).orElse(null);
        if (produs != null) {
            Meniuri meniu = produs.getMeniu();
            if (meniu != null) {
                meniuriRepository.delete(meniu);
            }
            List<Stocuri> stocuri = produs.getStocuri();
            if (stocuri != null) {
                for (Stocuri stoc : stocuri) {
                    stocuriContract.deleteById(stoc.getStoc_id());
                }
            }
            produseContract.deleteById(id);
        }

    }
}