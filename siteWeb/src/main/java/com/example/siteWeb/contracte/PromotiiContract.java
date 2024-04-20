package com.example.siteWeb.contracte;

import com.example.siteWeb.tabele.Promotii;

import java.util.List;
import java.util.Optional;

public interface PromotiiContract {
    List<Promotii> findAll();
    Optional<Promotii> findById(int id);
    Promotii save(Promotii promotie);
    void deleteById(int promotie);
    List<Promotii> findByCod_promotionalStartingWith(String codPromotional);
    List<Promotii> findByReducere(int reducere);
}
