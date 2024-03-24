package com.example.siteWeb.Tabele;

public class Promotii {

    private int promotie_id;
    private int restaurant_id;
    private String cod_promotional;
    private String descriere;
    private int reducere;

    public Promotii() {
    }

    public Promotii(int promotie_id, int restaurant_id, String cod_promotional, String descriere, int reducere) {
        this.promotie_id = promotie_id;
        this.restaurant_id = restaurant_id;
        this.cod_promotional = cod_promotional;
        this.descriere = descriere;
        this.reducere = reducere;
    }

    public int getPromotie_id() {
        return promotie_id;
    }

    public void setPromotie_id(int promotie_id) {
        this.promotie_id = promotie_id;
    }

    public int getRestaurant_id() {
        return restaurant_id;
    }

    public void setRestaurant_id(int restaurant_id) {
        this.restaurant_id = restaurant_id;
    }

    public String getCod_promotional() {
        return cod_promotional;
    }

    public void setCod_promotional(String cod_promotional) {
        this.cod_promotional = cod_promotional;
    }

    public String getDescriere() {
        return descriere;
    }

    public void setDescriere(String descriere) {
        this.descriere = descriere;
    }

    public double getReducere() {
        return reducere;
    }

    public void setReducere(int reducere) {
        this.reducere = reducere;
    }

    @Override
    public String toString() {
        return "Promotii{" +
                "promotie_id=" + promotie_id +
                ", restaurant_id=" + restaurant_id +
                ", cod_promotional='" + cod_promotional + '\'' +
                ", descriere='" + descriere + '\'' +
                ", reducere=" + reducere +
                '}';
    }
}
