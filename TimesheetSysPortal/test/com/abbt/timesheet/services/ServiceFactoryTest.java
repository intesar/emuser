package com.abbt.timesheet.services;
import junit.framework.*;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
/*
 * ServiceFactoryTest.java
 * JUnit based test
 *
 * Created on May 3, 2007, 11:15 PM
 */

/**
 *
 * @author shannan
 */
public class ServiceFactoryTest extends TestCase {
    
    public ServiceFactoryTest(String testName) {
        super(testName);
    }

    protected void setUp() throws Exception {
    }

    protected void tearDown() throws Exception {
    }

    public static Test suite() {
        TestSuite suite = new TestSuite(ServiceFactoryTest.class);
        
        return suite;
    }

    /**
     * Test of getService method, of class com.abbt.timesheet.services.ServiceFactory.
     */
    public void testGetService() {
        System.out.println("getService");
        
        String name = "";
        
        Object expResult = null;
        Object result = com.abbt.timesheet.services.ServiceFactory.getService(name);
        assertEquals(expResult, result);
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
