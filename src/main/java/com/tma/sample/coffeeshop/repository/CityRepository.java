package com.tma.sample.coffeeshop.repository;

import com.tma.sample.coffeeshop.model.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CityRepository extends JpaRepository<City,Long> {

    City findByName(String name);

}
