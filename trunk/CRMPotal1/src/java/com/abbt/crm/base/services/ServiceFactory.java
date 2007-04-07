/*
 * ServiceFactory.java
 *
 * Created on April 6, 2007, 10:25 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package com.abbt.crm.base.services;

/**
 *
 * @author shannan
 * singleton class
 * returns an service object which needs to be type caste
 *
 */
public final class ServiceFactory {
    private static final ServiceFactory instance = new ServiceFactory();
    /** Creates a new instance of ServiceFactory */
    private ServiceFactory() {
    }
   
    /** returns a single instance **/
    public static final ServiceFactory getInstance() {
        return instance;
    }

    /*  return a Service instance takes an service name 
     *  ICRUDService iCRUDService = (ICRUDService)  getService ( "ICRUDService"); 
     */
    public Object getService(String name) {
         return null;
    }

}
