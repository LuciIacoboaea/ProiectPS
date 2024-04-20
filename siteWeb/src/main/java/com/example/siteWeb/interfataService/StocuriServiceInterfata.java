package com.example.siteWeb.interfataService;

import com.example.siteWeb.tabele.Stocuri;

import java.util.List;

public interface StocuriServiceInterfata {
    List<Stocuri> getAllStocuri();
    Stocuri getStocById(int id);
    Stocuri createStoc(Stocuri stocuri);
    Stocuri updateStoc(int id, Stocuri stocuriDetails);
    void deleteStoc(int id);

}
