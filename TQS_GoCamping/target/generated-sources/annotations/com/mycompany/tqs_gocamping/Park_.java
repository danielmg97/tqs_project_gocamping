package com.mycompany.tqs_gocamping;

import com.mycompany.tqs_gocamping.Place;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-05-31T20:39:13")
@StaticMetamodel(Park.class)
public class Park_ { 

    public static volatile SingularAttribute<Park, String> address;
    public static volatile SingularAttribute<Park, String> name;
    public static volatile SingularAttribute<Park, Integer> id;
    public static volatile SingularAttribute<Park, String> pic;
    public static volatile CollectionAttribute<Park, Place> placeCollection;

}