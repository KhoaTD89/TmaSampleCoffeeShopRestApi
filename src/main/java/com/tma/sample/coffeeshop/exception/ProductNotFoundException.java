package com.tma.sample.coffeeshop.exception;

public class ProductNotFoundException extends RuntimeException{

    public ProductNotFoundException(long id) {
        super("PNFE_Could not find product with Id = " + id);
    }
}
