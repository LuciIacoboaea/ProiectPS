package com.example.siteWeb.data;

import com.example.siteWeb.contracte.PromotiiContract;
import com.example.siteWeb.repo.ClientiRepository;
import com.example.siteWeb.repo.PromotiiRepository;
import com.example.siteWeb.tabele.Clienti;
import com.example.siteWeb.tabele.Promotii;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
/**
 * Clasa responsabilă pentru gestionarea datelor referitoare la promotii.
 * Implementează operațiile specificate în contractul PromotiiContract.
 */
@Repository
public class PromotiiData implements PromotiiContract {

    private final PromotiiRepository promotiiRepository;
    @Autowired
    public PromotiiData(PromotiiRepository promotiiRepository) {
        this.promotiiRepository = promotiiRepository;
    }
    /**
     * Returnează toate promotiile din repository.
     *
     * @return Lista de promotii.
     */
    @Override
    public List<Promotii> findAll() {
        return promotiiRepository.findAll();
    }
    /**
     * Returnează o promotie după id-ul său.
     *
     * @param id Id-ul promotiei căutate.
     * @return Promotia cu id-ul specificat, încapsulată într-un obiect Optional, sau Optional.empty() dacă nu este găsită.
     */
    @Override
    public Optional<Promotii> findById(int id) {
        return this.promotiiRepository.findById(id);
    }
    /**
     * Salvează o promotie în repository.
     *
     * @param promotie Promotia care trebuie salvata.
     * @return Promotia salvata.
     */
    @Override
    public Promotii save(Promotii promotie) {
        return promotiiRepository.save(promotie);
    }
    /**
     * Șterge o promotie din repository după id-ul său.
     *
     * @param promotieId Id-ul promotiei care trebuie șters.
     */
    @Override
    public void deleteById(int promotieId) {
        promotiiRepository.deleteById(promotieId);
    }
    /**
     * Returnează o listă de promotii cu codul promoțional începând cu șirul dat.
     *
     * @param codPromotional Șirul cu care începe codul promoțional.
     * @return Lista de promotii care îndeplinesc criteriul dat.
     */
    @Override
    public List<Promotii> findByCod_promotionalStartingWith(String codPromotional) {
        return promotiiRepository.findByCod_promotionalStartingWith(codPromotional);
    }
    /**
     * Returnează o listă de promotii cu o anumită reducere.
     *
     * @param reducere Valoarea reducerii căutate.
     * @return Lista de promotii care îndeplinesc criteriul dat.
     */
    @Override
    public List<Promotii> findByReducere(int reducere) {
        return promotiiRepository.findByReducere(reducere);
    }
}
