package com.tma.sample.coffeeshop.service;

import com.tma.sample.coffeeshop.dto.StoreDTO;
import com.tma.sample.coffeeshop.model.Store;

import java.util.List;


public interface StoreService {
    List<StoreDTO> findAll();
    StoreDTO viewStoreDetail(long id);
    Store save(StoreDTO storeDTO,long addressId);
    Store edit(long storeId,StoreDTO storeDTO,long addressId);
    void delete(long storeId);
}
