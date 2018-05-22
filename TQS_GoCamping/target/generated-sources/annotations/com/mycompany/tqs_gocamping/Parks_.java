package com.mycompany.tqs_gocamping;

import com.mycompany.tqs_gocamping.Places;
import com.mycompany.tqs_gocamping.Users;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-05-22T17:59:47")
@StaticMetamodel(Parks.class)
public class Parks_ { 

    public static volatile SingularAttribute<Parks, Users> uid;
    public static volatile SingularAttribute<Parks, String> address;
    public static volatile SingularAttribute<Parks, String> name;
    public static volatile CollectionAttribute<Parks, Places> placesCollection;
    public static volatile SingularAttribute<Parks, Integer> id;

}