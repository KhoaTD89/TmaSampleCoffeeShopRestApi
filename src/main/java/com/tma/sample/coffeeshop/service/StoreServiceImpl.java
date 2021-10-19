package com.tma.sample.coffeeshop.service;

import com.tma.sample.coffeeshop.dto.AddressDTO;
import com.tma.sample.coffeeshop.dto.StoreDTO;
import com.tma.sample.coffeeshop.mapper.StoreMapper;
import com.tma.sample.coffeeshop.model.Address;
import com.tma.sample.coffeeshop.model.Store;
import com.tma.sample.coffeeshop.repository.AddressRepository;
import com.tma.sample.coffeeshop.repository.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class StoreServiceImpl implements StoreService {
    @Autowired
    private StoreRepository storeRepository;
    @Autowired
    private AddressRepository addressRepository;

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
    public Store save(StoreDTO storeDTO, long addressId) {
        Store store = storeMapper.map(storeDTO);
        storeRepository.save(store);

        Address address = addressRepository.findById(addressId).orElse(null);
        address.setStore(storeRepository.findById(store.getId()).orElse(null));
        addressRepository.save(address);

        return store;
    }

    @Override
    public Store edit(long storeId, StoreDTO storeDTO, long addressId) {
        Store store = storeRepository.findById(storeId).orElse(null);
        if (store == null) return null;

        Address oldAddress = addressRepository.findByStoreId(storeId).get(0);

        store = storeMapper.map(storeDTO);
        store.setId(storeId);
        storeRepository.save(store);

        Address address = addressRepository.findById(addressId).orElse(null);
        address.setStore(storeRepository.findById(store.getId()).orElse(null));
        addressRepository.save(address);

        if (oldAddress != null) {
            oldAddress.setStore(null);
        }
        return store;
    }

    @Override
    public boolean delete(long storeId) {
        Address oldAddress = addressRepository.findByStoreId(storeId).get(0);

        Store store = storeRepository.findById(storeId).orElse(null);
        if (store != null) {
            storeRepository.delete(store);
        }

        if (oldAddress != null) {
            oldAddress.setStore(null);
        }
        return true;
    }
}
