package com.tma.sample.coffeeshop.controller.admin;

import com.tma.sample.coffeeshop.dto.StoreDTO;
import com.tma.sample.coffeeshop.service.MenuService;
import com.tma.sample.coffeeshop.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class StoreAdminRestController {

    @Autowired
    private StoreService storeService;

    @Autowired
    MenuService menuService;

    //Add product to a store menu
    @PostMapping("/stores/{storeId}/products/{productId}")
    public boolean addProductToMenu(@PathVariable long storeId,
                                    @PathVariable long productId){
        return menuService.addProductToMenu(storeId, productId);
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
