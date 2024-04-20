package com.example.siteWeb.repo;

import com.example.siteWeb.tabele.Produse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Interfața ProduseRepository este responsabilă pentru interacțiunea cu baza de date pentru entitatea Produse.
 * Această interfață extinde JpaRepository pentru a oferi operații de bază de date, cum ar fi salvarea, actualizarea și ștergerea.
 */
@Repository
public interface ProduseRepository extends JpaRepository<Produse, Integer> {
}