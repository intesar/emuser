/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.bia.accountmanager.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author intesar
 */
@Entity
@Table(name = "transactions")
@NamedQueries({@NamedQuery(name = "Transactions.findById", query = "SELECT t FROM Transactions t WHERE t.id = :id"), @NamedQuery(name = "Transactions.findByDate", query = "SELECT t FROM Transactions t WHERE t.date = :date"), @NamedQuery(name = "Transactions.findByUsername", query = "SELECT t FROM Transactions t WHERE t.username = :username"), @NamedQuery(name = "Transactions.findByAction", query = "SELECT t FROM Transactions t WHERE t.action = :action"), @NamedQuery(name = "Transactions.findByAmount", query = "SELECT t FROM Transactions t WHERE t.amount = :amount"), @NamedQuery(name = "Transactions.findByMemo", query = "SELECT t FROM Transactions t WHERE t.memo = :memo"), @NamedQuery(name = "Transactions.findByPayee", query = "SELECT t FROM Transactions t WHERE t.payee = :payee"), @NamedQuery(name = "Transactions.findByEnabled", query = "SELECT t FROM Transactions t WHERE t.enabled = :enabled"), @NamedQuery(name = "Transactions.findByAccount", query = "SELECT t FROM Transactions t WHERE t.account = :account"), @NamedQuery(name = "Transactions.findByCreateDate", query = "SELECT t FROM Transactions t WHERE t.createDate = :createDate")})
public class Transactions implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;
    @Column(name = "_date", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date date;
    @Column(name = "username", nullable = false)
    private String username;
    @Column(name = "action")
    private String action;
    @Column(name = "amount", nullable = false)
    private double amount;
    @Column(name = "memo")
    private String memo;
    @Column(name = "payee", nullable = false)
    private String payee;
    @Column(name = "enabled")
    private Boolean enabled;
    @Column(name = "account", nullable = false)
    private String account;
    @Column(name = "create_date", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date createDate;

    public Transactions() {
    }

    public Transactions(Integer id) {
        this.id = id;
    }

    public Transactions(Integer id, Date date, String username, double amount, String payee, String account, Date createDate) {
        this.id = id;
        this.date = date;
        this.username = username;
        this.amount = amount;
        this.payee = payee;
        this.account = account;
        this.createDate = createDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public String getPayee() {
        return payee;
    }

    public void setPayee(String payee) {
        this.payee = payee;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Transactions)) {
            return false;
        }
        Transactions other = (Transactions) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bia.accountmanager.entity.Transactions[id=" + id + "]";
    }

}
