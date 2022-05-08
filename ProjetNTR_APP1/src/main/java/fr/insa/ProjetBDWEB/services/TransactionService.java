package fr.insa.ProjetBDWEB.services;

import fr.insa.ProjetBDWEB.models.Client;
import fr.insa.ProjetBDWEB.models.Transaction;
import fr.insa.ProjetBDWEB.repositories.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class TransactionService {
    @Autowired
    private TransactionRepository transactionRepository;

    public Transaction getTransaction(int id) throws Exception {
        return this.transactionRepository.findById(id).orElseThrow(Exception::new);
    }

    public List<Transaction> getTransactions(){
        return  transactionRepository.findAll();
    }

    public void deleteTransaction(int id){

        transactionRepository.deleteById(id);
    }

    public Transaction saveTransaction(Transaction Transaction){
        Transaction savedTransaction = transactionRepository.save(Transaction);
        return savedTransaction;
    }

}
