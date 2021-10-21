package com.tma.sample.coffeeshop.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Ward extends BaseEntity{

    private String name;

    @ManyToOne
    @JoinColumn(name = "district_id")
    @JsonBackReference
    private District district;

    @OneToMany(mappedBy = "ward",cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Address> addresses;
}
