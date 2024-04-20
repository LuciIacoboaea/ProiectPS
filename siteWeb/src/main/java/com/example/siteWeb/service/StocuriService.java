package com.example.siteWeb.service;
import com.example.siteWeb.observator.StocuriObs;
import com.example.siteWeb.repo.StocuriRepository;
import com.example.siteWeb.tabele.Produse;
import com.example.siteWeb.tabele.Restaurante;
import com.example.siteWeb.tabele.Stocuri;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class StocuriService {

    @Autowired
    private StocuriRepository stocuriRepository;

    @Autowired
    private StocuriObs stocuriObs;

    public List<Stocuri> getAllStocuri() {
        return stocuriRepository.findAll();
    }

    public Stocuri getStocById(int id) {
        return stocuriRepository.findById(id).orElse(null);
    }

    public Stocuri createStoc(Stocuri stocuri) {
        return stocuriRepository.save(stocuri);
    }

    public Stocuri updateStoc(int id, Stocuri stocuriDetails) {
        Stocuri stocuri = stocuriRepository.findById(id).orElse(null);
        if (stocuri != null) {
            stocuri.setRestaurant(stocuriDetails.getRestaurant());
            stocuri.setProdus(stocuriDetails.getProdus());
            stocuri.setCantitate(stocuriDetails.getCantitate());
            // Notificăm observatorul pentru actualizare
            stocuriObs.onStocUpdate(stocuri);
            // Notificăm observatorii asociați stocului
            stocuriObs.notifyObservers(stocuri);
            return stocuriRepository.save(stocuri);
        } else {
            return null;
        }
    }

    public void deleteStoc(int id) {
        stocuriRepository.deleteById(id);
    }

    public void deleteByRestaurant(Restaurante restaurant) {
        stocuriRepository.deleteByRestaurant(restaurant);
    }

    public void deleteByProdus(Produse produs) {
        stocuriRepository.deleteByProdus(produs);
    }
}