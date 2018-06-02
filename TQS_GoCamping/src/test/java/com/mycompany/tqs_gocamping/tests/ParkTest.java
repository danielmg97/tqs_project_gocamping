/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.tqs_gocamping.tests;

import com.mycompany.tqs_gocamping.Park;
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
public class ParkTest {
   
    public ParkTest() {
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
     * Test of equals method, of class Park.
     */
    @Test
    public void testEquals() {
        System.out.println("Testing equals");
        Object object = null;
        Park p1 = new Park(),p2 = new Park();
        
        p1.setId(39);
        p1.setName("Tenda");
        p1.setAddress("1454 Odio, Street");
        p1.setPic("https://odditymall.com/includes/content/house-shaped-front-porch-tent-0.jpg");
        
        p2.setId(39);
        p2.setName("Tenda");
        p2.setAddress("1454 Odio, Street");
        p2.setPic("https://odditymall.com/includes/content/house-shaped-front-porch-tent-0.jpg");
        
        boolean expResult = true;
        boolean result = p1.equals(p2);
        assertEquals(expResult, result);
     
    }
    
}
