package com.tp.ntr.bank.service;

import com.tp.ntr.bank.model.Address;
import com.tp.ntr.bank.model.Client;
import com.tp.ntr.bank.model.Operation;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface OperationService {
    Operation addOperation(Operation operation);
    Operation deleteOperation(Long id);
    Operation updateOperation(Long idOldOperation, Client newOperation);
    Operation findOperationById(Long id);
    List<Operation> findAllOperation();
}
