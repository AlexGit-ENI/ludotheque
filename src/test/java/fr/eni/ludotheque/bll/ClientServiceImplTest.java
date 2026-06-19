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
    private ClientService clientService;

    @Autowired
    private ClientRepository clientRepository;

    @Test
    void testCreationClient() {

        Adresse adresse =
                new Adresse("rue du paradis", "06666", "Cieux");

        Client client =
                new Client("Jesus", "Christ",
                        "christ.jesus@cieux.com",
                        adresse);

        client.setNoTelephone("06666666");

        clientService.ajouterClient(client);

        Client clientBD =
                clientRepository.findById(client.getNoClient())
                        .orElse(null);

        Assertions.assertNotNull(clientBD);
        Assertions.assertEquals("Jesus", clientBD.getNom());
        Assertions.assertEquals("Christ", clientBD.getPrenom());
    }

    @Test
    void testModificationAdresse() {

        Adresse ancienne =
                new Adresse("rue du pinard",
                        "01234",
                        "Bordeaux");

        Client client =
                new Client("Pokora",
                        "Matt",
                        "matt.po@mail.com",
                        ancienne);

        client.setNoTelephone("01234");

        clientService.ajouterClient(client);

        Adresse nouvelleAdresse =
                new Adresse("Rue du Soleil",
                        "75000",
                        "Paris");

        clientService.updateAdresse(
                client.getNoClient(),
                nouvelleAdresse);

        Client clientBD =
                clientRepository.findById(client.getNoClient())
                        .orElse(null);

        Assertions.assertNotNull(clientBD);

        Assertions.assertEquals(
                "Rue du Soleil",
                clientBD.getAdresse().getRue());
    }

    @Test
    void testModificationAdresseClientInexistant() {

        Adresse adresse =
                new Adresse("Rue X",
                        "00000",
                        "Ville X");

        RuntimeException exception =
                Assertions.assertThrows(
                        RuntimeException.class,
                        () -> clientService.updateAdresse(
                                999999,
                                adresse));

        Assertions.assertEquals(
                "Client non trouvé",
                exception.getMessage());
    }
}