package com.tma.sample.coffeeshop.controller.admin;

import com.tma.sample.coffeeshop.dto.ProductDTO;
import com.tma.sample.coffeeshop.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin/menus")
public class MenuRestController {
    @Autowired
    MenuService menuService;

    @PostMapping("/store/{storeId}/product/{productId}")
    public boolean addProductToMenu(@PathVariable long storeId,
                                    @PathVariable long productId){
        return menuService.addProductToMenu(storeId, productId);
    }

    @GetMapping("/store/{storeId}")
    public List<ProductDTO> getProductsOfAStore(@PathVariable long storeId){
        return menuService.getAllProductOfAStore(storeId);
    }

}
