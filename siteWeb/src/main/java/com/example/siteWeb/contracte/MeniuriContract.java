package com.example.siteWeb.contracte;

import com.example.siteWeb.tabele.Meniuri;


import java.util.List;
import java.util.Optional;

public interface MeniuriContract {
    List<Meniuri> findAll();
    Optional<Meniuri> findById(int id);
    Meniuri save(Meniuri meniu);
    void deleteById(int meniuId);
}
