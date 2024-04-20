package com.example.siteWeb.repo;

import com.example.siteWeb.tabele.Meniuri;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Interfața MeniuriRepository este responsabilă pentru interacțiunea cu baza de date pentru entitatea Meniuri.
 * Această interfață extinde JpaRepository pentru a oferi operații de bază de date, cum ar fi salvarea, actualizarea și ștergerea.
 */
@Repository
public interface MeniuriRepository extends JpaRepository<Meniuri, Integer> {
}
