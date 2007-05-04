package com.abbt.timesheet.daos;
import junit.framework.*;
import com.abbt.timesheet.exceptions.EntityExistsException;
import java.util.List;
/*
 * TimesheetDBDaoTest.java
 * JUnit based test
 *
 * Created on May 3, 2007, 11:15 PM
 */

/**
 *
 * @author shannan
 */
public class TimesheetDBDaoTest extends TestCase {
    
    public TimesheetDBDaoTest(String testName) {
        super(testName);
    }

    protected void setUp() throws Exception {
    }

    protected void tearDown() throws Exception {
    }

    public static Test suite() {
        TestSuite suite = new TestSuite(TimesheetDBDaoTest.class);
        
        return suite;
    }

    /**
     * Test of delete method, of class com.abbt.timesheet.daos.TimesheetDBDao.
     */
    public void testDelete() {
        System.out.println("delete");
        
        Object object = null;
        com.abbt.timesheet.daos.TimesheetDBDao instance = new com.abbt.timesheet.daos.TimesheetDBDao();
        
        instance.delete(object);
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findByPrimaryKey method, of class com.abbt.timesheet.daos.TimesheetDBDao.
     */
    public void testFindByPrimaryKey() {
        System.out.println("findByPrimaryKey");
        
        Class clazz = null;
        Object key = null;
        com.abbt.timesheet.daos.TimesheetDBDao instance = new com.abbt.timesheet.daos.TimesheetDBDao();
        
        Object expResult = null;
        Object result = instance.findByPrimaryKey(clazz, key);
        assertEquals(expResult, result);
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findResultListByNamedQuery method, of class com.abbt.timesheet.daos.TimesheetDBDao.
     */
    public void testFindResultListByNamedQuery() {
        System.out.println("findResultListByNamedQuery");
        
        String namedQuery = "";
        Object obj = null;
        com.abbt.timesheet.daos.TimesheetDBDao instance = new com.abbt.timesheet.daos.TimesheetDBDao();
        
        List expResult = null;
        List result = instance.findResultListByNamedQuery(namedQuery, obj);
        assertEquals(expResult, result);
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findSingleResultByNamedQuery method, of class com.abbt.timesheet.daos.TimesheetDBDao.
     */
    public void testFindSingleResultByNamedQuery() {
        System.out.println("findSingleResultByNamedQuery");
        
        String namedQuery = "";
        Object obj = null;
        com.abbt.timesheet.daos.TimesheetDBDao instance = new com.abbt.timesheet.daos.TimesheetDBDao();
        
        Object expResult = null;
        Object result = instance.findSingleResultByNamedQuery(namedQuery, obj);
        assertEquals(expResult, result);
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of save method, of class com.abbt.timesheet.daos.TimesheetDBDao.
     */
    public void testSave() throws Exception {
        System.out.println("save");
        
        Object object = null;
        com.abbt.timesheet.daos.TimesheetDBDao instance = new com.abbt.timesheet.daos.TimesheetDBDao();
        
        instance.save(object);
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of update method, of class com.abbt.timesheet.daos.TimesheetDBDao.
     */
    public void testUpdate() {
        System.out.println("update");
        
        Object object = null;
        com.abbt.timesheet.daos.TimesheetDBDao instance = new com.abbt.timesheet.daos.TimesheetDBDao();
        
        Object expResult = null;
        Object result = instance.update(object);
        assertEquals(expResult, result);
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Generated implementation of abstract class com.abbt.timesheet.daos.TimesheetDBDao. Please fill dummy bodies of generated methods.
     */
    private class TimesheetDBDaoImpl implements TimesheetDBDao {

        public void delete(java.lang.Object object) {
            // TODO fill the body in order to provide useful implementation
            
        }

        public java.lang.Object findByPrimaryKey(java.lang.Class clazz, java.lang.Object key) {
            // TODO fill the body in order to provide useful implementation
            
            return null;
        }

        public java.util.List findResultListByNamedQuery(java.lang.String namedQuery, java.lang.Object... obj) {
            // TODO fill the body in order to provide useful implementation
            
            return null;
        }

        public java.lang.Object findSingleResultByNamedQuery(java.lang.String namedQuery, java.lang.Object... obj) {
            // TODO fill the body in order to provide useful implementation
            
            return null;
        }

        public void save(java.lang.Object object) {
            // TODO fill the body in order to provide useful implementation
            
        }

        public java.lang.Object update(java.lang.Object object) {
            // TODO fill the body in order to provide useful implementation
            
            return null;
        }
    }

    
}
