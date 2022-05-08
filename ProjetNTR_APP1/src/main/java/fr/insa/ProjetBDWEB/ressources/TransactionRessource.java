package fr.insa.ProjetBDWEB.ressources;


import fr.insa.ProjetBDWEB.models.Transaction;
import fr.insa.ProjetBDWEB.repositories.TransactionRepository;
import fr.insa.ProjetBDWEB.services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("transactions")
public class TransactionRessource {
    @Autowired
    private TransactionService transactionService;
    @Autowired
    private TransactionRepository transactionRepository;
    @GetMapping()
    public List<Transaction> gettransactions(){
        return transactionService.getTransactions();
    }

    @GetMapping("{id}")
    public Transaction getTransaction(@PathVariable("id") int id) throws Exception {
        return transactionService.getTransaction(id);
    }
    @DeleteMapping("{id}")
    public ResponseEntity deleteTransaction(@PathVariable("id") int id) {
        transactionService.deleteTransaction(id);
        return ResponseEntity.ok().build();
    }
    @PostMapping
    public ResponseEntity<Transaction> createTransaction(@RequestBody Transaction transaction) {
        try {
            Transaction _transaction = transactionRepository
                    .save(new Transaction(transaction.getIdtransaction(),transaction.getType(),transaction.getDate(),transaction.getComptebenef(),transaction.getMontant()));
            return new ResponseEntity<>(_transaction, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
