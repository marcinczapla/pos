package com.marcinczapla.pos.model.products;

import com.marcinczapla.pos.model.products.exceptions.ProductNotFoundException;

/**
 * Created by Marcin on 2015-01-11.
 */
public interface ProductRepository {

    public Product loadById(Long productId) throws ProductNotFoundException;

    public Product loadByBarCode(String barCode) throws ProductNotFoundException;


}
