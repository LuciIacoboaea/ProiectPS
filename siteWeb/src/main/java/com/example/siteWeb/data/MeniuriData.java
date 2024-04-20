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
@Repository
public class MeniuriData implements MeniuriContract {

    private final MeniuriRepository meniuriRepository;

    @Autowired
    public MeniuriData(MeniuriRepository meniuriRepository) {
        this.meniuriRepository = meniuriRepository;
    }

    @Override
    public List<Meniuri> findAll() {
        return meniuriRepository.findAll();
    }

    @Override
    public Optional<Meniuri> findById(int id) {
        return meniuriRepository.findById(id);
    }

    @Override
    public Meniuri save(Meniuri meniu) {
        return meniuriRepository.save(meniu);
    }

    @Override
    public void deleteById(int meniuId) {
        meniuriRepository.deleteById(meniuId);
    }
}
