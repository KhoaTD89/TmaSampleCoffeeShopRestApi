package com.tma.sample.coffeeshop.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.rest.core.annotation.RestResource;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Address extends BaseEntity{
    private String description;
    private String building;
    private String gate;

    @ManyToOne
    @JoinColumn(name = "ward_id")
    @JsonBackReference
    private Ward ward;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "staff_id")
    private Staff staff;

    @OneToOne
    @JoinColumn(name = "store_id")
    @RestResource(rel = "store")
    private Store store;

    public Address(long id) {
        super.getId();
    }

    public Address(String description, String building, String gate) {
        this.description = description;
        this.building = building;
        this.gate = gate;
    }
}
