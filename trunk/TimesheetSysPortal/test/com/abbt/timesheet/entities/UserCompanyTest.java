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
 * UserCompanyTest.java
 * JUnit based test
 *
 * Created on May 3, 2007, 11:14 PM
 */

/**
 *
 * @author shannan
 */
public class UserCompanyTest extends TestCase {
    
    public UserCompanyTest(String testName) {
        super(testName);
    }

    protected void setUp() throws Exception {
    }

    protected void tearDown() throws Exception {
    }

    public static Test suite() {
        TestSuite suite = new TestSuite(UserCompanyTest.class);
        
        return suite;
    }

    /**
     * Test of getId method, of class com.abbt.timesheet.entities.UserCompany.
     */
    public void testGetId() {
        System.out.println("getId");
        
        com.abbt.timesheet.entities.UserCompany instance = new com.abbt.timesheet.entities.UserCompany();
        
        Integer expResult = null;
        Integer result = instance.getId();
        assertEquals(expResult, result);
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setId method, of class com.abbt.timesheet.entities.UserCompany.
     */
    public void testSetId() {
        System.out.println("setId");
        
        Integer id = null;
        com.abbt.timesheet.entities.UserCompany instance = new com.abbt.timesheet.entities.UserCompany();
        
        instance.setId(id);
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getClientBillingRate method, of class com.abbt.timesheet.entities.UserCompany.
     */
    public void testGetClientBillingRate() {
        System.out.println("getClientBillingRate");
        
        com.abbt.timesheet.entities.UserCompany instance = new com.abbt.timesheet.entities.UserCompany();
        
        Integer expResult = null;
        Integer result = instance.getClientBillingRate();
        assertEquals(expResult, result);
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setClientBillingRate method, of class com.abbt.timesheet.entities.UserCompany.
     */
    public void testSetClientBillingRate() {
        System.out.println("setClientBillingRate");
        
        Integer clientBillingRate = null;
        com.abbt.timesheet.entities.UserCompany instance = new com.abbt.timesheet.entities.UserCompany();
        
        instance.setClientBillingRate(clientBillingRate);
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPercentage method, of class com.abbt.timesheet.entities.UserCompany.
     */
    public void testGetPercentage() {
        System.out.println("getPercentage");
        
        com.abbt.timesheet.entities.UserCompany instance = new com.abbt.timesheet.entities.UserCompany();
        
        Integer expResult = null;
        Integer result = instance.getPercentage();
        assertEquals(expResult, result);
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPercentage method, of class com.abbt.timesheet.entities.UserCompany.
     */
    public void testSetPercentage() {
        System.out.println("setPercentage");
        
        Integer percentage = null;
        com.abbt.timesheet.entities.UserCompany instance = new com.abbt.timesheet.entities.UserCompany();
        
        instance.setPercentage(percentage);
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getUserPayedRate method, of class com.abbt.timesheet.entities.UserCompany.
     */
    public void testGetUserPayedRate() {
        System.out.println("getUserPayedRate");
        
        com.abbt.timesheet.entities.UserCompany instance = new com.abbt.timesheet.entities.UserCompany();
        
        Integer expResult = null;
        Integer result = instance.getUserPayedRate();
        assertEquals(expResult, result);
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setUserPayedRate method, of class com.abbt.timesheet.entities.UserCompany.
     */
    public void testSetUserPayedRate() {
        System.out.println("setUserPayedRate");
        
        Integer userPayedRate = null;
        com.abbt.timesheet.entities.UserCompany instance = new com.abbt.timesheet.entities.UserCompany();
        
        instance.setUserPayedRate(userPayedRate);
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getParentCompany1 method, of class com.abbt.timesheet.entities.UserCompany.
     */
    public void testGetParentCompany1() {
        System.out.println("getParentCompany1");
        
        com.abbt.timesheet.entities.UserCompany instance = new com.abbt.timesheet.entities.UserCompany();
        
        String expResult = "";
        String result = instance.getParentCompany1();
        assertEquals(expResult, result);
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setParentCompany1 method, of class com.abbt.timesheet.entities.UserCompany.
     */
    public void testSetParentCompany1() {
        System.out.println("setParentCompany1");
        
        String parentCompany1 = "";
        com.abbt.timesheet.entities.UserCompany instance = new com.abbt.timesheet.entities.UserCompany();
        
        instance.setParentCompany1(parentCompany1);
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getParentCompany2 method, of class com.abbt.timesheet.entities.UserCompany.
     */
    public void testGetParentCompany2() {
        System.out.println("getParentCompany2");
        
        com.abbt.timesheet.entities.UserCompany instance = new com.abbt.timesheet.entities.UserCompany();
        
        String expResult = "";
        String result = instance.getParentCompany2();
        assertEquals(expResult, result);
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setParentCompany2 method, of class com.abbt.timesheet.entities.UserCompany.
     */
    public void testSetParentCompany2() {
        System.out.println("setParentCompany2");
        
        String parentCompany2 = "";
        com.abbt.timesheet.entities.UserCompany instance = new com.abbt.timesheet.entities.UserCompany();
        
        instance.setParentCompany2(parentCompany2);
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getParentCompany3 method, of class com.abbt.timesheet.entities.UserCompany.
     */
    public void testGetParentCompany3() {
        System.out.println("getParentCompany3");
        
        com.abbt.timesheet.entities.UserCompany instance = new com.abbt.timesheet.entities.UserCompany();
        
        String expResult = "";
        String result = instance.getParentCompany3();
        assertEquals(expResult, result);
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setParentCompany3 method, of class com.abbt.timesheet.entities.UserCompany.
     */
    public void testSetParentCompany3() {
        System.out.println("setParentCompany3");
        
        String parentCompany3 = "";
        com.abbt.timesheet.entities.UserCompany instance = new com.abbt.timesheet.entities.UserCompany();
        
        instance.setParentCompany3(parentCompany3);
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCreatedBy method, of class com.abbt.timesheet.entities.UserCompany.
     */
    public void testGetCreatedBy() {
        System.out.println("getCreatedBy");
        
        com.abbt.timesheet.entities.UserCompany instance = new com.abbt.timesheet.entities.UserCompany();
        
        String expResult = "";
        String result = instance.getCreatedBy();
        assertEquals(expResult, result);
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCreatedBy method, of class com.abbt.timesheet.entities.UserCompany.
     */
    public void testSetCreatedBy() {
        System.out.println("setCreatedBy");
        
        String createdBy = "";
        com.abbt.timesheet.entities.UserCompany instance = new com.abbt.timesheet.entities.UserCompany();
        
        instance.setCreatedBy(createdBy);
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCreatedDate method, of class com.abbt.timesheet.entities.UserCompany.
     */
    public void testGetCreatedDate() {
        System.out.println("getCreatedDate");
        
        com.abbt.timesheet.entities.UserCompany instance = new com.abbt.timesheet.entities.UserCompany();
        
        Date expResult = null;
        Date result = instance.getCreatedDate();
        assertEquals(expResult, result);
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCreatedDate method, of class com.abbt.timesheet.entities.UserCompany.
     */
    public void testSetCreatedDate() {
        System.out.println("setCreatedDate");
        
        Date createdDate = null;
        com.abbt.timesheet.entities.UserCompany instance = new com.abbt.timesheet.entities.UserCompany();
        
        instance.setCreatedDate(createdDate);
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getLastUpdatedBy method, of class com.abbt.timesheet.entities.UserCompany.
     */
    public void testGetLastUpdatedBy() {
        System.out.println("getLastUpdatedBy");
        
        com.abbt.timesheet.entities.UserCompany instance = new com.abbt.timesheet.entities.UserCompany();
        
        String expResult = "";
        String result = instance.getLastUpdatedBy();
        assertEquals(expResult, result);
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setLastUpdatedBy method, of class com.abbt.timesheet.entities.UserCompany.
     */
    public void testSetLastUpdatedBy() {
        System.out.println("setLastUpdatedBy");
        
        String lastUpdatedBy = "";
        com.abbt.timesheet.entities.UserCompany instance = new com.abbt.timesheet.entities.UserCompany();
        
        instance.setLastUpdatedBy(lastUpdatedBy);
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getLastUpdatedDate method, of class com.abbt.timesheet.entities.UserCompany.
     */
    public void testGetLastUpdatedDate() {
        System.out.println("getLastUpdatedDate");
        
        com.abbt.timesheet.entities.UserCompany instance = new com.abbt.timesheet.entities.UserCompany();
        
        Date expResult = null;
        Date result = instance.getLastUpdatedDate();
        assertEquals(expResult, result);
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setLastUpdatedDate method, of class com.abbt.timesheet.entities.UserCompany.
     */
    public void testSetLastUpdatedDate() {
        System.out.println("setLastUpdatedDate");
        
        Date lastUpdatedDate = null;
        com.abbt.timesheet.entities.UserCompany instance = new com.abbt.timesheet.entities.UserCompany();
        
        instance.setLastUpdatedDate(lastUpdatedDate);
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCompanyName method, of class com.abbt.timesheet.entities.UserCompany.
     */
    public void testGetCompanyName() {
        System.out.println("getCompanyName");
        
        com.abbt.timesheet.entities.UserCompany instance = new com.abbt.timesheet.entities.UserCompany();
        
        com.abbt.timesheet.entities.Company expResult = null;
        com.abbt.timesheet.entities.Company result = instance.getCompanyName();
        assertEquals(expResult, result);
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCompanyName method, of class com.abbt.timesheet.entities.UserCompany.
     */
    public void testSetCompanyName() {
        System.out.println("setCompanyName");
        
        com.abbt.timesheet.entities.Company companyName = null;
        com.abbt.timesheet.entities.UserCompany instance = new com.abbt.timesheet.entities.UserCompany();
        
        instance.setCompanyName(companyName);
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getUserEmail method, of class com.abbt.timesheet.entities.UserCompany.
     */
    public void testGetUserEmail() {
        System.out.println("getUserEmail");
        
        com.abbt.timesheet.entities.UserCompany instance = new com.abbt.timesheet.entities.UserCompany();
        
        com.abbt.timesheet.entities.User expResult = null;
        com.abbt.timesheet.entities.User result = instance.getUserEmail();
        assertEquals(expResult, result);
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setUserEmail method, of class com.abbt.timesheet.entities.UserCompany.
     */
    public void testSetUserEmail() {
        System.out.println("setUserEmail");
        
        com.abbt.timesheet.entities.User userEmail = null;
        com.abbt.timesheet.entities.UserCompany instance = new com.abbt.timesheet.entities.UserCompany();
        
        instance.setUserEmail(userEmail);
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTimesheetCollection method, of class com.abbt.timesheet.entities.UserCompany.
     */
    public void testGetTimesheetCollection() {
        System.out.println("getTimesheetCollection");
        
        com.abbt.timesheet.entities.UserCompany instance = new com.abbt.timesheet.entities.UserCompany();
        
        Collection<com.abbt.timesheet.entities.Timesheet> expResult = null;
        Collection<com.abbt.timesheet.entities.Timesheet> result = instance.getTimesheetCollection();
        assertEquals(expResult, result);
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setTimesheetCollection method, of class com.abbt.timesheet.entities.UserCompany.
     */
    public void testSetTimesheetCollection() {
        System.out.println("setTimesheetCollection");
        
        Collection<com.abbt.timesheet.entities.Timesheet> timesheetCollection = null;
        com.abbt.timesheet.entities.UserCompany instance = new com.abbt.timesheet.entities.UserCompany();
        
        instance.setTimesheetCollection(timesheetCollection);
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of hashCode method, of class com.abbt.timesheet.entities.UserCompany.
     */
    public void testHashCode() {
        System.out.println("hashCode");
        
        com.abbt.timesheet.entities.UserCompany instance = new com.abbt.timesheet.entities.UserCompany();
        
        int expResult = 0;
        int result = instance.hashCode();
        assertEquals(expResult, result);
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of equals method, of class com.abbt.timesheet.entities.UserCompany.
     */
    public void testEquals() {
        System.out.println("equals");
        
        Object object = null;
        com.abbt.timesheet.entities.UserCompany instance = new com.abbt.timesheet.entities.UserCompany();
        
        boolean expResult = true;
        boolean result = instance.equals(object);
        assertEquals(expResult, result);
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class com.abbt.timesheet.entities.UserCompany.
     */
    public void testToString() {
        System.out.println("toString");
        
        com.abbt.timesheet.entities.UserCompany instance = new com.abbt.timesheet.entities.UserCompany();
        
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
