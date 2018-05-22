package com.mycompany.tqs_gocamping;

import com.mycompany.tqs_gocamping.Places;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-05-22T17:59:47")
@StaticMetamodel(Reservations.class)
public class Reservations_ { 

    public static volatile SingularAttribute<Reservations, Date> start;
    public static volatile SingularAttribute<Reservations, Places> placeId;
    public static volatile SingularAttribute<Reservations, Date> finish;
    public static volatile SingularAttribute<Reservations, Integer> id;
    public static volatile SingularAttribute<Reservations, Integer> people;

}