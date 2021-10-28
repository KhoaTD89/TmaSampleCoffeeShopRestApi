package com.tma.sample.coffeeshop.service;

import com.tma.sample.coffeeshop.dto.ProductDTO;
import com.tma.sample.coffeeshop.exception.ProductNotFoundException;
import com.tma.sample.coffeeshop.exception.ResourceNotFoundException;
import com.tma.sample.coffeeshop.mapper.ProductMapper;
import com.tma.sample.coffeeshop.model.Category;
import com.tma.sample.coffeeshop.model.Product;
import com.tma.sample.coffeeshop.model.ProductCategory;
import com.tma.sample.coffeeshop.model.ProductDetail;
import com.tma.sample.coffeeshop.repository.*;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Log4j2
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductReposiroty productReposiroty;
    @Autowired
    MenuRepository menuRepository;
    private final ProductMapper productMapper;
    @Autowired
    ProductDetailRepository productDetailRepository;
    @Autowired
    CategoryRepository categoryRepository;
    @Autowired
    ProductCategoryRepository productCategoryRepository;

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
        return menuRepository.findProductsOfAStore(storeId, pageable).map(productMapper::map);
    }

    @Override
    public void createNewProduct(ProductDTO productDTO) {
        try {
            ProductDetail productDetail = productMapper.map(productDTO);

            //save product
            Product product = new Product();
            product.setName(productDTO.getName());
            product.setActive(true);
            Product savedProduct = productReposiroty.save(product);

            //save product detail
            productDetail.setProduct(product);
            productDetailRepository.save(productDetail);

            //save product category
            Category category = categoryRepository.findById(productDTO.getCategoryId()).orElse(null);
            ProductCategory productCategory = ProductCategory.builder()
                    .product(savedProduct)
                    .category(category)
                    .build();
            productCategoryRepository.save(productCategory);
        } catch (Exception e) {
            throw new RuntimeException("could not save the product to DB");
        }
    }

    @Override
    public void editProduct(long productId, ProductDTO productDTO) {
        Product product = productReposiroty.findById(productId).orElseThrow(() -> new ProductNotFoundException(productId));

        ProductDetail productDetail = productMapper.map(productDTO);

        //save product
        product.setName(productDTO.getName());
        productReposiroty.save(product);

        //save a new product detail
        //todo: check if this product detail exists -> not save again
        productDetail.setProduct(product);
        productDetailRepository.save(productDetail);
        try {
            //save category
            Category category = categoryRepository.findById(productDTO.getCategoryId()).orElse(null);
            ProductCategory productCategory = ProductCategory.builder()
                    .product(product)
                    .category(category)
                    .build();
            productCategoryRepository.save(productCategory);
        } catch (Exception e) {
            log.info("duplicate id : product_id and category_id ", e);
        }


    }

    @Override
    public void deleteProduct(long productId) {
        try {
            productReposiroty.deleteById(productId);
        } catch (Exception e) {
            throw new ProductNotFoundException(productId);
        }
    }
}
