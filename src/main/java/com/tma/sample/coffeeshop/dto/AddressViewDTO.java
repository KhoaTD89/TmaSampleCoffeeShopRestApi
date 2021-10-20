package com.tma.sample.coffeeshop.dto;


import lombok.*;

@Data
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AddressViewDTO {

    private long id;
    private String description;
    private String building;
    private String gate;
    private String ward;
    private String district;
    private String city;

}
