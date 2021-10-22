package com.tma.sample.coffeeshop.service;

import com.tma.sample.coffeeshop.dto.ProductDTO;

import java.util.List;

public interface MenuService {


    boolean addProductToMenu(long storeId, long productId);

    List<ProductDTO> getAllProductOfAStore(long storeId);

    ProductDTO getProductById(long productId);

    boolean editProduct(long productId,ProductDTO productDTO);

    void deleteProduct(long productId);

    boolean createNewProduct(ProductDTO productDTO);




}
