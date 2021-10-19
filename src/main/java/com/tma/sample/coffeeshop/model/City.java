package com.tma.sample.coffeeshop.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@Data
public class City extends BaseEntity{

    private String name;

//    @ManyToOne
//    @JoinColumn(name = "province_id")
//    private Province province;

    @OneToMany(mappedBy = "city")
    private List<District> districts;
}
