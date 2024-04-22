package com.example.siteWeb.service;

import com.example.siteWeb.contracte.PromotiiContract;
import com.example.siteWeb.interfataService.PromotiiServiceInterfata;
import com.example.siteWeb.repo.RestauranteRepository;
import com.example.siteWeb.tabele.Promotii;
import com.example.siteWeb.tabele.Restaurante;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;

public class PromotiiServiceTests {
    @Mock
    private PromotiiContract promotiiContractMock;

    @Mock
    private RestauranteRepository restauranteRepositoryMock;

    private PromotiiServiceInterfata promotiiServiceInterfata;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        promotiiServiceInterfata = new PromotiiService(promotiiContractMock, restauranteRepositoryMock);
    }

    @Test
    public void getAllPromotiiTest() {
        List<Promotii> promotii = new ArrayList<>();
        Restaurante restaurant1 = new Restaurante();
        restaurant1.setRestaurant_id(1);
        promotii.add(new Promotii(restaurant1, "COD1", "Promotie 1", 10));

        Restaurante restaurant2 = new Restaurante();
        restaurant2.setRestaurant_id(2);
        promotii.add(new Promotii(restaurant2, "COD2", "Promotie 2", 20));

        Mockito.when(promotiiContractMock.findAll()).thenReturn(promotii);
        List<Promotii> allPromotii = promotiiServiceInterfata.getAllPromotii();
        Mockito.verify(promotiiContractMock).findAll();
        assertEquals(promotii, allPromotii);
    }

    @Test
    public void createPromotiiTest() {
        Restaurante restaurant = new Restaurante();
        restaurant.setRestaurant_id(1);
        Promotii promotieToCreate = new Promotii(restaurant, "COD3", "Promotie 3", 15);
        Promotii expectedPromotie = new Promotii(restaurant, "COD3", "Promotie 3", 15);

        Mockito.when(restauranteRepositoryMock.findById(1)).thenReturn(Optional.of(restaurant));
        Mockito.when(promotiiContractMock.save(any(Promotii.class))).thenReturn(expectedPromotie);

        Promotii createdPromotie = promotiiServiceInterfata.createPromotii(promotieToCreate, 1);

        Mockito.verify(restauranteRepositoryMock).findById(1);
        Mockito.verify(promotiiContractMock).save(promotieToCreate);

        assertEquals(expectedPromotie, createdPromotie);
    }
    @Test
    public void updatePromotiiTest() {
        int id = 1;
        Promotii existingPromotie = new Promotii();
        existingPromotie.setPromotie_id(id);
        existingPromotie.setCod_promotional("COD1");
        existingPromotie.setDescriere("Promotie veche");
        existingPromotie.setReducere(10);

        Promotii updatedPromotieDetails = new Promotii();
        updatedPromotieDetails.setCod_promotional("COD1");
        updatedPromotieDetails.setDescriere("Promotie actualizata");
        updatedPromotieDetails.setReducere(20);

        Mockito.when(promotiiContractMock.findById(id)).thenReturn(Optional.of(existingPromotie));
        Mockito.when(promotiiContractMock.save(any(Promotii.class))).thenReturn(updatedPromotieDetails);

        Promotii updatedPromotie = promotiiServiceInterfata.updatePromotii(id, updatedPromotieDetails);

        Mockito.verify(promotiiContractMock).findById(id);
        Mockito.verify(promotiiContractMock).save(existingPromotie);

        assertEquals(updatedPromotieDetails, updatedPromotie);
    }

    @Test
    public void deletePromotiiTest() {
        int id = 1;
        promotiiServiceInterfata.deletePromotii(id);
        Mockito.verify(promotiiContractMock).deleteById(id);
    }

    @Test
    public void getPromotiiByCodPromotionalTest() {
        String codPromotional = "COD";
        List<Promotii> promotii = new ArrayList<>();
        Restaurante restaurant1 = new Restaurante();
        restaurant1.setRestaurant_id(1);
        promotii.add(new Promotii(restaurant1, "COD123", "Promotie COD123", 15));
        promotii.add(new Promotii(restaurant1, "COD456", "Promotie COD456", 20));

        Mockito.when(promotiiContractMock.findByCod_promotionalStartingWith(codPromotional)).thenReturn(promotii);
        List<Promotii> resultPromotii = promotiiServiceInterfata.getPromotiiByCodPromotional(codPromotional);
        Mockito.verify(promotiiContractMock).findByCod_promotionalStartingWith(codPromotional);
        assertEquals(promotii, resultPromotii);
    }

    @Test
    public void getPromotiiByReducereTest() {
        int reducere = 10;
        List<Promotii> promotii = new ArrayList<>();
        Restaurante restaurant1 = new Restaurante();
        restaurant1.setRestaurant_id(1);
        promotii.add(new Promotii(restaurant1, "COD1", "Promotie 1", reducere));
        promotii.add(new Promotii(restaurant1, "COD2", "Promotie 2", reducere));

        Mockito.when(promotiiContractMock.findByReducere(reducere)).thenReturn(promotii);
        List<Promotii> resultPromotii = promotiiServiceInterfata.getPromotiiByReducere(reducere);
        Mockito.verify(promotiiContractMock).findByReducere(reducere);
        assertEquals(promotii, resultPromotii);
    }
}
