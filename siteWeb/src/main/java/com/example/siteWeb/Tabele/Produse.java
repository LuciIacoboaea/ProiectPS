package com.example.siteWeb.Tabele;
import jakarta.persistence.*;
/**
 * Aceasta este clasa care reprezintă entitatea Produse.
 * Această clasă este utilizată pentru a gestiona informațiile despre produsele disponibile în meniuri.
 */
@Entity
public class Produse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int produs_id;
    private int meniu_id;
    private String nume;
    private String descriere;
    private int pret;

    /**
     * Constructorul implicit al clasei Produse.
     */
    public Produse() {
    }

    /**
     * Constructorul cu parametri al clasei Produse.
     *
     * @param produs_id  ID-ul produsului.
     * @param meniu_id   ID-ul meniului la care este asociat produsul.
     * @param nume       Numele produsului.
     * @param descriere  Descrierea produsului.
     * @param pret       Prețul produsului.
     */
    public Produse(int produs_id, int meniu_id, String nume, String descriere, int pret) {
        this.produs_id = produs_id;
        this.meniu_id = meniu_id;
        this.nume = nume;
        this.descriere = descriere;
        this.pret = pret;
    }

    /**
     * Metodă pentru obținerea ID-ului produsului.
     *
     * @return ID-ul produsului.
     */
    public int getProdus_id() {
        return produs_id;
    }

    /**
     * Metodă pentru setarea ID-ului produsului.
     *
     * @param produs_id ID-ul produsului.
     */
    public void setProdus_id(int produs_id) {
        this.produs_id = produs_id;
    }

    /**
     * Metodă pentru obținerea ID-ului meniului asociat produsului.
     *
     * @return ID-ul meniului.
     */
    public int getMeniu_id() {
        return meniu_id;
    }

    /**
     * Metodă pentru setarea ID-ului meniului asociat produsului.
     *
     * @param meniu_id ID-ul meniului.
     */
    public void setMeniu_id(int meniu_id) {
        this.meniu_id = meniu_id;
    }

    /**
     * Metodă pentru obținerea numelui produsului.
     *
     * @return Numele produsului.
     */
    public String getNume() {
        return nume;
    }

    /**
     * Metodă pentru setarea numelui produsului.
     *
     * @param nume Numele produsului.
     */
    public void setNume(String nume) {
        this.nume = nume;
    }

    /**
     * Metodă pentru obținerea descrierii produsului.
     *
     * @return Descrierea produsului.
     */
    public String getDescriere() {
        return descriere;
    }

    /**
     * Metodă pentru setarea descrierii produsului.
     *
     * @param descriere Descrierea produsului.
     */
    public void setDescriere(String descriere) {
        this.descriere = descriere;
    }

    /**
     * Metodă pentru obținerea prețului produsului.
     *
     * @return Prețul produsului.
     */
    public int getPret() {
        return pret;
    }

    /**
     * Metodă pentru setarea prețului produsului.
     *
     * @param pret Prețul produsului.
     */
    public void setPret(int pret) {
        this.pret = pret;
    }

    /**
     * Metodă pentru obținerea reprezentării sub formă de șir de caractere a obiectului Produse.
     *
     * @return Șirul de caractere care reprezintă obiectul Produse.
     */
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