package com.example.siteWeb.Tabele;

import jakarta.persistence.*;

/**
 * Clasa Clienti reprezintă o entitate JPA care este mapată la tabela "clienti" din baza de date.
 */
@Entity
public class Clienti {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long client_id;

    private String nume;
    private String adresa;
    private String telefon;
    private String email;
    private String parola;

    /**
     * Constructorul implicit pentru clasa Clienti.
     */
    public Clienti() {
    }

    /**
     * Constructorul cu parametri pentru clasa Clienti.
     *
     * @param nume    Numele clientului.
     * @param adresa  Adresa clientului.
     * @param telefon Numărul de telefon al clientului.
     * @param email   Adresa de email a clientului.
     * @param parola  Parola clientului.
     */
    public Clienti(String nume, String adresa, String telefon, String email, String parola) {
        this.nume = nume;
        this.adresa = adresa;
        this.telefon = telefon;
        this.email = email;
        this.parola = parola;
    }

    /**
     * Returnează id-ul clientului.
     *
     * @return Id-ul clientului.
     */
    public long getClient_id() {
        return client_id;
    }

    /**
     * Setează id-ul clientului.
     *
     * @param client_id Id-ul clientului.
     */
    public void setClient_id(int client_id) {
        this.client_id = client_id;
    }

    /**
     * Returnează numele clientului.
     *
     * @return Numele clientului.
     */
    public String getNume() {
        return nume;
    }

    /**
     * Setează numele clientului.
     *
     * @param nume Numele clientului.
     */
    public void setNume(String nume) {
        this.nume = nume;
    }

    /**
     * Returnează adresa clientului.
     *
     * @return Adresa clientului.
     */
    public String getAdresa() {
        return adresa;
    }

    /**
     * Setează adresa clientului.
     *
     * @param adresa Adresa clientului.
     */
    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    /**
     * Returnează numărul de telefon al clientului.
     *
     * @return Numărul de telefon al clientului.
     */
    public String getTelefon() {
        return telefon;
    }

    /**
     * Setează numărul de telefon al clientului.
     *
     * @param telefon Numărul de telefon al clientului.
     */
    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    /**
     * Returnează adresa de email a clientului.
     *
     * @return Adresa de email a clientului.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Setează adresa de email a clientului.
     *
     * @param email Adresa de email a clientului.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Returnează parola clientului.
     *
     * @return Parola clientului.
     */
    public String getParola() {
        return parola;
    }

    /**
     * Setează parola clientului.
     *
     * @param parola Parola clientului.
     */
    public void setParola(String parola) {
        this.parola = parola;
    }

    /**
     * Returnează o reprezentare textuală a obiectului Clienti.
     *
     * @return String ce reprezintă obiectul Clienti.
     */
    @Override
    public String toString() {
        return "Client{" +
                "client_id=" + client_id +
                ", nume='" + nume + '\'' +
                ", adresa='" + adresa + '\'' +
                ", telefon='" + telefon + '\'' +
                ", email='" + email + '\'' +
                ", parola='" + parola + '\'' +
                '}';
    }
}