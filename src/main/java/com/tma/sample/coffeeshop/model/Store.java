package com.tma.sample.coffeeshop.model;

import lombok.*;
import org.aspectj.weaver.ast.Or;

import javax.persistence.*;
import java.time.LocalTime;
import java.util.List;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class Store extends BaseEntity{

    private String name;

    private String description;

    private String imagePath;

    private String phone;

    private LocalTime openTime;

    private LocalTime closeTime;

    @OneToOne(mappedBy = "store",cascade = CascadeType.ALL)
    private Address address;

    @OneToMany(mappedBy = "store",cascade = CascadeType.ALL)
    private List<Menu> menu;

    @OneToMany(mappedBy = "store",cascade = CascadeType.ALL)
    private List<Order> orders;

    @OneToMany(mappedBy = "store",cascade = CascadeType.ALL)
    private List<Promotion> promotions;


}
