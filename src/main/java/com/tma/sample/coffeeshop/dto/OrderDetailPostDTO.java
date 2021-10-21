package com.tma.sample.coffeeshop.dto;

import com.tma.sample.coffeeshop.enums.ProductSize;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class OrderDetailPostDTO {
    private String size;
    private long extraOptionId;
    private int productQty;
    private String note;
}
