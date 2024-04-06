package com.example.siteWeb.Tabele;

import java.time.LocalDateTime;
import jakarta.persistence.*;

/**
 * Această clasă reprezintă entitatea Comenzi.
 * Această clasă este utilizată pentru gestionarea informațiilor despre comenzile efectuate.
 */
@Entity
public class Comenzi {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int comanda_id;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Clienti client;

    @ManyToOne
    @JoinColumn(name = "restaurant_id")
    private Restaurante restaurant;

    @ManyToOne
    @JoinColumn(name = "meniu_id")
    private Meniuri meniu;

    private String adresa_livrare;
    private LocalDateTime data_ora;
    private int suma_totala;

    /**
     * Constructorul implicit al clasei Comenzi.
     */
    public Comenzi() {
    }

    /**
     * Constructor cu parametri pentru clasa Comenzi.
     *
     * @param comanda_id      ID-ul comenzii.
     * @param client          Clientul care a plasat comanda.
     * @param restaurant      Restaurantul de la care s-a comandat.
     * @param meniu           Meniul comandat.
     * @param adresa_livrare  Adresa la care se livrează comanda.
     * @param data_ora        Data și ora la care s-a plasat comanda.
     * @param suma_totala     Suma totală a comenzii.
     */
    public Comenzi(int comanda_id, Clienti client, Restaurante restaurant, Meniuri meniu, String adresa_livrare, LocalDateTime data_ora, int suma_totala) {
        this.comanda_id = comanda_id;
        this.client = client;
        this.restaurant = restaurant;
        this.meniu = meniu;
        this.adresa_livrare = adresa_livrare;
        this.data_ora = data_ora;
        this.suma_totala = suma_totala;
    }

    // Metode pentru accesarea și modificarea câmpurilor

    /**
     * Returnează ID-ul comenzii.
     *
     * @return ID-ul comenzii.
     */
    public int getComanda_id() {
        return comanda_id;
    }

    /**
     * Setează ID-ul comenzii.
     *
     * @param comanda_id ID-ul comenzii.
     */
    public void setComanda_id(int comanda_id) {
        this.comanda_id = comanda_id;
    }

    /**
     * Returnează clientul care a plasat comanda.
     *
     * @return Clientul care a plasat comanda.
     */
    public Clienti getClient() {
        return client;
    }

    /**
     * Setează clientul care a plasat comanda.
     *
     * @param client Clientul care a plasat comanda.
     */
    public void setClient(Clienti client) {
        this.client = client;
    }

    /**
     * Returnează restaurantul de la care s-a comandat.
     *
     * @return Restaurantul de la care s-a comandat.
     */
    public Restaurante getRestaurant() {
        return restaurant;
    }

    /**
     * Setează restaurantul de la care s-a comandat.
     *
     * @param restaurant Restaurantul de la care s-a comandat.
     */
    public void setRestaurant(Restaurante restaurant) {
        this.restaurant = restaurant;
    }

    /**
     * Returnează meniul comandat.
     *
     * @return Meniul comandat.
     */
    public Meniuri getMeniu() {
        return meniu;
    }

    /**
     * Setează meniul comandat.
     *
     * @param meniu Meniul comandat.
     */
    public void setMeniu(Meniuri meniu) {
        this.meniu = meniu;
    }

    /**
     * Returnează adresa la care se livrează comanda.
     *
     * @return Adresa la care se livrează comanda.
     */
    public String getAdresa_livrare() {
        return adresa_livrare;
    }

    /**
     * Setează adresa la care se livrează comanda.
     *
     * @param adresa_livrare Adresa la care se livrează comanda.
     */
    public void setAdresa_livrare(String adresa_livrare) {
        this.adresa_livrare = adresa_livrare;
    }

    /**
     * Returnează data și ora la care s-a plasat comanda.
     *
     * @return Data și ora la care s-a plasat comanda.
     */
    public LocalDateTime getData_ora() {
        return data_ora;
    }

    /**
     * Setează data și ora la care s-a plasat comanda.
     *
     * @param data_ora Data și ora la care s-a plasat comanda.
     */
    public void setData_ora(LocalDateTime data_ora) {
        this.data_ora = data_ora;
    }

    /**
     * Returnează suma totală a comenzii.
     *
     * @return Suma totală a comenzii.
     */
    public int getSuma_totala() {
        return suma_totala;
    }

    /**
     * Setează suma totală a comenzii.
     *
     * @param suma_totala Suma totală a comenzii.
     */
    public void setSuma_totala(int suma_totala) {
        this.suma_totala = suma_totala;
    }

    /**
     * Returnează reprezentarea sub formă de șir de caractere a obiectului Comenzi.
     *
     * @return Șirul de caractere care reprezintă obiectul Comenzi.
     */
    @Override
    public String toString() {
        return "Comenzi{" +
                "comanda_id=" + comanda_id +
                ", client=" + client +
                ", restaurant=" + restaurant +
                ", meniu=" + meniu +
                ", adresa_livrare='" + adresa_livrare + '\'' +
                ", data_ora=" + data_ora +
                ", suma_totala=" + suma_totala +
                '}';
    }
}