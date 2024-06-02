package com.example.siteWeb.repo;

import com.example.siteWeb.tabele.Clienti;
import com.example.siteWeb.tabele.Comenzi;
import com.example.siteWeb.tabele.Meniuri;
import com.example.siteWeb.tabele.Restaurante;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Interfața ComenziRepository este responsabilă pentru interacțiunea cu baza de date pentru entitatea Comenzi.
 * Această interfață extinde JpaRepository pentru a oferi operații de bază de date, cum ar fi salvarea, actualizarea și ștergerea.
 */
@Repository
public interface ComenziRepository extends JpaRepository<Comenzi, Integer> {
    /**
     * Returnează o listă de comenzi asociate unui anumit client.
     *
     * @param clientId ID-ul clientului pentru care se caută comenzile.
     * @return Lista de comenzi asociate clientului specificat.
     */
    @Query("SELECT c FROM Comenzi c WHERE c.client.client_id = :clientId")
    List<Comenzi> findByClientId(@Param("clientId") int clientId);
}