package com.tma.sample.coffeeshop.controller.admin;

import com.tma.sample.coffeeshop.dto.ProductDTO;
import com.tma.sample.coffeeshop.service.MenuService;
import com.tma.sample.coffeeshop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin/products")
public class ProductRestController {
    @Autowired
    MenuService menuService;
    @Autowired
    ProductService productService;

    @GetMapping
    public Page<ProductDTO> getAllProduct(Pageable pageable){
        return productService.findAll(pageable);
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
