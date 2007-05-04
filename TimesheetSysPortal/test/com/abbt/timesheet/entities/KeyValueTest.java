package com.abbt.timesheet.entities;
import junit.framework.*;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
/*
 * KeyValueTest.java
 * JUnit based test
 *
 * Created on May 3, 2007, 11:14 PM
 */

/**
 *
 * @author shannan
 */
public class KeyValueTest extends TestCase {
    
    public KeyValueTest(String testName) {
        super(testName);
    }

    protected void setUp() throws Exception {
    }

    protected void tearDown() throws Exception {
    }

    public static Test suite() {
        TestSuite suite = new TestSuite(KeyValueTest.class);
        
        return suite;
    }

    /**
     * Test of getId method, of class com.abbt.timesheet.entities.KeyValue.
     */
    public void testGetId() {
        System.out.println("getId");
        
        com.abbt.timesheet.entities.KeyValue instance = new com.abbt.timesheet.entities.KeyValue();
        
        Integer expResult = null;
        Integer result = instance.getId();
        assertEquals(expResult, result);
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setId method, of class com.abbt.timesheet.entities.KeyValue.
     */
    public void testSetId() {
        System.out.println("setId");
        
        Integer id = null;
        com.abbt.timesheet.entities.KeyValue instance = new com.abbt.timesheet.entities.KeyValue();
        
        instance.setId(id);
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getType method, of class com.abbt.timesheet.entities.KeyValue.
     */
    public void testGetType() {
        System.out.println("getType");
        
        com.abbt.timesheet.entities.KeyValue instance = new com.abbt.timesheet.entities.KeyValue();
        
        String expResult = "";
        String result = instance.getType();
        assertEquals(expResult, result);
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setType method, of class com.abbt.timesheet.entities.KeyValue.
     */
    public void testSetType() {
        System.out.println("setType");
        
        String type = "";
        com.abbt.timesheet.entities.KeyValue instance = new com.abbt.timesheet.entities.KeyValue();
        
        instance.setType(type);
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getValue method, of class com.abbt.timesheet.entities.KeyValue.
     */
    public void testGetValue() {
        System.out.println("getValue");
        
        com.abbt.timesheet.entities.KeyValue instance = new com.abbt.timesheet.entities.KeyValue();
        
        String expResult = "";
        String result = instance.getValue();
        assertEquals(expResult, result);
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setValue method, of class com.abbt.timesheet.entities.KeyValue.
     */
    public void testSetValue() {
        System.out.println("setValue");
        
        String value = "";
        com.abbt.timesheet.entities.KeyValue instance = new com.abbt.timesheet.entities.KeyValue();
        
        instance.setValue(value);
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDescription method, of class com.abbt.timesheet.entities.KeyValue.
     */
    public void testGetDescription() {
        System.out.println("getDescription");
        
        com.abbt.timesheet.entities.KeyValue instance = new com.abbt.timesheet.entities.KeyValue();
        
        String expResult = "";
        String result = instance.getDescription();
        assertEquals(expResult, result);
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDescription method, of class com.abbt.timesheet.entities.KeyValue.
     */
    public void testSetDescription() {
        System.out.println("setDescription");
        
        String description = "";
        com.abbt.timesheet.entities.KeyValue instance = new com.abbt.timesheet.entities.KeyValue();
        
        instance.setDescription(description);
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSortNumber method, of class com.abbt.timesheet.entities.KeyValue.
     */
    public void testGetSortNumber() {
        System.out.println("getSortNumber");
        
        com.abbt.timesheet.entities.KeyValue instance = new com.abbt.timesheet.entities.KeyValue();
        
        Integer expResult = null;
        Integer result = instance.getSortNumber();
        assertEquals(expResult, result);
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setSortNumber method, of class com.abbt.timesheet.entities.KeyValue.
     */
    public void testSetSortNumber() {
        System.out.println("setSortNumber");
        
        Integer sortNumber = null;
        com.abbt.timesheet.entities.KeyValue instance = new com.abbt.timesheet.entities.KeyValue();
        
        instance.setSortNumber(sortNumber);
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCreatedBy method, of class com.abbt.timesheet.entities.KeyValue.
     */
    public void testGetCreatedBy() {
        System.out.println("getCreatedBy");
        
        com.abbt.timesheet.entities.KeyValue instance = new com.abbt.timesheet.entities.KeyValue();
        
        String expResult = "";
        String result = instance.getCreatedBy();
        assertEquals(expResult, result);
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCreatedBy method, of class com.abbt.timesheet.entities.KeyValue.
     */
    public void testSetCreatedBy() {
        System.out.println("setCreatedBy");
        
        String createdBy = "";
        com.abbt.timesheet.entities.KeyValue instance = new com.abbt.timesheet.entities.KeyValue();
        
        instance.setCreatedBy(createdBy);
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCreatedDate method, of class com.abbt.timesheet.entities.KeyValue.
     */
    public void testGetCreatedDate() {
        System.out.println("getCreatedDate");
        
        com.abbt.timesheet.entities.KeyValue instance = new com.abbt.timesheet.entities.KeyValue();
        
        Date expResult = null;
        Date result = instance.getCreatedDate();
        assertEquals(expResult, result);
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCreatedDate method, of class com.abbt.timesheet.entities.KeyValue.
     */
    public void testSetCreatedDate() {
        System.out.println("setCreatedDate");
        
        Date createdDate = null;
        com.abbt.timesheet.entities.KeyValue instance = new com.abbt.timesheet.entities.KeyValue();
        
        instance.setCreatedDate(createdDate);
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getLastUpdatedBy method, of class com.abbt.timesheet.entities.KeyValue.
     */
    public void testGetLastUpdatedBy() {
        System.out.println("getLastUpdatedBy");
        
        com.abbt.timesheet.entities.KeyValue instance = new com.abbt.timesheet.entities.KeyValue();
        
        String expResult = "";
        String result = instance.getLastUpdatedBy();
        assertEquals(expResult, result);
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setLastUpdatedBy method, of class com.abbt.timesheet.entities.KeyValue.
     */
    public void testSetLastUpdatedBy() {
        System.out.println("setLastUpdatedBy");
        
        String lastUpdatedBy = "";
        com.abbt.timesheet.entities.KeyValue instance = new com.abbt.timesheet.entities.KeyValue();
        
        instance.setLastUpdatedBy(lastUpdatedBy);
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getLastUpdateDate method, of class com.abbt.timesheet.entities.KeyValue.
     */
    public void testGetLastUpdateDate() {
        System.out.println("getLastUpdateDate");
        
        com.abbt.timesheet.entities.KeyValue instance = new com.abbt.timesheet.entities.KeyValue();
        
        Date expResult = null;
        Date result = instance.getLastUpdateDate();
        assertEquals(expResult, result);
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setLastUpdateDate method, of class com.abbt.timesheet.entities.KeyValue.
     */
    public void testSetLastUpdateDate() {
        System.out.println("setLastUpdateDate");
        
        Date lastUpdateDate = null;
        com.abbt.timesheet.entities.KeyValue instance = new com.abbt.timesheet.entities.KeyValue();
        
        instance.setLastUpdateDate(lastUpdateDate);
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of hashCode method, of class com.abbt.timesheet.entities.KeyValue.
     */
    public void testHashCode() {
        System.out.println("hashCode");
        
        com.abbt.timesheet.entities.KeyValue instance = new com.abbt.timesheet.entities.KeyValue();
        
        int expResult = 0;
        int result = instance.hashCode();
        assertEquals(expResult, result);
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of equals method, of class com.abbt.timesheet.entities.KeyValue.
     */
    public void testEquals() {
        System.out.println("equals");
        
        Object object = null;
        com.abbt.timesheet.entities.KeyValue instance = new com.abbt.timesheet.entities.KeyValue();
        
        boolean expResult = true;
        boolean result = instance.equals(object);
        assertEquals(expResult, result);
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class com.abbt.timesheet.entities.KeyValue.
     */
    public void testToString() {
        System.out.println("toString");
        
        com.abbt.timesheet.entities.KeyValue instance = new com.abbt.timesheet.entities.KeyValue();
        
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
