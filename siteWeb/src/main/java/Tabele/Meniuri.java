package Tabele;
public class Meniuri {

    private int meniu_id;
    private int restaurant_id;
    private String nume;
    private String descriere;
    private String categorie;

    public Meniuri() {
    }

    public Meniuri(int meniu_id, int restaurant_id, String nume, String descriere, String categorie) {
        this.meniu_id = meniu_id;
        this.restaurant_id = restaurant_id;
        this.nume = nume;
        this.descriere = descriere;
        this.categorie = categorie;
    }

    public int getMeniu_id() {
        return meniu_id;
    }

    public void setMeniu_id(int meniu_id) {
        this.meniu_id = meniu_id;
    }

    public int getRestaurant_id() {
        return restaurant_id;
    }

    public void setRestaurant_id(int restaurant_id) {
        this.restaurant_id = restaurant_id;
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

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }


    @Override
    public String toString() {
        return "Meniuri{" +
                "meniu_id=" + meniu_id +
                ", restaurant_id=" + restaurant_id +
                ", nume='" + nume + '\'' +
                ", descriere='" + descriere + '\'' +
                ", categorie='" + categorie + '\'' +
                '}';
    }
}
