package com.example.siteWeb.Repo;

import com.example.siteWeb.Tabele.Produse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProduseRepository extends JpaRepository<Produse, Integer> {
    void deleteByMeniu_id(int meniuId);
}