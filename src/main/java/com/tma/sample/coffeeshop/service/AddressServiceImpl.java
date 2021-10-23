package com.tma.sample.coffeeshop.service;

import com.tma.sample.coffeeshop.dto.AddressDTO;
import com.tma.sample.coffeeshop.dto.AddressViewDTO;
import com.tma.sample.coffeeshop.exception.ResourceNotFoundException;
import com.tma.sample.coffeeshop.mapper.AddressMapper;
import com.tma.sample.coffeeshop.model.Address;
import com.tma.sample.coffeeshop.repository.AddressRepository;
import lombok.extern.log4j.Log4j2;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Log4j2
public class AddressServiceImpl implements AddressService {

    @Autowired
    AddressRepository addressRepository;

    private final AddressMapper addressMapper;

    public AddressServiceImpl(AddressMapper addressMapper) {
        this.addressMapper = addressMapper;
    }

    @Override
    public List<AddressViewDTO> getAllAddressesOfCustomer(long customerId) {
        return addressRepository.findByCustomerId(customerId).stream().map(addressMapper::map)
                .collect(Collectors.toList());
    }

    @Override
    public List<AddressViewDTO> getAllAddressesOfStore(long storeId) {
        return addressRepository.findByStoreId(storeId).stream().map(addressMapper::map)
                .collect(Collectors.toList());
    }

    @Override
    public AddressViewDTO getOne(long addressId) {
        Address address = addressRepository
                .findById(addressId).orElseThrow(() -> new ResourceNotFoundException("not found address with Id=" + addressId));
        return addressMapper.map(address);
    }

    @Override
    public Address save(AddressDTO addressDTO) {
        Address address = addressMapper.map(addressDTO);
        addressRepository.save(address);
        return address;
    }

    @Override
    public Address edit(long addressId, AddressDTO addressDTO) {
        //check if null
        addressRepository.findById(addressId).orElseThrow(() -> new ResourceNotFoundException("not found address with Id=" + addressId));
        Address address = addressMapper.map(addressDTO);
        address.setId(addressId);
        return addressRepository.save(address);
    }

    @Override
    public void delete(long addressId) {
        addressRepository.deleteById(addressId);
    }
}
