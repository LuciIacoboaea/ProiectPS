package com.example.siteWeb.tabele;

import jakarta.persistence.*;
import java.time.LocalDate;

/**
 * Clasa care reprezintă entitatea Recenzii.
 * Această clasă este utilizată pentru gestionarea recenziilor clienților asupra restaurantelor.
 */
@Entity
public class Recenzii {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int recenzie_id;
    private int client_id;
    private int restaurant_id;
    private int rating;
    private String comentariu;
    private LocalDate data;

    /**
     * Constructorul implicit al clasei Recenzii.
     */
    public Recenzii() {
    }

    /**
     * Constructor cu parametri pentru clasa Recenzii.
     *
     * @param client_id     ID-ul clientului care a realizat recenzia.
     * @param restaurant_id ID-ul restaurantului care este recenzat.
     * @param rating        Rating-ul acordat de client.
     * @param comentariu    Comentariul asociat recenziei.
     * @param data          Data la care a fost realizată recenzia.
     */
    public Recenzii(int client_id, int restaurant_id, int rating, String comentariu, LocalDate data) {
        this.client_id = client_id;
        this.restaurant_id = restaurant_id;
        this.rating = rating;
        this.comentariu = comentariu;
        this.data = data;
    }

    /**
     * Metodă pentru obținerea ID-ului recenziei.
     *
     * @return ID-ul recenziei.
     */
    public int getRecenzie_id() {
        return recenzie_id;
    }

    /**
     * Metodă pentru setarea ID-ului recenziei.
     *
     * @param recenzie_id ID-ul recenziei.
     */
    public void setRecenzie_id(int recenzie_id) {
        this.recenzie_id = recenzie_id;
    }

    /**
     * Metodă pentru obținerea ID-ului clientului care a realizat recenzia.
     *
     * @return ID-ul clientului.
     */
    public int getClient_id() {
        return client_id;
    }

    /**
     * Metodă pentru setarea ID-ului clientului care a realizat recenzia.
     *
     * @param client_id ID-ul clientului.
     */
    public void setClient_id(int client_id) {
        this.client_id = client_id;
    }

    /**
     * Metodă pentru obținerea ID-ului restaurantului care este recenzat.
     *
     * @return ID-ul restaurantului.
     */
    public int getRestaurant_id() {
        return restaurant_id;
    }

    /**
     * Metodă pentru setarea ID-ului restaurantului care este recenzat.
     *
     * @param restaurant_id ID-ul restaurantului.
     */
    public void setRestaurant_id(int restaurant_id) {
        this.restaurant_id = restaurant_id;
    }

    /**
     * Metodă pentru obținerea rating-ului acordat de client.
     *
     * @return Rating-ul acordat.
     */
    public int getRating() {
        return rating;
    }

    /**
     * Metodă pentru setarea rating-ului acordat de client.
     *
     * @param rating Rating-ul acordat.
     */
    public void setRating(int rating) {
        this.rating = rating;
    }

    /**
     * Metodă pentru obținerea comentariului asociat recenziei.
     *
     * @return Comentariul asociat recenziei.
     */
    public String getComentariu() {
        return comentariu;
    }

    /**
     * Metodă pentru setarea comentariului asociat recenziei.
     *
     * @param comentariu Comentariul asociat recenziei.
     */
    public void setComentariu(String comentariu) {
        this.comentariu = comentariu;
    }

    /**
     * Metodă pentru obținerea datei la care a fost realizată recenzia.
     *
     * @return Data recenziei.
     */
    public LocalDate getData() {
        return data;
    }

    /**
     * Metodă pentru setarea datei la care a fost realizată recenzia.
     *
     * @param data Data recenziei.
     */
    public void setData(LocalDate data) {
        this.data = data;
    }

    /**
     * Metodă pentru obținerea reprezentării sub formă de șir de caractere a obiectului Recenzii.
     *
     * @return Șirul de caractere care reprezintă obiectul Recenzii.
     */
    @Override
    public String toString() {
        return "Recenzii{" +
                "recenzie_id=" + recenzie_id +
                ", client_id=" + client_id +
                ", restaurant_id=" + restaurant_id +
                ", rating=" + rating +
                ", comentariu='" + comentariu + '\'' +
                ", data=" + data +
                '}';
    }
}