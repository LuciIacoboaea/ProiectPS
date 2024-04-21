package com.example.siteWeb.service;

import com.example.siteWeb.contracte.ProduseContract;
import com.example.siteWeb.contracte.StocuriContract;
import com.example.siteWeb.interfataService.ProduseServiceInterfata;
import com.example.siteWeb.repo.MeniuriRepository;
import com.example.siteWeb.tabele.Meniuri;
import com.example.siteWeb.tabele.Produse;
import com.example.siteWeb.tabele.Stocuri;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class ProduseServiceTests {
    @Mock
    private ProduseContract produseContractMock;

    @Mock
    private MeniuriRepository meniuriRepositoryMock;
    @Mock
    private StocuriContract stocuriContractMock;

    private ProduseServiceInterfata produseServiceInterfata;
    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
        produseServiceInterfata = new ProduseService(produseContractMock,meniuriRepositoryMock,stocuriContractMock);
    }
    @Test
    public void testGetAllProduse() {
        List<Produse> produseList = new ArrayList<>();
        produseList.add(new Produse(1, "Produs 1", "Descriere produs 1", 10));
        produseList.add(new Produse(2, "Produs 2", "Descriere produs 2", 20));
        Mockito.when(produseContractMock.findAll()).thenReturn(produseList);

        List<Produse> result = produseServiceInterfata.getAllProduse();

        assertEquals(produseList, result);
    }

    @Test
    public void testGetProdusById_ExistingId() {
        Produse expectedProdus = new Produse();
        Mockito.when(produseContractMock.findById(1)).thenReturn(Optional.of(expectedProdus));

        Produse result = produseServiceInterfata.getProdusById(1);

        assertEquals(expectedProdus, result);
    }

    @Test
    public void testGetProdusById_NonExistingId() {
        Mockito.when(produseContractMock.findById(1)).thenReturn(Optional.empty());

        Produse result = produseServiceInterfata.getProdusById(1);

        assertNull(result);
    }
    @Test
    public void testCreateProdus() {
        Meniuri meniu = new Meniuri();
        Produse produsToCreate = new Produse(1, "Nume Produs", "Descriere Produs", 50);

        Mockito.when(meniuriRepositoryMock.findById(1)).thenReturn(Optional.of(meniu));

        Produse expectedProdus = new Produse(1, "Nume Produs", "Descriere Produs", 50);
        expectedProdus.setMeniu(meniu);

        Mockito.when(produseContractMock.save(produsToCreate)).thenReturn(expectedProdus);

        Produse result = produseServiceInterfata.createProdus(produsToCreate, 1);

        assertEquals(expectedProdus, result);
    }

    @Test
    public void testDeleteProdus() {
        Produse produs = new Produse();
        produs.setProdus_id(1);
        Meniuri meniu = new Meniuri();
        produs.setMeniu(meniu);
        List<Stocuri> stocuri = new ArrayList<>();

        produs.setStocuri(stocuri);

        Mockito.when(produseContractMock.findById(1)).thenReturn(Optional.of(produs));

        produseServiceInterfata.deleteProdus(1);

        Mockito.verify(produseContractMock).findById(1);

        Mockito.verify(produseContractMock).deleteById(1);

        Mockito.verify(meniuriRepositoryMock).delete(meniu);

        for (Stocuri stoc : stocuri) {
            Mockito.verify(stocuriContractMock).deleteById(stoc.getStoc_id());
        }
    }
}
