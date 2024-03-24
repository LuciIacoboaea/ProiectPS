package com.example.siteWeb.Repo;
import com.example.siteWeb.Tabele.Clienti;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientiRepository extends JpaRepository<Clienti, Long> {
}
