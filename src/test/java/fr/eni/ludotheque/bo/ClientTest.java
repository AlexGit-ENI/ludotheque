package fr.eni.ludotheque.bo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ClientTest {

    @Test
    @DisplayName("test de creation client - cas droit")
    //Test JUnit
    public void testCreationClient() {
        Adresse adresse = new Adresse("rue du paradis", "06666", "Cieux");
        Client client = new Client("Jesus", "Christ", "jesus.christ@cieux.com", adresse);
        client.setNoTelephone("0666666666");
        Assertions.assertNotNull(client);
        Assertions.assertEquals("0666666666", client.getNoTelephone());
        Assertions.assertEquals("Jesus", client.getNom());
        Assertions.assertEquals("Christ", client.getPrenom());
        Assertions.assertEquals("jesus.christ@cieux.com", client.getEmail());
        Assertions.assertEquals(adresse, client.getAdresse());
    }

}
