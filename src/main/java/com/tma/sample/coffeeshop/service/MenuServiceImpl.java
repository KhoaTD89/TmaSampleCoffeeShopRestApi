package com.tma.sample.coffeeshop.service;

import com.tma.sample.coffeeshop.dto.ProductDTO;
import com.tma.sample.coffeeshop.mapper.ProductMapper;
import com.tma.sample.coffeeshop.model.*;
import com.tma.sample.coffeeshop.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class MenuServiceImpl implements MenuService {
    @Autowired
    StoreRepository storeRepository;
    @Autowired
    MenuRepository menuRepository;
    @Autowired
    ProductReposiroty productReposiroty;
    @Autowired
    ProductDetailRepository productDetailRepository;
    @Autowired
    CategoryRepository categoryRepository;
    @Autowired
    ProductCategoryRepository productCategoryRepository;

    private final ProductMapper productMapper;

    public MenuServiceImpl(ProductMapper productMapper) {
        this.productMapper = productMapper;
    }

    @Override
    public List<ProductDTO> getAllProductOfAStore(long storeId) {
        List<Product> products = menuRepository.findProductsOfAStore(storeId);
        List<ProductDTO> productDTOS = products.stream().map(product -> productMapper.map(product))
                .collect(Collectors.toList());
        return productDTOS;
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
    public boolean editProduct(long productId, ProductDTO productDTO) {
        Product product = productReposiroty.findById(productId).orElse(null);
        if (product == null) return false;

        try {
            ProductDetail productDetail = productMapper.map(productDTO);

            //save product
            product.setName(productDTO.getName());
            productReposiroty.save(product);

            //save a new product detail
            //todo: check if this product detail exists -> not save again
            productDetail.setProduct(product);
            productDetailRepository.save(productDetail);

            //save category
            Category category = categoryRepository.findById(productDTO.getCategoryId()).orElse(null);
            ProductCategory productCategory = ProductCategory.builder()
                    .product(product)
                    .category(category)
                    .build();
            productCategoryRepository.save(productCategory);
            return true;
        } catch (Exception e) {
            System.out.println("could not edit");
        }

        return false;
    }

    @Override
    public boolean deleteProduct(long productId) {
        Product product = productReposiroty.findById(productId).orElse(null);
        if (product == null) return false;
        productReposiroty.delete(product);
        return true;
    }


    @Override
    public boolean addCategory() {
        return false;
    }

    @Override
    public boolean updateCategory() {
        return false;
    }

    @Override
    public boolean deleteCategory() {
        return false;
    }

    @Override
    public boolean createNewProduct(ProductDTO productDTO) {
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
            return true;
        } catch (Exception e) {
            throw new RuntimeException("could not save the product to DB");
        }
    }

    @Override
    public boolean addProductToMenu(long storeId, long productId) {
        Menu menu = new Menu();
        Store store = storeRepository.findById(storeId).orElse(null);
        Product product = productReposiroty.findById(productId).orElse(null);
        try {
            if (store != null && product != null) {
                menu.setStore(store);
                menu.setProduct(product);
                menu.setActive(true);
                menuRepository.save(menu);
                return true;
            }
        } catch (Exception e) {
            System.out.println("duplicate key");
        }
        return false;
    }

    @Override
    public boolean updateProduct() {
        return false;
    }

    @Override
    public boolean deleteProduct() {
        return false;
    }
}
