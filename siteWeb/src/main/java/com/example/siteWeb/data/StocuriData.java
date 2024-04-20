package com.example.siteWeb.data;

import com.example.siteWeb.contracte.StocuriContract;
import com.example.siteWeb.repo.StocuriRepository;
import com.example.siteWeb.tabele.Stocuri;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public class StocuriData implements StocuriContract {
    private final StocuriRepository stocuriRepository;

    @Autowired
    public StocuriData(StocuriRepository stocuriRepository) {
        this.stocuriRepository = stocuriRepository;
    }

    @Override
    public List<Stocuri> findAll() {
        return stocuriRepository.findAll();
    }

    @Override
    public Optional<Stocuri> findById(int id) {
        return stocuriRepository.findById(id);
    }

    @Override
    public Stocuri save(Stocuri stoc) {
        return stocuriRepository.save(stoc);
    }

    @Override
    public void deleteById(int stocId) {
        stocuriRepository.deleteById(stocId);
    }
}
