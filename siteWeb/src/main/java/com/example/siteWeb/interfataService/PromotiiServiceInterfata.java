package com.example.siteWeb.interfataService;

import com.example.siteWeb.tabele.Promotii;

import java.util.List;
import java.util.Optional;

public interface PromotiiServiceInterfata {
    List<Promotii> getAllPromotii();

    Optional<Promotii> getPromotiiById(int id);

    Promotii createPromotii(Promotii promotii,int restaurantId);

    Promotii updatePromotii(int id, Promotii updatedPromotii);

    void deletePromotii(int id);

    List<Promotii> getPromotiiByCodPromotional(String codPromotional);

    List<Promotii> getPromotiiByReducere(int reducere);
}
