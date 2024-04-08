package com.example.siteWeb.Tabele;

import jakarta.persistence.*;

import java.util.List;

/**
 * Această clasă reprezintă o entitate pentru gestionarea informațiilor despre produsele disponibile în meniuri.
 */
@Entity
public class Produse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int produs_id;

    /** Numele produsului. */
    private String nume;

    /** Descrierea produsului. */
    private String descriere;

    /** Prețul produsului. */
    private int pret;

    /** Meniul asociat produsului. */
    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "meniu_id", referencedColumnName = "meniu_id", nullable = false)
    private Meniuri meniu;

    /** Lista de stocuri pentru acest produs. */
    @OneToMany(mappedBy = "produs", cascade = CascadeType.ALL)
    private List<Stocuri> stocuri;

    /**
     * Constructorul implicit al clasei Produse.
     */
    public Produse() {
    }

    /**
     * Constructor cu parametri pentru clasa Produse.
     *
     * @param produs_id ID-ul produsului.
     * @param nume      Numele produsului.
     * @param descriere Descrierea produsului.
     * @param pret      Prețul produsului.
     */
    public Produse(int produs_id, String nume, String descriere, int pret) {
        this.produs_id = produs_id;
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
     * Metodă pentru obținerea meniului asociat produsului.
     *
     * @return Meniul asociat produsului.
     */
    public Meniuri getMeniu() {
        return meniu;
    }

    /**
     * Metodă pentru setarea meniului asociat produsului.
     *
     * @param meniu Meniul asociat produsului.
     */
    public void setMeniu(Meniuri meniu) {
        this.meniu = meniu;
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
                ", nume='" + nume + '\'' +
                ", descriere='" + descriere + '\'' +
                ", pret=" + pret +
                '}';
    }
}
