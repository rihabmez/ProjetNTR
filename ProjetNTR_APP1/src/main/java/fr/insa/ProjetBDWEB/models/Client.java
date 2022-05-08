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
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idclient;
    private String nom;
    private String prenom;
    private Integer age;
    private String adresse;
    private Integer numtel;
    private String mail ;
    @OneToOne
    @JsonIgnore
    private Compte compte ;
    //pour pouvoir stocker les ids au lieu d'objet json dans POSTmapping
    @JsonCreator
    public Client(int id) {
        this.idclient= id;
    }
}