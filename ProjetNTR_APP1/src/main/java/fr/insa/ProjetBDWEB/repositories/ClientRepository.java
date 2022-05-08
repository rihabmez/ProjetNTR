package fr.insa.ProjetBDWEB.repositories;

import fr.insa.ProjetBDWEB.models.Client;
import fr.insa.ProjetBDWEB.models.Compte;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientRepository extends JpaRepository<Client, Integer> {
    public List<Client> findByNom(String nom) ;
    public List<Client> findByAge(String age);
    public List<Client> findByPrenom(String prenom);
    public List<Client> findByAdresse(String adresse);
    public List<Client> findByNumtel(String numtel);
    public List<Client> findByMail(String mail);
    public List<Client> findByCompte(Compte compte);




}