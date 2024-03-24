package com.example.siteWeb.Tabele;
import java.time.LocalDateTime;

public class Comenzi {

    private int comanda_id;
    private int client_id;
    private int restaurant_id;
    private int meniu_id;
    private String adresa_livrare;
    private LocalDateTime data_ora;
    private int suma_totala;


    public Comenzi() {
    }

    public Comenzi(int comanda_id, int client_id, int restaurant_id, int meniu_id, String adresa_livrare, LocalDateTime data_ora, int suma_totala) {
        this.comanda_id = comanda_id;
        this.client_id = client_id;
        this.restaurant_id = restaurant_id;
        this.meniu_id = meniu_id;
        this.adresa_livrare = adresa_livrare;
        this.data_ora = data_ora;
        this.suma_totala = suma_totala;
    }


    public int getComanda_id() {
        return comanda_id;
    }

    public void setComanda_id(int comanda_id) {
        this.comanda_id = comanda_id;
    }

    public int getClient_id() {
        return client_id;
    }

    public void setClient_id(int client_id) {
        this.client_id = client_id;
    }

    public int getRestaurant_id() {
        return restaurant_id;
    }

    public void setRestaurant_id(int restaurant_id) {
        this.restaurant_id = restaurant_id;
    }

    public int getMeniu_id() {
        return meniu_id;
    }

    public void setMeniu_id(int meniu_id) {
        this.meniu_id = meniu_id;
    }

    public String getAdresa_livrare() {
        return adresa_livrare;
    }

    public void setAdresa_livrare(String adresa_livrare) {
        this.adresa_livrare = adresa_livrare;
    }

    public LocalDateTime getData_ora() {
        return data_ora;
    }

    public void setData_ora(LocalDateTime data_ora) {
        this.data_ora = data_ora;
    }

    public int getSuma_totala() {
        return suma_totala;
    }

    public void setSuma_totala(int suma_totala) {
        this.suma_totala = suma_totala;
    }

    @Override
    public String toString() {
        return "Comenzi{" +
                "comanda_id=" + comanda_id +
                ", client_id=" + client_id +
                ", restaurant_id=" + restaurant_id +
                ", meniu_id=" + meniu_id +
                ", adresa_livrare='" + adresa_livrare + '\'' +
                ", data_ora=" + data_ora +
                ", suma_totala=" + suma_totala +
                '}';
    }
}
