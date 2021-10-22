package com.tma.sample.coffeeshop.controller.admin;

import com.tma.sample.coffeeshop.dto.AddressDTO;
import com.tma.sample.coffeeshop.dto.AddressViewDTO;
import com.tma.sample.coffeeshop.model.Address;
import com.tma.sample.coffeeshop.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping({"/admin/addresses"})
public class AddressRestController {
    @Autowired
    private AddressService addressService;

    @GetMapping("/{customerId}")
    public List<AddressViewDTO> getAllAddressesOfCustomer(@PathVariable long customerId){
        return addressService.getAllAddressesOfCustomer(customerId);
    }

    @PostMapping
    public Address addAddress(AddressDTO addressDTO){
        return addressService.save(addressDTO);
    }

    @PutMapping("/{addressId}")
    public Address editAddress(@PathVariable long addressId,
                              AddressDTO addressDTO){
        return addressService.edit(addressId,addressDTO);
    }

    @DeleteMapping("/{addressId}")
    public void deleteAddress(@PathVariable long addressId){
         addressService.delete(addressId);
    }

}