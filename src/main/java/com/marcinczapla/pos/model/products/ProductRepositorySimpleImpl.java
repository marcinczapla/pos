package com.marcinczapla.pos.model.products;

import com.marcinczapla.pos.model.products.exceptions.ProductNotFoundException;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Marcin on 2015-01-11.
 */
public class ProductRepositorySimpleImpl implements ProductRepository {

    private static List<Product> getProducts() {
        ArrayList<Product> result = new ArrayList<Product>();
        result.add(new Product(1L,"product1","1111111111111", BigDecimal.ONE));
        result.add(new Product(2L,"product2","2222222222222", BigDecimal.ONE));
        return  result;
    }

    @Override
    public Product loadById(Long productId) throws ProductNotFoundException{
        for(Product p : ProductRepositorySimpleImpl.getProducts()){
            if (p.getProductId().equals(productId)){
                return p;
            }
        }
        throw new ProductNotFoundException();
    }

    @Override
    public Product loadByBarCode(String barCode) throws ProductNotFoundException{
        for(Product p : ProductRepositorySimpleImpl.getProducts()){
            if (p.getBarCode().equals(barCode)){
                return p;
            }
        }
        throw new ProductNotFoundException();
    }
}
