package com.tma.sample.coffeeshop.controller.admin;

import com.tma.sample.coffeeshop.dto.CityDTO;
import com.tma.sample.coffeeshop.model.City;
import com.tma.sample.coffeeshop.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/admin/cities")
public class CityRestController {

    @Autowired
    private CityRepository cityRepository;

    @PostMapping
    public void createCity(@RequestBody CityDTO cityDTO){
        City city = new City();
        city.setName(cityDTO.getName());
        cityRepository.save(city);
    }

    @PutMapping("/{cityId}")
    public void updateCity(@PathVariable long cityId,@RequestBody CityDTO cityDTO){
        City city = cityRepository.getById(cityId);
        city.setName(cityDTO.getName());
        cityRepository.save(city);
    }

    @DeleteMapping("/{cityId}")
    public void deleteCity(@PathVariable long cityId){
        cityRepository.deleteById(cityId);
    }

    @GetMapping
    public List<CityDTO> findAllCities(){
        return cityRepository.findAll().stream().map(city -> map(city)).collect(Collectors.toList());
    }

    @GetMapping("/{cityId}")
    public CityDTO getCityById(@PathVariable long cityId){
        return map(cityRepository.findById(cityId).orElse(null));
    }

    public CityDTO map(City city){
        CityDTO cityDTO = new CityDTO();
        cityDTO.setId(city.getId());
        cityDTO.setName(city.getName());
        return cityDTO;
    }
}
