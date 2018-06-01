package com.mycompany.tqs_gocamping;

import com.mycompany.tqs_gocamping.Park;
import com.mycompany.tqs_gocamping.Reservation;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-06-01T16:32:34")
@StaticMetamodel(Place.class)
public class Place_ { 

    public static volatile SingularAttribute<Place, Float> price;
    public static volatile SingularAttribute<Place, String> name;
    public static volatile SingularAttribute<Place, String> description;
    public static volatile CollectionAttribute<Place, Reservation> reservationCollection;
    public static volatile SingularAttribute<Place, Integer> id;
    public static volatile SingularAttribute<Place, String> pic;
    public static volatile SingularAttribute<Place, Park> parkId;
    public static volatile SingularAttribute<Place, Integer> capacity;

}