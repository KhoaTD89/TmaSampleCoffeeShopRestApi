package com.tma.sample.coffeeshop.controller.admin;

import com.tma.sample.coffeeshop.dto.StoreDTO;
import com.tma.sample.coffeeshop.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class StoreRestController {

    @Autowired
    private StoreService storeService;

    @GetMapping("/stores")
    public List<StoreDTO> storeList(){
        return storeService.findAll();
    }

    @GetMapping("/store/{id}")
    public StoreDTO viewStoreDetail(@PathVariable long id){
        StoreDTO storeDTO = storeService.viewStoreDetail(id);
        return storeDTO;
    }

    @PostMapping
    public void saveStore(@RequestBody StoreDTO storeDTO,@RequestParam("addressId") long addressId){
        storeService.save(storeDTO,addressId);
    }

    @PutMapping("/store/{id}")
    public void editStore(@RequestBody StoreDTO storeDTO
            ,@PathVariable("id") long storeId
            ,@RequestParam("addressId") long addressId){
        storeService.edit(storeId,storeDTO,addressId);
    }

    @DeleteMapping("/store/{id}")
    public void deleteStore(@PathVariable long id){
        storeService.delete(id);
    }
}
