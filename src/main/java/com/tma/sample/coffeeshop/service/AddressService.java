package com.tma.sample.coffeeshop.service;

import com.tma.sample.coffeeshop.dto.AddressDTO;
import com.tma.sample.coffeeshop.dto.AddressViewDTO;
import com.tma.sample.coffeeshop.model.Address;

import java.util.List;

public interface AddressService {

    List<AddressViewDTO> getAllAddressesOfCustomer(long customerId);

    List<AddressViewDTO> getAllAddressesOfStore(long storeId);

    AddressViewDTO getOne(long addressId);
    Address save(AddressDTO addressDTO);
    Address edit(long addressId,AddressDTO addressDTO);
    void delete(long addressId);

}
