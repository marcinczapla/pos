package com.marcinczapla.pos.model.products;

/**
 * Created by Marcin on 2015-01-11.
 */
public interface ProductRepository {

    public Product loadById(Long productId);

    public Product loadByBarCode(String barCode);


}
