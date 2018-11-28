package Project.model;

import Project.model.ProductOrderItem;
import Project.model.User;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-11-28T21:58:24")
@StaticMetamodel(ProductOrder.class)
public class ProductOrder_ { 

    public static volatile SingularAttribute<ProductOrder, Date> createdAt;
    public static volatile SingularAttribute<ProductOrder, Double> totalPrice;
    public static volatile SingularAttribute<ProductOrder, Integer> totalQty;
    public static volatile ListAttribute<ProductOrder, ProductOrderItem> productOrderItemList;
    public static volatile SingularAttribute<ProductOrder, Integer> id;
    public static volatile SingularAttribute<ProductOrder, User> userId;

}