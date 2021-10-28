package com.tma.sample.coffeeshop.service;

import com.tma.sample.coffeeshop.dto.AddressDTO;
import com.tma.sample.coffeeshop.dto.AddressViewDTO;
import com.tma.sample.coffeeshop.model.Address;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;

import java.util.List;

public interface AddressService {

    //testing
    Page<AddressViewDTO> getAllAddressesWithPaging(Pageable pageable);
    Slice<AddressViewDTO> getAllAddressesWithSlice(Pageable pageable);

    Page<AddressViewDTO> getAllAddressesOfCustomer(long customerId,Pageable pageable);
    Page<AddressViewDTO> getAllAddressesOfStore(long storeId,Pageable pageable);

    AddressViewDTO getOne(long addressId);
    Address save(AddressDTO addressDTO);
    boolean edit(long addressId,AddressDTO addressDTO);
    void delete(long addressId);

}
