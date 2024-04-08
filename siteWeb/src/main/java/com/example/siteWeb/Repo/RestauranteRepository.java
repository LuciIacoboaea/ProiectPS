package com.example.siteWeb.Repo;

import com.example.siteWeb.Tabele.Restaurante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Interfața RestauranteRepository este responsabilă pentru interacțiunea cu baza de date pentru entitatea Restaurante.
 * Această interfață extinde JpaRepository pentru a oferi operații de bază de date, cum ar fi salvarea, actualizarea și ștergerea.
 */
@Repository
public interface RestauranteRepository extends JpaRepository<Restaurante, Integer> {
}