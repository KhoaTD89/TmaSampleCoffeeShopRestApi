package com.tma.sample.coffeeshop.dto;

import lombok.*;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@Getter @Setter
public class ProductDTO {

    private long id;
    private String name;
    private double price;
    private String description;
    private String imagePath;
    private long categoryId;

}
