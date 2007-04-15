/*
 * EmployeeViewedAccount.java
 *
 * Created on April 14, 2007, 7:49 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package com.abbt.crm.base.entity;

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
 * Entity class EmployeeViewedAccount
 * 
 * @author shannan
 */
@Entity
@Table(name = "employee_viewed_account")
@NamedQueries( {
        @NamedQuery(name = "EmployeeViewedAccount.findById", query = "SELECT e FROM EmployeeViewedAccount e WHERE e.id = :id"),
        @NamedQuery(name = "EmployeeViewedAccount.findByVersionId", query = "SELECT e FROM EmployeeViewedAccount e WHERE e.versionId = :versionId"),
        @NamedQuery(name = "EmployeeViewedAccount.findByUsername", query = "SELECT e FROM EmployeeViewedAccount e WHERE e.username = :username"),
        @NamedQuery(name = "EmployeeViewedAccount.findByAccountName", query = "SELECT e FROM EmployeeViewedAccount e WHERE e.accountName = :accountName"),
        @NamedQuery(name = "EmployeeViewedAccount.findByDateTime", query = "SELECT e FROM EmployeeViewedAccount e WHERE e.dateTime = :dateTime")
    })
public class EmployeeViewedAccount implements Serializable {

    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "versionId")
    private Integer versionId;

    @Column(name = "username")
    private String username;

    @Column(name = "accountName")
    private String accountName;

    @Column(name = "dateTime", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateTime;

    /** Creates a new instance of EmployeeViewedAccount */
    public EmployeeViewedAccount() {
    }

    /**
     * Creates a new instance of EmployeeViewedAccount with the specified values.
     * @param id the id of the EmployeeViewedAccount
     */
    public EmployeeViewedAccount(Integer id) {
        this.id = id;
    }

    /**
     * Creates a new instance of EmployeeViewedAccount with the specified values.
     * @param id the id of the EmployeeViewedAccount
     * @param dateTime the dateTime of the EmployeeViewedAccount
     */
    public EmployeeViewedAccount(Integer id, Date dateTime) {
        this.id = id;
        this.dateTime = dateTime;
    }

    /**
     * Gets the id of this EmployeeViewedAccount.
     * @return the id
     */
    public Integer getId() {
        return this.id;
    }

    /**
     * Sets the id of this EmployeeViewedAccount to the specified value.
     * @param id the new id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Gets the versionId of this EmployeeViewedAccount.
     * @return the versionId
     */
    public Integer getVersionId() {
        return this.versionId;
    }

    /**
     * Sets the versionId of this EmployeeViewedAccount to the specified value.
     * @param versionId the new versionId
     */
    public void setVersionId(Integer versionId) {
        this.versionId = versionId;
    }

    /**
     * Gets the username of this EmployeeViewedAccount.
     * @return the username
     */
    public String getUsername() {
        return this.username;
    }

    /**
     * Sets the username of this EmployeeViewedAccount to the specified value.
     * @param username the new username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Gets the accountName of this EmployeeViewedAccount.
     * @return the accountName
     */
    public String getAccountName() {
        return this.accountName;
    }

    /**
     * Sets the accountName of this EmployeeViewedAccount to the specified value.
     * @param accountName the new accountName
     */
    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    /**
     * Gets the dateTime of this EmployeeViewedAccount.
     * @return the dateTime
     */
    public Date getDateTime() {
        return this.dateTime;
    }

    /**
     * Sets the dateTime of this EmployeeViewedAccount to the specified value.
     * @param dateTime the new dateTime
     */
    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
    }

    /**
     * Returns a hash code value for the object.  This implementation computes 
     * a hash code value based on the id fields in this object.
     * @return a hash code value for this object.
     */
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (this.id != null ? this.id.hashCode() : 0);
        return hash;
    }

    /**
     * Determines whether another object is equal to this EmployeeViewedAccount.  The result is 
     * <code>true</code> if and only if the argument is not null and is a EmployeeViewedAccount object that 
     * has the same id field values as this object.
     * @param object the reference object with which to compare
     * @return <code>true</code> if this object is the same as the argument;
     * <code>false</code> otherwise.
     */
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EmployeeViewedAccount)) {
            return false;
        }
        EmployeeViewedAccount other = (EmployeeViewedAccount)object;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) return false;
        return true;
    }

    /**
     * Returns a string representation of the object.  This implementation constructs 
     * that representation based on the id fields.
     * @return a string representation of the object.
     */
    @Override
    public String toString() {
        return "com.abbt.crm.base.entity.EmployeeViewedAccount[id=" + id + "]";
    }

}
