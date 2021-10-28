package com.tma.sample.coffeeshop.controller.admin;

import com.tma.sample.coffeeshop.dto.ProductDTO;
import com.tma.sample.coffeeshop.service.MenuService;
import com.tma.sample.coffeeshop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin/products")
public class ProductRestController {
    @Autowired
    MenuService menuService;
    @Autowired
    ProductService productService;

    @GetMapping
    public ResponseEntity<Page<ProductDTO>>  getAllProduct(Pageable pageable){
        return ResponseEntity.ok()
                .body(productService.findAll(pageable));
    }

    @PostMapping
    public ResponseEntity<Object> createNewProduct(@RequestBody ProductDTO productDTO){
        productService.createNewProduct(productDTO);
        return ResponseEntity.ok()
                .eTag("V12.11.1") //The ETag (or entity tag) HTTP response header is an identifier for a specific version of a resource
                .body("Saved product");
    }

    @PutMapping("/{productId}")
    public ResponseEntity<Object> editProduct(@PathVariable("productId") long productId
            ,@RequestBody ProductDTO productDTO){
        productService.editProduct(productId,productDTO);
        return ResponseEntity.ok()
                .header("coffee-shop-location","Vietnam" ) //header for additional infor client want to sent
                .body("edited product with id = " + productId);
    }

    @DeleteMapping("/{productId}")
    public ResponseEntity<Object> deleteProduct(@PathVariable("productId") long productId){
            productService.deleteProduct(productId);
            return ResponseEntity.ok()
                    .body("Deleted product with id = " + productId);
    }

}
