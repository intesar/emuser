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
 * UserTest.java
 * JUnit based test
 *
 * Created on May 3, 2007, 11:14 PM
 */

/**
 *
 * @author shannan
 */
public class UserTest extends TestCase {
    
    public UserTest(String testName) {
        super(testName);
    }

    protected void setUp() throws Exception {
    }

    protected void tearDown() throws Exception {
    }

    public static Test suite() {
        TestSuite suite = new TestSuite(UserTest.class);
        
        return suite;
    }

    /**
     * Test of getId method, of class com.abbt.timesheet.entities.User.
     */
    public void testGetId() {
        System.out.println("getId");
        
        com.abbt.timesheet.entities.User instance = new com.abbt.timesheet.entities.User();
        
        Integer expResult = null;
        Integer result = instance.getId();
        assertEquals(expResult, result);
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setId method, of class com.abbt.timesheet.entities.User.
     */
    public void testSetId() {
        System.out.println("setId");
        
        Integer id = null;
        com.abbt.timesheet.entities.User instance = new com.abbt.timesheet.entities.User();
        
        instance.setId(id);
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getEmail method, of class com.abbt.timesheet.entities.User.
     */
    public void testGetEmail() {
        System.out.println("getEmail");
        
        com.abbt.timesheet.entities.User instance = new com.abbt.timesheet.entities.User();
        
        String expResult = "";
        String result = instance.getEmail();
        assertEquals(expResult, result);
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setEmail method, of class com.abbt.timesheet.entities.User.
     */
    public void testSetEmail() {
        System.out.println("setEmail");
        
        String email = "";
        com.abbt.timesheet.entities.User instance = new com.abbt.timesheet.entities.User();
        
        instance.setEmail(email);
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSecondaryEmail method, of class com.abbt.timesheet.entities.User.
     */
    public void testGetSecondaryEmail() {
        System.out.println("getSecondaryEmail");
        
        com.abbt.timesheet.entities.User instance = new com.abbt.timesheet.entities.User();
        
        String expResult = "";
        String result = instance.getSecondaryEmail();
        assertEquals(expResult, result);
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setSecondaryEmail method, of class com.abbt.timesheet.entities.User.
     */
    public void testSetSecondaryEmail() {
        System.out.println("setSecondaryEmail");
        
        String secondaryEmail = "";
        com.abbt.timesheet.entities.User instance = new com.abbt.timesheet.entities.User();
        
        instance.setSecondaryEmail(secondaryEmail);
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getFirstname method, of class com.abbt.timesheet.entities.User.
     */
    public void testGetFirstname() {
        System.out.println("getFirstname");
        
        com.abbt.timesheet.entities.User instance = new com.abbt.timesheet.entities.User();
        
        String expResult = "";
        String result = instance.getFirstname();
        assertEquals(expResult, result);
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setFirstname method, of class com.abbt.timesheet.entities.User.
     */
    public void testSetFirstname() {
        System.out.println("setFirstname");
        
        String firstname = "";
        com.abbt.timesheet.entities.User instance = new com.abbt.timesheet.entities.User();
        
        instance.setFirstname(firstname);
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getLastname method, of class com.abbt.timesheet.entities.User.
     */
    public void testGetLastname() {
        System.out.println("getLastname");
        
        com.abbt.timesheet.entities.User instance = new com.abbt.timesheet.entities.User();
        
        String expResult = "";
        String result = instance.getLastname();
        assertEquals(expResult, result);
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setLastname method, of class com.abbt.timesheet.entities.User.
     */
    public void testSetLastname() {
        System.out.println("setLastname");
        
        String lastname = "";
        com.abbt.timesheet.entities.User instance = new com.abbt.timesheet.entities.User();
        
        instance.setLastname(lastname);
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSsn method, of class com.abbt.timesheet.entities.User.
     */
    public void testGetSsn() {
        System.out.println("getSsn");
        
        com.abbt.timesheet.entities.User instance = new com.abbt.timesheet.entities.User();
        
        String expResult = "";
        String result = instance.getSsn();
        assertEquals(expResult, result);
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setSsn method, of class com.abbt.timesheet.entities.User.
     */
    public void testSetSsn() {
        System.out.println("setSsn");
        
        String ssn = "";
        com.abbt.timesheet.entities.User instance = new com.abbt.timesheet.entities.User();
        
        instance.setSsn(ssn);
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDob method, of class com.abbt.timesheet.entities.User.
     */
    public void testGetDob() {
        System.out.println("getDob");
        
        com.abbt.timesheet.entities.User instance = new com.abbt.timesheet.entities.User();
        
        Date expResult = null;
        Date result = instance.getDob();
        assertEquals(expResult, result);
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDob method, of class com.abbt.timesheet.entities.User.
     */
    public void testSetDob() {
        System.out.println("setDob");
        
        Date dob = null;
        com.abbt.timesheet.entities.User instance = new com.abbt.timesheet.entities.User();
        
        instance.setDob(dob);
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getEmployeeId method, of class com.abbt.timesheet.entities.User.
     */
    public void testGetEmployeeId() {
        System.out.println("getEmployeeId");
        
        com.abbt.timesheet.entities.User instance = new com.abbt.timesheet.entities.User();
        
        String expResult = "";
        String result = instance.getEmployeeId();
        assertEquals(expResult, result);
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setEmployeeId method, of class com.abbt.timesheet.entities.User.
     */
    public void testSetEmployeeId() {
        System.out.println("setEmployeeId");
        
        String employeeId = "";
        com.abbt.timesheet.entities.User instance = new com.abbt.timesheet.entities.User();
        
        instance.setEmployeeId(employeeId);
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getMobile method, of class com.abbt.timesheet.entities.User.
     */
    public void testGetMobile() {
        System.out.println("getMobile");
        
        com.abbt.timesheet.entities.User instance = new com.abbt.timesheet.entities.User();
        
        String expResult = "";
        String result = instance.getMobile();
        assertEquals(expResult, result);
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setMobile method, of class com.abbt.timesheet.entities.User.
     */
    public void testSetMobile() {
        System.out.println("setMobile");
        
        String mobile = "";
        com.abbt.timesheet.entities.User instance = new com.abbt.timesheet.entities.User();
        
        instance.setMobile(mobile);
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPhone method, of class com.abbt.timesheet.entities.User.
     */
    public void testGetPhone() {
        System.out.println("getPhone");
        
        com.abbt.timesheet.entities.User instance = new com.abbt.timesheet.entities.User();
        
        String expResult = "";
        String result = instance.getPhone();
        assertEquals(expResult, result);
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPhone method, of class com.abbt.timesheet.entities.User.
     */
    public void testSetPhone() {
        System.out.println("setPhone");
        
        String phone = "";
        com.abbt.timesheet.entities.User instance = new com.abbt.timesheet.entities.User();
        
        instance.setPhone(phone);
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getOfficePhone method, of class com.abbt.timesheet.entities.User.
     */
    public void testGetOfficePhone() {
        System.out.println("getOfficePhone");
        
        com.abbt.timesheet.entities.User instance = new com.abbt.timesheet.entities.User();
        
        String expResult = "";
        String result = instance.getOfficePhone();
        assertEquals(expResult, result);
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setOfficePhone method, of class com.abbt.timesheet.entities.User.
     */
    public void testSetOfficePhone() {
        System.out.println("setOfficePhone");
        
        String officePhone = "";
        com.abbt.timesheet.entities.User instance = new com.abbt.timesheet.entities.User();
        
        instance.setOfficePhone(officePhone);
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getFax method, of class com.abbt.timesheet.entities.User.
     */
    public void testGetFax() {
        System.out.println("getFax");
        
        com.abbt.timesheet.entities.User instance = new com.abbt.timesheet.entities.User();
        
        String expResult = "";
        String result = instance.getFax();
        assertEquals(expResult, result);
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setFax method, of class com.abbt.timesheet.entities.User.
     */
    public void testSetFax() {
        System.out.println("setFax");
        
        String fax = "";
        com.abbt.timesheet.entities.User instance = new com.abbt.timesheet.entities.User();
        
        instance.setFax(fax);
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCreatedBy method, of class com.abbt.timesheet.entities.User.
     */
    public void testGetCreatedBy() {
        System.out.println("getCreatedBy");
        
        com.abbt.timesheet.entities.User instance = new com.abbt.timesheet.entities.User();
        
        String expResult = "";
        String result = instance.getCreatedBy();
        assertEquals(expResult, result);
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCreatedBy method, of class com.abbt.timesheet.entities.User.
     */
    public void testSetCreatedBy() {
        System.out.println("setCreatedBy");
        
        String createdBy = "";
        com.abbt.timesheet.entities.User instance = new com.abbt.timesheet.entities.User();
        
        instance.setCreatedBy(createdBy);
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCreatedDate method, of class com.abbt.timesheet.entities.User.
     */
    public void testGetCreatedDate() {
        System.out.println("getCreatedDate");
        
        com.abbt.timesheet.entities.User instance = new com.abbt.timesheet.entities.User();
        
        Date expResult = null;
        Date result = instance.getCreatedDate();
        assertEquals(expResult, result);
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCreatedDate method, of class com.abbt.timesheet.entities.User.
     */
    public void testSetCreatedDate() {
        System.out.println("setCreatedDate");
        
        Date createdDate = null;
        com.abbt.timesheet.entities.User instance = new com.abbt.timesheet.entities.User();
        
        instance.setCreatedDate(createdDate);
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getLastUpdatedBy method, of class com.abbt.timesheet.entities.User.
     */
    public void testGetLastUpdatedBy() {
        System.out.println("getLastUpdatedBy");
        
        com.abbt.timesheet.entities.User instance = new com.abbt.timesheet.entities.User();
        
        String expResult = "";
        String result = instance.getLastUpdatedBy();
        assertEquals(expResult, result);
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setLastUpdatedBy method, of class com.abbt.timesheet.entities.User.
     */
    public void testSetLastUpdatedBy() {
        System.out.println("setLastUpdatedBy");
        
        String lastUpdatedBy = "";
        com.abbt.timesheet.entities.User instance = new com.abbt.timesheet.entities.User();
        
        instance.setLastUpdatedBy(lastUpdatedBy);
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getLastUpdatedDate method, of class com.abbt.timesheet.entities.User.
     */
    public void testGetLastUpdatedDate() {
        System.out.println("getLastUpdatedDate");
        
        com.abbt.timesheet.entities.User instance = new com.abbt.timesheet.entities.User();
        
        Date expResult = null;
        Date result = instance.getLastUpdatedDate();
        assertEquals(expResult, result);
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setLastUpdatedDate method, of class com.abbt.timesheet.entities.User.
     */
    public void testSetLastUpdatedDate() {
        System.out.println("setLastUpdatedDate");
        
        Date lastUpdatedDate = null;
        com.abbt.timesheet.entities.User instance = new com.abbt.timesheet.entities.User();
        
        instance.setLastUpdatedDate(lastUpdatedDate);
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getUserCompanyCollection method, of class com.abbt.timesheet.entities.User.
     */
    public void testGetUserCompanyCollection() {
        System.out.println("getUserCompanyCollection");
        
        com.abbt.timesheet.entities.User instance = new com.abbt.timesheet.entities.User();
        
        Collection<com.abbt.timesheet.entities.UserCompany> expResult = null;
        Collection<com.abbt.timesheet.entities.UserCompany> result = instance.getUserCompanyCollection();
        assertEquals(expResult, result);
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setUserCompanyCollection method, of class com.abbt.timesheet.entities.User.
     */
    public void testSetUserCompanyCollection() {
        System.out.println("setUserCompanyCollection");
        
        Collection<com.abbt.timesheet.entities.UserCompany> userCompanyCollection = null;
        com.abbt.timesheet.entities.User instance = new com.abbt.timesheet.entities.User();
        
        instance.setUserCompanyCollection(userCompanyCollection);
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTimesheetCollection method, of class com.abbt.timesheet.entities.User.
     */
    public void testGetTimesheetCollection() {
        System.out.println("getTimesheetCollection");
        
        com.abbt.timesheet.entities.User instance = new com.abbt.timesheet.entities.User();
        
        Collection<com.abbt.timesheet.entities.Timesheet> expResult = null;
        Collection<com.abbt.timesheet.entities.Timesheet> result = instance.getTimesheetCollection();
        assertEquals(expResult, result);
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setTimesheetCollection method, of class com.abbt.timesheet.entities.User.
     */
    public void testSetTimesheetCollection() {
        System.out.println("setTimesheetCollection");
        
        Collection<com.abbt.timesheet.entities.Timesheet> timesheetCollection = null;
        com.abbt.timesheet.entities.User instance = new com.abbt.timesheet.entities.User();
        
        instance.setTimesheetCollection(timesheetCollection);
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPrimaryAddress method, of class com.abbt.timesheet.entities.User.
     */
    public void testGetPrimaryAddress() {
        System.out.println("getPrimaryAddress");
        
        com.abbt.timesheet.entities.User instance = new com.abbt.timesheet.entities.User();
        
        com.abbt.timesheet.entities.Address expResult = null;
        com.abbt.timesheet.entities.Address result = instance.getPrimaryAddress();
        assertEquals(expResult, result);
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPrimaryAddress method, of class com.abbt.timesheet.entities.User.
     */
    public void testSetPrimaryAddress() {
        System.out.println("setPrimaryAddress");
        
        com.abbt.timesheet.entities.Address primaryAddress = null;
        com.abbt.timesheet.entities.User instance = new com.abbt.timesheet.entities.User();
        
        instance.setPrimaryAddress(primaryAddress);
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of hashCode method, of class com.abbt.timesheet.entities.User.
     */
    public void testHashCode() {
        System.out.println("hashCode");
        
        com.abbt.timesheet.entities.User instance = new com.abbt.timesheet.entities.User();
        
        int expResult = 0;
        int result = instance.hashCode();
        assertEquals(expResult, result);
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of equals method, of class com.abbt.timesheet.entities.User.
     */
    public void testEquals() {
        System.out.println("equals");
        
        Object object = null;
        com.abbt.timesheet.entities.User instance = new com.abbt.timesheet.entities.User();
        
        boolean expResult = true;
        boolean result = instance.equals(object);
        assertEquals(expResult, result);
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class com.abbt.timesheet.entities.User.
     */
    public void testToString() {
        System.out.println("toString");
        
        com.abbt.timesheet.entities.User instance = new com.abbt.timesheet.entities.User();
        
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
