package com.example.siteWeb.Service;

import com.example.siteWeb.Repo.PromotiiRepository;
import com.example.siteWeb.Tabele.Promotii;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class PromotiiService {

    @Autowired
    private PromotiiRepository promotiiRepository;

    public List<Promotii> getAllPromotii() {
        return promotiiRepository.findAll();
    }

    public Optional<Promotii> getPromotiiById(int id) {
        return promotiiRepository.findById(id);
    }

    public Promotii createOrUpdatePromotii(Promotii promotii) {
        return promotiiRepository.save(promotii);
    }

    public void deletePromotii(int id) {
        promotiiRepository.deleteById(id);
    }

    public List<Promotii> getPromotiiByCodPromotional(String codPromotional) {
        return promotiiRepository.findByCod_promotionalStartingWith(codPromotional);
    }

    public List<Promotii> getPromotiiByReducere(int reducere) {
        return promotiiRepository.findByReducere(reducere);
    }
}