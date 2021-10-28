package com.tma.sample.coffeeshop.mapper;

import com.tma.sample.coffeeshop.dto.ProductDTO;
import com.tma.sample.coffeeshop.model.Product;
import com.tma.sample.coffeeshop.model.ProductDetail;
import lombok.extern.log4j.Log4j2;
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
@Log4j2
public abstract class ProductMapper {

    private static ProductMapper productMapper = Mappers.getMapper(ProductMapper.class);

    @Mapping(target = "price", source = "productDTO.price")
    @Mapping(target = "description", source = "productDTO.description")
    @Mapping(target = "imagePath", source = "productDTO.imagePath")
    public abstract ProductDetail map(ProductDTO productDTO);


    @Mapping(target = "id", source = "product.id")
    @Mapping(target = "name", source = "product.name")
    public abstract ProductDTO map(Product product);

    @AfterMapping
    void after(@MappingTarget ProductDTO target, Product src) {
        try {
            List<ProductDetail> productDetails = src.getProductDetails();
            //get lastest product detail
            productDetails.sort(new Comparator<ProductDetail>() {
                @Override
                public int compare(ProductDetail o1, ProductDetail o2) {
                    return o2.getCreatedDate().compareTo(o1.getCreatedDate());
                }
            });
            ProductDetail productDetail = productDetails.get(0);
            log.info(productDetail.getDescription());
            target.setDescription(productDetail.getDescription());
            target.setImagePath(productDetail.getImagePath());
            target.setPrice(productDetail.getPrice());
        } catch (Exception e) {
            log.error("error in mapping product .%s", e);
        }
    }


}
