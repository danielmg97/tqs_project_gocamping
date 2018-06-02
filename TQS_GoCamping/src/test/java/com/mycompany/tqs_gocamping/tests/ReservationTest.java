/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.tqs_gocamping.tests;

import com.mycompany.tqs_gocamping.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
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
public class ReservationTest {
    
    public ReservationTest() {
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
     * Test of equals method, of class Reservation.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object object = null;
        Reservation r1= new Reservation(),r2 = new Reservation();
        
        Place p1=new Place();

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
        
        
        
        String string = "May 2, 2018";
        DateFormat format = new SimpleDateFormat("MMMM d, yyyy", Locale.ENGLISH);
        Date startDate = null,finishDate = null;
        try {
            startDate = format.parse(string);
            finishDate=startDate;
                
        } catch (ParseException ex) {
            Logger.getLogger(ReservationTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        r1.setId(123);
        r1.setPeople(4);
        r1.setPlaceId(p1);
        r1.setStart(startDate);
        r1.setFinish(finishDate);
        
        r2.setId(1);
        r2.setPeople(4);
        r2.setPlaceId(p1);
        r2.setStart(startDate);
        r2.setFinish(finishDate);
        
        boolean expResult = false;
        boolean result = r1.equals(r2);
        assertEquals(expResult, result);

    }

    
    
}
