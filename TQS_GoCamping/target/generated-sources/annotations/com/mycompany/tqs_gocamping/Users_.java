package com.mycompany.tqs_gocamping;

import com.mycompany.tqs_gocamping.Parks;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-05-22T17:59:47")
@StaticMetamodel(Users.class)
public class Users_ { 

    public static volatile SingularAttribute<Users, Integer> uid;
    public static volatile SingularAttribute<Users, String> password;
    public static volatile CollectionAttribute<Users, Parks> parksCollection;
    public static volatile SingularAttribute<Users, String> name;

}