/*
 * ContactServiceImpl.java
 *
 * Created on April 4, 2007, 9:39 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package com.abbt.crm.base.services;

import java.util.List;
import com.abbt.crm.base.dao.IGenericDAO;
import com.abbt.crm.base.dao.GenericDAOImpl;

/**
 *
 * @author Osman
 */
class ContactServiceImpl implements IContactService {
    
    private IGenericDAO dao = new GenericDAOImpl();
    /*
     *generating the object of generic DAO
     */
    
    /**
     * Creates a new instance of ContactServiceImpl
     */
    public ContactServiceImpl() {
            
    }
    
    public List<IContactService> findRecentContacts() {
        
        /*
         * Passing the query to the DAO.
         */
        
        String jpaQuery = " select contact from Contact contact order by contact.lastModifiedDate";
        return dao.find(jpaQuery);
    
    }
    
    public void setGenericDAO( IGenericDAO dao) {
        this.dao = dao;
    }
    
    
    
}
