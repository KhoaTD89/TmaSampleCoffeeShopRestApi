package com.tma.sample.coffeeshop.controller.admin;

import com.tma.sample.coffeeshop.dto.AddressDTO;
import com.tma.sample.coffeeshop.dto.AddressViewDTO;
import com.tma.sample.coffeeshop.model.Address;
import com.tma.sample.coffeeshop.repository.AddressRepository;
import com.tma.sample.coffeeshop.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping({"/admin/addresses"})
public class AddressRestController {
    @Autowired
    private AddressService addressService;
    @Autowired
    AddressRepository addressRepository;



    @PostMapping
    public Address addAddress(@RequestBody AddressDTO addressDTO) {
        return addressService.save(addressDTO);
    }

    @PutMapping("/{addressId}")
    public boolean editAddress(@PathVariable long addressId,
                               @RequestBody AddressDTO addressDTO) {
        addressService.edit(addressId, addressDTO);
        return true;
    }

    @DeleteMapping("/{addressId}")
    public void deleteAddress(@PathVariable long addressId) {
        addressService.delete(addressId);
    }

}
