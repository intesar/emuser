package com.abbt.timesheet.services;
import junit.framework.*;
import com.abbt.timesheet.daos.TimesheetDBDao;
import com.abbt.timesheet.entities.Timesheet;
import com.abbt.timesheet.exceptions.EntityExistsException;
/*
 * TimesheetServiceImplTest.java
 * JUnit based test
 *
 * Created on May 3, 2007, 11:15 PM
 */

/**
 *
 * @author shannan
 */
public class TimesheetServiceImplTest extends TestCase {
    
    public TimesheetServiceImplTest(String testName) {
        super(testName);
    }

    protected void setUp() throws Exception {
    }

    protected void tearDown() throws Exception {
    }

    public static Test suite() {
        TestSuite suite = new TestSuite(TimesheetServiceImplTest.class);
        
        return suite;
    }

    /**
     * Test of save method, of class com.abbt.timesheet.services.TimesheetServiceImpl.
     */
    public void testSave() throws Exception {
        System.out.println("save");
        
        Timesheet timesheet = null;
        com.abbt.timesheet.services.TimesheetServiceImpl instance = new com.abbt.timesheet.services.TimesheetServiceImpl();
        
        instance.save(timesheet);
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTimesheetDBDao method, of class com.abbt.timesheet.services.TimesheetServiceImpl.
     */
    public void testGetTimesheetDBDao() {
        System.out.println("getTimesheetDBDao");
        
        com.abbt.timesheet.services.TimesheetServiceImpl instance = new com.abbt.timesheet.services.TimesheetServiceImpl();
        
        TimesheetDBDao expResult = null;
        TimesheetDBDao result = instance.getTimesheetDBDao();
        assertEquals(expResult, result);
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setTimesheetDBDao method, of class com.abbt.timesheet.services.TimesheetServiceImpl.
     */
    public void testSetTimesheetDBDao() {
        System.out.println("setTimesheetDBDao");
        
        TimesheetDBDao timesheetDBDao = null;
        com.abbt.timesheet.services.TimesheetServiceImpl instance = new com.abbt.timesheet.services.TimesheetServiceImpl();
        
        instance.setTimesheetDBDao(timesheetDBDao);
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
