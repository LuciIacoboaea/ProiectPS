package com.example.siteWeb.observator;

import com.example.siteWeb.tabele.Stocuri;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
/**
 * Clasa StocuriObs este un serviciu care gestionează observatorii pentru actualizările stocurilor.
 * Implementează interfața Obs pentru a primi notificări despre modificările stocurilor.
 */
@Service
public class StocuriObs implements Obs {

    /**
     * Lista de observatori înregistrați pentru notificări.
     */
    private List<Obs> observers = new ArrayList<>();

    /**
     * Metodă pentru adăugarea unui observator.
     * @param observer Observatorul de adăugat.
     */
    public void attachObserver(Obs observer) {
        observers.add(observer);
    }

    /**
     * Metodă pentru eliminarea unui observator.
     * @param observer Observatorul de eliminat.
     */
    public void detachObserver(Obs observer) {
        observers.remove(observer);
    }

    /**
     * Metodă pentru notificarea tuturor observatorilor despre actualizarea stocurilor.
     * @param stocuri Obiectul de stoc actualizat.
     */
    public void notifyObservers(Stocuri stocuri) {
        for (Obs observer : observers) {
            observer.onStocUpdate(stocuri);
        }
    }

    /**
     * Implementare a metodei onStocUpdate din interfața Obs.
     * Această metodă este apelată atunci când se actualizează stocurile și afișează un mesaj de notificare.
     * @param stocuri Obiectul de stoc actualizat.
     */
    @Override
    public void onStocUpdate(Stocuri stocuri) {
        System.out.println("Stocul s-a modificat! " + stocuri);
    }
}