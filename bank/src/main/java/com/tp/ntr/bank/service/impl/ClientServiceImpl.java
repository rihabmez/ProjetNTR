package com.tp.ntr.bank.service.impl;

import com.tp.ntr.bank.model.Address;
import com.tp.ntr.bank.model.Client;
import com.tp.ntr.bank.model.Operation;
import com.tp.ntr.bank.repository.AddressRepository;
import com.tp.ntr.bank.repository.ClientRepository;
import com.tp.ntr.bank.repository.OperationRepository;
import com.tp.ntr.bank.service.ClientService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ClientServiceImpl implements ClientService {
    private final ClientRepository clientRepository;


    @Override
    public List<Long> findAllIDs() {
        return clientRepository.findAll().stream().map(client -> client.getId()).collect(Collectors.toList());
    }

    @Override
    public Client addClient(Client client) {
        return clientRepository.save(client);
    }

    @Override
    public void deleteClient(Long id) {
        clientRepository.deleteById(id);
    }

    @Override
    public Client updateClient(Client client) {
        Client oldClient = clientRepository.findById(client.getId()).get();
        oldClient.setAddress(client.getAddress());
        oldClient.setBalance(client.getBalance());
        oldClient.setEmail(client.getEmail());
        oldClient.setFirstName(client.getFirstName());
        oldClient.setLastName(client.getLastName());
        oldClient.setOperations(client.getOperations());
        return clientRepository.save(oldClient);
    }

    @Override
    public Client findClientById(Long id) {
        return clientRepository.findById(id).get();
    }

    @Override
    public List<Client> findAllClient() {
        return clientRepository.findAll();
    }

    @Override
    public void deleteOperation(Long idClient, Long idOperation) {
        Client client = clientRepository.findById(idClient).get();
        client.getOperations().removeIf(op -> op.getId() == idOperation);
        clientRepository.save(client);
    }

    @Override
    public void addOperation(Long idClient, Operation operation) {
        Client client = clientRepository.findById(idClient).get();
        client.getOperations().add(operation);
        clientRepository.save(client);
    }

    @Override
    public List<Operation> findAllOperations(Long id) {
        return clientRepository.findById(id).get().getOperations();
    }

    @Override
    public Address getAddress(Long id) {
        return clientRepository.findById(id).get().getAddress();
    }
}
