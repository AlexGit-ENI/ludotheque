package fr.eni.ludotheque.rest;

import fr.eni.ludotheque.Exeption.ClientNotFoundException;
import fr.eni.ludotheque.bll.ClientService;
import fr.eni.ludotheque.bo.Client;
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

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteClient(@PathVariable Integer id) {
        try {
            ClientService.deleteClient(id);
            return ResponseEntity.ok("success");
        } catch (ClientNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Client not found");
        }
    }
}