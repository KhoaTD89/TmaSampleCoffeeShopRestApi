package com.tma.sample.coffeeshop.service;

import com.tma.sample.coffeeshop.dto.AddressDTO;
import com.tma.sample.coffeeshop.dto.StoreDTO;
import com.tma.sample.coffeeshop.mapper.StoreMapper;
import com.tma.sample.coffeeshop.model.Store;
import com.tma.sample.coffeeshop.repository.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StoreServiceImpl implements StoreService{
    @Autowired
    private StoreRepository storeRepository;

    private final StoreMapper storeMapper;
    public StoreServiceImpl(StoreMapper storeMapper) {
        this.storeMapper = storeMapper;
    }

    @Override
    public List<StoreDTO> findAll() {
        List<StoreDTO> storeDTOS = new ArrayList<>();
        storeRepository.findAll().stream().forEach(store -> storeDTOS.add(storeMapper.map(store)));
        return storeDTOS;
    }

    @Override
    public StoreDTO viewStoreDetail(long id) {
        Store store = storeRepository.findById(id).orElse(null);
        StoreDTO storeDTO = storeMapper.map(store);
        return storeDTO;
    }

    @Override
    public Store save(StoreDTO storeDTO) {
        return null;
    }
}
