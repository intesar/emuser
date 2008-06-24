/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.bia.accountmanager.services.impl;

import com.bia.accountmanager.entity.Account;
import com.bia.accountmanager.services.AccountService;
import java.util.Date;
import java.util.List;

/**
 *
 * @author intesar
 */
public class AccountServiceImpl implements AccountService {

    public void createAccount(Account acct) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void activateDeactivate(String accountName) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public List<String> getAccountName() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void duplicate(long TransactionID) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void deleteTransaction(long transactionid) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void addTransaction(String account1, String account2, double amount, String memo, Date date) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void withdraw(String account, String payee, double amount, String memo, Date date) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void deposit(String account, String payee, double amount, String memo, Date date) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void getTransaction(int pageNo) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
