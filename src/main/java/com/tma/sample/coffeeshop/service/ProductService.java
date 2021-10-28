package com.tma.sample.coffeeshop.service;

import com.tma.sample.coffeeshop.dto.ProductDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


public interface ProductService {
    Page<ProductDTO> findAll(Pageable pageable);

    ProductDTO getProductById(long productId);

    Page<ProductDTO> getAllProductOfAStore(long storeId,Pageable pageable);
}
