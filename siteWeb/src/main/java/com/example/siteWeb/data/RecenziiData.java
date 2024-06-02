package com.example.siteWeb.data;

import com.example.siteWeb.contracte.RecenziiContract;
import com.example.siteWeb.repo.ProduseRepository;
import com.example.siteWeb.repo.RecenziiRepository;
import com.example.siteWeb.tabele.Produse;
import com.example.siteWeb.tabele.Recenzii;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
/**
 * Clasa responsabilă pentru gestionarea datelor referitoare la recenzii.
 * Implementează operațiile specificate în contractul RecenziiContract.
 */
@Repository
public class RecenziiData implements RecenziiContract {
    private final RecenziiRepository recenziiRepository;

    @Autowired
    public RecenziiData(RecenziiRepository recenziiRepository) {
        this.recenziiRepository = recenziiRepository;
    }
    /**
     * Returnează toate recenziile din repository.
     *
     * @return Lista de recenzii.
     */
    @Override
    public List<Recenzii> findAll() {
        return recenziiRepository.findAll();
    }
    /**
     * Returnează o recenzie după id-ul său.
     *
     * @param id Id-ul recenziei căutate.
     * @return Recenzia cu id-ul specificat, încapsulată într-un obiect Optional, sau Optional.empty() dacă nu este găsită.
     */
    @Override
    public Optional<Recenzii> findById(int id) {
        return recenziiRepository.findById(id);
    }
    /**
     * Salvează o recenzie în repository.
     *
     * @param recenzie Recenzia care trebuie salvată.
     * @return Recenzia salvată.
     */
    @Override
    public Recenzii save(Recenzii recenzie) {
        return recenziiRepository.save(recenzie);
    }
    /**
     * Șterge o recenzie din repository după id-ul său.
     *
     * @param recenzieId Id-ul recenziei care trebuie ștearsă.
     */
    @Override
    public void deleteById(int recenzieId) {
        recenziiRepository.deleteById(recenzieId);
    }

    @Override
    public List<Recenzii> findByRestaurantId(int restaurantId) {
        return recenziiRepository.findByRestaurantId(restaurantId);
    }
}
