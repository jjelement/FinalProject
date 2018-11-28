package Project.model;

import Project.model.Product;
import Project.model.ProductOrder;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-11-28T21:58:24")
@StaticMetamodel(ProductOrderItem.class)
public class ProductOrderItem_ { 

    public static volatile SingularAttribute<ProductOrderItem, Product> productId;
    public static volatile SingularAttribute<ProductOrderItem, ProductOrder> orderId;
    public static volatile SingularAttribute<ProductOrderItem, Double> price;
    public static volatile SingularAttribute<ProductOrderItem, Integer> qty;
    public static volatile SingularAttribute<ProductOrderItem, Integer> id;

}