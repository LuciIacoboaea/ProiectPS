package com.example.siteWeb.contracte;

import com.example.siteWeb.tabele.Comenzi;

import java.util.List;
import java.util.Optional;

public interface ComenziContract {
    List<Comenzi> findAll();
    Optional<Comenzi> findById(int id);
    Comenzi save(Comenzi comanda);
    void deleteById(int comandaId);
}
