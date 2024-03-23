package Tabele;

public class Clienti {
    private int client_id;

    private String nume;


    private String adresa;

    private String telefon;

    private String email;

    private String parola;



    public Clienti() {
    }

    public Clienti(String nume, String adresa, String telefon, String email, String parola) {
        this.nume = nume;
        this.adresa = adresa;
        this.telefon = telefon;
        this.email = email;
        this.parola = parola;
    }

    // Metode get și set

    public int getClientId() {
        return client_id;
    }

    public void setClientId(int clientId) {
        this.client_id = client_id;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getParola() {
        return parola;
    }

    public void setParola(String parola) {
        this.parola = parola;
    }

    // Metoda toString

    @Override
    public String toString() {
        return "Client{" +
                "clientId=" + client_id +
                ", nume='" + nume + '\'' +
                ", adresa='" + adresa + '\'' +
                ", telefon='" + telefon + '\'' +
                ", email='" + email + '\'' +
                ", parola='" + parola + '\'' +
                '}';
    }
}
