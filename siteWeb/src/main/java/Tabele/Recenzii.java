package Tabele;
import java.time.LocalDate;

public class Recenzii {

    private int recenzie_id;
    private int client_id;
    private int restaurant_id;
    private int rating;
    private String comentariu;
    private LocalDate data;

    public Recenzii() {
    }

    public Recenzii(int recenzie_id, int client_id, int restaurant_id, int rating, String comentariu, LocalDate data) {
        this.recenzie_id = recenzie_id;
        this.client_id = client_id;
        this.restaurant_id = restaurant_id;
        this.rating = rating;
        this.comentariu = comentariu;
        this.data = data;
    }

    public int getRecenzie_id() {
        return recenzie_id;
    }

    public void setRecenzie_id(int recenzie_id) {
        this.recenzie_id = recenzie_id;
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

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getComentariu() {
        return comentariu;
    }

    public void setComentariu(String comentariu) {
        this.comentariu = comentariu;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

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
