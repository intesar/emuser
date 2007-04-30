/*
 * ServiceFactory.java
 *
 * Created on April 29, 2007, 10:16 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package com.abbt.timesheet.services;


import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

/**
 *
 * @author shannan
 * singleton class
 * returns an service object which needs to be type caste
 *
 */
public final class ServiceFactory {
   
    /** Creates a new instance of ServiceFactory */
    private ServiceFactory() {
    }
      
    /*  return a Service instance takes an service name 
     *  ICRUDService iCRUDService = (ICRUDService)  getService ( "ICRUDService"); 
     */
    public static final Object getService(String name ) {
        Resource resource = new ClassPathResource("context/applicationContext.xml");       
        BeanFactory factory = new XmlBeanFactory(resource);
        return factory.getBean(name);
    }
}

