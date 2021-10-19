package com.tma.sample.coffeeshop.dto;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AddressViewDTO {

    private String description;
    private String building;
    private String gate;
    private String ward;
    private String district;
    private String city;

}
