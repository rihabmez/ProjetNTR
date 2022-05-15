package com.tp.ntr.bank.service;

import com.tp.ntr.bank.model.Address;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AddressService {
    Address addAddress(Address address);
    void deleteAddress(Long id);
    Address updateAddress(Address address);
    Address findAddressById(Long id);
    List<Address> findAllAddress();
}
