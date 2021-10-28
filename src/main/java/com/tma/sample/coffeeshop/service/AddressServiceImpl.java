package com.tma.sample.coffeeshop.service;

import com.tma.sample.coffeeshop.dto.AddressDTO;
import com.tma.sample.coffeeshop.dto.AddressViewDTO;
import com.tma.sample.coffeeshop.exception.ResourceNotFoundException;
import com.tma.sample.coffeeshop.mapper.AddressMapper;
import com.tma.sample.coffeeshop.model.Address;
import com.tma.sample.coffeeshop.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service

public class AddressServiceImpl implements AddressService {

    @Autowired
    AddressRepository addressRepository;

    private final AddressMapper addressMapper;


    public AddressServiceImpl(AddressMapper addressMapper) {
        this.addressMapper = addressMapper;
    }

    @Override
    public Page<AddressViewDTO> getAllAddressesOfCustomer(long customerId,Pageable pageable) {
        return addressRepository.findByCustomerId(customerId, pageable).map(address -> addressMapper.map(address));
    }

    @Override
    public Page<AddressViewDTO> getAllAddressesOfStore(long storeId, Pageable pageable) {
        return addressRepository.findByStoreId(storeId, pageable).map(address -> addressMapper.map(address));
    }

    @Override
    public Page<AddressViewDTO> getAllAddressesWithPaging(Pageable pageable) {
        return addressRepository.findAll(pageable).map(address -> addressMapper.map(address));
    }

    //TODO: delete after Test
    @Override
    public Slice<AddressViewDTO> getAllAddressesWithSlice(Pageable pageable) {
        return addressRepository.findAll(pageable).map(address -> addressMapper.map(address));
    }


    @Override
    public AddressViewDTO getOne(long addressId) {
        Address address = checkNullAddressById(addressId);
        return addressMapper.map(address);
    }

    @Override
    public Address save(AddressDTO addressDTO) {
        Address address = addressMapper.map(addressDTO);
        addressRepository.save(address);
        return address;
    }

    @Override
    public boolean edit(long addressId, AddressDTO addressDTO) {
        //check if null
        checkNullAddressById(addressId);
        //set address and save
        Address address = addressMapper.map(addressDTO);
        address.setId(addressId);
        addressRepository.save(address);
        return true;
    }

    @Override
    public void delete(long addressId) {
        checkNullAddressById(addressId);
        addressRepository.deleteById(addressId);
    }

    public Address checkNullAddressById(long addressId){
        return addressRepository
                .findById(addressId).orElseThrow(() -> new ResourceNotFoundException("not found address with Id=" + addressId));
    }
}
