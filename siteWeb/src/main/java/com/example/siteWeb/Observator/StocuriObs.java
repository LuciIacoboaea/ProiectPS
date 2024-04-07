package com.example.siteWeb.Observator;

import com.example.siteWeb.Tabele.Stocuri;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StocuriObs implements Obs {

    private List<Obs> observers = new ArrayList<>();

    public void attachObserver(Obs observer) {
        observers.add(observer);
    }

    public void detachObserver(Obs observer) {
        observers.remove(observer);
    }

    public void notifyObservers(Stocuri stocuri) {
        for (Obs observer : observers) {
            observer.onStocUpdate(stocuri);
        }
    }

    @Override
    public void onStocUpdate(Stocuri stocuri) {
        System.out.println("Stocul s-a modificat! " +stocuri);
    }
}
