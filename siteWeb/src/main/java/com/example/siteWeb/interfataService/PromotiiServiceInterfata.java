package com.example.siteWeb.interfataService;

import com.example.siteWeb.tabele.Promotii;

import java.util.List;
import java.util.Optional;
/**
 * Interfața pentru serviciul de gestionare a promoțiilor.
 * Definește operațiile disponibile pentru gestionarea promoțiilor.
 */
public interface PromotiiServiceInterfata {
    /**
     * Returnează o listă cu toate promoțiile.
     *
     * @return Lista cu toate promoțiile.
     */
    List<Promotii> getAllPromotii();
    /**
     * Returnează o promoție după id-ul său.
     *
     * @param id Id-ul promoției căutate.
     * @return Promoția cu id-ul specificat.
     */

    Optional<Promotii> getPromotiiById(int id);
    /**
     * Creează o nouă promoție.
     *
     * @param promotii     Obiectul Promotii care trebuie creat.
     * @param restaurantId Id-ul restaurantului asociat promoției.
     * @return Promoția creată.
     */

    Promotii createPromotii(Promotii promotii,int restaurantId);
    /**
     * Actualizează informațiile unei promoții existente.
     *
     * @param id               Id-ul promoției care trebuie actualizată.
     * @param updatedPromotii  Obiectul Promotii cu noile detalii.
     * @return Promoția actualizată.
     */
    Promotii updatePromotii(int id, Promotii updatedPromotii);
    /**
     * Șterge o promoție după id-ul său.
     *
     * @param id Id-ul promoției care trebuie ștearsă.
     */

    void deletePromotii(int id);
    /**
     * Returnează o listă cu promoțiile care încep cu un anumit cod promițional.
     *
     * @param codPromotional Codul promițional căutat.
     * @return Lista cu promoțiile care încep cu codul promițional specificat.
     */

    List<Promotii> getPromotiiByCodPromotional(String codPromotional);
    /**
     * Returnează o listă cu promoțiile care au o anumită reducere.
     *
     * @param reducere Reducerea căutată.
     * @return Lista cu promoțiile care au reducerea specificată.
     */

    List<Promotii> getPromotiiByReducere(int reducere);
}
