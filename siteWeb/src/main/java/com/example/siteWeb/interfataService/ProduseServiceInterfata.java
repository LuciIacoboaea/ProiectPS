package com.example.siteWeb.interfataService;

import com.example.siteWeb.tabele.Produse;

import java.util.List;

public interface ProduseServiceInterfata {
    List<Produse> getAllProduse();
    Produse getProdusById(int id);
    Produse createProdus(Produse produs,int meniuId);
    Produse updateProdus(int id, Produse produsDetails);
    void deleteProdus(int id);
}
