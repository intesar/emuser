/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bia.accountmanager.services.impl;

import com.bia.accountmanager.dao.AccountDao;
import com.bia.accountmanager.dao.TransactionDao;
import com.bia.accountmanager.dao.UsersDao;
import com.bia.accountmanager.entity.Account;
import com.bia.accountmanager.entity.Transactions;
import com.bia.accountmanager.services.AccountService;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.transaction.Transaction;


/**
 *
 * @author intesar
 */
public class AccountServiceImpl implements AccountService {

    public void createAccount(Account acct) {
        this.accountDao.create(acct);
    }

    public void activateDeactivate(String accountName) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public List<String> getAccountName(String organization) {
        List<Account> list = this.accountDao.findByOrganization(organization);

        List<String> l = new ArrayList<String>();
        for (Account a : list) {
            l.add(a.getName());
        }

        return l;
    }

    public void duplicate(long TransactionID) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void deleteTransaction(Integer transactionid) {
        Transactions t = transactionDao.read(transactionid);
        this.transactionDao.delete(t);
    }

    public void addTransaction(String account1, String account2, double amount, String memo, Date date) {
        Transaction s = transactionDao.create(transactionid);
        this.transactionDao.add(s);
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

    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    public void setTransactionDao(TransactionDao transactionDao) {
        this.transactionDao = transactionDao;
    }

    // setters for dao
    
    
    public void setUsersDao(UsersDao usersDao) {
        this.usersDao = usersDao;
    }
    private AccountDao accountDao;
    private UsersDao usersDao;
    private TransactionDao transactionDao;
    private TransactionDao addtransactionDao;

    public void setAddtransactionDao(TransactionDao addtransactionDao) {
        this.addtransactionDao = addtransactionDao;
    }
}
