/*
 * EmployeeServiceImplTest.java
 * JUnit based test
 *
 * Created on April 2, 2007, 8:50 PM
 */

package com.abbt.crm.services;

import junit.framework.*;
import com.abbt.crm.dao.GenericDAO;
import com.abbt.crm.dao.GenericDAOImpl;
import com.abbt.crm.entity.Contact;
import java.util.List;

/**
 *
 * @author shannan
 */
public class EmployeeServiceImplTest extends TestCase {
    
    public EmployeeServiceImplTest(String testName) {
        super(testName);
    }            

    protected void setUp() throws Exception {
    }

    protected void tearDown() throws Exception {
    }

    public static Test suite() {
        TestSuite suite = new TestSuite(EmployeeServiceImplTest.class);
        
        return suite;
    }

    /**
     * Test of findRecentEmployeeTask method, of class com.abbt.crm.services.TaskServiceImpl.
     */
    public void testFindRecentEmployeeTask() {
        System.out.println("findRecentEmployeeTask");
        
        String username = "archana";
        TaskServiceImpl instance = new TaskServiceImpl();
        
        List<Contact> expResult = null;
        List<Contact> result = instance.findRecentEmployeeTask(username);
        assertEquals(1, result.size());
        
        
    }

  
    
}
