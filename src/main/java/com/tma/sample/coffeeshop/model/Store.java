package com.tma.sample.coffeeshop.model;

import lombok.*;
import org.aspectj.weaver.ast.Or;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
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

    @OneToOne(mappedBy = "store")
    private Address address;

    @OneToOne(mappedBy = "store")
    private Menu menu;

    @OneToMany(mappedBy = "store")
    private List<Order> orders;

    @OneToMany(mappedBy = "store")
    private List<Promotion> promotions;


}
