package fr.insa.ProjetBDWEB.services;


import fr.insa.ProjetBDWEB.models.Client;
import fr.insa.ProjetBDWEB.repositories.ClientRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Data
@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;


    public Client getClient(int id) throws Exception {
        return this.clientRepository.findById(id).orElseThrow(Exception::new);
    }

    public List<Client> getClients(){
        return  clientRepository.findAll();
    }

    public void deleteClient(int id){

        clientRepository.deleteById(id);
    }

    public Client saveClient(Client client){
        Client savedClient = clientRepository.save(client);
        return savedClient;
    }



}
