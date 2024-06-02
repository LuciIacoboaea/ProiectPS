package com.example.siteWeb.repo;

import com.example.siteWeb.tabele.Meniuri;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Interfața MeniuriRepository este responsabilă pentru interacțiunea cu baza de date pentru entitatea Meniuri.
 * Această interfață extinde JpaRepository pentru a oferi operații de bază de date, cum ar fi salvarea, actualizarea și ștergerea.
 */
@Repository
public interface MeniuriRepository extends JpaRepository<Meniuri, Integer> {
    /**
     * Găsește toate meniurile asociate unui anumit restaurant_id.
     *
     * @param restaurantId ID-ul restaurantului pentru care se caută meniurile.
     * @return Lista de meniuri asociate restaurantului dat.
     */
    @Query("SELECT m FROM Meniuri m WHERE m.restaurant.restaurant_id = :restaurantId")
    List<Meniuri> findByRestaurantId(@Param("restaurantId") int restaurantId);
}
