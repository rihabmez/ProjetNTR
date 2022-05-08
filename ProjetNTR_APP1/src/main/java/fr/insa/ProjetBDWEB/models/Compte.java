package fr.insa.ProjetBDWEB.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Compte {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idcompte;
    private String iban;
    @OneToOne
    @JsonIgnore
    private Client client;
    @OneToMany(mappedBy = "comptebenef")
    @JsonIgnore
    private List<Transaction> transactions;
    private Integer solde;

    //pour pouvoir stocker les ids au lieu d'objet json dans POSTmapping
    @JsonCreator
    public Compte(int id) {
        this.idcompte = id;
    }

}
