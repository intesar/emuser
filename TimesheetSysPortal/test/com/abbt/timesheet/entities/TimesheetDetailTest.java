package com.abbt.timesheet.entities;
import junit.framework.*;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
/*
 * TimesheetDetailTest.java
 * JUnit based test
 *
 * Created on May 3, 2007, 11:14 PM
 */

/**
 *
 * @author shannan
 */
public class TimesheetDetailTest extends TestCase {
    
    public TimesheetDetailTest(String testName) {
        super(testName);
    }

    protected void setUp() throws Exception {
    }

    protected void tearDown() throws Exception {
    }

    public static Test suite() {
        TestSuite suite = new TestSuite(TimesheetDetailTest.class);
        
        return suite;
    }

    /**
     * Test of getRegularHours method, of class com.abbt.timesheet.entities.TimesheetDetail.
     */
    public void testGetRegularHours() {
        System.out.println("getRegularHours");
        
        com.abbt.timesheet.entities.TimesheetDetail instance = new com.abbt.timesheet.entities.TimesheetDetail();
        
        Double expResult = null;
        Double result = instance.getRegularHours();
        assertEquals(expResult, result);
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setRegularHours method, of class com.abbt.timesheet.entities.TimesheetDetail.
     */
    public void testSetRegularHours() {
        System.out.println("setRegularHours");
        
        Double regularHours = null;
        com.abbt.timesheet.entities.TimesheetDetail instance = new com.abbt.timesheet.entities.TimesheetDetail();
        
        instance.setRegularHours(regularHours);
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getOverTimeHours method, of class com.abbt.timesheet.entities.TimesheetDetail.
     */
    public void testGetOverTimeHours() {
        System.out.println("getOverTimeHours");
        
        com.abbt.timesheet.entities.TimesheetDetail instance = new com.abbt.timesheet.entities.TimesheetDetail();
        
        Double expResult = null;
        Double result = instance.getOverTimeHours();
        assertEquals(expResult, result);
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setOverTimeHours method, of class com.abbt.timesheet.entities.TimesheetDetail.
     */
    public void testSetOverTimeHours() {
        System.out.println("setOverTimeHours");
        
        Double overTimeHours = null;
        com.abbt.timesheet.entities.TimesheetDetail instance = new com.abbt.timesheet.entities.TimesheetDetail();
        
        instance.setOverTimeHours(overTimeHours);
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getComments method, of class com.abbt.timesheet.entities.TimesheetDetail.
     */
    public void testGetComments() {
        System.out.println("getComments");
        
        com.abbt.timesheet.entities.TimesheetDetail instance = new com.abbt.timesheet.entities.TimesheetDetail();
        
        String expResult = null;
        String result = instance.getComments();
        assertEquals(expResult, result);
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setComments method, of class com.abbt.timesheet.entities.TimesheetDetail.
     */
    public void testSetComments() {
        System.out.println("setComments");
        
        String comments = null;
        com.abbt.timesheet.entities.TimesheetDetail instance = new com.abbt.timesheet.entities.TimesheetDetail();
        
        instance.setComments(comments);
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCreatedBy method, of class com.abbt.timesheet.entities.TimesheetDetail.
     */
    public void testGetCreatedBy() {
        System.out.println("getCreatedBy");
        
        com.abbt.timesheet.entities.TimesheetDetail instance = new com.abbt.timesheet.entities.TimesheetDetail();
        
        String expResult = null;
        String result = instance.getCreatedBy();
        assertEquals(expResult, result);
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCreatedBy method, of class com.abbt.timesheet.entities.TimesheetDetail.
     */
    public void testSetCreatedBy() {
        System.out.println("setCreatedBy");
        
        String createdBy = null;
        com.abbt.timesheet.entities.TimesheetDetail instance = new com.abbt.timesheet.entities.TimesheetDetail();
        
        instance.setCreatedBy(createdBy);
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCreatedDate method, of class com.abbt.timesheet.entities.TimesheetDetail.
     */
    public void testGetCreatedDate() {
        System.out.println("getCreatedDate");
        
        com.abbt.timesheet.entities.TimesheetDetail instance = new com.abbt.timesheet.entities.TimesheetDetail();
        
        Date expResult = null;
        Date result = instance.getCreatedDate();
        assertEquals(expResult, result);
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCreatedDate method, of class com.abbt.timesheet.entities.TimesheetDetail.
     */
    public void testSetCreatedDate() {
        System.out.println("setCreatedDate");
        
        Date createdDate = null;
        com.abbt.timesheet.entities.TimesheetDetail instance = new com.abbt.timesheet.entities.TimesheetDetail();
        
        instance.setCreatedDate(createdDate);
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getLastUpdatedBy method, of class com.abbt.timesheet.entities.TimesheetDetail.
     */
    public void testGetLastUpdatedBy() {
        System.out.println("getLastUpdatedBy");
        
        com.abbt.timesheet.entities.TimesheetDetail instance = new com.abbt.timesheet.entities.TimesheetDetail();
        
        String expResult = null;
        String result = instance.getLastUpdatedBy();
        assertEquals(expResult, result);
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setLastUpdatedBy method, of class com.abbt.timesheet.entities.TimesheetDetail.
     */
    public void testSetLastUpdatedBy() {
        System.out.println("setLastUpdatedBy");
        
        String lastUpdatedBy = null;
        com.abbt.timesheet.entities.TimesheetDetail instance = new com.abbt.timesheet.entities.TimesheetDetail();
        
        instance.setLastUpdatedBy(lastUpdatedBy);
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getLastUpdatedDate method, of class com.abbt.timesheet.entities.TimesheetDetail.
     */
    public void testGetLastUpdatedDate() {
        System.out.println("getLastUpdatedDate");
        
        com.abbt.timesheet.entities.TimesheetDetail instance = new com.abbt.timesheet.entities.TimesheetDetail();
        
        Date expResult = null;
        Date result = instance.getLastUpdatedDate();
        assertEquals(expResult, result);
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setLastUpdatedDate method, of class com.abbt.timesheet.entities.TimesheetDetail.
     */
    public void testSetLastUpdatedDate() {
        System.out.println("setLastUpdatedDate");
        
        Date lastUpdatedDate = null;
        com.abbt.timesheet.entities.TimesheetDetail instance = new com.abbt.timesheet.entities.TimesheetDetail();
        
        instance.setLastUpdatedDate(lastUpdatedDate);
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getId method, of class com.abbt.timesheet.entities.TimesheetDetail.
     */
    public void testGetId() {
        System.out.println("getId");
        
        com.abbt.timesheet.entities.TimesheetDetail instance = new com.abbt.timesheet.entities.TimesheetDetail();
        
        Integer expResult = null;
        Integer result = instance.getId();
        assertEquals(expResult, result);
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setId method, of class com.abbt.timesheet.entities.TimesheetDetail.
     */
    public void testSetId() {
        System.out.println("setId");
        
        Integer id = null;
        com.abbt.timesheet.entities.TimesheetDetail instance = new com.abbt.timesheet.entities.TimesheetDetail();
        
        instance.setId(id);
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTimesheetDate method, of class com.abbt.timesheet.entities.TimesheetDetail.
     */
    public void testGetTimesheetDate() {
        System.out.println("getTimesheetDate");
        
        com.abbt.timesheet.entities.TimesheetDetail instance = new com.abbt.timesheet.entities.TimesheetDetail();
        
        Date expResult = null;
        Date result = instance.getTimesheetDate();
        assertEquals(expResult, result);
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setTimesheetDate method, of class com.abbt.timesheet.entities.TimesheetDetail.
     */
    public void testSetTimesheetDate() {
        System.out.println("setTimesheetDate");
        
        Date timesheetDate = null;
        com.abbt.timesheet.entities.TimesheetDetail instance = new com.abbt.timesheet.entities.TimesheetDetail();
        
        instance.setTimesheetDate(timesheetDate);
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTimesheetUser method, of class com.abbt.timesheet.entities.TimesheetDetail.
     */
    public void testGetTimesheetUser() {
        System.out.println("getTimesheetUser");
        
        com.abbt.timesheet.entities.TimesheetDetail instance = new com.abbt.timesheet.entities.TimesheetDetail();
        
        String expResult = null;
        String result = instance.getTimesheetUser();
        assertEquals(expResult, result);
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setTimesheetUser method, of class com.abbt.timesheet.entities.TimesheetDetail.
     */
    public void testSetTimesheetUser() {
        System.out.println("setTimesheetUser");
        
        String timesheetUser = null;
        com.abbt.timesheet.entities.TimesheetDetail instance = new com.abbt.timesheet.entities.TimesheetDetail();
        
        instance.setTimesheetUser(timesheetUser);
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTimesheetDetailDate method, of class com.abbt.timesheet.entities.TimesheetDetail.
     */
    public void testGetTimesheetDetailDate() {
        System.out.println("getTimesheetDetailDate");
        
        com.abbt.timesheet.entities.TimesheetDetail instance = new com.abbt.timesheet.entities.TimesheetDetail();
        
        Date expResult = null;
        Date result = instance.getTimesheetDetailDate();
        assertEquals(expResult, result);
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setTimesheetDetailDate method, of class com.abbt.timesheet.entities.TimesheetDetail.
     */
    public void testSetTimesheetDetailDate() {
        System.out.println("setTimesheetDetailDate");
        
        Date timesheetDetailDate = null;
        com.abbt.timesheet.entities.TimesheetDetail instance = new com.abbt.timesheet.entities.TimesheetDetail();
        
        instance.setTimesheetDetailDate(timesheetDetailDate);
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getVid method, of class com.abbt.timesheet.entities.TimesheetDetail.
     */
    public void testGetVid() {
        System.out.println("getVid");
        
        com.abbt.timesheet.entities.TimesheetDetail instance = new com.abbt.timesheet.entities.TimesheetDetail();
        
        Integer expResult = null;
        Integer result = instance.getVid();
        assertEquals(expResult, result);
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setVid method, of class com.abbt.timesheet.entities.TimesheetDetail.
     */
    public void testSetVid() {
        System.out.println("setVid");
        
        Integer vid = null;
        com.abbt.timesheet.entities.TimesheetDetail instance = new com.abbt.timesheet.entities.TimesheetDetail();
        
        instance.setVid(vid);
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getEnabled method, of class com.abbt.timesheet.entities.TimesheetDetail.
     */
    public void testGetEnabled() {
        System.out.println("getEnabled");
        
        com.abbt.timesheet.entities.TimesheetDetail instance = new com.abbt.timesheet.entities.TimesheetDetail();
        
        Boolean expResult = null;
        Boolean result = instance.getEnabled();
        assertEquals(expResult, result);
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setEnabled method, of class com.abbt.timesheet.entities.TimesheetDetail.
     */
    public void testSetEnabled() {
        System.out.println("setEnabled");
        
        Boolean enabled = null;
        com.abbt.timesheet.entities.TimesheetDetail instance = new com.abbt.timesheet.entities.TimesheetDetail();
        
        instance.setEnabled(enabled);
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDay method, of class com.abbt.timesheet.entities.TimesheetDetail.
     */
    public void testGetDay() {
        System.out.println("getDay");
        
        com.abbt.timesheet.entities.TimesheetDetail instance = new com.abbt.timesheet.entities.TimesheetDetail();
        
        String expResult = null;
        String result = instance.getDay();
        assertEquals(expResult, result);
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDay method, of class com.abbt.timesheet.entities.TimesheetDetail.
     */
    public void testSetDay() {
        System.out.println("setDay");
        
        String day = null;
        com.abbt.timesheet.entities.TimesheetDetail instance = new com.abbt.timesheet.entities.TimesheetDetail();
        
        instance.setDay(day);
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTimesheetId method, of class com.abbt.timesheet.entities.TimesheetDetail.
     */
    public void testGetTimesheetId() {
        System.out.println("getTimesheetId");
        
        com.abbt.timesheet.entities.TimesheetDetail instance = new com.abbt.timesheet.entities.TimesheetDetail();
        
        com.abbt.timesheet.entities.Timesheet expResult = null;
        com.abbt.timesheet.entities.Timesheet result = instance.getTimesheetId();
        assertEquals(expResult, result);
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setTimesheetId method, of class com.abbt.timesheet.entities.TimesheetDetail.
     */
    public void testSetTimesheetId() {
        System.out.println("setTimesheetId");
        
        com.abbt.timesheet.entities.Timesheet timesheetId = null;
        com.abbt.timesheet.entities.TimesheetDetail instance = new com.abbt.timesheet.entities.TimesheetDetail();
        
        instance.setTimesheetId(timesheetId);
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of hashCode method, of class com.abbt.timesheet.entities.TimesheetDetail.
     */
    public void testHashCode() {
        System.out.println("hashCode");
        
        com.abbt.timesheet.entities.TimesheetDetail instance = new com.abbt.timesheet.entities.TimesheetDetail();
        
        int expResult = 0;
        int result = instance.hashCode();
        assertEquals(expResult, result);
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of equals method, of class com.abbt.timesheet.entities.TimesheetDetail.
     */
    public void testEquals() {
        System.out.println("equals");
        
        Object object = null;
        com.abbt.timesheet.entities.TimesheetDetail instance = new com.abbt.timesheet.entities.TimesheetDetail();
        
        boolean expResult = true;
        boolean result = instance.equals(object);
        assertEquals(expResult, result);
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class com.abbt.timesheet.entities.TimesheetDetail.
     */
    public void testToString() {
        System.out.println("toString");
        
        com.abbt.timesheet.entities.TimesheetDetail instance = new com.abbt.timesheet.entities.TimesheetDetail();
        
        String expResult = null;
        String result = instance.toString();
        assertEquals(expResult, result);
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
