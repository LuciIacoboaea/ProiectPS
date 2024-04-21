package com.example.siteWeb.service;
import com.example.siteWeb.contracte.ClientiContract;
import com.example.siteWeb.interfataService.ClientiServiceInterfata;
import com.example.siteWeb.repo.ClientiRepository;
import com.example.siteWeb.tabele.Clienti;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;

public class ClientiServiceTests {

   @Mock
    private ClientiContract clientiContractMock;
   private ClientiServiceInterfata clientiServiceInterfata;
   @Before
    public void setUp(){
       MockitoAnnotations.initMocks(this);
       clientiServiceInterfata = new ClientiService(clientiContractMock);
   }

    @Test
    public void getAllUsersTest() {
        List<Clienti> clienti = new ArrayList<>();
        clienti.add(new Clienti("Marcel","strada florii","0745678290","marcel@yahoo.com","123456789"));
        clienti.add(new Clienti("Marcel12","strada florii12","0745678291","marcel12@yahoo.com","1223456789"));
        Mockito.when(clientiContractMock.findAll()).thenReturn(clienti);
        List<Clienti> allClienti = clientiServiceInterfata.getAllClients();
        Mockito.verify(clientiContractMock).findAll();
        assertEquals(clienti, allClienti);
    }
    @Test
    public void testGetClientById() {
        int id = 1;
        Clienti expectedClient = new Clienti("Marcel0", "strada florii", "0745678290", "marcel@yahoo.com", "123456789");

        Mockito.when(clientiContractMock.findById(id)).thenReturn(Optional.of(expectedClient));

        Clienti client = clientiServiceInterfata.getClientById(id);

        Mockito.verify(clientiContractMock).findById(id);

        assertEquals(expectedClient, client);
    }

    @Test
    public void testCreateClient() {
        Clienti clientToCreate = new Clienti("Marcel", "strada florii", "0745678290", "marcel@yahoo.com", "123456789");
        Clienti expectedClient = new Clienti("Marcel", "strada florii", "0745678290", "marcel@yahoo.com", "123456789");

        Mockito.when(clientiContractMock.save(clientToCreate)).thenReturn(expectedClient);

        Clienti createdClient = clientiServiceInterfata.createClient(clientToCreate);

        Mockito.verify(clientiContractMock).save(clientToCreate);

        assertEquals(expectedClient, createdClient);
    }
    @Test
    public void testUpdateClient() {
        int id = 1;
        Clienti clientToUpdate = new Clienti("Marcel", "strada florii", "0745678290", "marcel@yahoo.com", "123456789");
        Clienti updatedClientDetails = new Clienti("Marcel Updated", "strada florii Updated", "0745678290", "marcel@yahoo.com", "123456789");

        Mockito.when(clientiContractMock.findById(id)).thenReturn(Optional.of(clientToUpdate));
        Mockito.when(clientiContractMock.save(clientToUpdate)).thenReturn(updatedClientDetails);

        Clienti updatedClient = clientiServiceInterfata.updateClient(id, updatedClientDetails);

        Mockito.verify(clientiContractMock).findById(id);
        Mockito.verify(clientiContractMock).save(clientToUpdate);

        assertEquals(updatedClientDetails, updatedClient);
    }

    @Test
    public void testDeleteClient() {
        int id = 1;

        clientiServiceInterfata.deleteClient(id);

        Mockito.verify(clientiContractMock).deleteById(id);
    }
    @Test
    public void testPartiallyUpdateClient() {
        int id = 1;
        Clienti clientToUpdate = new Clienti("Marcel", "strada florii", "0745678290", "marcel@yahoo.com", "123456789");
        Clienti clientDetails = new Clienti("Marcel Updated", null, null, null, null);

        Mockito.when(clientiContractMock.findById(id)).thenReturn(Optional.of(clientToUpdate));
        Mockito.when(clientiContractMock.save(clientToUpdate)).thenReturn(clientToUpdate);

        Clienti updatedClient = clientiServiceInterfata.partiallyUpdateClient(id, clientDetails);

        Mockito.verify(clientiContractMock).findById(id);
        Mockito.verify(clientiContractMock).save(clientToUpdate);

        assertEquals(clientDetails.getNume(), updatedClient.getNume());
    }
}
