package com.tma.sample.coffeeshop.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Data
public class Customer extends BaseEntity{

    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private LocalDate birthDate;
    private LocalDate email;
    private String grade;

    @OneToMany(mappedBy = "customer")
    private List<Address> addresses;

    @OneToMany(mappedBy = "customer")
    private List<Order> orders;
}
