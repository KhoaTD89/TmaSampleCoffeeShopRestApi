package com.tma.sample.coffeeshop.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;


public class Country extends BaseEntity{
    private String name;

    @OneToMany(mappedBy = "country")
    private List<Province> provinces;
}
