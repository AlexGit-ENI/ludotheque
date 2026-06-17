package fr.eni.ludotheque;

import fr.eni.ludotheque.bo.Adresse;
import fr.eni.ludotheque.bo.Client;
import fr.eni.ludotheque.dal.ClientRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class LudothequeApplication {

    public static void main(String[] args) {
        SpringApplication.run(LudothequeApplication.class, args);
    }

    @Bean
    public CommandLineRunner demo(ClientRepository clientDAO) {
        return args -> {

            Adresse a1 = new Adresse("rue des Fleurs", "29710", "Cieux");
            Adresse a2 = new Adresse("rue de la paix", "00666", "Saturn6");
            Adresse a3 = new Adresse("rue de la bière", "05555", "Moe La Ville");


            Client christ = new Client("Jesus", "Christ", "Jesus@mail.com", "6666666666");
            Client emma = new Client("Watson", "Emma", "Emma@mail.com", "0000000000");
            Client alfred = new Client("Dimitrof", "Alfred", "Dimitrof@mail.com", "1234567890" );

            christ.addAdresse(a2);
            emma.addAdresse(a1);
            alfred.addAdresse(a3);



            clientDAO.save();



        };
    }
}
