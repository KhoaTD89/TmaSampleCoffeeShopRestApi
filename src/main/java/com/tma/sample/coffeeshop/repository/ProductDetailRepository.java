package com.tma.sample.coffeeshop.repository;

import com.tma.sample.coffeeshop.enums.ProductSize;
import com.tma.sample.coffeeshop.model.ProductDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductDetailRepository extends JpaRepository<ProductDetail,Long> {

    @Query(value = "select P from ProductDetail P" +
            " where P.product.id=:productId " +
            " and P.size=:size " +
            " order by P.createdDate desc")
    List<ProductDetail> findByProductIdAndSize(@Param("productId") long productId
    , @Param("size") ProductSize size);


    //Altenative option for above
    List<ProductDetail> findByProductIdAndSizeOrderByCreatedDateDesc(long productId, ProductSize size);

}
