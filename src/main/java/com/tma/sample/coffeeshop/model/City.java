package com.tma.sample.coffeeshop.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Getter
@Setter
public class City extends BaseEntity {

    private String name;

    @OneToMany(mappedBy = "city",cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<District> districts;
}
