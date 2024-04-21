package com.example.siteWeb.service;
import com.example.siteWeb.contracte.StocuriContract;
import com.example.siteWeb.interfataService.StocuriServiceInterfata;
import com.example.siteWeb.observator.StocuriObs;
import com.example.siteWeb.repo.StocuriRepository;
import com.example.siteWeb.tabele.Produse;
import com.example.siteWeb.tabele.Restaurante;
import com.example.siteWeb.tabele.Stocuri;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
/**
 * Serviciu pentru gestionarea operațiilor legate de stocuri.
 */
@Service
public class StocuriService implements StocuriServiceInterfata {

    @Autowired
    private final StocuriContract stocuriContract;
    @Autowired
    private final StocuriObs stocuriObs;

    @Autowired
    public StocuriService(StocuriContract stocuriContract, StocuriObs stocuriObs) {
        this.stocuriContract = stocuriContract;
        this.stocuriObs = stocuriObs;
    }
    /**
     * Returnează o listă cu toate stocurile din baza de date.
     *
     * @return Lista cu toate stocurile.
     */
    public List<Stocuri> getAllStocuri() {
        return stocuriContract.findAll();
    }
    /**
     * Returnează un stoc după identificatorul său.
     *
     * @param id Identificatorul stocului.
     * @return Stocul cu identificatorul specificat sau null dacă nu este găsit.
     */
    public Stocuri getStocById(int id) {
        return stocuriContract.findById(id).orElse(null);
    }
    /**
     * Creează un nou stoc în baza de date.
     *
     * @param stocuri Obiectul Stocuri ce urmează să fie creat.
     * @return Stocul creat.
     */
    public Stocuri createStoc(Stocuri stocuri) {
        return stocuriContract.save(stocuri);
    }
    /**
     * Actualizează informațiile unui stoc existent în baza de date.
     *
     * @param id               Identificatorul stocului ce urmează să fie actualizat.
     * @param stocuriDetails Obiectul Stocuri ce conține noile informații ale stocului.
     * @return Stocul actualizat sau null dacă stocul cu identificatorul specificat nu există.
     */
    public Stocuri updateStoc(int id, Stocuri stocuriDetails) {
        Stocuri stocuri = stocuriContract.findById(id).orElse(null);
        if (stocuri != null) {
            stocuri.setRestaurant(stocuriDetails.getRestaurant());
            stocuri.setProdus(stocuriDetails.getProdus());
            stocuri.setCantitate(stocuriDetails.getCantitate());
            stocuriObs.onStocUpdate(stocuri);
            stocuriObs.notifyObservers(stocuri);
            return stocuriContract.save(stocuri);
        } else {
            return null;
        }
    }
    /**
     * Șterge un stoc din baza de date după identificatorul său.
     *
     * @param id Identificatorul stocului ce urmează să fie șters.
     */
    public void deleteStoc(int id) {
        stocuriContract.deleteById(id);
    }
}