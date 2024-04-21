package com.example.siteWeb.service;

import com.example.siteWeb.contracte.ClientiContract;
import com.example.siteWeb.contracte.ComenziContract;
import com.example.siteWeb.contracte.MeniuriContract;
import com.example.siteWeb.interfataService.ClientiServiceInterfata;
import com.example.siteWeb.interfataService.ComenziServiceInterfata;
import com.example.siteWeb.tabele.Clienti;
import com.example.siteWeb.tabele.Comenzi;
import com.example.siteWeb.tabele.Meniuri;
import com.example.siteWeb.tabele.Restaurante;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;

public class ComenziServiceTests {
    @Mock
    private ComenziContract comenziContractMock;
    @Mock
    private MeniuriContract meniuriContractMock;
    private ComenziServiceInterfata comenziServiceInterfata;
    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
        comenziServiceInterfata = new ComenziService(comenziContractMock,meniuriContractMock);
    }
    @Test
    public void testGetAllComenzi() {
        List<Comenzi> comenziList = new ArrayList<>();
        comenziList.add(new Comenzi(1, new Clienti(), new Restaurante(), new Meniuri(), "Adresa", LocalDateTime.now(), 100));
        comenziList.add(new Comenzi(2, new Clienti(), new Restaurante(), new Meniuri(), "Adresa", LocalDateTime.now(), 200));

        Mockito.when(comenziContractMock.findAll()).thenReturn(comenziList);

        List<Comenzi> allComenzi = comenziServiceInterfata.getAllComenzi();

        Mockito.verify(comenziContractMock).findAll();

        assertEquals(comenziList, allComenzi);
    }

    @Test
    public void testGetComandaById() {
        int id = 1;
        Comenzi expectedComanda = new Comenzi(id, new Clienti(), new Restaurante(), new Meniuri(), "Adresa", LocalDateTime.now(), 100);

        Mockito.when(comenziContractMock.findById(id)).thenReturn(Optional.of(expectedComanda));

        Comenzi comanda = comenziServiceInterfata.getComandaById(id);

        Mockito.verify(comenziContractMock).findById(id);

        assertEquals(expectedComanda, comanda);
    }

    @Test
    public void testCreateComanda() {
        Comenzi comandaToCreate = new Comenzi(1, new Clienti(), new Restaurante(), new Meniuri(), "Adresa", LocalDateTime.now(), 100);

        Mockito.when(comenziContractMock.save(comandaToCreate)).thenReturn(comandaToCreate);

        Comenzi createdComanda = comenziServiceInterfata.createComanda(comandaToCreate);

        Mockito.verify(comenziContractMock).save(comandaToCreate);

        assertEquals(comandaToCreate, createdComanda);
    }
    @Test
    public void testUpdateComanda() {
        int id = 1;
        Comenzi comandaToUpdate = new Comenzi(id, new Clienti(), new Restaurante(), new Meniuri(), "Adresa", LocalDateTime.now(), 100);
        Comenzi updatedComandaDetails = new Comenzi(id, new Clienti(), new Restaurante(), new Meniuri(), "Adresa Actualizata", LocalDateTime.now(), 200);

        Mockito.when(comenziContractMock.findById(id)).thenReturn(Optional.of(comandaToUpdate));
        Mockito.when(comenziContractMock.save(comandaToUpdate)).thenReturn(updatedComandaDetails);

        Comenzi updatedComanda = comenziServiceInterfata.updateComanda(id, updatedComandaDetails);

        Mockito.verify(comenziContractMock).findById(id);
        Mockito.verify(comenziContractMock).save(comandaToUpdate);

        assertEquals(updatedComandaDetails, updatedComanda);
    }

    @Test
    public void testDeleteComanda() {
        int id = 1;

        comenziServiceInterfata.deleteComanda(id);

        Mockito.verify(comenziContractMock).deleteById(id);
    }
}
