package com.tma.sample.coffeeshop.service;

import com.tma.sample.coffeeshop.dto.AddressDTO;
import com.tma.sample.coffeeshop.dto.StoreDTO;
import com.tma.sample.coffeeshop.model.Address;
import com.tma.sample.coffeeshop.model.Store;

import java.util.List;


public interface StoreService {
    List<StoreDTO> findAll();
    StoreDTO viewStoreDetail(long id);
    Store save(StoreDTO storeDTO);
}
