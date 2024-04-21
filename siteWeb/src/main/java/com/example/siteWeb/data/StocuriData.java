package com.example.siteWeb.data;

import com.example.siteWeb.contracte.StocuriContract;
import com.example.siteWeb.repo.StocuriRepository;
import com.example.siteWeb.tabele.Stocuri;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
/**
 * Clasa responsabilă pentru gestionarea datelor referitoare la stocuri.
 * Implementează operațiile specificate în contractul StocuriContract.
 */
@Repository
public class StocuriData implements StocuriContract {
    private final StocuriRepository stocuriRepository;

    @Autowired
    public StocuriData(StocuriRepository stocuriRepository) {
        this.stocuriRepository = stocuriRepository;
    }
    /**
     * Returnează toate stocurile din repository.
     *
     * @return Lista de stocuri.
     */
    @Override
    public List<Stocuri> findAll() {
        return stocuriRepository.findAll();
    }
    /**
     * Returnează un stoc după id-ul său.
     *
     * @param id Id-ul stocului căutat.
     * @return Stocul cu id-ul specificat, încapsulat într-un obiect Optional, sau Optional.empty() dacă nu este găsit.
     */
    @Override
    public Optional<Stocuri> findById(int id) {
        return stocuriRepository.findById(id);
    }
    /**
     * Salvează un stoc în repository.
     *
     * @param stoc Stocul care trebuie salvat.
     * @return Stocul salvat.
     */
    @Override
    public Stocuri save(Stocuri stoc) {
        return stocuriRepository.save(stoc);
    }
    /**
     * Șterge un stoc din repository după id-ul său.
     *
     * @param stocId Id-ul stocului care trebuie șters.
     */
    @Override
    public void deleteById(int stocId) {
        stocuriRepository.deleteById(stocId);
    }
}
