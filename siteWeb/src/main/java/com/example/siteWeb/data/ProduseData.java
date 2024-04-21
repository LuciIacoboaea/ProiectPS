package com.example.siteWeb.data;

import com.example.siteWeb.contracte.ProduseContract;
import com.example.siteWeb.repo.ProduseRepository;
import com.example.siteWeb.tabele.Produse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
/**
 * Clasa responsabilă pentru gestionarea datelor referitoare la produse.
 * Implementează operațiile specificate în contractul ProduseContract.
 */
@Repository
public class ProduseData implements ProduseContract {
    private final ProduseRepository produseRepository;

    @Autowired
    public ProduseData(ProduseRepository produseRepository) {
        this.produseRepository = produseRepository;
    }

    /**
     * Returnează toate produsele din repository.
     *
     * @return Lista de produse.
     */
    @Override
    public List<Produse> findAll() {
        return produseRepository.findAll();
    }
    /**
     * Returnează un produs după id-ul său.
     *
     * @param id Id-ul produsului căutat.
     * @return Produsul cu id-ul specificat, încapsulat într-un obiect Optional, sau Optional.empty() dacă nu este găsit.
     */
    @Override
    public Optional<Produse> findById(int id) {
        return produseRepository.findById(id);
    }
    /**
     * Salvează un produs în repository.
     *
     * @param produs Produsul care trebuie salvat.
     * @return Produsul salvat.
     */

    @Override
    public Produse save(Produse produs) {
        return produseRepository.save(produs);
    }
    /**
     * Șterge un produs din repository după id-ul său.
     *
     * @param produsId Id-ul produsului care trebuie șters.
     */
    @Override
    public void deleteById(int produsId) {
        produseRepository.deleteById(produsId);
    }
}
