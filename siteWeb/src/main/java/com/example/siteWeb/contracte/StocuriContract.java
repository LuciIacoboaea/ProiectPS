package com.example.siteWeb.contracte;
import com.example.siteWeb.tabele.Stocuri;

import java.util.List;
import java.util.Optional;

public interface StocuriContract {
    List<Stocuri> findAll();
    Optional<Stocuri> findById(int id);
    Stocuri save(Stocuri stocuri);
    void deleteById(int stocId);
}
