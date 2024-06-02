package com.example.siteWeb.repo;
import com.example.siteWeb.tabele.Clienti;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
/**
 * Interfață de repository pentru efectuarea operațiilor CRUD pe entitățile Clienti.
 */
@Repository
public interface ClientiRepository extends JpaRepository<Clienti, Integer> {
    /**
     * Returnează un client după adresa de email.
     *
     * @param email Adresa de email a clientului căutat.
     * @return Clientul cu adresa de email specificată sau null dacă nu a fost găsit.
     */
    Clienti findByEmailAndParola(String email,String parola);
}
