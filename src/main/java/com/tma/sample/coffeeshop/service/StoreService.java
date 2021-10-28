package com.tma.sample.coffeeshop.service;

import com.tma.sample.coffeeshop.dto.ProductDTO;
import com.tma.sample.coffeeshop.dto.StoreDTO;
import com.tma.sample.coffeeshop.model.Store;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;


public interface StoreService {
    Page<StoreDTO> findAll(Pageable pageable);
    StoreDTO viewStoreDetail(long id);
    Store save(StoreDTO storeDTO,long addressId);
    Store edit(long storeId,StoreDTO storeDTO,long addressId);
    void delete(long storeId);

}
