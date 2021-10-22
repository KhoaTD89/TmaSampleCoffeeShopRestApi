package com.tma.sample.coffeeshop.service;

import com.tma.sample.coffeeshop.dto.AddressDTO;
import com.tma.sample.coffeeshop.dto.AddressViewDTO;
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
public class AddressServiceImpl implements AddressService{

    @Autowired
    AddressRepository addressRepository;

    private final AddressMapper addressMapper;

    public AddressServiceImpl(AddressMapper addressMapper) {
        this.addressMapper = addressMapper;
    }

    @Override
    public List<AddressViewDTO> getAllAddressesOfCustomer(long customerId) {
        List<Address> addresses = addressRepository.findByCustomerId(customerId);
        List<AddressViewDTO> addressViewDTOS = addresses.stream().map(address -> addressMapper.map(address))
                .collect(Collectors.toList());

        return addressViewDTOS;
    }

    @Override
    public List<AddressViewDTO> getAllAddressesOfStore() {
        return null;
    }

    @Override
    public AddressViewDTO getOne(long addressId) {
        return null;
    }

    @Override
    public Address save(AddressDTO addressDTO) {
        Address address = addressMapper.map(addressDTO);
        addressRepository.save(address);
        return address;
    }

    @Override
    public Address edit(long addressId, AddressDTO addressDTO) {
        try {
            Address address = addressRepository.findById(addressId).orElse(null);
            if (address != null) {
                address = addressMapper.map(addressDTO);
            } else {
//                LOGGER.error("null object");
            }
            address.setId(addressId);
            return addressRepository.save(address);

        }catch(Exception e ){
            log.error("Address is not found",e);
            return null;
        }
    }

    @Override
    public void delete(long addressId) {
        addressRepository.deleteById(addressId);
    }
}
