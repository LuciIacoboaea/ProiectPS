package com.example.siteWeb.data;

import com.example.siteWeb.contracte.ClientiContract;
import com.example.siteWeb.repo.ClientiRepository;
import com.example.siteWeb.tabele.Clienti;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
/**
 * Clasa responsabilă pentru gestionarea datelor referitoare la clienți.
 * Implementează operațiile specificate în contractul ClientiContract.
 */
@Repository
public class ClientiData implements ClientiContract {
    private final ClientiRepository clientiRepository;

    @Autowired
    public ClientiData(ClientiRepository clientiRepository) {
        this.clientiRepository = clientiRepository;
    }
    /**
     * Returnează toți clienții din repository.
     *
     * @return Lista de clienți.
     */
    @Override
    public List<Clienti> findAll() {
        return clientiRepository.findAll();
    }
    /**
     * Returnează un client după id-ul său.
     *
     * @param id Id-ul clientului căutat.
     * @return Clientul cu id-ul specificat, încapsulat într-un obiect Optional, sau Optional.empty() dacă nu este găsit.
     */
    @Override
    public Optional<Clienti> findById(int id) {
        return this.clientiRepository.findById(id);
    }
    /**
     * Salvează un client în repository.
     *
     * @param client Clientul care trebuie salvat.
     * @return Clientul salvat.
     */
    @Override
    public Clienti save(Clienti client) {
        return clientiRepository.save(client);
    }
    /**
     * Șterge un client din repository după id-ul său.
     *
     * @param clientId Id-ul clientului care trebuie șters.
     */
    @Override
    public void deleteById(int clientId) {
        clientiRepository.deleteById(clientId);
    }
}
