package com.example.siteWeb.service;

import com.example.siteWeb.contracte.*;
import com.example.siteWeb.interfataService.RestauranteServiceInterfata;
import com.example.siteWeb.tabele.*;
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
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class RestauranteServiceTests {
    @Mock
    private RestauranteContract restauranteContractMock;

    @Mock
    private MeniuriContract meniuriContractMock;

    @Mock
    private ComenziContract comenziContractMock;

    @Mock
    private PromotiiContract promotiiContractMock;

    @Mock
    private RecenziiContract recenziiContractMock;

    private RestauranteServiceInterfata restauranteServiceInterfata;

    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
        restauranteServiceInterfata = new RestauranteService(restauranteContractMock,
                meniuriContractMock, comenziContractMock, promotiiContractMock, recenziiContractMock);

    }

    @Test
    public void testGetAllRestaurante() {
        List<Restaurante> expectedRestauranteList = new ArrayList<>();
        expectedRestauranteList.add(new Restaurante());
        expectedRestauranteList.add(new Restaurante());

        when(restauranteContractMock.findAll()).thenReturn(expectedRestauranteList);

        List<Restaurante> result = restauranteServiceInterfata.getAllRestaurante();

        assertEquals(expectedRestauranteList, result);
    }

    @Test
    public void testGetRestauranteById_ExistingId() {
        int id = 1;
        Restaurante expectedRestaurante = new Restaurante();
        when(restauranteContractMock.findById(id)).thenReturn(Optional.of(expectedRestaurante));

        Restaurante result = restauranteServiceInterfata.getRestauranteById(id);

        assertEquals(expectedRestaurante, result);
    }

    @Test
    public void testGetRestauranteById_NonExistingId() {
        int id = 1;
        when(restauranteContractMock.findById(id)).thenReturn(Optional.empty());

        Restaurante result = restauranteServiceInterfata.getRestauranteById(id);

        assertNull(result);
    }


    @Test
    public void testCreateRestaurante() {
        Restaurante restaurantToCreate = new Restaurante(1, "Restaurant Test", "Str. Testului 1", "Testville", "0123456789", "test@example.com", 5);
        Restaurante expectedRestaurant = new Restaurante(1, "Restaurant Test", "Str. Testului 1", "Testville", "0123456789", "test@example.com", 5);

        when(restauranteContractMock.save(restaurantToCreate)).thenReturn(expectedRestaurant);

        Restaurante result = restauranteServiceInterfata.createRestaurante(restaurantToCreate);

        assertEquals(expectedRestaurant, result);
        verify(restauranteContractMock).save(restaurantToCreate);
    }

    @Test
    public void testUpdateRestaurante() {
        int id = 1;
        Restaurante existingRestaurant = new Restaurante(1, "Restaurant Initial", "Str. Initiala 1", "Initialville", "0987654321", "initial@example.com", 4);
        Restaurante updatedRestaurantDetails = new Restaurante(1, "Restaurant Updated", "Str. Updated 1", "Updatedville", "0123456789", "updated@example.com", 5);
        Restaurante expectedUpdatedRestaurant = new Restaurante(1, "Restaurant Updated", "Str. Updated 1", "Updatedville", "0123456789", "updated@example.com", 5);

        when(restauranteContractMock.findById(id)).thenReturn(Optional.of(existingRestaurant));
        when(restauranteContractMock.save(existingRestaurant)).thenReturn(expectedUpdatedRestaurant);

        Restaurante result = restauranteServiceInterfata.updateRestaurante(id, updatedRestaurantDetails);

        assertEquals(expectedUpdatedRestaurant, result);
        verify(restauranteContractMock).findById(id);
        verify(restauranteContractMock).save(existingRestaurant);
    }

    @Test
    public void testDeleteRestaurantAndAssociatedData() {
        int restaurantId = 1;
        Restaurante existingRestaurant = new Restaurante(1, "Restaurant Initial", "Str. Initiala 1", "Initialville",
                "0987654321", "initial@example.com", 4);
        List<Recenzii> recenzii = new ArrayList<>();
        recenzii.add(new Recenzii());
        existingRestaurant.setRecenzii(recenzii);
        List<Comenzi> comenzi = new ArrayList<>();
        comenzi.add(new Comenzi());
        existingRestaurant.setComenzi(comenzi);
        List<Meniuri> meniuri = new ArrayList<>();
        meniuri.add(new Meniuri());
        existingRestaurant.setMeniuri(meniuri);
        List<Promotii> promotii = new ArrayList<>();
        promotii.add(new Promotii());
        existingRestaurant.setPromotii(promotii);

        when(restauranteContractMock.findById(restaurantId)).thenReturn(Optional.of(existingRestaurant));

        restauranteServiceInterfata.deleteRestaurantAndAssociatedData(restaurantId);

        verify(recenziiContractMock).deleteById(anyInt());
        verify(comenziContractMock).deleteById(anyInt());
        verify(meniuriContractMock).deleteById(anyInt());
        verify(promotiiContractMock).deleteById(anyInt());
        verify(restauranteContractMock).deleteById(restaurantId);
    }
}
