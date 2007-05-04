package com.abbt.timesheet.services;
import junit.framework.*;
import com.abbt.timesheet.entities.Timesheet;
import com.abbt.timesheet.exceptions.EntityExistsException;
/*
 * TimesheetServiceTest.java
 * JUnit based test
 *
 * Created on May 3, 2007, 11:14 PM
 */

/**
 *
 * @author shannan
 */
public class TimesheetServiceTest extends TestCase {
    
    public TimesheetServiceTest(String testName) {
        super(testName);
    }

    protected void setUp() throws Exception {
    }

    protected void tearDown() throws Exception {
    }

    public static Test suite() {
        TestSuite suite = new TestSuite(TimesheetServiceTest.class);
        
        return suite;
    }

    /**
     * Test of save method, of class com.abbt.timesheet.services.TimesheetService.
     */
    public void testSave() throws Exception {
        System.out.println("save");
        
        Timesheet timesheet = null;
        com.abbt.timesheet.services.TimesheetService instance = new com.abbt.timesheet.services.TimesheetService();
        
        instance.save(timesheet);
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Generated implementation of abstract class com.abbt.timesheet.services.TimesheetService. Please fill dummy bodies of generated methods.
     */
    private class TimesheetServiceImpl implements TimesheetService {

        public void save(com.abbt.timesheet.entities.Timesheet timesheet) {
            // TODO fill the body in order to provide useful implementation
            
        }
    }

    
}
