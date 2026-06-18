package fr.eni.ludotheque.dal;

import fr.eni.ludotheque.bll.ClientService;
import fr.eni.ludotheque.bo.Adresse;
import fr.eni.ludotheque.bo.Client;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class ClientRepositoryTest {
    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private ClientService clientService;

    @Test
    @DisplayName("test positif de creation d'un client en BD")
    @Transactional
    public void testCreationClient() {

        Adresse adresse = new Adresse("rue du paradis", "06666", "Cieux");
        Client client = new Client("Jesus", "Christ", "jesus.christ@cieux.com", adresse);
        client.setNoTelephone("0666666666");

        //Act
        clientRepository.save(client);

        //Assert
        Client clientEnBD = clientRepository.findById(client.getNoClient()).orElse(null);
        assertNotNull(clientEnBD);
        assertNotNull(clientEnBD.getNoClient());
        assertEquals("Jesus", clientEnBD.getNom());
        assertEquals("Christ", clientEnBD.getPrenom());
        assertEquals("jesus.christ@cieux.com", clientEnBD.getEmail());
        assertEquals("0666666666", clientEnBD.getNoTelephone());
        assertNotNull(clientEnBD.getAdresse().getNoAdresse());
        assertEquals(adresse, clientEnBD.getAdresse());

        Client findById = clientRepository.findById(clientEnBD.getNoClient()).orElse(null);
        assertNotNull(findById);
        assertEquals(clientEnBD, findById);
    }
    @Test
        void updateClient () {

                Adresse adresse = new Adresse("Rue de la Bière", "06666", "Cieux");
        Client client = new Client("Saint", "Pierre", "pierre.saint@cieux.com", adresse);
        client.setNoTelephone("020202020202");

        clientService.ajouterClient(client);

        Adresse nouvelleAdresse =
                new Adresse("Rue du Thé", "05488", "Hell");

        client.setNom("Saint");
        client.setPrenom("Pierre");
        client.setEmail("pierre.saint@cieux.com");
        client.setNoTelephone("020202020202");
        client.setAdresse(nouvelleAdresse);

        clientService.updateClient(client);

        Client clientBD = clientRepository.findById(client.getNoClient()).orElse(null);

        Assertions.assertNotNull(clientBD);
        Assertions.assertEquals("Saint", clientBD.getNom());
        Assertions.assertEquals("Pierre", clientBD.getPrenom());
        Assertions.assertEquals("pierre.saint@cieux.com", clientBD.getEmail());
        Assertions.assertEquals("020202020202", clientBD.getNoTelephone());

        Assertions.assertEquals("Rue du Thé",
                clientBD.getAdresse().getRue());
    }

    @Test
        void testModificationClientNonTrouve() {

            Adresse adresse = new Adresse("Rue X", "00000", "Ville X");

            Client client =
                    new Client("Inconnu", "Test", "inconnu@test.fr", adresse);

            client.setNoClient(666666);

            RuntimeException exception = Assertions.assertThrows(
                    RuntimeException.class,
                    () -> clientService.updateClient(client)
            );

            Assertions.assertEquals(
                    "Client non trouvé",
                    exception.getMessage()
            );
        }
}







