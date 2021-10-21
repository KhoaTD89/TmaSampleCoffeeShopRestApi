package com.tma.sample.coffeeshop.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@Data
public class ExtraOption extends BaseEntity{
    private String name;
    private String description;
    private String imagePath;
    private double price;

    @OneToMany(mappedBy = "extraOption",cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<ProductExtraOption> productExtraOptions;

    @OneToMany(mappedBy = "extraOption",cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<OrderDetail> orderDetails;
}
