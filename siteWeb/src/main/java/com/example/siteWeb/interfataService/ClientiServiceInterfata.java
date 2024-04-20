package com.example.siteWeb.interfataService;
import com.example.siteWeb.tabele.Clienti;

import java.util.List;
public interface ClientiServiceInterfata {
    List<Clienti> getAllClients();
    Clienti getClientById(int id);
    Clienti createClient(Clienti client);
    Clienti updateClient(int id, Clienti clientDetails);
    void deleteClient(int id);
    Clienti partiallyUpdateClient(int id, Clienti clientDetails);
}
