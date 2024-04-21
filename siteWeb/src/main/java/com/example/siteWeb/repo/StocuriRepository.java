package com.example.siteWeb.repo;
import com.example.siteWeb.tabele.Produse;
import com.example.siteWeb.tabele.Restaurante;
import com.example.siteWeb.tabele.Stocuri;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Interfața StocuriRepository este responsabilă pentru interacțiunea cu baza de date pentru entitatea Stocuri.
 * Această interfață extinde JpaRepository pentru a oferi operații de bază de date, cum ar fi salvarea, actualizarea și ștergerea.
 * De asemenea, oferă metode personalizate pentru ștergerea stocurilor asociate unui restaurant sau unui produs.
 */
public interface StocuriRepository extends JpaRepository<Stocuri, Integer> {

}
