package com.example.siteWeb.tabele;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Aceasta este clasa care reprezintă entitatea Meniuri.
 * Această clasă este utilizată pentru a gestiona informațiile despre meniurile disponibile în restaurante.
 */
@Entity
public class Meniuri {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int meniu_id;

    @JsonIgnore
    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "restaurant_id")
    private Restaurante restaurant;

    private String nume;

    private String descriere;

    private String categorie;

    @OneToMany(mappedBy = "meniu", cascade = CascadeType.ALL)
    private List<Comenzi> comenzi = new ArrayList<>();

    @OneToMany(mappedBy = "meniu", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Produse> produse;

    /**
     * Constructorul implicit al clasei Meniuri.
     */
    public Meniuri() {
    }

    /**
     * Constructor cu parametri pentru clasa Meniuri.
     *
     * @param meniu_id  ID-ul meniului.
     * @param nume      Numele meniului.
     * @param descriere Descrierea meniului.
     * @param categorie Categorie a meniului.
     * @param restaurant Restaurantul asociat meniului.
     */
    public Meniuri(int meniu_id, String nume, String descriere, String categorie, Restaurante restaurant) {
        this.meniu_id = meniu_id;
        this.nume = nume;
        this.descriere = descriere;
        this.categorie = categorie;
        this.restaurant = restaurant;
    }


    /**
     * Metodă pentru obținerea ID-ului meniului.
     *
     * @return ID-ul meniului.
     */
    public int getMeniu_id() {
        return meniu_id;
    }

    /**
     * Metodă pentru setarea ID-ului meniului.
     *
     * @param meniu_id ID-ul meniului.
     */
    public void setMeniu_id(int meniu_id) {
        this.meniu_id = meniu_id;
    }

    /**
     * Metodă pentru obținerea restaurantului asociat meniului.
     *
     * @return Restaurantul asociat meniului.
     */
    public Restaurante getRestaurant() {
        return restaurant;
    }

    /**
     * Metodă pentru setarea restaurantului asociat meniului.
     *
     * @param restaurant Restaurantul asociat meniului.
     */
    public void setRestaurant(Restaurante restaurant) {
        this.restaurant = restaurant;
    }

    /**
     * Metodă pentru obținerea numelui meniului.
     *
     * @return Numele meniului.
     */
    public String getNume() {
        return nume;
    }

    /**
     * Metodă pentru setarea numelui meniului.
     *
     * @param nume Numele meniului.
     */
    public void setNume(String nume) {
        this.nume = nume;
    }

    /**
     * Metodă pentru obținerea descrierii meniului.
     *
     * @return Descrierea meniului.
     */
    public String getDescriere() {
        return descriere;
    }

    /**
     * Metodă pentru setarea descrierii meniului.
     *
     * @param descriere Descrierea meniului.
     */
    public void setDescriere(String descriere) {
        this.descriere = descriere;
    }

    /**
     * Metodă pentru obținerea categoriei meniului.
     *
     * @return Categorie a meniului.
     */
    public String getCategorie() {
        return categorie;
    }

    /**
     * Metodă pentru setarea categoriei meniului.
     *
     * @param categorie Categorie a meniului.
     */
    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    /**
     * Metodă pentru obținerea reprezentării sub formă de șir de caractere a obiectului Meniuri.
     *
     * @return Șirul de caractere care reprezintă obiectul Meniuri.
     */
    @Override
    public String toString() {
        return "Meniuri{" +
                "meniu_id=" + meniu_id +
                ", restaurant=" + restaurant +
                ", nume='" + nume + '\'' +
                ", descriere='" + descriere + '\'' +
                ", categorie='" + categorie + '\'' +
                '}';
    }
}
