package com.example.siteWeb.data;
import com.example.siteWeb.contracte.ComenziContract;
import com.example.siteWeb.repo.ComenziRepository;
import com.example.siteWeb.tabele.Comenzi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ComenziData implements ComenziContract {
    private final ComenziRepository comenziRepository;

    @Autowired
    public ComenziData(ComenziRepository comenziRepository) {
        this.comenziRepository = comenziRepository;
    }

    @Override
    public List<Comenzi> findAll() {
        return comenziRepository.findAll();
    }

    @Override
    public Optional<Comenzi> findById(int id) {
        return comenziRepository.findById(id);
    }

    @Override
    public Comenzi save(Comenzi comanda) {
        return comenziRepository.save(comanda);
    }

    @Override
    public void deleteById(int meniuId) {
        comenziRepository.deleteById(meniuId);
    }
}
