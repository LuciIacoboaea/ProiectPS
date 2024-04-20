package com.example.siteWeb.tabele;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Clasa care reprezintă entitatea Restaurante.
 * Această clasă este utilizată pentru gestionarea informațiilor despre restaurante.
 */
@Entity
public class Restaurante {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int restaurant_id;
    private String nume;
    private String adresa;
    private String oras;
    private String telefon;
    private String email;
    private int rating;

    @JsonIgnore
    @OneToMany(mappedBy = "restaurant", orphanRemoval = true)
    private List<Meniuri> meniuri = new ArrayList<>();

    @OneToMany(mappedBy = "restaurant", cascade = CascadeType.ALL)
    private List<Stocuri> stocuri;

    @OneToMany(mappedBy = "restaurant", cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
    private List<Comenzi> comenzi = new ArrayList<>();

    /**
     * Constructorul implicit al clasei Restaurante.
     */
    public Restaurante() {
    }

    /**
     * Constructor cu parametri pentru clasa Restaurante.
     *
     * @param restaurant_id Identificatorul restaurantului.
     * @param nume          Numele restaurantului.
     * @param adresa        Adresa restaurantului.
     * @param oras          Orașul în care se află restaurantul.
     * @param telefon       Numărul de telefon al restaurantului.
     * @param email         Adresa de email a restaurantului.
     * @param rating        Ratingul restaurantului.
     */
    public Restaurante(int restaurant_id, String nume, String adresa, String oras, String telefon, String email, int rating) {
        this.restaurant_id = restaurant_id;
        this.nume = nume;
        this.adresa = adresa;
        this.oras = oras;
        this.telefon = telefon;
        this.email = email;
        this.rating = rating;
    }

    /**
     * Returnează identificatorul restaurantului.
     *
     * @return Identificatorul restaurantului.
     */
    public int getRestaurant_id() {
        return restaurant_id;
    }

    /**
     * Setează identificatorul restaurantului.
     *
     * @param restaurant_id Identificatorul restaurantului.
     */
    public void setRestaurant_id(int restaurant_id) {
        this.restaurant_id = restaurant_id;
    }

    /**
     * Returnează numele restaurantului.
     *
     * @return Numele restaurantului.
     */
    public String getNume() {
        return nume;
    }

    /**
     * Setează numele restaurantului.
     *
     * @param nume Numele restaurantului.
     */
    public void setNume(String nume) {
        this.nume = nume;
    }

    /**
     * Returnează adresa restaurantului.
     *
     * @return Adresa restaurantului.
     */
    public String getAdresa() {
        return adresa;
    }

    /**
     * Setează adresa restaurantului.
     *
     * @param adresa Adresa restaurantului.
     */
    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    /**
     * Returnează orașul în care se află restaurantul.
     *
     * @return Orașul restaurantului.
     */
    public String getOras() {
        return oras;
    }

    /**
     * Setează orașul în care se află restaurantul.
     *
     * @param oras Orașul restaurantului.
     */
    public void setOras(String oras) {
        this.oras = oras;
    }

    /**
     * Returnează numărul de telefon al restaurantului.
     *
     * @return Numărul de telefon al restaurantului.
     */
    public String getTelefon() {
        return telefon;
    }

    /**
     * Setează numărul de telefon al restaurantului.
     *
     * @param telefon Numărul de telefon al restaurantului.
     */
    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    /**
     * Returnează adresa de email a restaurantului.
     *
     * @return Adresa de email a restaurantului.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Setează adresa de email a restaurantului.
     *
     * @param email Adresa de email a restaurantului.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Returnează ratingul restaurantului.
     *
     * @return Ratingul restaurantului.
     */
    public int getRating() {
        return rating;
    }

    /**
     * Setează ratingul restaurantului.
     *
     * @param rating Ratingul restaurantului.
     */
    public void setRating(int rating) {
        this.rating = rating;
    }

    /**
     * Returnează lista de meniuri asociate restaurantului.
     *
     * @return Lista de meniuri asociate restaurantului.
     */
    public List<Meniuri> getMeniuri() {
        return meniuri;
    }

    /**
     * Setează lista de meniuri asociate restaurantului.
     *
     * @param meniuri Lista de meniuri asociate restaurantului.
     */
    public void setMeniuri(List<Meniuri> meniuri) {
        this.meniuri = meniuri;
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