package com.tma.sample.coffeeshop;

import com.tma.sample.coffeeshop.dto.ProductDTO;
import com.tma.sample.coffeeshop.mapper.ProductMapper;
import com.tma.sample.coffeeshop.mapper.ProductMapperImpl;
import com.tma.sample.coffeeshop.model.Product;
import com.tma.sample.coffeeshop.repository.ProductReposiroty;
import com.tma.sample.coffeeshop.service.ProductService;
import com.tma.sample.coffeeshop.service.ProductServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

@RunWith(SpringRunner.class)
public class ProductServiceTest {
    Pageable pageable;
    @MockBean
    ProductReposiroty productReposiroty;

    @TestConfiguration
    public static class config{
        ProductMapper productMapper = new ProductMapperImpl();
        @Bean
        ProductService productService(){
          return new ProductServiceImpl(productMapper);
        }
    }
    @Autowired
    ProductService productService;

    @Before
    public void setup(){
        pageable = PageRequest.of(0,2);
        List<Product> products = LongStream.range(0, 10).mapToObj(i -> Product.builder()
                        .name("p_"+i).build())
                .collect(Collectors.toList());
        Mockito.when(productReposiroty.findAll(pageable))
                .thenReturn(new PageImpl <>(products));
    }

    @Test
    public void givenProducts_whenGetAll_thenReturnPageOfProduct() {
        Page<ProductDTO> productDTOPage = productService.findAll(pageable);
        Assertions.assertNotNull(productDTOPage);
        Assertions.assertTrue(productDTOPage.getContent().size()==10);
    }


}
