package com.tp.ntr.bank.repository;

import com.tp.ntr.bank.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {
}
