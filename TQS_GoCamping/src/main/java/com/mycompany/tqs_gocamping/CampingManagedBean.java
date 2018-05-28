package com.mycompany.tqs_gocamping;

import java.io.IOException;
import java.io.StringReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Element;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

@Named(value = "CampingManagedBean")
@RequestScoped
public class CampingManagedBean {
    private List<String> types = new ArrayList<String>();
    private String destination;
    private String arrivalDate;
    private String leavingDate;
    private String type;
    private int people;
    
    private String selectedPlace;

    public CampingManagedBean() {
       types.add("Casa");
       types.add("Tenda");
    } 

    public void setDestination(String destination){
        this.destination=destination;
    }
    public void setArrivalDate(String arrivalDate){
        this.arrivalDate=arrivalDate;
    }
    public void setLeavingDate(String leavingDate){
        this.leavingDate=leavingDate;
    }
    public void setType(String type){
        this.type=type;
    }
    public void setPeople(int people){
        this.people=people;
    }
    public String getDestination(){
        return destination;
    }
    public String getArrivalDate(){
        return arrivalDate;
    }public String getLeavingDate(){
        return leavingDate;
    }public String getType(){
        return type;
    }public int getPeople(){
        return people;
    } 
    public List getTypes(){
        return types;
    }
    
    public String moveToSearchPage(){
        return "searchPage";
    }
    
    public List<Place> getPlaces() throws ParserConfigurationException, SAXException, IOException {
        List<Place> places = new ArrayList<Place>();
        PlaceClient pc = new PlaceClient();
        String xmlRecords = pc.findAll_XML(String.class);
        try{
            DocumentBuilder db = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            InputSource is = new InputSource();
            is.setCharacterStream(new StringReader(xmlRecords));
            Document doc = db.parse(is);
            NodeList nList = doc.getElementsByTagName("place");
            
            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    Place p = new Place();
                    p.setId(Integer.parseInt(eElement.getElementsByTagName("id").item(0).getTextContent()));
                    p.setName(eElement.getElementsByTagName("name").item(0).getTextContent());
                    
                    p.setCapacity(Integer.parseInt(eElement.getElementsByTagName("capacity").item(0).getTextContent()));
                    p.setDescription(eElement.getElementsByTagName("description").item(0).getTextContent());

                    NodeList insideList = nNode.getChildNodes();
                    Park pk = new Park();
                    for (int temp1 = 0; temp1 < insideList.getLength(); temp1++) {
                        Node childNode = insideList.item(temp1);
                        if (childNode.getNodeType() == Node.ELEMENT_NODE) {
                            Element eElement1 = (Element) nNode;
                            pk.setAddress(eElement1.getElementsByTagName("address").item(0).getTextContent());
                            pk.setId(Integer.parseInt(eElement1.getElementsByTagName("id").item(0).getTextContent()));
                            pk.setName(eElement1.getElementsByTagName("name").item(0).getTextContent());
                            pk.setPic(eElement1.getElementsByTagName("pic").item(0).getTextContent());
                        }
                    }
                    p.setParkId(pk);
                    p.setPic(eElement.getElementsByTagName("pic").item(0).getTextContent());
                    //TODO meter isto na BD como FLOAT!!!!!!!!!!!!!
                    p.setPrice(Float.parseFloat(eElement.getElementsByTagName("price").item(0).getTextContent()));
                    places.add(p);
                }
            }
        }catch(Exception e){
        }
        return places;
    }
    
    public String getSelectedPlace() {
        return selectedPlace;
    }
 
    public void setSelectedPlace(String selectedPlace) {
        this.selectedPlace = selectedPlace;
    }
}

