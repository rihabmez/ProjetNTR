package fr.insa.ProjetBDWEB.repositories;

import fr.insa.ProjetBDWEB.models.Compte;
import fr.insa.ProjetBDWEB.models.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;
import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Integer> {
    public Transaction findByIdtransaction(Integer idtransaction);
    public List<Transaction> findByType(String type);
    public List<Transaction> findByDate(Date date);
    public List<Transaction> findByComptebenef(Compte comptebenef);
    public List<Transaction> findByMontant(Integer montant);


}
