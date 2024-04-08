package com.example.siteWeb.Repo;

import com.example.siteWeb.Tabele.Clienti;
import com.example.siteWeb.Tabele.Comenzi;
import com.example.siteWeb.Tabele.Meniuri;
import com.example.siteWeb.Tabele.Restaurante;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
/**
 * Interfața ComenziRepository este responsabilă pentru interacțiunea cu baza de date pentru entitatea Comenzi.
 * Această interfață extinde JpaRepository pentru a oferi operații de bază de date, cum ar fi salvarea, actualizarea și ștergerea.
 */
@Repository
public interface ComenziRepository extends JpaRepository<Comenzi, Integer> {

    /**
     * Metodă pentru ștergerea comenzilor asociate unui client.
     * @param client Clientul asociat comenzilor de șters.
     */
    @Transactional
    void deleteByClient(Clienti client);

    /**
     * Metodă pentru ștergerea comenzilor asociate unui restaurant.
     * @param restaurant Restaurantul asociat comenzilor de șters.
     */
    @Transactional
    void deleteByRestaurant(Restaurante restaurant);

    /**
     * Metodă pentru ștergerea comenzilor asociate unui meniu.
     * @param meniu Meniul asociat comenzilor de șters.
     */
    @Transactional
    void deleteByMeniu(Meniuri meniu);
}