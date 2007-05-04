package com.abbt.timesheet.portlets;
import junit.framework.*;
import javax.portlet.GenericPortlet;
import javax.portlet.ActionRequest;
import javax.portlet.PortletConfig;
import javax.portlet.PortletRequestDispatcher;
import javax.portlet.RenderRequest;
import javax.portlet.ActionResponse;
import javax.portlet.RenderResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletURL;
import javax.portlet.PortletMode;
import javax.portlet.PortletPreferences;
import javax.portlet.WindowState;
import java.io.IOException;
import java.io.PrintWriter;
/*
 * RecentTimesheetsTest.java
 * JUnit based test
 *
 * Created on May 3, 2007, 11:14 PM
 */

/**
 *
 * @author shannan
 */
public class RecentTimesheetsTest extends TestCase {
    
    public RecentTimesheetsTest(String testName) {
        super(testName);
    }

    protected void setUp() throws Exception {
    }

    protected void tearDown() throws Exception {
    }

    public static Test suite() {
        TestSuite suite = new TestSuite(RecentTimesheetsTest.class);
        
        return suite;
    }

    /**
     * Test of init method, of class com.abbt.timesheet.portlets.RecentTimesheets.
     */
    public void testInit() throws Exception {
        System.out.println("init");
        
        PortletConfig config = null;
        com.abbt.timesheet.portlets.RecentTimesheets instance = new com.abbt.timesheet.portlets.RecentTimesheets();
        
        instance.init(config);
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of doView method, of class com.abbt.timesheet.portlets.RecentTimesheets.
     */
    public void testDoView() throws Exception {
        System.out.println("doView");
        
        RenderRequest request = null;
        RenderResponse response = null;
        com.abbt.timesheet.portlets.RecentTimesheets instance = new com.abbt.timesheet.portlets.RecentTimesheets();
        
        instance.doView(request, response);
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of doEdit method, of class com.abbt.timesheet.portlets.RecentTimesheets.
     */
    public void testDoEdit() throws Exception {
        System.out.println("doEdit");
        
        RenderRequest request = null;
        RenderResponse response = null;
        com.abbt.timesheet.portlets.RecentTimesheets instance = new com.abbt.timesheet.portlets.RecentTimesheets();
        
        instance.doEdit(request, response);
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of doHelp method, of class com.abbt.timesheet.portlets.RecentTimesheets.
     */
    public void testDoHelp() throws Exception {
        System.out.println("doHelp");
        
        RenderRequest request = null;
        RenderResponse response = null;
        com.abbt.timesheet.portlets.RecentTimesheets instance = new com.abbt.timesheet.portlets.RecentTimesheets();
        
        instance.doHelp(request, response);
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
