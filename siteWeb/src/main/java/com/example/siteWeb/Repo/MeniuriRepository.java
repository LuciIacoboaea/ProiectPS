package com.example.siteWeb.Repo;

import com.example.siteWeb.Tabele.Meniuri;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MeniuriRepository extends JpaRepository<Meniuri, Integer> {
}
