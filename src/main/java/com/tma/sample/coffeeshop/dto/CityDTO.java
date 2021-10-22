package com.tma.sample.coffeeshop.dto;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.tma.sample.coffeeshop.model.BaseEntity;
import com.tma.sample.coffeeshop.model.District;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;


@Data
@Getter
@Setter
public class CityDTO{
    private long id;
    private String name;

}
