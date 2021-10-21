package com.tma.sample.coffeeshop.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalTime;

@Entity
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "product_category",
    uniqueConstraints = @UniqueConstraint(columnNames = {"product_id","category_id"})
)
public class ProductCategory extends BaseEntity {

    @ManyToOne
    @JoinColumn(name="product_id")
    @JsonBackReference
    private Product product;

    @ManyToOne
    @JoinColumn(name="category_id")
    @JsonBackReference
    private Category category;

    @CreationTimestamp
    private LocalTime createdDate;
}
