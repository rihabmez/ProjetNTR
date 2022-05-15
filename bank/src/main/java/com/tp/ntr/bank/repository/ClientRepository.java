package com.tp.ntr.bank.repository;

import com.tp.ntr.bank.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client,Long> {
}
