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

    @ManyToOne
    @JoinColumn(name = "restaurant_id")
    private Restaurante restaurant;

    @ManyToOne
    @JoinColumn(name = "produs_id")
    private Produse produs;

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
     * @param restaurant   Restaurantul asociat stocului.
     * @param produs       Produsul asociat stocului.
     * @param cantitate    Cantitatea de produs disponibilă în stoc.
     */
    public Stocuri(int stoc_id, Restaurante restaurant, Produse produs, int cantitate) {
        this.stoc_id = stoc_id;
        this.restaurant = restaurant;
        this.produs = produs;
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
     * Returnează restaurantul asociat stocului.
     *
     * @return Restaurantul asociat stocului.
     */
    public Restaurante getRestaurant() {
        return restaurant;
    }

    /**
     * Setează restaurantul asociat stocului.
     *
     * @param restaurant Restaurantul asociat stocului.
     */
    public void setRestaurant(Restaurante restaurant) {
        this.restaurant = restaurant;
    }

    /**
     * Returnează produsul asociat stocului.
     *
     * @return Produsul asociat stocului.
     */
    public Produse getProdus() {
        return produs;
    }

    /**
     * Setează produsul asociat stocului.
     *
     * @param produs Produsul asociat stocului.
     */
    public void setProdus(Produse produs) {
        this.produs = produs;
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

    /**
     * Returnează o reprezentare sub formă de șir de caractere a obiectului Stocuri.
     *
     * @return Șirul de caractere care reprezintă obiectul Stocuri.
     */
    @Override
    public String toString() {
        return "Stocuri{" +
                "stoc_id=" + stoc_id +
                ", restaurant_id=" + (restaurant != null ? restaurant.getRestaurant_id() : null) +
                ", produs_id=" + (produs != null ? produs.getProdus_id() : null) +
                ", cantitate=" + cantitate +
                '}';
    }
}
