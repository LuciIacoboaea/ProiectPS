package com.example.siteWeb.Tabele;

import jakarta.persistence.*;

/**
 * Aceasta este clasa care reprezintă entitatea Promotii.
 * Această clasă este utilizată pentru a gestiona informațiile despre promoțiile disponibile în restaurante.
 */
@Entity
public class Promotii {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int promotie_id;
    private int restaurant_id;
    private String cod_promotional;
    private String descriere;
    private int reducere;

    /**
     * Constructorul implicit al clasei Promotii.
     */
    public Promotii() {
    }

    /**
     * Constructorul cu parametri al clasei Promotii.
     *
     * @param restaurant_id    ID-ul restaurantului la care este asociată promoția.
     * @param cod_promotional  Codul promoțional asociat promoției.
     * @param descriere        Descrierea promoției.
     * @param reducere         Valoarea reducerii oferite de promoție.
     */
    public Promotii(int restaurant_id, String cod_promotional, String descriere, int reducere) {
        this.restaurant_id = restaurant_id;
        this.cod_promotional = cod_promotional;
        this.descriere = descriere;
        this.reducere = reducere;
    }

    /**
     * Metodă pentru obținerea ID-ului promoției.
     *
     * @return ID-ul promoției.
     */
    public int getPromotie_id() {
        return promotie_id;
    }

    /**
     * Metodă pentru setarea ID-ului promoției.
     *
     * @param promotie_id ID-ul promoției.
     */
    public void setPromotie_id(int promotie_id) {
        this.promotie_id = promotie_id;
    }

    /**
     * Metodă pentru obținerea ID-ului restaurantului asociat promoției.
     *
     * @return ID-ul restaurantului.
     */
    public int getRestaurant_id() {
        return restaurant_id;
    }

    /**
     * Metodă pentru setarea ID-ului restaurantului asociat promoției.
     *
     * @param restaurant_id ID-ul restaurantului.
     */
    public void setRestaurant_id(int restaurant_id) {
        this.restaurant_id = restaurant_id;
    }

    /**
     * Metodă pentru obținerea codului promoțional.
     *
     * @return Codul promoțional.
     */
    public String getCod_promotional() {
        return cod_promotional;
    }

    /**
     * Metodă pentru setarea codului promoțional.
     *
     * @param cod_promotional Codul promoțional.
     */
    public void setCod_promotional(String cod_promotional) {
        this.cod_promotional = cod_promotional;
    }

    /**
     * Metodă pentru obținerea descrierii promoției.
     *
     * @return Descrierea promoției.
     */
    public String getDescriere() {
        return descriere;
    }

    /**
     * Metodă pentru setarea descrierii promoției.
     *
     * @param descriere Descrierea promoției.
     */
    public void setDescriere(String descriere) {
        this.descriere = descriere;
    }

    /**
     * Metodă pentru obținerea reducerii oferite de promoție.
     *
     * @return Reducerea oferită de promoție.
     */
    public int getReducere() {
        return reducere;
    }

    /**
     * Metodă pentru setarea reducerii oferite de promoție.
     *
     * @param reducere Reducerea oferită de promoție.
     */
    public void setReducere(int reducere) {
        this.reducere = reducere;
    }

    /**
     * Metodă pentru obținerea reprezentării sub formă de șir de caractere a obiectului Promotii.
     *
     * @return Șirul de caractere care reprezintă obiectul Promotii.
     */
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
