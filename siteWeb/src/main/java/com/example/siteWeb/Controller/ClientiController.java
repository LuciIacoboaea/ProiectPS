package com.example.siteWeb.Controller;

import com.example.siteWeb.Service.ClientiService;
import com.example.siteWeb.Tabele.Clienti;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * Controller-ul pentru gestionarea operațiilor CRUD legate de clienti.
 */
@RestController
@RequestMapping("/clienti")
public class ClientiController {

    private final ClientiService clientiService;

    /**
     * Constructor pentru ClientiController.
     *
     * @param clientiService serviciul care gestionează operațiile legate de clienti
     */
    @Autowired
    public ClientiController(ClientiService clientiService) {
        this.clientiService = clientiService;
    }

    /**
     * Returnează un client bazat pe ID-ul dat.
     *
     * @param id ID-ul clientului
     * @return Răspunsul HTTP care conține clientul sau o eroare 404 dacă clientul nu a fost găsit
     */
    @GetMapping("/{id}")
    public ResponseEntity<Clienti> getClientById(@PathVariable int id) {
        Clienti client = clientiService.getClientById(id);
        return client != null ? ResponseEntity.ok(client) : ResponseEntity.notFound().build();
    }

    /**
     * Returnează toți clienții.
     *
     * @return Răspunsul HTTP care conține lista de clienți
     */
    @GetMapping
    public ResponseEntity<List<Clienti>> getAllClients() {
        List<Clienti> clients = clientiService.getAllClients();
        return ResponseEntity.ok(clients);
    }

    /**
     * Creează un client nou.
     *
     * @param client Detaliile clientului care urmează să fie creat
     * @return Răspunsul HTTP care conține clientul creat sau o eroare 400 dacă solicitarea este invalidă
     */
    @PostMapping
    public ResponseEntity<Clienti> createClient(@RequestBody Clienti client) {
        Clienti createdClient = clientiService.createClient(client);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdClient);
    }

    /**
     * Actualizează un client existent.
     *
     * @param id ID-ul clientului care urmează să fie actualizat
     * @param clientDetails Detaliile actualizate ale clientului
     * @return Răspunsul HTTP care conține clientul actualizat sau o eroare 404 dacă clientul nu a fost găsit
     */
    @PutMapping("/{id}")
    public ResponseEntity<Clienti> updateClient(@PathVariable int id, @RequestBody Clienti clientDetails) {
        Clienti updatedClient = clientiService.updateClient(id, clientDetails);
        return updatedClient != null ? ResponseEntity.ok(updatedClient) : ResponseEntity.notFound().build();
    }

    /**
     * Șterge un client bazat pe ID-ul dat.
     *
     * @param id ID-ul clientului care urmează să fie șters
     * @return Răspunsul HTTP fără conținut, indicând că ștergerea a fost realizată cu succes
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteClient(@PathVariable int id) {
        clientiService.deleteClient(id);
        return ResponseEntity.ok().build();
    }

    /**
     * Actualizează parțial un client existent.
     *
     * @param id ID-ul clientului care urmează să fie actualizat
     * @param clientDetails Detaliile actualizate ale clientului
     * @return Răspunsul HTTP care conține clientul actualizat sau o eroare 404 dacă clientul nu a fost găsit
     */
    @PatchMapping("/{id}")
    public ResponseEntity<Clienti> partiallyUpdateClient(@PathVariable int id, @RequestBody Clienti clientDetails) {
        Clienti updatedClient = clientiService.partiallyUpdateClient(id, clientDetails);
        return updatedClient != null ? ResponseEntity.ok(updatedClient) : ResponseEntity.notFound().build();
    }
    /**
     * Returnează antetul (header-ul) unui client bazat pe ID-ul dat.
     *
     * @param id ID-ul clientului
     * @return Răspunsul HTTP care conține antetul clientului sau o eroare 404 dacă clientul nu a fost găsit
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.HEAD)
    public ResponseEntity<Void> getClientHeaderById(@PathVariable int id) {
        Clienti client = clientiService.getClientById(id);
        return client != null ? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }

    /**
     * Returnează opțiunile de comunicație disponibile pentru resursa țintă.
     *
     * @return Răspunsul HTTP care conține opțiunile disponibile
     */
    @RequestMapping(method = RequestMethod.OPTIONS)
    public ResponseEntity<Void> getOptions() {
        return ResponseEntity.ok().build();
    }
}