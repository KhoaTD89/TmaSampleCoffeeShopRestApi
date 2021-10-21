package com.tma.sample.coffeeshop.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.tma.sample.coffeeshop.enums.ProductSize;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductDetail extends BaseEntity{

    @ManyToOne
    @JoinColumn(name = "product_id")
    @JsonBackReference
    private Product product;

    @OneToMany(mappedBy = "productDetail")
    @JsonManagedReference
    private List<OrderDetail> orderDetails;

    @CreationTimestamp
    private LocalDateTime createdDate;

    private String description;
    private String imagePath;
    private double price;

    @Enumerated(EnumType.STRING)
    private ProductSize size;

    private boolean isActive;

}
