/*
 * ContactImpl.java
 *
 * Created on April 4, 2007, 9:39 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package com.abbt.crm.base.services;

import java.util.List;
import com.abbt.crm.base.dao.GenericDAO;
import com.abbt.crm.base.dao.GenericDAOImpl;

/**
 *
 * @author Osman
 */
public class ContactImpl implements Contact {
    
    private GenericDAO dao = new GenericDAOImpl();
    /*
     *generating the object of generic DAO
     */
    
    /** Creates a new instance of ContactImpl */
    public ContactImpl() {
            
    }
    
    public List<Contact> findRecentContacts() {
        
        /*
         * Passing the query to the DAO.
         */
        
        String jpaQuery = " select contact from Contact contact order by contact.lastModifiedDate";
        return dao.find(jpaQuery);
    
    }
    
    public void setGenericDAO( GenericDAO dao) {
        this.dao = dao;
    }
    
    
    
}
