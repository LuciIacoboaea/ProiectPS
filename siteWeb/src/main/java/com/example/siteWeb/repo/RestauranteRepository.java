package com.example.siteWeb.repo;

import com.example.siteWeb.tabele.Restaurante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Interfața RestauranteRepository este responsabilă pentru interacțiunea cu baza de date pentru entitatea Restaurante.
 * Această interfață extinde JpaRepository pentru a oferi operații de bază de date, cum ar fi salvarea, actualizarea și ștergerea.
 */
@Repository
public interface RestauranteRepository extends JpaRepository<Restaurante, Integer> {
    /**
     * Caută restaurante după numele lor care conțin un anumit șir, ignorând diferențele de majusculă/minusculă.
     *
     * @param query Șirul de căutare pentru nume.
     * @return Lista de restaurante care conțin șirul specificat în numele lor.
     */
    List<Restaurante> findByNumeContainingIgnoreCase(String query);
}