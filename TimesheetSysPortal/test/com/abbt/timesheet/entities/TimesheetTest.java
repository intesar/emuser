package com.abbt.timesheet.entities;
import junit.framework.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
/*
 * TimesheetTest.java
 * JUnit based test
 *
 * Created on May 3, 2007, 11:14 PM
 */

/**
 *
 * @author shannan
 */
public class TimesheetTest extends TestCase {
    
    public TimesheetTest(String testName) {
        super(testName);
    }

    protected void setUp() throws Exception {
    }

    protected void tearDown() throws Exception {
    }

    public static Test suite() {
        TestSuite suite = new TestSuite(TimesheetTest.class);
        
        return suite;
    }

    /**
     * Test of getId method, of class com.abbt.timesheet.entities.Timesheet.
     */
    public void testGetId() {
        System.out.println("getId");
        
        com.abbt.timesheet.entities.Timesheet instance = new com.abbt.timesheet.entities.Timesheet();
        
        Integer expResult = null;
        Integer result = instance.getId();
        assertEquals(expResult, result);
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setId method, of class com.abbt.timesheet.entities.Timesheet.
     */
    public void testSetId() {
        System.out.println("setId");
        
        Integer id = null;
        com.abbt.timesheet.entities.Timesheet instance = new com.abbt.timesheet.entities.Timesheet();
        
        instance.setId(id);
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTimesheetDate method, of class com.abbt.timesheet.entities.Timesheet.
     */
    public void testGetTimesheetDate() {
        System.out.println("getTimesheetDate");
        
        com.abbt.timesheet.entities.Timesheet instance = new com.abbt.timesheet.entities.Timesheet();
        
        Date expResult = null;
        Date result = instance.getTimesheetDate();
        assertEquals(expResult, result);
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setTimesheetDate method, of class com.abbt.timesheet.entities.Timesheet.
     */
    public void testSetTimesheetDate() {
        System.out.println("setTimesheetDate");
        
        Date timesheetDate = null;
        com.abbt.timesheet.entities.Timesheet instance = new com.abbt.timesheet.entities.Timesheet();
        
        instance.setTimesheetDate(timesheetDate);
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDaysFor method, of class com.abbt.timesheet.entities.Timesheet.
     */
    public void testGetDaysFor() {
        System.out.println("getDaysFor");
        
        com.abbt.timesheet.entities.Timesheet instance = new com.abbt.timesheet.entities.Timesheet();
        
        int expResult = 0;
        int result = instance.getDaysFor();
        assertEquals(expResult, result);
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDaysFor method, of class com.abbt.timesheet.entities.Timesheet.
     */
    public void testSetDaysFor() {
        System.out.println("setDaysFor");
        
        int daysFor = 0;
        com.abbt.timesheet.entities.Timesheet instance = new com.abbt.timesheet.entities.Timesheet();
        
        instance.setDaysFor(daysFor);
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCreatedBy method, of class com.abbt.timesheet.entities.Timesheet.
     */
    public void testGetCreatedBy() {
        System.out.println("getCreatedBy");
        
        com.abbt.timesheet.entities.Timesheet instance = new com.abbt.timesheet.entities.Timesheet();
        
        String expResult = null;
        String result = instance.getCreatedBy();
        assertEquals(expResult, result);
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCreatedBy method, of class com.abbt.timesheet.entities.Timesheet.
     */
    public void testSetCreatedBy() {
        System.out.println("setCreatedBy");
        
        String createdBy = null;
        com.abbt.timesheet.entities.Timesheet instance = new com.abbt.timesheet.entities.Timesheet();
        
        instance.setCreatedBy(createdBy);
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCreatedDate method, of class com.abbt.timesheet.entities.Timesheet.
     */
    public void testGetCreatedDate() {
        System.out.println("getCreatedDate");
        
        com.abbt.timesheet.entities.Timesheet instance = new com.abbt.timesheet.entities.Timesheet();
        
        Date expResult = null;
        Date result = instance.getCreatedDate();
        assertEquals(expResult, result);
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCreatedDate method, of class com.abbt.timesheet.entities.Timesheet.
     */
    public void testSetCreatedDate() {
        System.out.println("setCreatedDate");
        
        Date createdDate = null;
        com.abbt.timesheet.entities.Timesheet instance = new com.abbt.timesheet.entities.Timesheet();
        
        instance.setCreatedDate(createdDate);
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getLastUpdatedBy method, of class com.abbt.timesheet.entities.Timesheet.
     */
    public void testGetLastUpdatedBy() {
        System.out.println("getLastUpdatedBy");
        
        com.abbt.timesheet.entities.Timesheet instance = new com.abbt.timesheet.entities.Timesheet();
        
        String expResult = null;
        String result = instance.getLastUpdatedBy();
        assertEquals(expResult, result);
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setLastUpdatedBy method, of class com.abbt.timesheet.entities.Timesheet.
     */
    public void testSetLastUpdatedBy() {
        System.out.println("setLastUpdatedBy");
        
        String lastUpdatedBy = null;
        com.abbt.timesheet.entities.Timesheet instance = new com.abbt.timesheet.entities.Timesheet();
        
        instance.setLastUpdatedBy(lastUpdatedBy);
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getLastUpdatedDate method, of class com.abbt.timesheet.entities.Timesheet.
     */
    public void testGetLastUpdatedDate() {
        System.out.println("getLastUpdatedDate");
        
        com.abbt.timesheet.entities.Timesheet instance = new com.abbt.timesheet.entities.Timesheet();
        
        Date expResult = null;
        Date result = instance.getLastUpdatedDate();
        assertEquals(expResult, result);
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setLastUpdatedDate method, of class com.abbt.timesheet.entities.Timesheet.
     */
    public void testSetLastUpdatedDate() {
        System.out.println("setLastUpdatedDate");
        
        Date lastUpdatedDate = null;
        com.abbt.timesheet.entities.Timesheet instance = new com.abbt.timesheet.entities.Timesheet();
        
        instance.setLastUpdatedDate(lastUpdatedDate);
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTimesheetDetailCollection method, of class com.abbt.timesheet.entities.Timesheet.
     */
    public void testGetTimesheetDetailCollection() {
        System.out.println("getTimesheetDetailCollection");
        
        com.abbt.timesheet.entities.Timesheet instance = new com.abbt.timesheet.entities.Timesheet();
        
        Collection<com.abbt.timesheet.entities.TimesheetDetail> expResult = null;
        Collection<com.abbt.timesheet.entities.TimesheetDetail> result = instance.getTimesheetDetailCollection();
        assertEquals(expResult, result);
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setTimesheetDetailCollection method, of class com.abbt.timesheet.entities.Timesheet.
     */
    public void testSetTimesheetDetailCollection() {
        System.out.println("setTimesheetDetailCollection");
        
        Collection<com.abbt.timesheet.entities.TimesheetDetail> timesheetDetailCollection = null;
        com.abbt.timesheet.entities.Timesheet instance = new com.abbt.timesheet.entities.Timesheet();
        
        instance.setTimesheetDetailCollection(timesheetDetailCollection);
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getUserEmail method, of class com.abbt.timesheet.entities.Timesheet.
     */
    public void testGetUserEmail() {
        System.out.println("getUserEmail");
        
        com.abbt.timesheet.entities.Timesheet instance = new com.abbt.timesheet.entities.Timesheet();
        
        com.abbt.timesheet.entities.User expResult = null;
        com.abbt.timesheet.entities.User result = instance.getUserEmail();
        assertEquals(expResult, result);
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setUserEmail method, of class com.abbt.timesheet.entities.Timesheet.
     */
    public void testSetUserEmail() {
        System.out.println("setUserEmail");
        
        com.abbt.timesheet.entities.User userEmail = null;
        com.abbt.timesheet.entities.Timesheet instance = new com.abbt.timesheet.entities.Timesheet();
        
        instance.setUserEmail(userEmail);
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getClientCompany method, of class com.abbt.timesheet.entities.Timesheet.
     */
    public void testGetClientCompany() {
        System.out.println("getClientCompany");
        
        com.abbt.timesheet.entities.Timesheet instance = new com.abbt.timesheet.entities.Timesheet();
        
        com.abbt.timesheet.entities.UserCompany expResult = null;
        com.abbt.timesheet.entities.UserCompany result = instance.getClientCompany();
        assertEquals(expResult, result);
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setClientCompany method, of class com.abbt.timesheet.entities.Timesheet.
     */
    public void testSetClientCompany() {
        System.out.println("setClientCompany");
        
        com.abbt.timesheet.entities.UserCompany clientCompany = null;
        com.abbt.timesheet.entities.Timesheet instance = new com.abbt.timesheet.entities.Timesheet();
        
        instance.setClientCompany(clientCompany);
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getStatus method, of class com.abbt.timesheet.entities.Timesheet.
     */
    public void testGetStatus() {
        System.out.println("getStatus");
        
        com.abbt.timesheet.entities.Timesheet instance = new com.abbt.timesheet.entities.Timesheet();
        
        com.abbt.timesheet.entities.TimesheetStatus expResult = null;
        com.abbt.timesheet.entities.TimesheetStatus result = instance.getStatus();
        assertEquals(expResult, result);
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setStatus method, of class com.abbt.timesheet.entities.Timesheet.
     */
    public void testSetStatus() {
        System.out.println("setStatus");
        
        com.abbt.timesheet.entities.TimesheetStatus status = null;
        com.abbt.timesheet.entities.Timesheet instance = new com.abbt.timesheet.entities.Timesheet();
        
        instance.setStatus(status);
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of hashCode method, of class com.abbt.timesheet.entities.Timesheet.
     */
    public void testHashCode() {
        System.out.println("hashCode");
        
        com.abbt.timesheet.entities.Timesheet instance = new com.abbt.timesheet.entities.Timesheet();
        
        int expResult = 0;
        int result = instance.hashCode();
        assertEquals(expResult, result);
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of equals method, of class com.abbt.timesheet.entities.Timesheet.
     */
    public void testEquals() {
        System.out.println("equals");
        
        Object object = null;
        com.abbt.timesheet.entities.Timesheet instance = new com.abbt.timesheet.entities.Timesheet();
        
        boolean expResult = true;
        boolean result = instance.equals(object);
        assertEquals(expResult, result);
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class com.abbt.timesheet.entities.Timesheet.
     */
    public void testToString() {
        System.out.println("toString");
        
        com.abbt.timesheet.entities.Timesheet instance = new com.abbt.timesheet.entities.Timesheet();
        
        String expResult = null;
        String result = instance.toString();
        assertEquals(expResult, result);
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
