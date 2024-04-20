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

    public List<Stocuri> getAllStocuri() {
        return stocuriContract.findAll();
    }

    public Stocuri getStocById(int id) {
        return stocuriContract.findById(id).orElse(null);
    }

    public Stocuri createStoc(Stocuri stocuri) {
        return stocuriContract.save(stocuri);
    }

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

    public void deleteStoc(int id) {
        stocuriContract.deleteById(id);
    }
}