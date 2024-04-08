package com.example.siteWeb.Repo;

import com.example.siteWeb.Tabele.Promotii;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Interfața PromotiiRepository este responsabilă pentru interacțiunea cu baza de date pentru entitatea Promotii.
 * Această interfață extinde JpaRepository pentru a oferi operații de bază de date, cum ar fi salvarea, actualizarea și ștergerea.
 * De asemenea, oferă metode personalizate de interogare a datelor legate de Promotii.
 */
@Repository
public interface PromotiiRepository extends JpaRepository<Promotii, Integer> {

    /**
     * Metodă pentru găsirea promotiilor cu un cod promotional care începe cu un anumit șir de caractere.
     * @param cod_promotional Șirul de caractere cu care începe codul promotional.
     * @return Lista de promotii care îndeplinesc condiția specificată.
     */
    @Query("SELECT p FROM Promotii p WHERE p.cod_promotional LIKE :codPromotional%")
    List<Promotii> findByCod_promotionalStartingWith(@Param("codPromotional") String cod_promotional);

    /**
     * Metodă pentru găsirea promotiilor după o anumită reducere.
     * @param reducere Valoarea reducerii căutate.
     * @return Lista de promotii care au reducerea specificată.
     */
    List<Promotii> findByReducere(int reducere);
}