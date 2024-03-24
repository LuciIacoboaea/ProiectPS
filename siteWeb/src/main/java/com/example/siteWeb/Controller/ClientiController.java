package com.example.siteWeb.Controller;

import com.example.siteWeb.Service.ClientiService;
import com.example.siteWeb.Tabele.Clienti;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/clienti")
public class ClientiController {

    private final ClientiService clientiService;

    @Autowired
    public ClientiController(ClientiService clientiService) {
        this.clientiService = clientiService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Clienti> getClientById(@PathVariable Long id) {
        Clienti client = clientiService.getClientById(id);
        return client != null ? ResponseEntity.ok(client) : ResponseEntity.notFound().build();
    }

    @GetMapping
    public ResponseEntity<List<Clienti>> getAllClients() {
        List<Clienti> clients = clientiService.getAllClients();
        return ResponseEntity.ok(clients);
    }

    @PostMapping
    public ResponseEntity<Clienti> createClient(@RequestBody Clienti client) {
        Clienti createdClient = clientiService.createClient(client);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdClient);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Clienti> updateClient(@PathVariable Long id, @RequestBody Clienti clientDetails) {
        Clienti updatedClient = clientiService.updateClient(id, clientDetails);
        return updatedClient != null ? ResponseEntity.ok(updatedClient) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteClient(@PathVariable Long id) {
        clientiService.deleteClient(id);
        return ResponseEntity.ok().build();
    }
}