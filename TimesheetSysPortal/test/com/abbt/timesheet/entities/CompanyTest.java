package com.abbt.timesheet.entities;
import junit.framework.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.CascadeType;
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
 * CompanyTest.java
 * JUnit based test
 *
 * Created on May 3, 2007, 11:14 PM
 */

/**
 *
 * @author shannan
 */
public class CompanyTest extends TestCase {
    
    public CompanyTest(String testName) {
        super(testName);
    }

    protected void setUp() throws Exception {
    }

    protected void tearDown() throws Exception {
    }

    public static Test suite() {
        TestSuite suite = new TestSuite(CompanyTest.class);
        
        return suite;
    }

    /**
     * Test of getId method, of class com.abbt.timesheet.entities.Company.
     */
    public void testGetId() {
        System.out.println("getId");
        
        com.abbt.timesheet.entities.Company instance = new com.abbt.timesheet.entities.Company();
        
        Integer expResult = null;
        Integer result = instance.getId();
        assertEquals(expResult, result);
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setId method, of class com.abbt.timesheet.entities.Company.
     */
    public void testSetId() {
        System.out.println("setId");
        
        Integer id = null;
        com.abbt.timesheet.entities.Company instance = new com.abbt.timesheet.entities.Company();
        
        instance.setId(id);
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getName method, of class com.abbt.timesheet.entities.Company.
     */
    public void testGetName() {
        System.out.println("getName");
        
        com.abbt.timesheet.entities.Company instance = new com.abbt.timesheet.entities.Company();
        
        String expResult = "";
        String result = instance.getName();
        assertEquals(expResult, result);
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setName method, of class com.abbt.timesheet.entities.Company.
     */
    public void testSetName() {
        System.out.println("setName");
        
        String name = "";
        com.abbt.timesheet.entities.Company instance = new com.abbt.timesheet.entities.Company();
        
        instance.setName(name);
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPhone1 method, of class com.abbt.timesheet.entities.Company.
     */
    public void testGetPhone1() {
        System.out.println("getPhone1");
        
        com.abbt.timesheet.entities.Company instance = new com.abbt.timesheet.entities.Company();
        
        String expResult = "";
        String result = instance.getPhone1();
        assertEquals(expResult, result);
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPhone1 method, of class com.abbt.timesheet.entities.Company.
     */
    public void testSetPhone1() {
        System.out.println("setPhone1");
        
        String phone1 = "";
        com.abbt.timesheet.entities.Company instance = new com.abbt.timesheet.entities.Company();
        
        instance.setPhone1(phone1);
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPhone2 method, of class com.abbt.timesheet.entities.Company.
     */
    public void testGetPhone2() {
        System.out.println("getPhone2");
        
        com.abbt.timesheet.entities.Company instance = new com.abbt.timesheet.entities.Company();
        
        String expResult = "";
        String result = instance.getPhone2();
        assertEquals(expResult, result);
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPhone2 method, of class com.abbt.timesheet.entities.Company.
     */
    public void testSetPhone2() {
        System.out.println("setPhone2");
        
        String phone2 = "";
        com.abbt.timesheet.entities.Company instance = new com.abbt.timesheet.entities.Company();
        
        instance.setPhone2(phone2);
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getFax method, of class com.abbt.timesheet.entities.Company.
     */
    public void testGetFax() {
        System.out.println("getFax");
        
        com.abbt.timesheet.entities.Company instance = new com.abbt.timesheet.entities.Company();
        
        String expResult = "";
        String result = instance.getFax();
        assertEquals(expResult, result);
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setFax method, of class com.abbt.timesheet.entities.Company.
     */
    public void testSetFax() {
        System.out.println("setFax");
        
        String fax = "";
        com.abbt.timesheet.entities.Company instance = new com.abbt.timesheet.entities.Company();
        
        instance.setFax(fax);
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCreatedBy method, of class com.abbt.timesheet.entities.Company.
     */
    public void testGetCreatedBy() {
        System.out.println("getCreatedBy");
        
        com.abbt.timesheet.entities.Company instance = new com.abbt.timesheet.entities.Company();
        
        String expResult = "";
        String result = instance.getCreatedBy();
        assertEquals(expResult, result);
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCreatedBy method, of class com.abbt.timesheet.entities.Company.
     */
    public void testSetCreatedBy() {
        System.out.println("setCreatedBy");
        
        String createdBy = "";
        com.abbt.timesheet.entities.Company instance = new com.abbt.timesheet.entities.Company();
        
        instance.setCreatedBy(createdBy);
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCreatedDate method, of class com.abbt.timesheet.entities.Company.
     */
    public void testGetCreatedDate() {
        System.out.println("getCreatedDate");
        
        com.abbt.timesheet.entities.Company instance = new com.abbt.timesheet.entities.Company();
        
        Date expResult = null;
        Date result = instance.getCreatedDate();
        assertEquals(expResult, result);
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCreatedDate method, of class com.abbt.timesheet.entities.Company.
     */
    public void testSetCreatedDate() {
        System.out.println("setCreatedDate");
        
        Date createdDate = null;
        com.abbt.timesheet.entities.Company instance = new com.abbt.timesheet.entities.Company();
        
        instance.setCreatedDate(createdDate);
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getLastUpdatedBy method, of class com.abbt.timesheet.entities.Company.
     */
    public void testGetLastUpdatedBy() {
        System.out.println("getLastUpdatedBy");
        
        com.abbt.timesheet.entities.Company instance = new com.abbt.timesheet.entities.Company();
        
        String expResult = "";
        String result = instance.getLastUpdatedBy();
        assertEquals(expResult, result);
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setLastUpdatedBy method, of class com.abbt.timesheet.entities.Company.
     */
    public void testSetLastUpdatedBy() {
        System.out.println("setLastUpdatedBy");
        
        String lastUpdatedBy = "";
        com.abbt.timesheet.entities.Company instance = new com.abbt.timesheet.entities.Company();
        
        instance.setLastUpdatedBy(lastUpdatedBy);
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getLastUpdatedDate method, of class com.abbt.timesheet.entities.Company.
     */
    public void testGetLastUpdatedDate() {
        System.out.println("getLastUpdatedDate");
        
        com.abbt.timesheet.entities.Company instance = new com.abbt.timesheet.entities.Company();
        
        Date expResult = null;
        Date result = instance.getLastUpdatedDate();
        assertEquals(expResult, result);
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setLastUpdatedDate method, of class com.abbt.timesheet.entities.Company.
     */
    public void testSetLastUpdatedDate() {
        System.out.println("setLastUpdatedDate");
        
        Date lastUpdatedDate = null;
        com.abbt.timesheet.entities.Company instance = new com.abbt.timesheet.entities.Company();
        
        instance.setLastUpdatedDate(lastUpdatedDate);
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getUserCompanyCollection method, of class com.abbt.timesheet.entities.Company.
     */
    public void testGetUserCompanyCollection() {
        System.out.println("getUserCompanyCollection");
        
        com.abbt.timesheet.entities.Company instance = new com.abbt.timesheet.entities.Company();
        
        Collection<com.abbt.timesheet.entities.UserCompany> expResult = null;
        Collection<com.abbt.timesheet.entities.UserCompany> result = instance.getUserCompanyCollection();
        assertEquals(expResult, result);
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setUserCompanyCollection method, of class com.abbt.timesheet.entities.Company.
     */
    public void testSetUserCompanyCollection() {
        System.out.println("setUserCompanyCollection");
        
        Collection<com.abbt.timesheet.entities.UserCompany> userCompanyCollection = null;
        com.abbt.timesheet.entities.Company instance = new com.abbt.timesheet.entities.Company();
        
        instance.setUserCompanyCollection(userCompanyCollection);
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getBillingAddress method, of class com.abbt.timesheet.entities.Company.
     */
    public void testGetBillingAddress() {
        System.out.println("getBillingAddress");
        
        com.abbt.timesheet.entities.Company instance = new com.abbt.timesheet.entities.Company();
        
        com.abbt.timesheet.entities.Address expResult = null;
        com.abbt.timesheet.entities.Address result = instance.getBillingAddress();
        assertEquals(expResult, result);
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setBillingAddress method, of class com.abbt.timesheet.entities.Company.
     */
    public void testSetBillingAddress() {
        System.out.println("setBillingAddress");
        
        com.abbt.timesheet.entities.Address billingAddress = null;
        com.abbt.timesheet.entities.Company instance = new com.abbt.timesheet.entities.Company();
        
        instance.setBillingAddress(billingAddress);
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of hashCode method, of class com.abbt.timesheet.entities.Company.
     */
    public void testHashCode() {
        System.out.println("hashCode");
        
        com.abbt.timesheet.entities.Company instance = new com.abbt.timesheet.entities.Company();
        
        int expResult = 0;
        int result = instance.hashCode();
        assertEquals(expResult, result);
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of equals method, of class com.abbt.timesheet.entities.Company.
     */
    public void testEquals() {
        System.out.println("equals");
        
        Object object = null;
        com.abbt.timesheet.entities.Company instance = new com.abbt.timesheet.entities.Company();
        
        boolean expResult = true;
        boolean result = instance.equals(object);
        assertEquals(expResult, result);
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class com.abbt.timesheet.entities.Company.
     */
    public void testToString() {
        System.out.println("toString");
        
        com.abbt.timesheet.entities.Company instance = new com.abbt.timesheet.entities.Company();
        
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
