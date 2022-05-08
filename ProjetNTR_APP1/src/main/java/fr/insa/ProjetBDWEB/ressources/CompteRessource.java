package fr.insa.ProjetBDWEB.ressources;

import fr.insa.ProjetBDWEB.models.Compte;
import fr.insa.ProjetBDWEB.repositories.CompteRepository;
import fr.insa.ProjetBDWEB.services.CompteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("comptes")
public class CompteRessource {
    @Autowired
    private CompteService compteService;
    @Autowired
    private CompteRepository compteRepository;


    @GetMapping()
    public List
            <Compte> getComptes(){
        return compteService.getComptes();
    }

    @GetMapping("{id}")
    public Compte getCompte(@PathVariable("id") int id) throws Exception {
        return compteService.getCompte(id);
    }
    @DeleteMapping("{id}")
    public ResponseEntity deleteCompte(@PathVariable("id") int id) {
        compteService.deleteCompte(id);
        return ResponseEntity.ok().build();
    }
    @PostMapping
    public ResponseEntity<Compte> createCompte(@RequestBody Compte compte) {
        //CALCULE IBAN
       /* String codeagence= agenceService.getCodeagence();
        String codebanque= "54678";
        String ibancalcule = "FR76"+codebanque+ 15*codeagence +"10313400399 49" ;
        compte.setIban(ibancalcule);
      */

        try {
            Compte _compte = compteRepository
                    .save(new Compte(compte.getIdcompte(),compte.getIban(), compte.getClient(), compte.getTransactions(), compte.getSolde()));
            return new ResponseEntity<>(_compte, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
