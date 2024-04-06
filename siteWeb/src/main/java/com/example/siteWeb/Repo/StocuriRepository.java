package com.example.siteWeb.Repo;
import com.example.siteWeb.Tabele.Produse;
import com.example.siteWeb.Tabele.Restaurante;
import com.example.siteWeb.Tabele.Stocuri;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

public interface StocuriRepository extends JpaRepository<Stocuri, Integer> {

    @Transactional
    void deleteByRestaurant(Restaurante restaurant);

    @Transactional
    void deleteByProdus(Produse produs);
}
