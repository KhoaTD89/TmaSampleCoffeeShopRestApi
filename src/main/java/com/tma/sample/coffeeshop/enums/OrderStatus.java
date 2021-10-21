package com.tma.sample.coffeeshop.enums;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


public enum OrderStatus{
    PROCESSING,ORDERED,CANCELED
}
