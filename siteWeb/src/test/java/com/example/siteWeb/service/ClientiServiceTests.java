package com.example.siteWeb.service;
import com.example.siteWeb.repo.ClientiRepository;
import org.mockito.Mock;

import static org.junit.Assert.assertEquals;

public class ClientiServiceTests {

    @Mock
    private ClientiRepository clientiRepositoryMock;
    private ClientiService clientiService;

    /*@Before
    public void setup(){
        MockitoAnnotations.initMocks(this);
        //clientiService=new ClientiService(clientiRepositoryMock);
    }*/
   /* @Test
    public void saveClientiTests(){
        Clienti client=new Clienti("Lucian","str.C.Prof","0732145638","luci@gmail.com","123sef123");
        Mockito.when(clientiRepositoryMock.save(client)).thenReturn(client);
       Clienti result = clientiService.createClient(client);
        Mockito.verify(clientiRepositoryMock).save(client);
        assertEquals(client,result);
    }*/
}
