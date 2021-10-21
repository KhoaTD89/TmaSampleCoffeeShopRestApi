package com.tma.sample.coffeeshop.service;

import com.tma.sample.coffeeshop.dto.ProductDTO;

import java.util.List;

public interface MenuService {


    boolean addProductToMenu(long storeId, long productId);

    List<ProductDTO> getAllProductOfAStore(long storeId);

    ProductDTO getProductById(long productId);

    boolean editProduct(long productId,ProductDTO productDTO);
    boolean deleteProduct(long productId);


    boolean addCategory();
    boolean updateCategory();
    boolean deleteCategory();

    boolean createNewProduct(ProductDTO productDTO);
    boolean updateProduct();
    boolean deleteProduct();



}
