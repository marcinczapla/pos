package com.marcinczapla.pos.model;

/**
 * Created by Marcin on 2015-01-11.
 */
public interface ProductRepository {

    public Product loadById(Long productId);

    public Product loadByEan(String ean);


}
