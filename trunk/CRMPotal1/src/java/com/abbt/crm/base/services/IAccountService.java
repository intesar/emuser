/*
 * IAccountService.java
 *
 * Created on April 3, 2007, 8:32 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package com.abbt.crm.base.services;

import com.abbt.crm.base.entity.Account;
import java.util.List;
import com.abbt.crm.base.entity.Account;

/**
 *
 * @author Osman
 */
public interface IAccountService {
    /*
     * declaring the interface for recent employee accounts
     */
    List<Account> findRecentEmployeeAccounts();
    
}
