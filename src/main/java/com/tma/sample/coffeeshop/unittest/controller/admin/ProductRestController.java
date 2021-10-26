package com.tma.sample.coffeeshop.unittest.controller.admin;

import com.tma.sample.coffeeshop.dto.ProductDTO;
import com.tma.sample.coffeeshop.unittest.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin/products")
public class ProductRestController {
    @Autowired
    MenuService menuService;

    @GetMapping("/{productId}")
    public ProductDTO getProductById(@PathVariable("productId") long productId){
        return menuService.getProductById(productId);
    }

    @PostMapping
    public boolean createNewProduct(@RequestBody ProductDTO productDTO){
        return menuService.createNewProduct(productDTO);
    }

    @PutMapping("/{productId}")
    public boolean editProduct(@PathVariable("productId") long productId
            ,@RequestBody ProductDTO productDTO){
        return menuService.editProduct(productId,productDTO);
    }

    @DeleteMapping("/{productId}")
    public void deleteProduct(@PathVariable("productId") long productId){
         menuService.deleteProduct(productId);
    }

}
