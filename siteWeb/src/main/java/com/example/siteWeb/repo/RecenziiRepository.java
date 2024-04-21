package com.example.siteWeb.repo;

import com.example.siteWeb.tabele.Recenzii;
import org.springframework.data.jpa.repository.JpaRepository;
/**
 * Repository interface for managing Recenzii entities.
 * Extends JpaRepository to inherit basic CRUD methods.
 */
public interface RecenziiRepository extends JpaRepository<Recenzii, Integer> {
}
