/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.bia.accountmanager.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author intesar
 */
@Entity
@Table(name = "account")
@NamedQueries({@NamedQuery(name = "Account.findByName", query = "SELECT a FROM Account a WHERE a.name = :name"), @NamedQuery(name = "Account.findByBalance", query = "SELECT a FROM Account a WHERE a.balance = :balance"), @NamedQuery(name = "Account.findByOrganization", query = "SELECT a FROM Account a WHERE a.organization = :organization"), @NamedQuery(name = "Account.findByNote", query = "SELECT a FROM Account a WHERE a.note = :note"), @NamedQuery(name = "Account.findByAccountType", query = "SELECT a FROM Account a WHERE a.accountType = :accountType")})
public class Account implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "balance", nullable = false)
    private double balance;
    @Column(name = "organization", nullable = false)
    private String organization;
    @Column(name = "note")
    private String note;
    @Column(name = "account_type", nullable = false)
    private String accountType;

    public Account() {
    }

    public Account(String name) {
        this.name = name;
    }

    public Account(String name, double balance, String organization, String accountType) {
        this.name = name;
        this.balance = balance;
        this.organization = organization;
        this.accountType = accountType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getOrganization() {
        return organization;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (name != null ? name.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Account)) {
            return false;
        }
        Account other = (Account) object;
        if ((this.name == null && other.name != null) || (this.name != null && !this.name.equals(other.name))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bia.accountmanager.entity.Account[name=" + name + "]";
    }

}
