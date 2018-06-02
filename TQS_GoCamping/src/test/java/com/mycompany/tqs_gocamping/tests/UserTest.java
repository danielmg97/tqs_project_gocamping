/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.tqs_gocamping.tests;

import com.mycompany.tqs_gocamping.User;
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
public class UserTest {
    
    public UserTest() {
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
     * Test of equals method, of class User.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object object = null;
        User u1= new User(),u2 = new User();
        
        u1.setEmail("tqs@ua.pt");
        u1.setName("tqs");
        u1.setPassword("1234");
        u1.setUid(12);
        u2.setEmail("tqs@ua.pt");
        u2.setName("tqs");
        u2.setPassword("1234");
        u2.setUid(12);
        
        boolean expResult = true;
        boolean result = u1.equals(u2);
        assertEquals(expResult, result);
    }

}
