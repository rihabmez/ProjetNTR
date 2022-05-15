package com.tp.ntr.bank.service;

import com.tp.ntr.bank.model.Address;
import com.tp.ntr.bank.model.Client;
import com.tp.ntr.bank.model.Operation;

import java.util.List;

public interface ClientService {
    List<Long> findAllIDs();
    Client addClient(Client client);
    void deleteClient(Long id);
    Client updateClient(Client client);
    Client findClientById(Long id);
    List<Client> findAllClient();
    void deleteOperation(Long idClient, Long idOperation);
    void addOperation(Long idClient, Operation operation);
    List<Operation> findAllOperations(Long id);
    Address getAddress(Long id);
}
