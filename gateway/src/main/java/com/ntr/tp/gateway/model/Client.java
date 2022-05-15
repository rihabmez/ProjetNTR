package com.ntr.tp.gateway.model;

import java.util.List;


public class Client {

    private Long id;
    private String firstName;
    private String lastName;
    private Float balance;
    private String email;
    private Address address;
    private List<Operation> operations;
}
