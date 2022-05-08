package fr.insa.ProjetBDWEB.repositories;

import fr.insa.ProjetBDWEB.models.Client;
import fr.insa.ProjetBDWEB.models.Compte;
import fr.insa.ProjetBDWEB.models.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompteRepository extends JpaRepository<Compte, Integer> {
    public Compte findByIban(String iban);
    public Compte findByIdcompte(Integer idcompte);
    public Compte findByClient(Client client);
    public List<Compte> findBySolde(Integer solde);
    public List<Compte> findByTransactions(Transaction transactions);
}
