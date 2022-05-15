package com.tp.ntr.bank.controller;

import com.tp.ntr.bank.model.Address;
import com.tp.ntr.bank.model.Client;
import com.tp.ntr.bank.model.Operation;
import com.tp.ntr.bank.service.ClientService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/client")
@AllArgsConstructor
@CrossOrigin
public class ClientController {
    private final ClientService clientService;

    @PostMapping("/")
    public ResponseEntity<Client> addClient(@RequestBody Client client){
        return new ResponseEntity(clientService.addClient(client),HttpStatus.ACCEPTED);
    }

    @GetMapping("/")
    public ResponseEntity<List<Client>> allClient(){
        return new ResponseEntity(clientService.findAllClient(),HttpStatus.ACCEPTED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Client> addClient(@PathVariable Long id){
        return new ResponseEntity(clientService.findClientById(id),HttpStatus.ACCEPTED);
    }

    @PutMapping("/")
    public ResponseEntity<Client> updateClient(@RequestBody Client client){
        return new ResponseEntity(clientService.updateClient(client),HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteClient(@PathVariable Long id){
        clientService.deleteClient(id);
        return new ResponseEntity(HttpStatus.ACCEPTED);
    }

    @GetMapping("/operation/{id}")
    public ResponseEntity<List<Operation>> getOperations(@PathVariable Long id){
        return new ResponseEntity(clientService.findAllOperations(id),HttpStatus.ACCEPTED);
    }

    @GetMapping("/address/{id}")
    public ResponseEntity<Address> getAddress(@PathVariable Long id){
        return new ResponseEntity(clientService.getAddress(id),HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/operation")
    public ResponseEntity<?> deleteOperation(@RequestParam Long client,@RequestParam Long operation){
        clientService.deleteOperation(client,operation);
        return new ResponseEntity(HttpStatus.ACCEPTED);
    }

    @PostMapping("/operation/{id}")
    public ResponseEntity<Client> addOperation(@PathVariable Long id, @RequestBody Operation operation){
        clientService.addOperation(id,operation);
        return new ResponseEntity(clientService.findClientById(id),HttpStatus.ACCEPTED);
    }

    @GetMapping("ids")
    public ResponseEntity<List<Long>> findAllIDs(){
        return new ResponseEntity(clientService.findAllIDs(),HttpStatus.ACCEPTED);
    }
}
