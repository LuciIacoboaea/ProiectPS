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
@Repository
public class PromotiiData implements PromotiiContract {

    private final PromotiiRepository promotiiRepository;
    @Autowired
    public PromotiiData(PromotiiRepository promotiiRepository) {
        this.promotiiRepository = promotiiRepository;
    }

    @Override
    public List<Promotii> findAll() {
        return promotiiRepository.findAll();
    }

    @Override
    public Optional<Promotii> findById(int id) {
        return this.promotiiRepository.findById(id);
    }

    @Override
    public Promotii save(Promotii promotie) {
        return promotiiRepository.save(promotie);
    }

    @Override
    public void deleteById(int promotieId) {
        promotiiRepository.deleteById(promotieId);
    }

    @Override
    public List<Promotii> findByCod_promotionalStartingWith(String codPromotional) {
        return promotiiRepository.findByCod_promotionalStartingWith(codPromotional);
    }

    @Override
    public List<Promotii> findByReducere(int reducere) {
        return promotiiRepository.findByReducere(reducere);
    }
}
