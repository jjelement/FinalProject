package Project.model;

import Project.model.Product;
import Project.model.User;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-11-28T21:58:24")
@StaticMetamodel(Wishlist.class)
public class Wishlist_ { 

    public static volatile SingularAttribute<Wishlist, Date> createdAt;
    public static volatile SingularAttribute<Wishlist, Product> productId;
    public static volatile SingularAttribute<Wishlist, Integer> id;
    public static volatile SingularAttribute<Wishlist, User> userId;

}