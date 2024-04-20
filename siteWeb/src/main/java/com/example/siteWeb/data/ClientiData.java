package com.example.siteWeb.data;

import com.example.siteWeb.contracte.ClientiContract;
import com.example.siteWeb.repo.ClientiRepository;
import com.example.siteWeb.tabele.Clienti;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public class ClientiData implements ClientiContract {
    private final ClientiRepository clientiRepository;

    @Autowired
    public ClientiData(ClientiRepository clientiRepository) {
        this.clientiRepository = clientiRepository;
    }

    @Override
    public List<Clienti> findAll() {
        return clientiRepository.findAll();
    }

    @Override
    public Optional<Clienti> findById(int id) {
        return this.clientiRepository.findById(id);
    }

    @Override
    public Clienti save(Clienti client) {
        return clientiRepository.save(client);
    }

    @Override
    public void deleteById(int clientId) {
        clientiRepository.deleteById(clientId);
    }
}
