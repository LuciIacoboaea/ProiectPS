package com.example.siteWeb.data;

import com.example.siteWeb.contracte.MeniuriContract;
import com.example.siteWeb.repo.MeniuriRepository;
import com.example.siteWeb.repo.RestauranteRepository;
import com.example.siteWeb.tabele.Meniuri;
import com.example.siteWeb.tabele.Restaurante;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
/**
 * Clasa responsabilă pentru gestionarea datelor referitoare la meniuri.
 * Implementează operațiile specificate în contractul MeniuriContract.
 */
@Repository
public class MeniuriData implements MeniuriContract {

    private final MeniuriRepository meniuriRepository;

    @Autowired
    public MeniuriData(MeniuriRepository meniuriRepository) {
        this.meniuriRepository = meniuriRepository;
    }
    /**
     * Returnează toate meniurile din repository.
     *
     * @return Lista de meniuri.
     */
    @Override
    public List<Meniuri> findAll() {
        return meniuriRepository.findAll();
    }
    /**
     * Returnează un meniu după id-ul său.
     *
     * @param id Id-ul meniului căutat.
     * @return Meniul cu id-ul specificat, încapsulat într-un obiect Optional, sau Optional.empty() dacă nu este găsit.
     */
    @Override
    public Optional<Meniuri> findById(int id) {
        return meniuriRepository.findById(id);
    }
    /**
     * Salvează un meniu în repository.
     *
     * @param meniu Meniul care trebuie salvat.
     * @return Meniul salvat.
     */
    @Override
    public Meniuri save(Meniuri meniu) {
        return meniuriRepository.save(meniu);
    }
    /**
     * Șterge un meniu din repository după id-ul său.
     *
     * @param meniuId Id-ul meniului care trebuie șters.
     */
    @Override
    public void deleteById(int meniuId) {
        meniuriRepository.deleteById(meniuId);
    }
}
