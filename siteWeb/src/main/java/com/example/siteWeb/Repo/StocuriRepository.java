package com.example.siteWeb.Repo;
import com.example.siteWeb.Tabele.Produse;
import com.example.siteWeb.Tabele.Restaurante;
import com.example.siteWeb.Tabele.Stocuri;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Interfața StocuriRepository este responsabilă pentru interacțiunea cu baza de date pentru entitatea Stocuri.
 * Această interfață extinde JpaRepository pentru a oferi operații de bază de date, cum ar fi salvarea, actualizarea și ștergerea.
 * De asemenea, oferă metode personalizate pentru ștergerea stocurilor asociate unui restaurant sau unui produs.
 */
public interface StocuriRepository extends JpaRepository<Stocuri, Integer> {

    /**
     * Metodă pentru ștergerea stocurilor asociate unui restaurant.
     * @param restaurant Restaurantul asociat stocurilor de șters.
     */
    @Transactional
    void deleteByRestaurant(Restaurante restaurant);

    /**
     * Metodă pentru ștergerea stocurilor asociate unui produs.
     * @param produs Produsul asociat stocurilor de șters.
     */
    @Transactional
    void deleteByProdus(Produse produs);
}
