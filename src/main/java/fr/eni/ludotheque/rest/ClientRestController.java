package fr.eni.ludotheque.rest;

import fr.eni.ludotheque.Exeption.ClientNotFoundException;
import fr.eni.ludotheque.bll.ClientService;
import fr.eni.ludotheque.bo.Client;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/clients")
public class ClientRestController {

    private final ClientService clientService;

    public ClientRestController(ClientService clientService) {
        this.clientService = clientService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void ajouterClient(@RequestBody Client client) {
        clientService.ajouterClient(client);
    }

    @DeleteMapping("/{id}/client")
    public ResponseEntity<String> deleteClient(@PathVariable Integer id) {
        try {
            ClientService.deleteClient(id);
            return ResponseEntity.ok("success");
        } catch (ClientNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Client not found");
        }
    }

    @PutMapping("/{id}/client")
    public ResponseEntity<Client> updateClient(
            @PathVariable Integer id,
            @Valid @RequestBody Client client) {
        try {
            client.setNoClient(id);
            Client updatedClient = clientService.updateClient(client);
            return ResponseEntity.ok(updatedClient);
        } catch (ClientNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
    //Modification partiel d'une information : Adresse
    @PatchMapping("/{id}/adresse")
    public ResponseEntity<Client> updateClientAdresse(
            @PathVariable Integer id,
            @RequestBody Client client) {
        try {
            Client updatedClient =
                    clientService.updateAdresse(id, client.getAdresse());
            return ResponseEntity.ok(updatedClient);
        } catch (ClientNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}