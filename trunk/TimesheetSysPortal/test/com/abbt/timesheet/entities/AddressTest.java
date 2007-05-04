package com.abbt.timesheet.entities;
import junit.framework.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
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
 * AddressTest.java
 * JUnit based test
 *
 * Created on May 3, 2007, 11:14 PM
 */

/**
 *
 * @author shannan
 */
public class AddressTest extends TestCase {
    
    public AddressTest(String testName) {
        super(testName);
    }

    protected void setUp() throws Exception {
    }

    protected void tearDown() throws Exception {
    }

    public static Test suite() {
        TestSuite suite = new TestSuite(AddressTest.class);
        
        return suite;
    }

    /**
     * Test of getId method, of class com.abbt.timesheet.entities.Address.
     */
    public void testGetId() {
        System.out.println("getId");
        
        com.abbt.timesheet.entities.Address instance = new com.abbt.timesheet.entities.Address();
        
        Integer expResult = null;
        Integer result = instance.getId();
        assertEquals(expResult, result);
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setId method, of class com.abbt.timesheet.entities.Address.
     */
    public void testSetId() {
        System.out.println("setId");
        
        Integer id = null;
        com.abbt.timesheet.entities.Address instance = new com.abbt.timesheet.entities.Address();
        
        instance.setId(id);
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAddressType method, of class com.abbt.timesheet.entities.Address.
     */
    public void testGetAddressType() {
        System.out.println("getAddressType");
        
        com.abbt.timesheet.entities.Address instance = new com.abbt.timesheet.entities.Address();
        
        String expResult = "";
        String result = instance.getAddressType();
        assertEquals(expResult, result);
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setAddressType method, of class com.abbt.timesheet.entities.Address.
     */
    public void testSetAddressType() {
        System.out.println("setAddressType");
        
        String addressType = "";
        com.abbt.timesheet.entities.Address instance = new com.abbt.timesheet.entities.Address();
        
        instance.setAddressType(addressType);
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getStreetLine1 method, of class com.abbt.timesheet.entities.Address.
     */
    public void testGetStreetLine1() {
        System.out.println("getStreetLine1");
        
        com.abbt.timesheet.entities.Address instance = new com.abbt.timesheet.entities.Address();
        
        String expResult = "";
        String result = instance.getStreetLine1();
        assertEquals(expResult, result);
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setStreetLine1 method, of class com.abbt.timesheet.entities.Address.
     */
    public void testSetStreetLine1() {
        System.out.println("setStreetLine1");
        
        String streetLine1 = "";
        com.abbt.timesheet.entities.Address instance = new com.abbt.timesheet.entities.Address();
        
        instance.setStreetLine1(streetLine1);
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getStreetLine2 method, of class com.abbt.timesheet.entities.Address.
     */
    public void testGetStreetLine2() {
        System.out.println("getStreetLine2");
        
        com.abbt.timesheet.entities.Address instance = new com.abbt.timesheet.entities.Address();
        
        String expResult = "";
        String result = instance.getStreetLine2();
        assertEquals(expResult, result);
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setStreetLine2 method, of class com.abbt.timesheet.entities.Address.
     */
    public void testSetStreetLine2() {
        System.out.println("setStreetLine2");
        
        String streetLine2 = "";
        com.abbt.timesheet.entities.Address instance = new com.abbt.timesheet.entities.Address();
        
        instance.setStreetLine2(streetLine2);
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCity method, of class com.abbt.timesheet.entities.Address.
     */
    public void testGetCity() {
        System.out.println("getCity");
        
        com.abbt.timesheet.entities.Address instance = new com.abbt.timesheet.entities.Address();
        
        String expResult = "";
        String result = instance.getCity();
        assertEquals(expResult, result);
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCity method, of class com.abbt.timesheet.entities.Address.
     */
    public void testSetCity() {
        System.out.println("setCity");
        
        String city = "";
        com.abbt.timesheet.entities.Address instance = new com.abbt.timesheet.entities.Address();
        
        instance.setCity(city);
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getState method, of class com.abbt.timesheet.entities.Address.
     */
    public void testGetState() {
        System.out.println("getState");
        
        com.abbt.timesheet.entities.Address instance = new com.abbt.timesheet.entities.Address();
        
        String expResult = "";
        String result = instance.getState();
        assertEquals(expResult, result);
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setState method, of class com.abbt.timesheet.entities.Address.
     */
    public void testSetState() {
        System.out.println("setState");
        
        String state = "";
        com.abbt.timesheet.entities.Address instance = new com.abbt.timesheet.entities.Address();
        
        instance.setState(state);
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getZipcode method, of class com.abbt.timesheet.entities.Address.
     */
    public void testGetZipcode() {
        System.out.println("getZipcode");
        
        com.abbt.timesheet.entities.Address instance = new com.abbt.timesheet.entities.Address();
        
        String expResult = "";
        String result = instance.getZipcode();
        assertEquals(expResult, result);
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setZipcode method, of class com.abbt.timesheet.entities.Address.
     */
    public void testSetZipcode() {
        System.out.println("setZipcode");
        
        String zipcode = "";
        com.abbt.timesheet.entities.Address instance = new com.abbt.timesheet.entities.Address();
        
        instance.setZipcode(zipcode);
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCountry method, of class com.abbt.timesheet.entities.Address.
     */
    public void testGetCountry() {
        System.out.println("getCountry");
        
        com.abbt.timesheet.entities.Address instance = new com.abbt.timesheet.entities.Address();
        
        String expResult = "";
        String result = instance.getCountry();
        assertEquals(expResult, result);
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCountry method, of class com.abbt.timesheet.entities.Address.
     */
    public void testSetCountry() {
        System.out.println("setCountry");
        
        String country = "";
        com.abbt.timesheet.entities.Address instance = new com.abbt.timesheet.entities.Address();
        
        instance.setCountry(country);
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getVerified method, of class com.abbt.timesheet.entities.Address.
     */
    public void testGetVerified() {
        System.out.println("getVerified");
        
        com.abbt.timesheet.entities.Address instance = new com.abbt.timesheet.entities.Address();
        
        Short expResult = null;
        Short result = instance.getVerified();
        assertEquals(expResult, result);
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setVerified method, of class com.abbt.timesheet.entities.Address.
     */
    public void testSetVerified() {
        System.out.println("setVerified");
        
        Short verified = null;
        com.abbt.timesheet.entities.Address instance = new com.abbt.timesheet.entities.Address();
        
        instance.setVerified(verified);
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCreatedBy method, of class com.abbt.timesheet.entities.Address.
     */
    public void testGetCreatedBy() {
        System.out.println("getCreatedBy");
        
        com.abbt.timesheet.entities.Address instance = new com.abbt.timesheet.entities.Address();
        
        String expResult = "";
        String result = instance.getCreatedBy();
        assertEquals(expResult, result);
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCreatedBy method, of class com.abbt.timesheet.entities.Address.
     */
    public void testSetCreatedBy() {
        System.out.println("setCreatedBy");
        
        String createdBy = "";
        com.abbt.timesheet.entities.Address instance = new com.abbt.timesheet.entities.Address();
        
        instance.setCreatedBy(createdBy);
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCreatedDate method, of class com.abbt.timesheet.entities.Address.
     */
    public void testGetCreatedDate() {
        System.out.println("getCreatedDate");
        
        com.abbt.timesheet.entities.Address instance = new com.abbt.timesheet.entities.Address();
        
        Date expResult = null;
        Date result = instance.getCreatedDate();
        assertEquals(expResult, result);
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCreatedDate method, of class com.abbt.timesheet.entities.Address.
     */
    public void testSetCreatedDate() {
        System.out.println("setCreatedDate");
        
        Date createdDate = null;
        com.abbt.timesheet.entities.Address instance = new com.abbt.timesheet.entities.Address();
        
        instance.setCreatedDate(createdDate);
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getLastUpdatedBy method, of class com.abbt.timesheet.entities.Address.
     */
    public void testGetLastUpdatedBy() {
        System.out.println("getLastUpdatedBy");
        
        com.abbt.timesheet.entities.Address instance = new com.abbt.timesheet.entities.Address();
        
        String expResult = "";
        String result = instance.getLastUpdatedBy();
        assertEquals(expResult, result);
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setLastUpdatedBy method, of class com.abbt.timesheet.entities.Address.
     */
    public void testSetLastUpdatedBy() {
        System.out.println("setLastUpdatedBy");
        
        String lastUpdatedBy = "";
        com.abbt.timesheet.entities.Address instance = new com.abbt.timesheet.entities.Address();
        
        instance.setLastUpdatedBy(lastUpdatedBy);
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getLastUpdatedDate method, of class com.abbt.timesheet.entities.Address.
     */
    public void testGetLastUpdatedDate() {
        System.out.println("getLastUpdatedDate");
        
        com.abbt.timesheet.entities.Address instance = new com.abbt.timesheet.entities.Address();
        
        Date expResult = null;
        Date result = instance.getLastUpdatedDate();
        assertEquals(expResult, result);
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setLastUpdatedDate method, of class com.abbt.timesheet.entities.Address.
     */
    public void testSetLastUpdatedDate() {
        System.out.println("setLastUpdatedDate");
        
        Date lastUpdatedDate = null;
        com.abbt.timesheet.entities.Address instance = new com.abbt.timesheet.entities.Address();
        
        instance.setLastUpdatedDate(lastUpdatedDate);
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCompanyCollection method, of class com.abbt.timesheet.entities.Address.
     */
    public void testGetCompanyCollection() {
        System.out.println("getCompanyCollection");
        
        com.abbt.timesheet.entities.Address instance = new com.abbt.timesheet.entities.Address();
        
        Collection<com.abbt.timesheet.entities.Company> expResult = null;
        Collection<com.abbt.timesheet.entities.Company> result = instance.getCompanyCollection();
        assertEquals(expResult, result);
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCompanyCollection method, of class com.abbt.timesheet.entities.Address.
     */
    public void testSetCompanyCollection() {
        System.out.println("setCompanyCollection");
        
        Collection<com.abbt.timesheet.entities.Company> companyCollection = null;
        com.abbt.timesheet.entities.Address instance = new com.abbt.timesheet.entities.Address();
        
        instance.setCompanyCollection(companyCollection);
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getUserCollection method, of class com.abbt.timesheet.entities.Address.
     */
    public void testGetUserCollection() {
        System.out.println("getUserCollection");
        
        com.abbt.timesheet.entities.Address instance = new com.abbt.timesheet.entities.Address();
        
        Collection<com.abbt.timesheet.entities.User> expResult = null;
        Collection<com.abbt.timesheet.entities.User> result = instance.getUserCollection();
        assertEquals(expResult, result);
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setUserCollection method, of class com.abbt.timesheet.entities.Address.
     */
    public void testSetUserCollection() {
        System.out.println("setUserCollection");
        
        Collection<com.abbt.timesheet.entities.User> userCollection = null;
        com.abbt.timesheet.entities.Address instance = new com.abbt.timesheet.entities.Address();
        
        instance.setUserCollection(userCollection);
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of hashCode method, of class com.abbt.timesheet.entities.Address.
     */
    public void testHashCode() {
        System.out.println("hashCode");
        
        com.abbt.timesheet.entities.Address instance = new com.abbt.timesheet.entities.Address();
        
        int expResult = 0;
        int result = instance.hashCode();
        assertEquals(expResult, result);
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of equals method, of class com.abbt.timesheet.entities.Address.
     */
    public void testEquals() {
        System.out.println("equals");
        
        Object object = null;
        com.abbt.timesheet.entities.Address instance = new com.abbt.timesheet.entities.Address();
        
        boolean expResult = true;
        boolean result = instance.equals(object);
        assertEquals(expResult, result);
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class com.abbt.timesheet.entities.Address.
     */
    public void testToString() {
        System.out.println("toString");
        
        com.abbt.timesheet.entities.Address instance = new com.abbt.timesheet.entities.Address();
        
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
