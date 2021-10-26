package com.tma.sample.coffeeshop.unittest.controller.admin;

import com.tma.sample.coffeeshop.dto.AddressDTO;
import com.tma.sample.coffeeshop.dto.AddressViewDTO;
import com.tma.sample.coffeeshop.model.Address;
import com.tma.sample.coffeeshop.unittest.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping({"/admin/addresses"})
public class AddressRestController {
    @Autowired
    private AddressService addressService;

    @GetMapping("/{addressId}")
    public AddressViewDTO getAddressbyId(@PathVariable long addressId){
        return addressService.getOne(addressId);
    }

    @GetMapping("/customer/{customerId}")
    public List<AddressViewDTO> getAllAddressesOfCustomer(@PathVariable long customerId){
        return addressService.getAllAddressesOfCustomer(customerId);
    }

    @GetMapping("/store/{storeId}")
    public List<AddressViewDTO> getAllAddressesOfStore(@PathVariable long storeId){
        return addressService.getAllAddressesOfStore(storeId);
    }

    @PostMapping
    public Address addAddress(@RequestBody AddressDTO addressDTO){
        return addressService.save(addressDTO);
    }

    @PutMapping("/{addressId}")
    public boolean editAddress(@PathVariable long addressId,
                               @RequestBody AddressDTO addressDTO){
        addressService.edit(addressId,addressDTO);
        return true;
    }

    @DeleteMapping("/{addressId}")
    public void deleteAddress(@PathVariable long addressId){
         addressService.delete(addressId);
    }

}
