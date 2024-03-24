package com.example.siteWeb.Service;

import com.example.siteWeb.Repo.ClientiRepository;
import com.example.siteWeb.Tabele.Clienti;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ClientiService {

    @Autowired
    private ClientiRepository clientiRepository;

    public ClientiService(ClientiRepository clientiRepository) {
        this.clientiRepository = clientiRepository;
    }

    public List<Clienti> getAllClients() {
        return clientiRepository.findAll();
    }

    public Clienti getClientById(long id) {
        return clientiRepository.findById(id).orElse(null);
    }

    public Clienti createClient(Clienti client) {

        return clientiRepository.save(client);
    }

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

    public void deleteClient(Long id) {
        clientiRepository.deleteById(id);
    }
}