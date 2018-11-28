package Project.model;

import Project.model.Product;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-11-28T21:58:24")
@StaticMetamodel(Brand.class)
public class Brand_ { 

    public static volatile SingularAttribute<Brand, String> name;
    public static volatile SingularAttribute<Brand, Integer> id;
    public static volatile ListAttribute<Brand, Product> productList;

}