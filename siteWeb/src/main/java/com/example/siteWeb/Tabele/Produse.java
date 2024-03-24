package com.example.siteWeb.Tabele;
public class Produse {

    private int produs_id;
    private int meniu_id;
    private String nume;
    private String descriere;
    private int pret;

    public Produse() {
    }

    public Produse(int produs_id, int meniu_id, String nume, String descriere, int pret) {
        this.produs_id = produs_id;
        this.meniu_id = meniu_id;
        this.nume = nume;
        this.descriere = descriere;
        this.pret = pret;
    }

    public int getProdus_id() {
        return produs_id;
    }

    public void setProdus_id(int produs_id) {
        this.produs_id = produs_id;
    }

    public int getMeniu_id() {
        return meniu_id;
    }

    public void setMeniu_id(int meniu_id) {
        this.meniu_id = meniu_id;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getDescriere() {
        return descriere;
    }

    public void setDescriere(String descriere) {
        this.descriere = descriere;
    }

    public double getPret() {
        return pret;
    }

    public void setPret(int pret) {
        this.pret = pret;
    }

    @Override
    public String toString() {
        return "Produse{" +
                "produs_id=" + produs_id +
                ", meniu_id=" + meniu_id +
                ", nume='" + nume + '\'' +
                ", descriere='" + descriere + '\'' +
                ", pret=" + pret +
                '}';
    }
}
