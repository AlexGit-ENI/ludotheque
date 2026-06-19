package fr.eni.ludotheque.dal;

import fr.eni.ludotheque.bo.Adresse;
import fr.eni.ludotheque.bo.Client;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ClientRepositoryTest {

    @Autowired
    private ClientRepository clientRepository;

    @Test
    @DisplayName("Création d'un client")
    void testCreationClient() {

        Adresse adresse =
                new Adresse("Rue du Paradis",
                        "06666",
                        "Cieux");

        Client client =
                new Client("Jesus",
                        "Christ",
                        "jesus.christ@cieux.com",
                        adresse);

        client.setNoTelephone("0666666666");

        clientRepository.save(client);

        Client clientBD =
                clientRepository.findById(client.getNoClient())
                        .orElse(null);

        Assertions.assertNotNull(clientBD);
        Assertions.assertEquals("Jesus", clientBD.getNom());
        Assertions.assertEquals("Christ", clientBD.getPrenom());
    }

    @Test
    @DisplayName("Recherche par nom")
    void testFindByNom() {

        Adresse adresse =
                new Adresse("Rue Test",
                        "11111",
                        "Paris");

        Client client =
                new Client("Martin",
                        "Paul",
                        "paul.martin@test.fr",
                        adresse);
        client.setNoTelephone("0659888888");


        clientRepository.save(client);

        Assertions.assertFalse(
                clientRepository.findByNom("Martin")
                        .isEmpty());
    }
}