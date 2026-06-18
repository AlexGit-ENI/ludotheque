package fr.eni.ludotheque.bll;

import fr.eni.ludotheque.bo.Adresse;
import fr.eni.ludotheque.bo.Client;
import fr.eni.ludotheque.dal.ClientRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

    @SpringBootTest
    public class ClientServiceImplTest {
        @Autowired
        ClientService clientService;

        @Autowired
        ClientRepository clientRepository;

        @Test
        void testCreationClient() {
            Adresse adresse = new Adresse("rue du paradis", "06666", "Cieux");
            Client client = new Client("Jesus", "Christ", "christ.jesus@cieux.com", adresse);
            client.setNoTelephone("06666666");

            clientService.ajouterClient(client);

            Client clientBD = clientRepository.findById(client.getNoClient()).orElse(null);
            Assertions.assertNotNull(clientBD);
            Assertions.assertEquals(client,  clientBD);


        }

    }

