package com.tma.sample.coffeeshop.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@Entity
@Data
@Table(
        uniqueConstraints=
        @UniqueConstraint(columnNames={"store_id", "product_id"})
)
public class Menu extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "store_id")
    @JsonBackReference
    private Store store;

    @ManyToOne
    @JoinColumn(name = "product_id")
    @JsonBackReference
    private Product product;

    @CreationTimestamp
    private LocalDateTime createdDate;

    private boolean isActive;


}
