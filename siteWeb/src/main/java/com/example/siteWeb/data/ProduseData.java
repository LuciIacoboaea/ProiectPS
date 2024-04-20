package com.example.siteWeb.data;

import com.example.siteWeb.contracte.ProduseContract;
import com.example.siteWeb.repo.ProduseRepository;
import com.example.siteWeb.tabele.Produse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public class ProduseData implements ProduseContract {
    private final ProduseRepository produseRepository;

    @Autowired
    public ProduseData(ProduseRepository produseRepository) {
        this.produseRepository = produseRepository;
    }

    @Override
    public List<Produse> findAll() {
        return produseRepository.findAll();
    }

    @Override
    public Optional<Produse> findById(int id) {
        return produseRepository.findById(id);
    }

    @Override
    public Produse save(Produse produs) {
        return produseRepository.save(produs);
    }

    @Override
    public void deleteById(int produsId) {
        produseRepository.deleteById(produsId);
    }
}
