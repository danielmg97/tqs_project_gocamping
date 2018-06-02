/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.tqs_gocamping.tests;

import com.mycompany.tqs_gocamping.Place;
import com.mycompany.tqs_gocamping.PlaceClient;
import com.mycompany.tqs_gocamping.PlaceClientFactory;
import com.mycompany.tqs_gocamping.RESTResource;
import com.mycompany.tqs_gocamping.UserClient;
import com.mycompany.tqs_gocamping.UserClientFactory;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.mockito.Matchers;
import org.mockito.Mockito;
import static org.mockito.Mockito.when;

/**
 *
 * @author Admin
 */
public class RESTResourceMockTest {
    
    RESTResource rest;
    
    @Before
    public void init() {
        rest = new RESTResource();
        this.rest.em = Mockito.mock(EntityManager.class);
    }
    
    public void mockQuery(String name, List<Place> results) {
        Query mockedQuery = Mockito.mock(Query.class);
        
        when(mockedQuery.getResultList()).thenReturn(results);
        when(this.rest.em.createNamedQuery(name)).thenReturn(mockedQuery);
        when(mockedQuery.setParameter(
                Matchers.anyString(),
                Matchers.anyObject())
        ).thenReturn(mockedQuery);
    }
    
    @Test
    public void testGetResultsFull() throws ClassNotFoundException {
        List<Place> listOfPlaces = new ArrayList<>();
        
        Place place = Mockito.mock(Place.class);        
        listOfPlaces.add(place);
        
        mockQuery("Place.findByJoinTypeAddress", listOfPlaces);
        
        String xml = rest.getResultsFull("Odio", "a", "b", "Tenda", 0);
        
        assertNotNull(xml);
        assertThat(xml, not("<places></places>"));
    }
    
    @Test
    public void testGetResultsNoType() throws ClassNotFoundException {
        List<Place> listOfPlaces = new ArrayList<>();
        
        Place place = Mockito.mock(Place.class);        
        listOfPlaces.add(place);
        
        mockQuery("Place.findByJoinAddress", listOfPlaces);
        
        String xml = rest.getResultsNoType("Odio", "a", "b", 0);
        
        assertNotNull(xml);
        assertThat(xml, not("<places></places>"));
    }
    
    @Test
    public void testGetResultsNoDestination() throws ClassNotFoundException {
        List<Place> listOfPlaces = new ArrayList<>();
        
        Place place = Mockito.mock(Place.class);        
        listOfPlaces.add(place);
        
        mockQuery("Place.findByName", listOfPlaces);
        
        String xml = rest.getResultsNoDestination("a", "b", "Tenda", 0);
        
        assertNotNull(xml);
        assertThat(xml, not("<places></places>"));
    }
    
    @Test
    public void testGetResultsNoDestinationV2() throws ClassNotFoundException {
        List<Place> listOfPlaces = new ArrayList<>();
        
        Place place = Mockito.mock(Place.class);        
        listOfPlaces.add(place);
        
        mockQuery("Place.findByJoinTypePeople", listOfPlaces);
        
        String xml = rest.getResultsNoDestination("a", "b", "Tenda", 3);
        
        assertNotNull(xml);
        assertThat(xml, not("<places></places>"));
    }
    
    @Test
    public void testGetResultsNothing() throws ClassNotFoundException {
        List<Place> listOfPlaces = new ArrayList<>();
        
        Place place = Mockito.mock(Place.class);        
        listOfPlaces.add(place);
        
        mockQuery("Place.findByCapacity", listOfPlaces);
        
        String xml = rest.getResultsNothing("a", "b", 2);
        
        assertNotNull(xml);
        assertThat(xml, not("<places></places>"));
    }
    
    @Test
    public void testGetResultsNothingV2() throws ClassNotFoundException {
        
        PlaceClientFactory pcf = Mockito.mock(PlaceClientFactory.class);
        PlaceClient pc = Mockito.mock(PlaceClient.class);
        
        rest.setPlaceClientFactory(pcf);
        
        when(pcf.getPlaceClient()).thenReturn(pc);
        
        when(pc.findAll_XML(String.class)).thenReturn("<places><place>...</place></places>");
        
        String xml = rest.getResultsNothing("a", "b", 0);
        
        assertNotNull(xml);
        assertThat(xml, not("<places></places>"));
    }
    
    @Test
    public void testGetLogin() throws ClassNotFoundException {
        List<Place> listOfPlaces = new ArrayList<>();
        
        Place place = Mockito.mock(Place.class);        
        listOfPlaces.add(place);
        
        mockQuery("User.findByLogin", listOfPlaces);
        
        String result = rest.getLogin("campingfanboy123", "1234");
        
        assertNotNull(result);
        assertThat(result, is("True"));
    }
    
    @Test
    public void testGetLoginV2() throws ClassNotFoundException {
        List<Place> listOfPlaces = new ArrayList<>();
        
        String user = "campingfanboy123";
        String password = "1234";
        
        mockQuery("User.findByLogin", listOfPlaces);
        
        String result = rest.getLogin(user, password);
        
        assertNotNull(result);
        assertThat(result, is("False"));
    }
    
    @Test
    public void testGetRegister() throws ClassNotFoundException {
        List<Place> listOfPlaces = new ArrayList<>();
        
        Place place = Mockito.mock(Place.class);        
        listOfPlaces.add(place);
        
        mockQuery("User.findByRegister", listOfPlaces);
        
        String result = rest.getRegister("campingfanboy123", "1234", "cfb@sharklazers.net");
        
        assertNotNull(result);
        assertThat(result, is("False"));
    }
    
    @Test
    public void testGetRegisterV2() throws ClassNotFoundException {
        List<Place> listOfPlaces = new ArrayList<>();
        
        String user = "campingfanboy123";
        String password = "1234";
        String email = "cfb@sharklazors.net";
        
        UserClientFactory ucf = Mockito.mock(UserClientFactory.class);
        UserClient uc = Mockito.mock(UserClient.class);
        
        rest.setUserClientFactory(ucf);
        
        when(ucf.getUserClient()).thenReturn(uc);
        
        mockQuery("User.findByRegister", listOfPlaces);
        
        String result = rest.getRegister(user, password, email);
        
        assertNotNull(result);
        assertThat(result, is("True"));
    }
}
