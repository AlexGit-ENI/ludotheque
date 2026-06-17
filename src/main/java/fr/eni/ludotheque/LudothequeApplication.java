package fr.eni.ludotheque;

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
            Client c1 = new Client("Jesus", "Christ", "Jesus@mail.com", "6666666666");
            Client c2 = new Client("Watson", "Emma", "Emma@mail.com", "0000000000");
            Client c3 = new Client("Dimitrof", "Alfred", "Dimitrof@mail.com", "1234567890" );



        }
    }
}
