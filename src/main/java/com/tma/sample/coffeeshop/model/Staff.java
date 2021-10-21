package com.tma.sample.coffeeshop.model;

import lombok.Data;
import org.aspectj.weaver.ast.Or;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.time.LocalDate;
import java.util.List;

@Entity
@Data
public class Staff extends BaseEntity{

    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private LocalDate birthDate;
    private String email;
    private String grade;

    @OneToMany(mappedBy = "staff")
    private List<Address> addresses;

    @OneToMany(mappedBy = "staff")
    private List<Order> orders;
}
