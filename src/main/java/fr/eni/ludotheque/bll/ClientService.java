package fr.eni.ludotheque.bll;

import fr.eni.ludotheque.bo.Adresse;
import fr.eni.ludotheque.bo.Client;

import java.util.List;

public interface ClientService {

    void ajouterClient(Client client);

    List<Client> findClientByNom(String nom);

    Client updateClient(Client client);

    Client updateAdresse(int noClient, Adresse adresse);
}