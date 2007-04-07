/*
 * OpportunityServiceImpl.java
 *
 * Created on April 4, 2007, 10:36 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package com.abbt.crm.base.services;

import com.abbt.crm.base.dao.GenericDAO;
import com.abbt.crm.base.dao.GenericDAOImpl;
import java.util.List;

/**
 *
 * @author Osman
 */
public class OpportunityServiceImpl implements  IOpportunityService {
    
     private GenericDAO dao = new GenericDAOImpl();
    /**
     * Creates a new instance of OpportunityServiceImpl
     */
    public OpportunityServiceImpl() {
    }
     public List<IOpportunityService> findRecentOppertunity()
    {
        String jpaQuery = " select oppertunity from Opportunity oppertunity order by oppertunity.lastModifiedDate";
        return dao.find(jpaQuery);        
    }
    
    public void setGenericDAO( GenericDAO dao) {
        this.dao = dao;
    }

        
}

