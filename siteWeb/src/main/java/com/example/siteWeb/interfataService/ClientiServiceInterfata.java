package com.example.siteWeb.interfataService;
import com.example.siteWeb.tabele.Clienti;

import java.util.List;
/**
 * Interfața pentru serviciul de gestionare a clienților.
 * Definește operațiile disponibile pentru gestionarea clienților.
 */
public interface ClientiServiceInterfata {
    /**
     * Returnează o listă cu toți clienții.
     *
     * @return Lista cu toți clienții.
     */
    List<Clienti> getAllClients();
    /**
     * Returnează un client după id-ul său.
     *
     * @param id Id-ul clientului căutat.
     * @return Clientul cu id-ul specificat.
     */
    Clienti getClientById(int id);
    /**
     * Creează un nou client.
     *
     * @param client Obiectul Clienti care trebuie creat.
     * @return Clientul creat.
     */
    Clienti createClient(Clienti client);
    /**
     * Actualizează informațiile unui client existent.
     *
     * @param id            Id-ul clientului care trebuie actualizat.
     * @param clientDetails Obiectul Clienti cu noile detalii.
     * @return Clientul actualizat.
     */
    Clienti updateClient(int id, Clienti clientDetails);
    /**
     * Șterge un client după id-ul său.
     *
     * @param id Id-ul clientului care trebuie șters.
     */
    void deleteClient(int id);
    /**
     * Actualizează parțial informațiile unui client existent.
     *
     * @param id            Id-ul clientului care trebuie actualizat.
     * @param clientDetails Obiectul Clienti cu noile detalii.
     * @return Clientul actualizat parțial.
     */
    Clienti partiallyUpdateClient(int id, Clienti clientDetails);
    Clienti authenticate(String email, String parola);
}
