/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Project.model;

//import sit.int303.mockup.model.Product;

import java.io.Serializable;
import java.math.BigDecimal;


/**
 *
 * @author INT303
 */
public class LineItem implements Serializable {
    Product product;
    BigDecimal salePrice;
    int quantity;

    public LineItem() {
    }

    public LineItem(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
        this.salePrice = BigDecimal.valueOf(product.getPrice());
    }

    public LineItem(Product product) {
        this(product, 1);
    }
    
    public BigDecimal getTotalPrice(){
        return this.salePrice.multiply(new BigDecimal(this.quantity));
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public BigDecimal getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(BigDecimal salePrice) {
        this.salePrice = salePrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
    
}
