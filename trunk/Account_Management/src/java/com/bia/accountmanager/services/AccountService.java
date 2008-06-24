/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.bia.accountmanager.services;

import com.bia.accountmanager.entity.Account;
import java.util.Date;
import java.util.List;

/**
 *
 * @author intesar
 */
public interface AccountService {
    
    void createAccount(Account acct);
    void activateDeactivate(String accountName);
    List<String> getAccountName();
    void duplicate(long TransactionID);
    void deleteTransaction(long transactionid);
    void addTransaction(String account1,String account2,double amount,String memo,Date date);
    void withdraw(String account,String payee,double amount,String memo,Date date);
    void deposit(String account,String payee,double amount,String memo,Date date);
    void getTransaction(int pageNo);
     
}
