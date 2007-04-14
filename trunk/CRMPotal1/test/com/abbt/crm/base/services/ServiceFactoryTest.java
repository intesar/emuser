package com.abbt.crm.base.services;
import junit.framework.*;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
/*
 * ServiceFactoryTest.java
 * JUnit based test
 *
 * Created on April 13, 2007, 11:02 PM
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

    /**
     * Test of getInstance method, of class com.abbt.crm.base.services.ServiceFactory.
     */
    public void testGetInstance() {
        System.out.println("getInstance");
        
        com.abbt.crm.base.services.ServiceFactory expResult = null;
        com.abbt.crm.base.services.ServiceFactory result = com.abbt.crm.base.services.ServiceFactory.getInstance();
        assertEquals(expResult, result);
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getService method, of class com.abbt.crm.base.services.ServiceFactory.
     */
    public void testGetService() {
        System.out.println("getService");
        
        String name = "";
        com.abbt.crm.base.services.ServiceFactory instance = com.abbt.crm.base.services.ServiceFactory.getInstance();
        Object expResult = null;
        Object result = instance.getService(name);
        assertEquals(expResult, result);
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getBean method, of class com.abbt.crm.base.services.ServiceFactory.
     */
    public void testGetBean() {
        System.out.println("getBean");
        
        String name = "IGenericDAO";
        com.abbt.crm.base.services.ServiceFactory instance = com.abbt.crm.base.services.ServiceFactory.getInstance();
        
        Object expResult = null;
        Object result = instance.getBean(name);
        this.assertNotNull(result);
        
        // TODO review the generated test code and remove the default call to fail.
       // fail("The test case is a prototype.");
    }
    
}
