package com.tma.sample.coffeeshop.controller.admin;

import com.tma.sample.coffeeshop.dto.ProductDTO;
import com.tma.sample.coffeeshop.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class MenuRestController {
    @Autowired
    MenuService menuService;

    @GetMapping("/product/{productId}")
    public ProductDTO getProductById(@PathVariable("productId") long productId){
        return menuService.getProductById(productId);
    }
    @PostMapping("/product")
    public boolean createNewProduct(@RequestBody ProductDTO productDTO){
        return menuService.createNewProduct(productDTO);
    }

    @PutMapping("/product/{productId}")
    public boolean editProduct(@PathVariable("productId") long productId
            ,@RequestBody ProductDTO productDTO){
        return menuService.editProduct(productId,productDTO);
    }

    @DeleteMapping("/product/{productId}")
    public boolean deleteProduct(@PathVariable("productId") long productId){
        return menuService.deleteProduct(productId);
    }

    @PostMapping("/{storeId}/{productId}")
    public boolean addProductToMenu(@PathVariable("storeId") long storeId,
                                    @PathVariable("productId") long productId){
        return menuService.addProductToMenu(storeId, productId);
    }

    @GetMapping("/store/products")
    public List<ProductDTO> getProductsOfAStore(long storeId){
        return menuService.getAllProductOfAStore(storeId);
    }



}
