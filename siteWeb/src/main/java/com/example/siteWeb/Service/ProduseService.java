package com.example.siteWeb.Service;

import com.example.siteWeb.Repo.ProduseRepository;
import com.example.siteWeb.Tabele.Produse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProduseService {

    @Autowired
    private ProduseRepository produseRepository;

    public List<Produse> getAllProduse() {
        return produseRepository.findAll();
    }

    public Produse getProdusById(int id) {
        return produseRepository.findById(id).orElse(null);
    }

    public Produse createProdus(Produse produs) {
        return produseRepository.save(produs);
    }

    public Produse updateProdus(int id, Produse produsDetails) {
        Produse produs = produseRepository.findById(id).orElse(null);
        if (produs != null) {
            produs.setNume(produsDetails.getNume());
            produs.setDescriere(produsDetails.getDescriere());
            produs.setPret(produsDetails.getPret());
            return produseRepository.save(produs);
        } else {
            return null;
        }
    }

    public void deleteProdus(int id) {
        produseRepository.deleteById(id);
    }

    public void deleteByMeniuId(int meniuId) {
        produseRepository.deleteByMeniu_id(meniuId);
    }
}