package com.example.siteWeb.interfataService;

import com.example.siteWeb.tabele.Recenzii;

import java.util.List;
/**
 * Interfața pentru serviciul de gestionare a recenziilor.
 */

public interface RecenziiInterfataService {
    /**
     * Returnează o listă cu toate recenziile din baza de date.
     *
     * @return Lista cu toate recenziile.
     */
    List<Recenzii> getAllRecenzii();

    /**
     * Returnează o recenzie după identificatorul său.
     *
     * @param id Identificatorul recenziei.
     * @return Recenzia cu identificatorul specificat sau null dacă nu este găsită.
     */
    Recenzii getRecenzieById(int id);

    /**
     * Creează o nouă recenzie în baza de date.
     *
     * @param recenzie Obiectul Recenzii ce urmează să fie creat.
     * @return Recenzia creată.
     */
    Recenzii createRecenzie(Recenzii recenzie);

    /**
     * Actualizează informațiile unei recenzii existente în baza de date.
     *
     * @param id             Identificatorul recenziei ce urmează să fie actualizată.
     * @param recenzieDetails Obiectul Recenzii ce conține noile informații ale recenziei.
     * @return Recenzia actualizată sau null dacă recenzia cu identificatorul specificat nu există.
     */
    Recenzii updateRecenzie(int id, Recenzii recenzieDetails);

    /**
     * Șterge o recenzie din baza de date după identificatorul său.
     *
     * @param id Identificatorul recenziei ce urmează să fie ștearsă.
     */
    void deleteRecenzie(int id);
}
