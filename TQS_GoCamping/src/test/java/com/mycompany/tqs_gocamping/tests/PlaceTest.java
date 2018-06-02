/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.tqs_gocamping.tests;

import com.mycompany.tqs_gocamping.*;
import java.util.Collection;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author SomeoneElse
 */
public class PlaceTest {
    
    public PlaceTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

  
    /**
     * Test of equals method, of class Place.
     */
    @Test
    public void testEquals() {
        System.out.println("Testing equals");
        Object object = null;
        Place p1=new Place(),p2 = new Place();
        
        //place 1
        p1.setName("Tenda");
        p1.setId(39);
        p1.setCapacity(4);
        p1.setPic(" https://odditymall.com/includes/content/house-shaped-front-porch-tent-0.jpg ");
            Park park1 = new Park();
            park1.setId(39);
            park1.setName("Tenda");
            park1.setAddress("1454 Odio, Street");
            park1.setPic("https://odditymall.com/includes/content/house-shaped-front-porch-tent-0.jpg");
        p1.setParkId(park1);
        p1.setDescription("eu, ligula. Aenean euismod mauris eu elit. Nulla facilisi. Sed neque. Sed eget lacus. Mauris non dui nec urna suscipit nonummy. Fusce fermentum fermentum arcu. Vestibulum ante ipsum primis in");
        p1.setPrice((float) 572.55);
        
         //place 2
        p2.setName("Tenda");
        p2.setId(39);
        p2.setCapacity(4);
        p2.setPic(" https://odditymall.com/includes/content/house-shaped-front-porch-tent-0.jpg ");
            Park park2 = new Park();
            park2.setId(39);
            park2.setName("Tenda");
            park2.setAddress("1454 Odio, Street");
            park2.setPic("https://odditymall.com/includes/content/house-shaped-front-porch-tent-0.jpg");
        p2.setParkId(park2);
        p2.setDescription("eu, ligula. Aenean euismod mauris eu elit. Nulla facilisi. Sed neque. Sed eget lacus. Mauris non dui nec urna suscipit nonummy. Fusce fermentum fermentum arcu. Vestibulum ante ipsum primis in");
        p2.setPrice((float) 572.55);
        
        boolean expResult = true;
        boolean result = p1.equals(p2);
        assertEquals(expResult, result);

    }
    
}
