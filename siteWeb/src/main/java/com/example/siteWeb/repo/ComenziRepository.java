package com.example.siteWeb.repo;

import com.example.siteWeb.tabele.Clienti;
import com.example.siteWeb.tabele.Comenzi;
import com.example.siteWeb.tabele.Meniuri;
import com.example.siteWeb.tabele.Restaurante;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
/**
 * Interfața ComenziRepository este responsabilă pentru interacțiunea cu baza de date pentru entitatea Comenzi.
 * Această interfață extinde JpaRepository pentru a oferi operații de bază de date, cum ar fi salvarea, actualizarea și ștergerea.
 */
@Repository
public interface ComenziRepository extends JpaRepository<Comenzi, Integer> {

}