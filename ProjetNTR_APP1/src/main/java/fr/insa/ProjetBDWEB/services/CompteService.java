package fr.insa.ProjetBDWEB.services;

import fr.insa.ProjetBDWEB.models.Client;
import fr.insa.ProjetBDWEB.models.Compte;
import fr.insa.ProjetBDWEB.repositories.CompteRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Data
@Service
public class CompteService {

    @Autowired
    private CompteRepository compteRepository;

    public Compte getCompte(int id) throws Exception {
        return this.compteRepository.findById(id).orElseThrow(Exception::new);
    }

    public List<Compte> getComptes(){
        return  compteRepository.findAll();
    }

    public void deleteCompte(int id){

        compteRepository.deleteById(id);
    }

    public Compte saveCompte(Compte Compte){
        Compte savedCompte = compteRepository.save(Compte);
        return savedCompte;
    }
}
