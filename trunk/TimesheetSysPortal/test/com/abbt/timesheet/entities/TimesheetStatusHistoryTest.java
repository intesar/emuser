package com.abbt.timesheet.entities;
import junit.framework.*;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
/*
 * TimesheetStatusHistoryTest.java
 * JUnit based test
 *
 * Created on May 3, 2007, 11:14 PM
 */

/**
 *
 * @author shannan
 */
public class TimesheetStatusHistoryTest extends TestCase {
    
    public TimesheetStatusHistoryTest(String testName) {
        super(testName);
    }

    protected void setUp() throws Exception {
    }

    protected void tearDown() throws Exception {
    }

    public static Test suite() {
        TestSuite suite = new TestSuite(TimesheetStatusHistoryTest.class);
        
        return suite;
    }

    /**
     * Test of getId method, of class com.abbt.timesheet.entities.TimesheetStatusHistory.
     */
    public void testGetId() {
        System.out.println("getId");
        
        com.abbt.timesheet.entities.TimesheetStatusHistory instance = new com.abbt.timesheet.entities.TimesheetStatusHistory();
        
        Integer expResult = null;
        Integer result = instance.getId();
        assertEquals(expResult, result);
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setId method, of class com.abbt.timesheet.entities.TimesheetStatusHistory.
     */
    public void testSetId() {
        System.out.println("setId");
        
        Integer id = null;
        com.abbt.timesheet.entities.TimesheetStatusHistory instance = new com.abbt.timesheet.entities.TimesheetStatusHistory();
        
        instance.setId(id);
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTimesheetId method, of class com.abbt.timesheet.entities.TimesheetStatusHistory.
     */
    public void testGetTimesheetId() {
        System.out.println("getTimesheetId");
        
        com.abbt.timesheet.entities.TimesheetStatusHistory instance = new com.abbt.timesheet.entities.TimesheetStatusHistory();
        
        int expResult = 0;
        int result = instance.getTimesheetId();
        assertEquals(expResult, result);
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setTimesheetId method, of class com.abbt.timesheet.entities.TimesheetStatusHistory.
     */
    public void testSetTimesheetId() {
        System.out.println("setTimesheetId");
        
        int timesheetId = 0;
        com.abbt.timesheet.entities.TimesheetStatusHistory instance = new com.abbt.timesheet.entities.TimesheetStatusHistory();
        
        instance.setTimesheetId(timesheetId);
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getStatusKey method, of class com.abbt.timesheet.entities.TimesheetStatusHistory.
     */
    public void testGetStatusKey() {
        System.out.println("getStatusKey");
        
        com.abbt.timesheet.entities.TimesheetStatusHistory instance = new com.abbt.timesheet.entities.TimesheetStatusHistory();
        
        String expResult = "";
        String result = instance.getStatusKey();
        assertEquals(expResult, result);
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setStatusKey method, of class com.abbt.timesheet.entities.TimesheetStatusHistory.
     */
    public void testSetStatusKey() {
        System.out.println("setStatusKey");
        
        String statusKey = "";
        com.abbt.timesheet.entities.TimesheetStatusHistory instance = new com.abbt.timesheet.entities.TimesheetStatusHistory();
        
        instance.setStatusKey(statusKey);
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAssignedUser method, of class com.abbt.timesheet.entities.TimesheetStatusHistory.
     */
    public void testGetAssignedUser() {
        System.out.println("getAssignedUser");
        
        com.abbt.timesheet.entities.TimesheetStatusHistory instance = new com.abbt.timesheet.entities.TimesheetStatusHistory();
        
        String expResult = "";
        String result = instance.getAssignedUser();
        assertEquals(expResult, result);
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setAssignedUser method, of class com.abbt.timesheet.entities.TimesheetStatusHistory.
     */
    public void testSetAssignedUser() {
        System.out.println("setAssignedUser");
        
        String assignedUser = "";
        com.abbt.timesheet.entities.TimesheetStatusHistory instance = new com.abbt.timesheet.entities.TimesheetStatusHistory();
        
        instance.setAssignedUser(assignedUser);
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getComments method, of class com.abbt.timesheet.entities.TimesheetStatusHistory.
     */
    public void testGetComments() {
        System.out.println("getComments");
        
        com.abbt.timesheet.entities.TimesheetStatusHistory instance = new com.abbt.timesheet.entities.TimesheetStatusHistory();
        
        String expResult = "";
        String result = instance.getComments();
        assertEquals(expResult, result);
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setComments method, of class com.abbt.timesheet.entities.TimesheetStatusHistory.
     */
    public void testSetComments() {
        System.out.println("setComments");
        
        String comments = "";
        com.abbt.timesheet.entities.TimesheetStatusHistory instance = new com.abbt.timesheet.entities.TimesheetStatusHistory();
        
        instance.setComments(comments);
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of hashCode method, of class com.abbt.timesheet.entities.TimesheetStatusHistory.
     */
    public void testHashCode() {
        System.out.println("hashCode");
        
        com.abbt.timesheet.entities.TimesheetStatusHistory instance = new com.abbt.timesheet.entities.TimesheetStatusHistory();
        
        int expResult = 0;
        int result = instance.hashCode();
        assertEquals(expResult, result);
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of equals method, of class com.abbt.timesheet.entities.TimesheetStatusHistory.
     */
    public void testEquals() {
        System.out.println("equals");
        
        Object object = null;
        com.abbt.timesheet.entities.TimesheetStatusHistory instance = new com.abbt.timesheet.entities.TimesheetStatusHistory();
        
        boolean expResult = true;
        boolean result = instance.equals(object);
        assertEquals(expResult, result);
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class com.abbt.timesheet.entities.TimesheetStatusHistory.
     */
    public void testToString() {
        System.out.println("toString");
        
        com.abbt.timesheet.entities.TimesheetStatusHistory instance = new com.abbt.timesheet.entities.TimesheetStatusHistory();
        
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
