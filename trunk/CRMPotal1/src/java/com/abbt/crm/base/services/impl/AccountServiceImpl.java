/*
 * AccountServiceImpl.java
 *
 * Created on April 3, 2007, 8:32 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package com.abbt.crm.base.services.impl;

import com.abbt.crm.base.dao.IGenericDAO;
import com.abbt.crm.base.dao.GenericDAOImpl;
import com.abbt.crm.base.entity.Account;
import com.abbt.crm.base.services.*;
import java.util.List;
 
/**
 *
 * @author Osman
 */
class AccountServiceImpl implements IAccountService {
    
    private IGenericDAO dao = new GenericDAOImpl();
    /** Creates a new instance of AccountServiceImpl */
    public AccountServiceImpl() {
    }
    
    public List<Account> findRecentEmployeeAccounts() {
        
        /*
         * Passing the query to the DAO.
         */
        
        String jpaQuery = " select account from Account account order by account.lastModifiedDate";
        return getDao().find(jpaQuery);
    
    }

   
    public void setDao(IGenericDAO dao) {
        this.dao = dao;
    }
    
    public IGenericDAO getDao() {
        return this.dao;
    }
  
    
}
