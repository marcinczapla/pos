package com.marcinczapla.pos.model.products;

import java.math.BigDecimal;

/**
 * Created by Marcin on 2015-01-11.
 */
public class Product {

    private Long productId;
    private String name;
    private String barCode;
    private BigDecimal price;

    public Product(Long productId, String name, String barCode, BigDecimal price) {
        this.productId = productId;
        this.name = name;
        this.barCode = barCode;
        this.price = price;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBarCode() {
        return barCode;
    }

    public void setBarCode(String barCode) {
        this.barCode = barCode;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId=" + productId +
                ", name='" + name + '\'' +
                ", barCode='" + barCode + '\'' +
                ", price=" + price +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Product product = (Product) o;

        if (barCode != null ? !barCode.equals(product.barCode) : product.barCode != null) return false;
        if (name != null ? !name.equals(product.name) : product.name != null) return false;
        if (price != null ? !price.equals(product.price) : product.price != null) return false;
        if (productId != null ? !productId.equals(product.productId) : product.productId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = productId != null ? productId.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (barCode != null ? barCode.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        return result;
    }

}
