package com.example.siteWeb.service;

import com.example.siteWeb.contracte.MeniuriContract;
import com.example.siteWeb.contracte.RestauranteContract;
import com.example.siteWeb.interfataService.ComenziServiceInterfata;
import com.example.siteWeb.interfataService.MeniuriServiceInterfata;
import com.example.siteWeb.repo.RestauranteRepository;
import com.example.siteWeb.tabele.Meniuri;
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
import static org.junit.Assert.assertNull;

public class MeniuriServiceTests {
    @Mock
    private MeniuriContract meniuriContractMock;
    @Mock
    private RestauranteRepository restauranteRepositoryMock;
    private MeniuriServiceInterfata meniuriServiceInterfata;
    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
        meniuriServiceInterfata = new MeniuriService(meniuriContractMock,restauranteRepositoryMock);
    }

    @Test
    public void testGetAllMeniuri() {
        Meniuri meniu1 = new Meniuri(1, "Nume meniu 1", "Descriere meniu 1", "Categorie 1", new Restaurante());
        Meniuri meniu2 = new Meniuri(2, "Nume meniu 2", "Descriere meniu 2", "Categorie 2", new Restaurante());
        List<Meniuri> meniuriList = new ArrayList<>();
        meniuriList.add(meniu1);
        meniuriList.add(meniu2);

        Mockito.when(meniuriContractMock.findAll()).thenReturn(meniuriList);

        List<Meniuri> result = meniuriServiceInterfata.getAllMeniuri();

        assertEquals(meniuriList, result);
    }
    @Test
    public void testCreateMeniu() {
        Restaurante restaurant = new Restaurante();
        Meniuri meniuToCreate = new Meniuri(1, "Nume meniu", "Descriere meniu", "Categorie", restaurant);

        Mockito.when(restauranteRepositoryMock.findById(1)).thenReturn(Optional.of(restaurant));

        Meniuri expectedMeniu = new Meniuri(1, "Nume meniu", "Descriere meniu", "Categorie", restaurant);
        Mockito.when(meniuriContractMock.save(meniuToCreate)).thenReturn(expectedMeniu);

        Meniuri result = meniuriServiceInterfata.createMeniu(meniuToCreate, 1);

        assertEquals(expectedMeniu, result);
    }
    @Test
    public void testUpdateMeniu_ExistingId() {
        Meniuri existingMeniu = new Meniuri(1, "Nume meniu existent", "Descriere meniu existent", "Categorie existentă", new Restaurante());
        Mockito.when(meniuriContractMock.findById(1)).thenReturn(Optional.of(existingMeniu));

        Meniuri updatedMeniu = new Meniuri(1, "Nume meniu actualizat", "Descriere meniu actualizată", "Categorie actualizată", new Restaurante());

        Meniuri expectedMeniu = new Meniuri(1, "Nume meniu actualizat", "Descriere meniu actualizată", "Categorie actualizată", existingMeniu.getRestaurant());
        Mockito.when(meniuriContractMock.save(existingMeniu)).thenReturn(expectedMeniu);

        Meniuri result = meniuriServiceInterfata.updateMeniu(1, updatedMeniu);

        assertEquals(expectedMeniu, result);
    }
    @Test
    public void testGetMeniuById_ExistingId() {
        Meniuri expectedMeniu = new Meniuri();
        Mockito.when(meniuriContractMock.findById(1)).thenReturn(Optional.of(expectedMeniu));

        Meniuri result = meniuriServiceInterfata.getMeniuById(1);

        assertEquals(expectedMeniu, result);
    }

    @Test
    public void testGetMeniuById_NonExistingId() {
        Mockito.when(meniuriContractMock.findById(1)).thenReturn(Optional.empty());

        Meniuri result = meniuriServiceInterfata.getMeniuById(1);

        assertNull(result);
    }
    @Test
    public void testDeleteMeniu() {
        meniuriServiceInterfata.deleteMeniu(1);

        Mockito.verify(meniuriContractMock).deleteById(1);
    }

}
