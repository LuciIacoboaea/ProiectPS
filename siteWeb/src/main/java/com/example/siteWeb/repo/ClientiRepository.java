package com.example.siteWeb.repo;
import com.example.siteWeb.tabele.Clienti;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
/**
 * Interfață de repository pentru efectuarea operațiilor CRUD pe entitățile Clienti.
 */
@Repository
public interface ClientiRepository extends JpaRepository<Clienti, Integer> {
}
