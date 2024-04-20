package com.example.siteWeb.contracte;



import com.example.siteWeb.tabele.Produse;

import java.util.List;
import java.util.Optional;

public interface ProduseContract {
    List<Produse> findAll();
    Optional<Produse> findById(int id);
    Produse save(Produse produs);
    void deleteById(int produsId);
}
