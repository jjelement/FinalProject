package Project.model;

import Project.model.Brand;
import Project.model.ProductImage;
import Project.model.ProductOrderItem;
import Project.model.Wishlist;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-11-28T21:58:24")
@StaticMetamodel(Product.class)
public class Product_ { 

    public static volatile ListAttribute<Product, ProductImage> productImageList;
    public static volatile SingularAttribute<Product, Double> price;
    public static volatile ListAttribute<Product, ProductOrderItem> productOrderItemList;
    public static volatile SingularAttribute<Product, Brand> brandId;
    public static volatile SingularAttribute<Product, String> name;
    public static volatile SingularAttribute<Product, Integer> id;
    public static volatile SingularAttribute<Product, String> detail;
    public static volatile ListAttribute<Product, Wishlist> wishlistList;

}