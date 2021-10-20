package com.tma.sample.coffeeshop.restController;

import com.tma.sample.coffeeshop.dto.AddressDTO;
import com.tma.sample.coffeeshop.dto.AddressViewDTO;
import com.tma.sample.coffeeshop.model.Address;
import com.tma.sample.coffeeshop.service.AddressService;
import com.tma.sample.coffeeshop.service.AddressServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class AddressRestController {
    @Autowired
    private AddressService addressService;

    @GetMapping("/{customerId}/addresses")
    public List<AddressViewDTO> getAllAddressesOfCustomer(@PathVariable("customerId") long customerId){
        return addressService.getAllAddressesOfCustomer(customerId);
    }

    @PostMapping("/address")
    public Address addAddress(AddressDTO addressDTO){
        return addressService.save(addressDTO);
    }

    @PutMapping("/address/{addressId}")
    public Address addAddress(@PathVariable("addressId") long addressId,
                              AddressDTO addressDTO){
        return addressService.edit(addressId,addressDTO);
    }

    @DeleteMapping("/address/{addressId}")
    public boolean deleteAddress(@PathVariable("addressId") long addressId){
        return addressService.delete(addressId);
    }


}
