package com.abbt.timesheet.entities;
import junit.framework.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
/*
 * TimesheetStatusTest.java
 * JUnit based test
 *
 * Created on May 3, 2007, 11:14 PM
 */

/**
 *
 * @author shannan
 */
public class TimesheetStatusTest extends TestCase {
    
    public TimesheetStatusTest(String testName) {
        super(testName);
    }

    protected void setUp() throws Exception {
    }

    protected void tearDown() throws Exception {
    }

    public static Test suite() {
        TestSuite suite = new TestSuite(TimesheetStatusTest.class);
        
        return suite;
    }

    /**
     * Test of getId method, of class com.abbt.timesheet.entities.TimesheetStatus.
     */
    public void testGetId() {
        System.out.println("getId");
        
        com.abbt.timesheet.entities.TimesheetStatus instance = new com.abbt.timesheet.entities.TimesheetStatus();
        
        Integer expResult = null;
        Integer result = instance.getId();
        assertEquals(expResult, result);
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setId method, of class com.abbt.timesheet.entities.TimesheetStatus.
     */
    public void testSetId() {
        System.out.println("setId");
        
        Integer id = null;
        com.abbt.timesheet.entities.TimesheetStatus instance = new com.abbt.timesheet.entities.TimesheetStatus();
        
        instance.setId(id);
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getStatusKey method, of class com.abbt.timesheet.entities.TimesheetStatus.
     */
    public void testGetStatusKey() {
        System.out.println("getStatusKey");
        
        com.abbt.timesheet.entities.TimesheetStatus instance = new com.abbt.timesheet.entities.TimesheetStatus();
        
        String expResult = "";
        String result = instance.getStatusKey();
        assertEquals(expResult, result);
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setStatusKey method, of class com.abbt.timesheet.entities.TimesheetStatus.
     */
    public void testSetStatusKey() {
        System.out.println("setStatusKey");
        
        String statusKey = "";
        com.abbt.timesheet.entities.TimesheetStatus instance = new com.abbt.timesheet.entities.TimesheetStatus();
        
        instance.setStatusKey(statusKey);
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getEditable method, of class com.abbt.timesheet.entities.TimesheetStatus.
     */
    public void testGetEditable() {
        System.out.println("getEditable");
        
        com.abbt.timesheet.entities.TimesheetStatus instance = new com.abbt.timesheet.entities.TimesheetStatus();
        
        boolean expResult = true;
        boolean result = instance.getEditable();
        assertEquals(expResult, result);
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setEditable method, of class com.abbt.timesheet.entities.TimesheetStatus.
     */
    public void testSetEditable() {
        System.out.println("setEditable");
        
        boolean editable = true;
        com.abbt.timesheet.entities.TimesheetStatus instance = new com.abbt.timesheet.entities.TimesheetStatus();
        
        instance.setEditable(editable);
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAssignedBy method, of class com.abbt.timesheet.entities.TimesheetStatus.
     */
    public void testGetAssignedBy() {
        System.out.println("getAssignedBy");
        
        com.abbt.timesheet.entities.TimesheetStatus instance = new com.abbt.timesheet.entities.TimesheetStatus();
        
        String expResult = "";
        String result = instance.getAssignedBy();
        assertEquals(expResult, result);
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setAssignedBy method, of class com.abbt.timesheet.entities.TimesheetStatus.
     */
    public void testSetAssignedBy() {
        System.out.println("setAssignedBy");
        
        String assignedBy = "";
        com.abbt.timesheet.entities.TimesheetStatus instance = new com.abbt.timesheet.entities.TimesheetStatus();
        
        instance.setAssignedBy(assignedBy);
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getComments method, of class com.abbt.timesheet.entities.TimesheetStatus.
     */
    public void testGetComments() {
        System.out.println("getComments");
        
        com.abbt.timesheet.entities.TimesheetStatus instance = new com.abbt.timesheet.entities.TimesheetStatus();
        
        String expResult = "";
        String result = instance.getComments();
        assertEquals(expResult, result);
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setComments method, of class com.abbt.timesheet.entities.TimesheetStatus.
     */
    public void testSetComments() {
        System.out.println("setComments");
        
        String comments = "";
        com.abbt.timesheet.entities.TimesheetStatus instance = new com.abbt.timesheet.entities.TimesheetStatus();
        
        instance.setComments(comments);
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCreatedBy method, of class com.abbt.timesheet.entities.TimesheetStatus.
     */
    public void testGetCreatedBy() {
        System.out.println("getCreatedBy");
        
        com.abbt.timesheet.entities.TimesheetStatus instance = new com.abbt.timesheet.entities.TimesheetStatus();
        
        String expResult = "";
        String result = instance.getCreatedBy();
        assertEquals(expResult, result);
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCreatedBy method, of class com.abbt.timesheet.entities.TimesheetStatus.
     */
    public void testSetCreatedBy() {
        System.out.println("setCreatedBy");
        
        String createdBy = "";
        com.abbt.timesheet.entities.TimesheetStatus instance = new com.abbt.timesheet.entities.TimesheetStatus();
        
        instance.setCreatedBy(createdBy);
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCreatedDate method, of class com.abbt.timesheet.entities.TimesheetStatus.
     */
    public void testGetCreatedDate() {
        System.out.println("getCreatedDate");
        
        com.abbt.timesheet.entities.TimesheetStatus instance = new com.abbt.timesheet.entities.TimesheetStatus();
        
        Date expResult = null;
        Date result = instance.getCreatedDate();
        assertEquals(expResult, result);
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCreatedDate method, of class com.abbt.timesheet.entities.TimesheetStatus.
     */
    public void testSetCreatedDate() {
        System.out.println("setCreatedDate");
        
        Date createdDate = null;
        com.abbt.timesheet.entities.TimesheetStatus instance = new com.abbt.timesheet.entities.TimesheetStatus();
        
        instance.setCreatedDate(createdDate);
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getLastUpdatedBy method, of class com.abbt.timesheet.entities.TimesheetStatus.
     */
    public void testGetLastUpdatedBy() {
        System.out.println("getLastUpdatedBy");
        
        com.abbt.timesheet.entities.TimesheetStatus instance = new com.abbt.timesheet.entities.TimesheetStatus();
        
        String expResult = "";
        String result = instance.getLastUpdatedBy();
        assertEquals(expResult, result);
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setLastUpdatedBy method, of class com.abbt.timesheet.entities.TimesheetStatus.
     */
    public void testSetLastUpdatedBy() {
        System.out.println("setLastUpdatedBy");
        
        String lastUpdatedBy = "";
        com.abbt.timesheet.entities.TimesheetStatus instance = new com.abbt.timesheet.entities.TimesheetStatus();
        
        instance.setLastUpdatedBy(lastUpdatedBy);
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getLastUpdatedDate method, of class com.abbt.timesheet.entities.TimesheetStatus.
     */
    public void testGetLastUpdatedDate() {
        System.out.println("getLastUpdatedDate");
        
        com.abbt.timesheet.entities.TimesheetStatus instance = new com.abbt.timesheet.entities.TimesheetStatus();
        
        Date expResult = null;
        Date result = instance.getLastUpdatedDate();
        assertEquals(expResult, result);
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setLastUpdatedDate method, of class com.abbt.timesheet.entities.TimesheetStatus.
     */
    public void testSetLastUpdatedDate() {
        System.out.println("setLastUpdatedDate");
        
        Date lastUpdatedDate = null;
        com.abbt.timesheet.entities.TimesheetStatus instance = new com.abbt.timesheet.entities.TimesheetStatus();
        
        instance.setLastUpdatedDate(lastUpdatedDate);
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTimesheetCollection method, of class com.abbt.timesheet.entities.TimesheetStatus.
     */
    public void testGetTimesheetCollection() {
        System.out.println("getTimesheetCollection");
        
        com.abbt.timesheet.entities.TimesheetStatus instance = new com.abbt.timesheet.entities.TimesheetStatus();
        
        Collection<com.abbt.timesheet.entities.Timesheet> expResult = null;
        Collection<com.abbt.timesheet.entities.Timesheet> result = instance.getTimesheetCollection();
        assertEquals(expResult, result);
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setTimesheetCollection method, of class com.abbt.timesheet.entities.TimesheetStatus.
     */
    public void testSetTimesheetCollection() {
        System.out.println("setTimesheetCollection");
        
        Collection<com.abbt.timesheet.entities.Timesheet> timesheetCollection = null;
        com.abbt.timesheet.entities.TimesheetStatus instance = new com.abbt.timesheet.entities.TimesheetStatus();
        
        instance.setTimesheetCollection(timesheetCollection);
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of hashCode method, of class com.abbt.timesheet.entities.TimesheetStatus.
     */
    public void testHashCode() {
        System.out.println("hashCode");
        
        com.abbt.timesheet.entities.TimesheetStatus instance = new com.abbt.timesheet.entities.TimesheetStatus();
        
        int expResult = 0;
        int result = instance.hashCode();
        assertEquals(expResult, result);
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of equals method, of class com.abbt.timesheet.entities.TimesheetStatus.
     */
    public void testEquals() {
        System.out.println("equals");
        
        Object object = null;
        com.abbt.timesheet.entities.TimesheetStatus instance = new com.abbt.timesheet.entities.TimesheetStatus();
        
        boolean expResult = true;
        boolean result = instance.equals(object);
        assertEquals(expResult, result);
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class com.abbt.timesheet.entities.TimesheetStatus.
     */
    public void testToString() {
        System.out.println("toString");
        
        com.abbt.timesheet.entities.TimesheetStatus instance = new com.abbt.timesheet.entities.TimesheetStatus();
        
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
