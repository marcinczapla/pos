package com.marcinczapla.pos.model.products.exceptions;

/**
 * Created by Marcin Czapla on 2015-01-15.
 */
public class ProductNotFoundException extends Exception{

    public ProductNotFoundException() {
    }

    public ProductNotFoundException(String message) {
        super(message);
    }
}
