package com.tma.sample.coffeeshop.service;

import com.tma.sample.coffeeshop.model.Product;
import com.tma.sample.coffeeshop.model.ProductDetail;

import java.util.List;

public interface MenuService {

    List<Product> getAllItemInAMenu();

    ProductDetail getProductdetailFromMenu();

    boolean addCategory();
    boolean updateCategory();
    boolean deleteCategory();

    boolean addProduct();
    boolean updateProduct();
    boolean deleteProduct();



}
