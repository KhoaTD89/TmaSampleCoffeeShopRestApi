package com.tma.sample.coffeeshop.service;

import com.tma.sample.coffeeshop.dto.ProductDTO;
import com.tma.sample.coffeeshop.mapper.ProductMapper;
import com.tma.sample.coffeeshop.model.Product;
import com.tma.sample.coffeeshop.repository.MenuRepository;
import com.tma.sample.coffeeshop.repository.ProductReposiroty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductReposiroty productReposiroty;
    @Autowired
    MenuRepository menuRepository;
    private final ProductMapper productMapper;

    public ProductServiceImpl(ProductMapper productMapper) {
        this.productMapper = productMapper;
    }

    @Override
    public Page<ProductDTO> findAll(Pageable pageable) {
        return productReposiroty.findAll(pageable).map(productMapper::map);
    }

    @Override
    public ProductDTO getProductById(long productId) {
        Product product = productReposiroty.findById(productId).orElse(null);
        if (product != null) {
            return productMapper.map(product);
        }
        return null;
    }

    @Override
    public Page<ProductDTO> getAllProductOfAStore(long storeId, Pageable pageable) {
        return new PageImpl<>(menuRepository.findProductsOfAStore(storeId)
                .stream().map(p -> productMapper.map(p))
                .collect(Collectors.toList())) ;
    }

}
