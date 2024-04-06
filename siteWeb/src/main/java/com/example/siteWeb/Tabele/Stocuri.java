package com.example.siteWeb.Tabele;
import jakarta.persistence.*;
/**
 * Clasa care reprezintă entitatea Stocuri.
 * Această clasă este utilizată pentru gestionarea informațiilor despre stocurile de produse ale restaurantelor.
 */
@Entity
public class Stocuri {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int stoc_id;
    private int restaurant_id;
    private int produs_id;
    private int cantitate;

    /**
     * Constructorul implicit al clasei Stocuri.
     */
    public Stocuri() {
    }

    /**
     * Constructor cu parametri pentru clasa Stocuri.
     *
     * @param stoc_id      Identificatorul stocului.
     * @param restaurant_id Identificatorul restaurantului asociat stocului.
     * @param produs_id    Identificatorul produsului asociat stocului.
     * @param cantitate    Cantitatea de produs disponibilă în stoc.
     */
    public Stocuri(int stoc_id, int restaurant_id, int produs_id, int cantitate) {
        this.stoc_id = stoc_id;
        this.restaurant_id = restaurant_id;
        this.produs_id = produs_id;
        this.cantitate = cantitate;
    }

    /**
     * Returnează identificatorul stocului.
     *
     * @return Identificatorul stocului.
     */
    public int getStoc_id() {
        return stoc_id;
    }

    /**
     * Setează identificatorul stocului.
     *
     * @param stoc_id Identificatorul stocului.
     */
    public void setStoc_id(int stoc_id) {
        this.stoc_id = stoc_id;
    }

    /**
     * Returnează identificatorul restaurantului asociat stocului.
     *
     * @return Identificatorul restaurantului asociat stocului.
     */
    public int getRestaurant_id() {
        return restaurant_id;
    }

    /**
     * Setează identificatorul restaurantului asociat stocului.
     *
     * @param restaurant_id Identificatorul restaurantului asociat stocului.
     */
    public void setRestaurant_id(int restaurant_id) {
        this.restaurant_id = restaurant_id;
    }

    /**
     * Returnează identificatorul produsului asociat stocului.
     *
     * @return Identificatorul produsului asociat stocului.
     */
    public int getProdus_id() {
        return produs_id;
    }

    /**
     * Setează identificatorul produsului asociat stocului.
     *
     * @param produs_id Identificatorul produsului asociat stocului.
     */
    public void setProdus_id(int produs_id) {
        this.produs_id = produs_id;
    }

    /**
     * Returnează cantitatea de produs disponibilă în stoc.
     *
     * @return Cantitatea de produs disponibilă în stoc.
     */
    public int getCantitate() {
        return cantitate;
    }

    /**
     * Setează cantitatea de produs disponibilă în stoc.
     *
     * @param cantitate Cantitatea de produs disponibilă în stoc.
     */
    public void setCantitate(int cantitate) {
        this.cantitate = cantitate;
    }

    @Override
    public String toString() {
        return "Stocuri{" +
                "stoc_id=" + stoc_id +
                ", restaurant_id=" + restaurant_id +
                ", produs_id=" + produs_id +
                ", cantitate=" + cantitate +
                '}';
    }
}