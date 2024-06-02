package com.example.siteWeb.repo;

import com.example.siteWeb.tabele.Recenzii;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Repository interface for managing Recenzii entities.
 * Extends JpaRepository to inherit basic CRUD methods.
 */
public interface RecenziiRepository extends JpaRepository<Recenzii, Integer> {

    /**
     * Returnează o listă de recenzii pentru un anumit restaurant.
     *
     * @param restaurantId ID-ul restaurantului.
     * @return Lista de recenzii pentru restaurantul specificat.
     */
    @Query("SELECT r FROM Recenzii r WHERE r.restaurant.id = :restaurantId")
    List<Recenzii> findByRestaurantId(@Param("restaurantId") int restaurantId);
}
