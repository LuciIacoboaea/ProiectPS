package com.example.siteWeb.data;
import com.example.siteWeb.contracte.ComenziContract;
import com.example.siteWeb.repo.ComenziRepository;
import com.example.siteWeb.tabele.Comenzi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
/**
 * Clasa responsabilă pentru gestionarea datelor referitoare la comenzile efectuate.
 * Implementează operațiile specificate în contractul ComenziContract.
 */
@Repository
public class ComenziData implements ComenziContract {
    private final ComenziRepository comenziRepository;

    @Autowired
    public ComenziData(ComenziRepository comenziRepository) {
        this.comenziRepository = comenziRepository;
    }
    /**
     * Returnează toate comenzile din repository.
     *
     * @return Lista de comenzi.
     */
    @Override
    public List<Comenzi> findAll() {
        return comenziRepository.findAll();
    }
    /**
     * Returnează o comandă după id-ul său.
     *
     * @param id Id-ul comenzii căutate.
     * @return Comanda cu id-ul specificat, încapsulată într-un obiect Optional, sau Optional.empty() dacă nu este găsită.
     */
    @Override
    public Optional<Comenzi> findById(int id) {
        return comenziRepository.findById(id);
    }
    /**
     * Salvează o comandă în repository.
     *
     * @param comanda Comanda care trebuie salvată.
     * @return Comanda salvată.
     */
    @Override
    public Comenzi save(Comenzi comanda) {
        return comenziRepository.save(comanda);
    }
    /**
     * Șterge o comandă din repository după id-ul său.
     *
     * @param comandaId Id-ul comenzii care trebuie ștearsă.
     */
    @Override
    public void deleteById(int comandaId) {
        comenziRepository.deleteById(comandaId);
    }
}
