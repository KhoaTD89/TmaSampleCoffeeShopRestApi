package com.tma.sample.coffeeshop.dto;


import lombok.*;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AddressDTO {
    private String description;
    private String building;
    private String gate;
    private long wardId;
//    private long customerId;
//    private long staffId;
//    private long storeId;
}
