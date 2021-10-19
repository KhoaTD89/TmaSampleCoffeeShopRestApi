package com.tma.sample.coffeeshop.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@Getter @Setter
public class StoreDTO {
    private long id;
    private String name;
    private String description;
    private String imagePath;
    private AddressViewDTO addressViewDTO;
    private String phone;
    private String openTime;
    private String closeTime;
}
