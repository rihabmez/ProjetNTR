package com.tp.ntr.bank.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Client {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String firstName;
    private String lastName;
    private Float balance;
    private String email;
    @OneToOne(cascade = CascadeType.ALL)
    private Address address;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Operation> operations;
}
