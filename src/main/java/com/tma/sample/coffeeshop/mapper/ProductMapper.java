package com.tma.sample.coffeeshop.mapper;

import com.tma.sample.coffeeshop.dto.ProductDTO;
import com.tma.sample.coffeeshop.model.Product;
import com.tma.sample.coffeeshop.model.ProductDetail;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Mapper(componentModel = "spring")
public abstract class ProductMapper {

    private static ProductMapper productMapper = Mappers.getMapper(ProductMapper.class);

    @Mapping(target = "price",source = "productDTO.price")
    @Mapping(target = "description",source = "productDTO.description")
    @Mapping(target = "imagePath",source = "productDTO.imagePath")
    public abstract ProductDetail map(ProductDTO productDTO);


    @Mapping(target="id",source = "product.id")
    @Mapping(target="name",source = "product.name")
    public abstract ProductDTO map(Product product);
    @AfterMapping
     void after(@MappingTarget ProductDTO target, Product src){
        List<ProductDetail> productDetails = src.getProductDetails();

        //get lastest product detail
        ProductDetail productDetail = productDetails.stream()
                .max(Comparator.comparing(ProductDetail::getCreatedDate)).orElse(null);

        target.setDescription(productDetail.getDescription());
        target.setImagePath(productDetail.getImagePath());
        target.setPrice(productDetail.getPrice());
    }


}
