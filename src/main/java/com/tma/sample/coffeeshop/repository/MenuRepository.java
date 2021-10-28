package com.tma.sample.coffeeshop.repository;

import com.tma.sample.coffeeshop.model.Menu;
import com.tma.sample.coffeeshop.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;
@Transactional
public interface MenuRepository extends JpaRepository<Menu,Long> {

    //conventional query only return Menu --> expected Product
    //use HQL instead
    @Query("SELECT m.product FROM Menu m WHERE m.store.id=:storeId order by m.product.name")
    Page<Product> findProductsOfAStore(@Param("storeId") long storeId, Pageable pageable);

}
