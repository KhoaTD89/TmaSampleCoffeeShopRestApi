package com.tma.sample.coffeeshop.controller.admin;

import com.tma.sample.coffeeshop.model.City;
import com.tma.sample.coffeeshop.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class CityRestController {

    @Autowired
    private CityRepository cityRepository;

    @PostMapping(value="/api/city")
    public void createCity(@RequestBody City city){
            cityRepository.save(city);
    }

    @PutMapping(value="/api/city")
    public void updateCity(@RequestBody City city){
        cityRepository.save(city);
    }

    @DeleteMapping(value="/api/city/{id}")
    public void deleteCity(@PathVariable long id){
        City city = cityRepository.findById(id).orElse(null);
        if (city!=null){
            cityRepository.delete(city);
        }
    }

    @GetMapping("/api/cities")
    public List<City> findAll(){
        return cityRepository.findAll();
    }

    @GetMapping("/api/city/{id}")
    public City getById(@PathVariable long id){
        return cityRepository.findById(id).orElse(null);
    }
}
