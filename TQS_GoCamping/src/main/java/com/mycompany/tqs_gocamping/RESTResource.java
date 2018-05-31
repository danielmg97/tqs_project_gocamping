package com.mycompany.tqs_gocamping;

import java.io.Console;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
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
    //http://deti-tqs-08.ua.pt:8080/TQS_GoCamping/webresources/camping/full/as/sd/df/fg/gh

    @PersistenceContext(unitName = "com.mycompany_TQS_GoCamping_war_1.0-SNAPSHOTPU")
    private EntityManager em;
    
    private String resultGenerator(List<Place> res){
        StringBuilder sb = new StringBuilder();
        res.stream().forEach(s -> sb.append(s));
        return sb.toString();
    }
    
    
    @GET
    @Path("full/{destination}/{arrival}/{duration}/{type}/{people}")
    @Produces(MediaType.TEXT_PLAIN)
    public String getResultsFull(@PathParam("destination") String destination,
                            @PathParam("arrival") String arrival,
                            @PathParam("duration") String duration,
                            @PathParam("type") String type,
                            @PathParam("people") int people) throws ClassNotFoundException {
        if(people != 0){
                List<Place> results = em.createNamedQuery("Place.findByJoinTypeAddressPeople")
                        .setParameter("address", "%"+destination+"%")
                        .setParameter("type", type)
                        .setParameter("capacity", people)
                        .getResultList();
                return "<places>"+resultGenerator(results)+"</places>";
        }
        List<Place> results = em.createNamedQuery("Place.findByJoinTypeAddress")
                    .setParameter("address", "%"+destination+"%")
                    .setParameter("type", type)
                    .getResultList();
            return "<places>"+resultGenerator(results)+"</places>";
    }
    
    @GET
    @Path("noType/{destination}/{arrival}/{duration}/{people}")
    @Produces(MediaType.TEXT_PLAIN)
    public String getResultsNoType(@PathParam("destination") String destination,
                            @PathParam("arrival") String arrival,
                            @PathParam("duration") String duration,
                            @PathParam("people") int people) throws ClassNotFoundException {
        if(people != 0){
                List<Place> results = em.createNamedQuery("Place.findByJoinAddressPeople")
                        .setParameter("address", "%"+destination+"%")
                        .setParameter("capacity", people)
                        .getResultList();
                return "<places>"+resultGenerator(results)+"</places>";
        }
        List<Place> results = em.createNamedQuery("Place.findByJoinAddress")
                    .setParameter("address", "%"+destination+"%")
                    .getResultList();
            return "<places>"+resultGenerator(results)+"</places>";
    }
    
    @GET
    @Path("noDestination/{arrival}/{duration}/{type}/{people}")
    @Produces(MediaType.TEXT_PLAIN)
    public String getResultsNoDestination(@PathParam("arrival") String arrival,
                            @PathParam("duration") String duration,
                            @PathParam("type") String type,
                            @PathParam("people") int people) throws ClassNotFoundException {
        if(people != 0){
                List<Place> results = em.createNamedQuery("Place.findByJoinTypePeople")
                        .setParameter("type", type)
                        .setParameter("capacity", people)
                        .getResultList();
                return "<places>"+resultGenerator(results)+"</places>";
        }
        List<Place> results = em.createNamedQuery("Place.findByName")
                    .setParameter("type", type)
                    .getResultList();
            return "<places>"+resultGenerator(results)+"</places>";
    }
    
    @GET
    @Path("nothing/{arrival}/{duration}/{people}")
    @Produces(MediaType.TEXT_PLAIN)
    public String getResultsNothing(@PathParam("arrival") String arrival,
                            @PathParam("duration") String duration, 
                            @PathParam("people") int people) throws ClassNotFoundException {
        if(people != 0){
                List<Place> results = em.createNamedQuery("Place.findByCapacity")
                        .setParameter("capacity", people)
                        .getResultList();
                return "<places>"+resultGenerator(results)+"</places>";
        }
        PlaceClient pc = new PlaceClient();
        return pc.findAll_XML(String.class);
    }
}
