package com.mycompany.tqs_gocamping;

import com.mycompany.tqs_gocamping.Place;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-05-28T21:40:42")
@StaticMetamodel(Reservation.class)
public class Reservation_ { 

    public static volatile SingularAttribute<Reservation, Date> start;
    public static volatile SingularAttribute<Reservation, Place> placeId;
    public static volatile SingularAttribute<Reservation, Date> finish;
    public static volatile SingularAttribute<Reservation, Integer> id;
    public static volatile SingularAttribute<Reservation, Integer> people;

}