package com.tma.sample.coffeeshop.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Menu extends BaseEntity{

    @OneToOne
    @JoinColumn(name = "store_id")
    private Store store;

    @OneToMany(mappedBy = "menu")
    private List<Product> products;



}
