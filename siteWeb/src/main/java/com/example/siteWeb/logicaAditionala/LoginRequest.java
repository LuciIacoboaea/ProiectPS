package com.example.siteWeb.logicaAditionala;

public class LoginRequest {

    private String email;
    private String parola;

    // Constructori, getter-e și setter-e

    public LoginRequest() {
    }

    public LoginRequest(String email, String parola) {
        this.email = email;
        this.parola = parola;
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
}