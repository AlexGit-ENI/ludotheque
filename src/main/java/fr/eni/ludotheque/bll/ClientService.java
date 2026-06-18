package fr.eni.ludotheque.bll;

import fr.eni.ludotheque.bo.Client;

import java.util.List;

public interface ClientService {

    void ajouterClient(Client client);

    List<Client> findClientByNom(String nom);
}
