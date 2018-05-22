package com.mycompany.tqs_gocamping;

import com.mycompany.tqs_gocamping.Parks;
import com.mycompany.tqs_gocamping.Reservations;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-05-22T17:59:47")
@StaticMetamodel(Places.class)
public class Places_ { 

    public static volatile CollectionAttribute<Places, Reservations> reservationsCollection;
    public static volatile SingularAttribute<Places, Float> price;
    public static volatile SingularAttribute<Places, String> name;
    public static volatile SingularAttribute<Places, String> description;
    public static volatile SingularAttribute<Places, Integer> id;
    public static volatile SingularAttribute<Places, Parks> parkId;
    public static volatile SingularAttribute<Places, Integer> capacity;

}