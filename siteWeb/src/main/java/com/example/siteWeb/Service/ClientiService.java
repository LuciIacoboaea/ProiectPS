package com.example.siteWeb.Service;

import com.example.siteWeb.Repo.ClientiRepository;
import com.example.siteWeb.Tabele.Clienti;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * Serviciu pentru gestionarea operațiilor legate de clienți.
 * Acest serviciu oferă funcționalități pentru CRUD (create, read, update, delete) pentru entitatea Clienti.
 */
@Service
public class ClientiService {

    @Autowired
    private ClientiRepository clientiRepository;

    /**
     * Constructor pentru injecția de dependențe a repository-ului Clienti.
     *
     * @param clientiRepository Repository-ul pentru entitatea Clienti.
     */
    public ClientiService(ClientiRepository clientiRepository) {
        this.clientiRepository = clientiRepository;
    }

    /**
     * Returnează o listă cu toți clienții din baza de date.
     *
     * @return Lista cu toți clienții.
     */
    public List<Clienti> getAllClients() {
        return clientiRepository.findAll();
    }

    /**
     * Returnează un client după identificatorul său.
     *
     * @param id Identificatorul clientului.
     * @return Clientul cu identificatorul specificat sau null dacă nu este găsit.
     */
    public Clienti getClientById(long id) {
        return clientiRepository.findById(id).orElse(null);
    }

    /**
     * Creează un nou client în baza de date.
     *
     * @param client Obiectul Clienti ce urmează să fie creat.
     * @return Clientul creat.
     */
    public Clienti createClient(Clienti client) {
        return clientiRepository.save(client);
    }

    /**
     * Actualizează informațiile unui client existent în baza de date.
     *
     * @param id            Identificatorul clientului ce urmează să fie actualizat.
     * @param clientDetails Obiectul Clienti ce conține noile informații ale clientului.
     * @return Clientul actualizat sau null dacă clientul cu identificatorul specificat nu există.
     */
    public Clienti updateClient(Long id, Clienti clientDetails) {
        Clienti client = clientiRepository.findById(id).orElse(null);
        if (client != null) {
            client.setNume(clientDetails.getNume());
            client.setAdresa(clientDetails.getAdresa());
            client.setTelefon(clientDetails.getTelefon());
            client.setEmail(clientDetails.getEmail());
            client.setParola(clientDetails.getParola());
            return clientiRepository.save(client);
        }
        return null;
    }

    /**
     * Șterge un client din baza de date după identificatorul său.
     *
     * @param id Identificatorul clientului ce urmează să fie șters.
     */
    public void deleteClient(Long id) {
        clientiRepository.deleteById(id);
    }

    /**
     * Actualizează parțial informațiile unui client existent în baza de date.
     *
     * @param id            Identificatorul clientului ce urmează să fie actualizat.
     * @param clientDetails Obiectul Clienti ce conține parțial noile informații ale clientului.
     * @return Clientul actualizat sau null dacă clientul cu identificatorul specificat nu există.
     */
    public Clienti partiallyUpdateClient(Long id, Clienti clientDetails) {
        Clienti client = clientiRepository.findById(id).orElse(null);
        if (client != null) {
            if (clientDetails.getNume() != null) {
                client.setNume(clientDetails.getNume());
            }
            return clientiRepository.save(client);
        }
        return null;
    }
}