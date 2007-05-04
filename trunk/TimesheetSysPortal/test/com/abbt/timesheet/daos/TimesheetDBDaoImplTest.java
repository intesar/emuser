package com.abbt.timesheet.daos;
import junit.framework.*;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
/*
 * TimesheetDBDaoImplTest.java
 * JUnit based test
 *
 * Created on May 3, 2007, 11:15 PM
 */

/**
 *
 * @author shannan
 */
public class TimesheetDBDaoImplTest extends TestCase {
    
    public TimesheetDBDaoImplTest(String testName) {
        super(testName);
    }

    protected void setUp() throws Exception {
    }

    protected void tearDown() throws Exception {
    }

    public static Test suite() {
        TestSuite suite = new TestSuite(TimesheetDBDaoImplTest.class);
        
        return suite;
    }

    /**
     * Test of save method, of class com.abbt.timesheet.daos.TimesheetDBDaoImpl.
     */
    public void testSave() throws Exception {
        System.out.println("save");
        
        Object object = null;
        com.abbt.timesheet.daos.TimesheetDBDaoImpl instance = new com.abbt.timesheet.daos.TimesheetDBDaoImpl();
        
        instance.save(object);
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of update method, of class com.abbt.timesheet.daos.TimesheetDBDaoImpl.
     */
    public void testUpdate() {
        System.out.println("update");
        
        Object object = null;
        com.abbt.timesheet.daos.TimesheetDBDaoImpl instance = new com.abbt.timesheet.daos.TimesheetDBDaoImpl();
        
        Object expResult = null;
        Object result = instance.update(object);
        assertEquals(expResult, result);
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of delete method, of class com.abbt.timesheet.daos.TimesheetDBDaoImpl.
     */
    public void testDelete() {
        System.out.println("delete");
        
        Object object = null;
        com.abbt.timesheet.daos.TimesheetDBDaoImpl instance = new com.abbt.timesheet.daos.TimesheetDBDaoImpl();
        
        instance.delete(object);
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findByPrimaryKey method, of class com.abbt.timesheet.daos.TimesheetDBDaoImpl.
     */
    public void testFindByPrimaryKey() {
        System.out.println("findByPrimaryKey");
        
        Class clazz = null;
        Object key = null;
        com.abbt.timesheet.daos.TimesheetDBDaoImpl instance = new com.abbt.timesheet.daos.TimesheetDBDaoImpl();
        
        Object expResult = null;
        Object result = instance.findByPrimaryKey(clazz, key);
        assertEquals(expResult, result);
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findSingleResultByNamedQuery method, of class com.abbt.timesheet.daos.TimesheetDBDaoImpl.
     */
    public void testFindSingleResultByNamedQuery() {
        System.out.println("findSingleResultByNamedQuery");
        
        String namedQuery = "";
        Object obj = null;
        com.abbt.timesheet.daos.TimesheetDBDaoImpl instance = new com.abbt.timesheet.daos.TimesheetDBDaoImpl();
        
        Object expResult = null;
        Object result = instance.findSingleResultByNamedQuery(namedQuery, obj);
        assertEquals(expResult, result);
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findResultListByNamedQuery method, of class com.abbt.timesheet.daos.TimesheetDBDaoImpl.
     */
    public void testFindResultListByNamedQuery() {
        System.out.println("findResultListByNamedQuery");
        
        String namedQuery = "";
        Object obj = null;
        com.abbt.timesheet.daos.TimesheetDBDaoImpl instance = new com.abbt.timesheet.daos.TimesheetDBDaoImpl();
        
        List expResult = null;
        List result = instance.findResultListByNamedQuery(namedQuery, obj);
        assertEquals(expResult, result);
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
