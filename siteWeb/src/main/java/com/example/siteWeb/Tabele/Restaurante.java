package com.example.siteWeb.Tabele;
public class Restaurante {

    private int restaurant_id;
    private String nume;
    private String adresa;
    private String oras;
    private String telefon;
    private String email;
    private int rating;

    public Restaurante() {
    }

    public Restaurante(int restaurant_id, String nume, String adresa, String oras, String telefon, String email, int rating) {
        this.restaurant_id = restaurant_id;
        this.nume = nume;
        this.adresa = adresa;
        this.oras = oras;
        this.telefon = telefon;
        this.email = email;
        this.rating = rating;
    }

    public int getRestaurant_id() {
        return restaurant_id;
    }

    public void setRestaurant_id(int restaurant_id) {
        this.restaurant_id = restaurant_id;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public String getOras() {
        return oras;
    }

    public void setOras(String oras) {
        this.oras = oras;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "Restaurante{" +
                "restaurant_id=" + restaurant_id +
                ", nume='" + nume + '\'' +
                ", adresa='" + adresa + '\'' +
                ", oras='" + oras + '\'' +
                ", telefon='" + telefon + '\'' +
                ", email='" + email + '\'' +
                ", rating=" + rating +
                '}';
    }
}
