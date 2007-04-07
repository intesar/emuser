/*
 * AccountPhone.java
 *
 * Created on April 7, 2007, 1:27 PM
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
 * Entity class AccountPhone
 * 
 * @author Mohammed Hamed
 */
@Entity
@Table(name = "account_phone")
@NamedQueries( {
        @NamedQuery(name = "AccountPhone.findById", query = "SELECT a FROM AccountPhone a WHERE a.id = :id"),
        @NamedQuery(name = "AccountPhone.findByVersionId", query = "SELECT a FROM AccountPhone a WHERE a.versionId = :versionId"),
        @NamedQuery(name = "AccountPhone.findByFaxNo", query = "SELECT a FROM AccountPhone a WHERE a.faxNo = :faxNo"),
        @NamedQuery(name = "AccountPhone.findByPhoneNo", query = "SELECT a FROM AccountPhone a WHERE a.phoneNo = :phoneNo"),
        @NamedQuery(name = "AccountPhone.findByAccountId", query = "SELECT a FROM AccountPhone a WHERE a.accountId = :accountId"),
        @NamedQuery(name = "AccountPhone.findByCreationDate", query = "SELECT a FROM AccountPhone a WHERE a.creationDate = :creationDate"),
        @NamedQuery(name = "AccountPhone.findByCreatedUser", query = "SELECT a FROM AccountPhone a WHERE a.createdUser = :createdUser"),
        @NamedQuery(name = "AccountPhone.findByLastModifiedUser", query = "SELECT a FROM AccountPhone a WHERE a.lastModifiedUser = :lastModifiedUser"),
        @NamedQuery(name = "AccountPhone.findByLastModifiedDate", query = "SELECT a FROM AccountPhone a WHERE a.lastModifiedDate = :lastModifiedDate")
    })
public class AccountPhone implements Serializable {

    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "versionId", nullable = false)
    private int versionId;

    @Column(name = "faxNo", nullable = false)
    private int faxNo;

    @Column(name = "phoneNo", nullable = false)
    private String phoneNo;

    @Column(name = "accountId", nullable = false)
    private String accountId;

    @Column(name = "creationDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date creationDate;

    @Column(name = "createdUser", nullable = false)
    private String createdUser;

    @Column(name = "lastModifiedUser", nullable = false)
    private String lastModifiedUser;

    @Column(name = "lastModifiedDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModifiedDate;
    
    /** Creates a new instance of AccountPhone */
    public AccountPhone() {
    }

    /**
     * Creates a new instance of AccountPhone with the specified values.
     * @param id the id of the AccountPhone
     */
    public AccountPhone(Integer id) {
        this.id = id;
    }

    /**
     * Creates a new instance of AccountPhone with the specified values.
     * @param id the id of the AccountPhone
     * @param versionId the versionId of the AccountPhone
     * @param faxNo the faxNo of the AccountPhone
     * @param phoneNo the phoneNo of the AccountPhone
     * @param accountId the accountId of the AccountPhone
     * @param createdUser the createdUser of the AccountPhone
     * @param lastModifiedUser the lastModifiedUser of the AccountPhone
     */
    public AccountPhone(Integer id, int versionId, int faxNo, String phoneNo, String accountId, String createdUser, String lastModifiedUser) {
        this.id = id;
        this.versionId = versionId;
        this.faxNo = faxNo;
        this.phoneNo = phoneNo;
        this.accountId = accountId;
        this.createdUser = createdUser;
        this.lastModifiedUser = lastModifiedUser;
    }

    /**
     * Gets the id of this AccountPhone.
     * @return the id
     */
    public Integer getId() {
        return this.id;
    }

    /**
     * Sets the id of this AccountPhone to the specified value.
     * @param id the new id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Gets the versionId of this AccountPhone.
     * @return the versionId
     */
    public int getVersionId() {
        return this.versionId;
    }

    /**
     * Sets the versionId of this AccountPhone to the specified value.
     * @param versionId the new versionId
     */
    public void setVersionId(int versionId) {
        this.versionId = versionId;
    }

    /**
     * Gets the faxNo of this AccountPhone.
     * @return the faxNo
     */
    public int getFaxNo() {
        return this.faxNo;
    }

    /**
     * Sets the faxNo of this AccountPhone to the specified value.
     * @param faxNo the new faxNo
     */
    public void setFaxNo(int faxNo) {
        this.faxNo = faxNo;
    }

    /**
     * Gets the phoneNo of this AccountPhone.
     * @return the phoneNo
     */
    public String getPhoneNo() {
        return this.phoneNo;
    }

    /**
     * Sets the phoneNo of this AccountPhone to the specified value.
     * @param phoneNo the new phoneNo
     */
    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    /**
     * Gets the accountId of this AccountPhone.
     * @return the accountId
     */
    public String getAccountId() {
        return this.accountId;
    }

    /**
     * Sets the accountId of this AccountPhone to the specified value.
     * @param accountId the new accountId
     */
    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    /**
     * Gets the creationDate of this AccountPhone.
     * @return the creationDate
     */
    public Date getCreationDate() {
        return this.creationDate;
    }

    /**
     * Sets the creationDate of this AccountPhone to the specified value.
     * @param creationDate the new creationDate
     */
    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    /**
     * Gets the createdUser of this AccountPhone.
     * @return the createdUser
     */
    public String getCreatedUser() {
        return this.createdUser;
    }

    /**
     * Sets the createdUser of this AccountPhone to the specified value.
     * @param createdUser the new createdUser
     */
    public void setCreatedUser(String createdUser) {
        this.createdUser = createdUser;
    }

    /**
     * Gets the lastModifiedUser of this AccountPhone.
     * @return the lastModifiedUser
     */
    public String getLastModifiedUser() {
        return this.lastModifiedUser;
    }

    /**
     * Sets the lastModifiedUser of this AccountPhone to the specified value.
     * @param lastModifiedUser the new lastModifiedUser
     */
    public void setLastModifiedUser(String lastModifiedUser) {
        this.lastModifiedUser = lastModifiedUser;
    }

    /**
     * Gets the lastModifiedDate of this AccountPhone.
     * @return the lastModifiedDate
     */
    public Date getLastModifiedDate() {
        return this.lastModifiedDate;
    }

    /**
     * Sets the lastModifiedDate of this AccountPhone to the specified value.
     * @param lastModifiedDate the new lastModifiedDate
     */
    public void setLastModifiedDate(Date lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
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
     * Determines whether another object is equal to this AccountPhone.  The result is 
     * <code>true</code> if and only if the argument is not null and is a AccountPhone object that 
     * has the same id field values as this object.
     * @param object the reference object with which to compare
     * @return <code>true</code> if this object is the same as the argument;
     * <code>false</code> otherwise.
     */
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AccountPhone)) {
            return false;
        }
        AccountPhone other = (AccountPhone)object;
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
        return "com.abbt.crm.base.entity.AccountPhone[id=" + id + "]";
    }
    
}
