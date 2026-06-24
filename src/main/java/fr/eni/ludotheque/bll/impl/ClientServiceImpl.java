package fr.eni.ludotheque.bll.impl;

import fr.eni.ludotheque.bll.ClientService;
import fr.eni.ludotheque.bo.Adresse;
import fr.eni.ludotheque.bo.Client;
import fr.eni.ludotheque.dal.ClientRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientServiceImpl implements ClientService {

    private final ClientRepository clientRepository;

    public ClientServiceImpl(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public void ajouterClient(Client client) {
        clientRepository.save(client);
    }

    @Override
    public List<Client> findClientByNom(String nom) {
        return clientRepository.findByNom(nom);
    }

    @Override
    public Client updateClient(Client client) {

        Client clientExistant = clientRepository.findById(client.getNoClient())
                .orElseThrow(() -> new RuntimeException("Client non trouvé"));

        clientExistant.setNom(client.getNom());
        clientExistant.setPrenom(client.getPrenom());
        clientExistant.setEmail(client.getEmail());
        clientExistant.setNoTelephone(client.getNoTelephone());
        clientExistant.setAdresse(client.getAdresse());

        return clientRepository.save(clientExistant);
    }

    @Override
    public Client updateAdresse(int noClient, String adresse) {

        Client client = clientRepository.findById(noClient)
                .orElseThrow(() -> new RuntimeException("Client non trouvé"));

        client.setAdresse(new Adresse());

        return clientRepository.save(client);
    }
}