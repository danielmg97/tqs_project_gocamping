package com.mycompany.tqs_gocamping;

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
    //http://deti-tqs-08.ua.pt:8080/TQS_GoCamping/webresources/camping/as/sd/df/fg/gh

    @GET
    @Path("{destination}/{arrival}/{duration}/{type}/{people}")
    @Produces(MediaType.TEXT_PLAIN)
    public String getResults(@PathParam("destination") String destination,
                            @PathParam("arrival") String arrival,
                            @PathParam("duration") String duration,
                            @PathParam("type") String type,
                            @PathParam("people") String people) throws ClassNotFoundException {

//            NewJerseyClient p = new NewJerseyClient();
//            return p.findAll_XML(String.class);
            return "";
    }
}
