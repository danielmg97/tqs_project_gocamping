package com.mycompany.tqs_gocamping;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;


/**
 * REST Web Service
 *
 * @author danie
 */
@Path("camping")
public class RESTResource {
    
    public String starter() throws ClassNotFoundException {

       Connection conn = null;
       Statement st;
       ResultSet rs;

       try{

           String url = "jdbc:mysql://deti-tqs-08.ua.pt:3306/tqssandbox";
           Class.forName("com.mysql.jdbc.Driver").newInstance();
           conn = DriverManager.getConnection (url,"root","1234");
           String query = "SELECT * FROM Parks";
           st=conn.createStatement();
           rs=st.executeQuery(query);
           while(rs.next()){
               int id = rs.getInt("id");
               String name = rs.getString("name");
               String address = rs.getString("address");
               return id+name+address;
           }
           st.close();
        }
       catch (Exception e){
           e.printStackTrace();

       }
       finally{
           if (conn != null){
               try{
                   conn.close ();
                   System.out.println ("Database connection terminated");
               }
               catch (Exception e){  }
           }
       }
       return "";
    }
    
    @GET
    @Path("{destination}/{arrival}/{duration}/{type}/{people}")
    @Produces(MediaType.TEXT_PLAIN)
    public String getResults(@PathParam("destination") String destination,
                            @PathParam("arrival") String arrival,
                            @PathParam("duration") String duration,
                            @PathParam("type") String type,
                            @PathParam("people") String people) throws ClassNotFoundException {
//        return starter();
            return "";
    }
}
