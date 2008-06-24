/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.bia.accountmanager.services.ajax;

import com.bia.accountmanager.services.AccountService;

/**
 *
 * @author intesar
 */
public class AccountAjaxService {

    public void setAccountService(AccountService accountService) {
        this.accountService = accountService;
    }
    
    
    private AccountService accountService;

}
