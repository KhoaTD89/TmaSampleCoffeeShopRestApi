package com.tma.sample.coffeeshop.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.LocalDateTime;

@Entity
@Data
public class VoucherDetail extends BaseEntity{

    @ManyToOne
    @JoinColumn(name = "voucher_id")
    private Voucher voucher;

    private double minOrder;

    private double maxDiscount;

    private LocalDateTime expiredTime;
    


}
