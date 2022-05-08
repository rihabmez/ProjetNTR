package fr.insa.ProjetBDWEB.ressources;


import fr.insa.ProjetBDWEB.models.Client;
import fr.insa.ProjetBDWEB.repositories.ClientRepository;
import fr.insa.ProjetBDWEB.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("clients")
public class ClientRessource {
    @Autowired
    private ClientService clientService;
    @Autowired
    private ClientRepository clientRepository;
     @GetMapping()
     public List<Client> getClients(){
         return this.clientService.getClients();
     }

    @GetMapping("{id}")
    public Client getClient(@PathVariable("id") int id) throws Exception {
        return clientService.getClient(id);
    }

    @DeleteMapping("{id}")
    public ResponseEntity deleteClient(@PathVariable("id") int id) {
        clientService.deleteClient(id);
        return ResponseEntity.ok().build();
    }

    @PostMapping
    public ResponseEntity<Client> createClient(@RequestBody Client client) {
        try {
            Client _client = clientRepository
                    .save(new Client(client.getIdclient(),client.getNom(),client.getPrenom(), client.getAge(), client.getAdresse(), client.getNumtel(),client.getMail(),client.getCompte()));
            return new ResponseEntity<>(_client, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
