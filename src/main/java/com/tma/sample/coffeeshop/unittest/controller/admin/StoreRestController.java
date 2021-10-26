package com.tma.sample.coffeeshop.unittest.controller.admin;

import com.tma.sample.coffeeshop.dto.StoreDTO;
import com.tma.sample.coffeeshop.unittest.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin/stores")
public class StoreRestController {

    @Autowired
    private StoreService storeService;

    @GetMapping
    public List<StoreDTO> storeList(){
        return storeService.findAll();
    }

    @GetMapping("/{storeId}")
    public StoreDTO viewStoreDetail(@PathVariable long storeId){
        StoreDTO storeDTO = storeService.viewStoreDetail(storeId);
        return storeDTO;
    }

    @PostMapping
    public void saveStore(@RequestBody StoreDTO storeDTO,@RequestParam("addressId") long addressId){
        storeService.save(storeDTO,addressId);
    }

    @PutMapping("/{storeId}")
    public void editStore(@RequestBody StoreDTO storeDTO
            ,@PathVariable long storeId
            ,@RequestParam("addressId") long addressId){
        storeService.edit(storeId,storeDTO,addressId);
    }

    @DeleteMapping("/{storeId}")
    public void deleteStore(@PathVariable long storeId){
        storeService.delete(storeId);
    }
}
