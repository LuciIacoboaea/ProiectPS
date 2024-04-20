package com.example.siteWeb.service;

import com.example.siteWeb.tabele.Clienti;
import com.example.siteWeb.contracte.ClientiContract;
import com.example.siteWeb.interfataService.ClientiServiceInterfata;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * Serviciu pentru gestionarea operațiilor legate de clienți.
 * Acest serviciu oferă funcționalități pentru CRUD (create, read, update, delete) pentru entitatea Clienti.
 */
@Service
public class ClientiService implements ClientiServiceInterfata {

    private final ClientiContract clientiContract;

    /**
     * Constructor pentru injecția de dependențe a contractului Clienti.
     *
     * @param clientiContract Contractul pentru operațiile legate de clienți.
     */
    @Autowired
    public ClientiService(ClientiContract clientiContract) {
        this.clientiContract = clientiContract;
    }
    /**
     * Returnează o listă cu toți clienții din baza de date.
     *
     * @return Lista cu toți clienții.
     */
    @Override
    public List<Clienti> getAllClients() {
        return clientiContract.findAll();
    }
    /**
     * Returnează un client după identificatorul său.
     *
     * @param id Identificatorul clientului.
     * @return Clientul cu identificatorul specificat sau null dacă nu este găsit.
     */
    @Override
    public Clienti getClientById(int id) {
        return clientiContract.findById(id).orElse(null);
    }
    /**
     * Creează un nou client în baza de date.
     *
     * @param client Obiectul Clienti ce urmează să fie creat.
     * @return Clientul creat.
     */
    @Override
    public Clienti createClient(Clienti client) {
        return clientiContract.save(client);
    }

    /**
     * Actualizează informațiile unui client existent în baza de date.
     *
     * @param id            Identificatorul clientului ce urmează să fie actualizat.
     * @param clientDetails Obiectul Clienti ce conține noile informații ale clientului.
     * @return Clientul actualizat sau null dacă clientul cu identificatorul specificat nu există.
     */
    public Clienti updateClient(int id, Clienti clientDetails) {
        Clienti client = clientiContract.findById(id).orElse(null);
        if (client != null) {
            client.setNume(clientDetails.getNume());
            client.setAdresa(clientDetails.getAdresa());
            client.setTelefon(clientDetails.getTelefon());
            client.setEmail(clientDetails.getEmail());
            client.setParola(clientDetails.getParola());
            return clientiContract.save(client);
        }
        return null;
    }

    /**
     * Șterge un client din baza de date după identificatorul său.
     *
     * @param id Identificatorul clientului ce urmează să fie șters.
     */
    public void deleteClient(int id) {
        clientiContract.deleteById(id);
    }

    /**
     * Actualizează parțial informațiile unui client existent în baza de date.
     *
     * @param id            Identificatorul clientului ce urmează să fie actualizat.
     * @param clientDetails Obiectul Clienti ce conține parțial noile informații ale clientului.
     * @return Clientul actualizat sau null dacă clientul cu identificatorul specificat nu există.
     */
    public Clienti partiallyUpdateClient(int id, Clienti clientDetails) {
        Clienti client = clientiContract.findById(id).orElse(null);
        if (client != null) {
            if (clientDetails.getNume() != null) {
                client.setNume(clientDetails.getNume());
            }
            return clientiContract.save(client);
        }
        return null;
    }
}