package fr.eni.ludotheque.dal;

import fr.eni.ludotheque.bo.Adresse;
import fr.eni.ludotheque.bo.Client;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class ClientRepositoryTest {
    @Autowired
    private ClientRepository clientRepository;

    @Test
    @DisplayName("test positif de creation d'un client en BD")
    @Transactional
    public void testCreationClient() {
        //Arrange
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

        List<Client> findByOrderByNom();

        @Query("select c FROM Client WHERE c.nom = Jesus")
        Client findByNom((@Param("Jesus")String nom);

    }
//    public interface ClientRepository extends JpaRepository<Client, Integer> {
//        List<Client> findByNom(String nom);
//        Client findByNomWithJPQL(@Param("nom") String nom);

}






