package com.tma.sample.coffeeshop.repository;

import com.tma.sample.coffeeshop.model.Menu;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MenuRepository extends JpaRepository<Menu,Long> {

}
