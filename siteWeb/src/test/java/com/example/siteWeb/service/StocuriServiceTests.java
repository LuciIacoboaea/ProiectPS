package com.example.siteWeb.service;

import com.example.siteWeb.contracte.StocuriContract;
import com.example.siteWeb.interfataService.StocuriServiceInterfata;
import com.example.siteWeb.observator.StocuriObs;
import com.example.siteWeb.tabele.Produse;
import com.example.siteWeb.tabele.Restaurante;
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

public class StocuriServiceTests {
    @Mock
    private StocuriContract stocuriContractMock;

    @Mock
    private StocuriObs stocuriObsMock;

    private StocuriServiceInterfata stocuriServiceInterfata;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        stocuriServiceInterfata = new StocuriService(stocuriContractMock, stocuriObsMock);
    }

    @Test
    public void getAllStocuriTest() {
        Restaurante restaurant1 = new Restaurante();
        Produse produs1 = new Produse();

        Restaurante restaurant2 = new Restaurante();
        Produse produs2 = new Produse();


        Stocuri stoc1 = new Stocuri(1, restaurant1, produs1, 100);
        Stocuri stoc2 = new Stocuri(2, restaurant2, produs2, 200);


        List<Stocuri> stocuri = new ArrayList<>();
        stocuri.add(stoc1);
        stocuri.add(stoc2);
        Mockito.when(stocuriContractMock.findAll()).thenReturn(stocuri);
        List<Stocuri> allStocuri = stocuriServiceInterfata.getAllStocuri();
        Mockito.verify(stocuriContractMock).findAll();
        assertEquals(stocuri, allStocuri);
    }

    @Test
    public void testGetStocById() {
        int id = 1;
        Stocuri expectedStoc = new Stocuri();

        Mockito.when(stocuriContractMock.findById(id)).thenReturn(Optional.of(expectedStoc));

        Stocuri stoc = stocuriServiceInterfata.getStocById(id);

        Mockito.verify(stocuriContractMock).findById(id);

        assertEquals(expectedStoc, stoc);
    }

    @Test
    public void testCreateStoc() {
        Stocuri stocToCreate = new Stocuri();
        Stocuri expectedStoc = new Stocuri();

        Mockito.when(stocuriContractMock.save(stocToCreate)).thenReturn(expectedStoc);

        Stocuri createdStoc = stocuriServiceInterfata.createStoc(stocToCreate);

        Mockito.verify(stocuriContractMock).save(stocToCreate);

        assertEquals(expectedStoc, createdStoc);
    }

    @Test
    public void testUpdateStoc() {
        int id = 1;
        Stocuri stocToUpdate = new Stocuri();
        Stocuri updatedStocDetails = new Stocuri();

        Mockito.when(stocuriContractMock.findById(id)).thenReturn(Optional.of(stocToUpdate));
        Mockito.when(stocuriContractMock.save(stocToUpdate)).thenReturn(updatedStocDetails);

        Stocuri updatedStoc = stocuriServiceInterfata.updateStoc(id, updatedStocDetails);

        Mockito.verify(stocuriContractMock).findById(id);
        Mockito.verify(stocuriContractMock).save(stocToUpdate);

        assertEquals(updatedStocDetails, updatedStoc);
    }

    @Test
    public void testDeleteStoc() {
        int id = 1;

        stocuriServiceInterfata.deleteStoc(id);

        Mockito.verify(stocuriContractMock).deleteById(id);
    }


}
