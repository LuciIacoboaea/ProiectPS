package com.example.siteWeb.Tabele;
public class Stocuri {

    private int stoc_id;
    private int restaurant_id;
    private int produs_id;
    private int cantitate;

    public Stocuri() {
    }

    public Stocuri(int stoc_id, int restaurant_id, int produs_id, int cantitate) {
        this.stoc_id = stoc_id;
        this.restaurant_id = restaurant_id;
        this.produs_id = produs_id;
        this.cantitate = cantitate;
    }

    public int getStoc_id() {
        return stoc_id;
    }

    public void setStoc_id(int stoc_id) {
        this.stoc_id = stoc_id;
    }

    public int getRestaurant_id() {
        return restaurant_id;
    }

    public void setRestaurant_id(int restaurant_id) {
        this.restaurant_id = restaurant_id;
    }

    public int getProdus_id() {
        return produs_id;
    }

    public void setProdus_id(int produs_id) {
        this.produs_id = produs_id;
    }

    public int getCantitate() {
        return cantitate;
    }

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
