package com.example.siteWeb.Repo;

import com.example.siteWeb.Tabele.Comenzi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface ComenziRepository extends JpaRepository<Comenzi,Integer> {
}
