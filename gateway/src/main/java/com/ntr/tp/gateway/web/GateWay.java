package com.ntr.tp.gateway.web;

import com.ntr.tp.gateway.http.ClientService;
import com.ntr.tp.gateway.model.Address;
import com.ntr.tp.gateway.model.Client;
import com.ntr.tp.gateway.model.Operation;
import lombok.AllArgsConstructor;
import org.json.simple.parser.ParseException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

@RestController
@RequestMapping("/gateway")
@AllArgsConstructor
@CrossOrigin
public class GateWay {

    private ClientService clientService;

    @PostMapping("/")
    public ResponseEntity<Client> addClient(@RequestBody Client client){
        return new ResponseEntity(clientService, HttpStatus.ACCEPTED);
    }

    @GetMapping("/")
    public ResponseEntity<List<Client>> allClient() throws IOException, ParseException {
        clientService.setUrl(new URL("http://localhost:1337/client/"));
        return new ResponseEntity(clientService.sendGET(null,List.class),HttpStatus.ACCEPTED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Client> addClient(@PathVariable Long id) throws IOException, ParseException {
        clientService.setUrl(new URL("http://localhost:1337/client/" + id.toString()));
        return new ResponseEntity(clientService.sendGET(null,Client.class),HttpStatus.ACCEPTED);
    }

    @PutMapping("/")
    public ResponseEntity<Client> updateClient(@RequestBody Client client){
        return new ResponseEntity(clientService,HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteClient(@PathVariable Long id){

        return new ResponseEntity(HttpStatus.ACCEPTED);
    }

    @GetMapping("/operation/{id}")
    public ResponseEntity<List<Operation>> getOperations(@PathVariable Long id) throws IOException, ParseException {
        clientService.setUrl(new URL("http://localhost:1337/client/operation/" + id.toString()));
        return new ResponseEntity(clientService.sendGET(null,List.class),HttpStatus.ACCEPTED);
    }

    @GetMapping("/address/{id}")
    public ResponseEntity<Address> getAddress(@PathVariable Long id) throws IOException, ParseException {
        clientService.setUrl(new URL("http://localhost:1337/client/address/" + id.toString()));
        return new ResponseEntity(clientService.sendGET(null,Address.class),HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/operation")
    public ResponseEntity<?> deleteOperation(@RequestParam Long client,@RequestParam Long operation){

        return new ResponseEntity(HttpStatus.ACCEPTED);
    }

    @PostMapping("/operation/{id}")
    public ResponseEntity<Client> addOperation(@PathVariable Long id, @RequestBody Operation operation){

        return new ResponseEntity(HttpStatus.ACCEPTED);
    }

    @GetMapping("ids")
    public ResponseEntity<List<Long>> findAllIDs() throws IOException, ParseException {
        clientService.setUrl(new URL("http://localhost:1337/client/ids"));
        return new ResponseEntity(clientService.sendGET(null,List.class),HttpStatus.ACCEPTED);
    }
}
