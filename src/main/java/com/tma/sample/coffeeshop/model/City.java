package com.tma.sample.coffeeshop.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@Data
@Getter
@Setter
public class City extends BaseEntity {

    private String name;

    @OneToMany(mappedBy = "city")
    @JsonManagedReference
    private List<District> districts;
}
