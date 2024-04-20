package com.example.siteWeb.contracte;
import com.example.siteWeb.tabele.Clienti;

import java.util.List;
import java.util.Optional;

public interface ClientiContract {
    List<Clienti> findAll();
    Optional<Clienti> findById(int id);
    Clienti save(Clienti client);
    void deleteById(int clientId);
}
