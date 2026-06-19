package fr.eni.ludotheque.bll;

import fr.eni.ludotheque.bo.Location;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
    public class LocationServiceTest {

    @Autowired
    private LocationService locationService;

    @Test
    public void ajouterLocationExemplaire() {

        //Location Exemplaire ;
        Location l1 = new Location(1, 19/ 6 /2026, 21/06/2026, 5.5f);
        Location l2 = new Location(2, 22/ 6 /2026, 25/06/2026, 4.2f );
        Location l3 = new Location(3, 30/ 6 /2026, 02/07/2026, 4.8f );
    }
}
