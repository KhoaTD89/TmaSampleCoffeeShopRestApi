package com.tma.sample.coffeeshop.controller.admin;

import com.tma.sample.coffeeshop.dto.StoreDTO;
import com.tma.sample.coffeeshop.service.MenuService;
import com.tma.sample.coffeeshop.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin/stores")
public class StoreAdminRestController {

    @Autowired
    private StoreService storeService;

    @Autowired
    MenuService menuService;

    @PostMapping("/{storeId}/products/{productId}")
    public ResponseEntity<Object> addProductToMenu(@PathVariable long storeId,
                                           @PathVariable long productId){
        menuService.addProductToMenu(storeId, productId);
        return ResponseEntity.ok()
                .body("saved a product to menu of a store");
    }

    @PostMapping
    public ResponseEntity<Object> saveStore(@RequestBody StoreDTO storeDTO,@RequestParam("addressId") long addressId){
        storeService.save(storeDTO,addressId);
        return ResponseEntity.ok()
                .body("saved a store");
    }

    @PutMapping("/{storeId}")
    public ResponseEntity<Object> editStore(@RequestBody StoreDTO storeDTO
            ,@PathVariable long storeId
            ,@RequestParam("addressId") long addressId){
        storeService.edit(storeId,storeDTO,addressId);
        return ResponseEntity.ok()
                .body("Edited the store id = " + storeId);
    }

    @DeleteMapping("/{storeId}")
    public ResponseEntity<Object> deleteStore(@PathVariable long storeId){
        storeService.delete(storeId);
        return ResponseEntity.ok()
                .body("deleted the store id = " + storeId);
    }
}
