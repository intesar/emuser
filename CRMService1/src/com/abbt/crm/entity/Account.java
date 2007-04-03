/*
 * Account.java
 *
 * Created on April 2, 2007, 8:50 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package com.abbt.crm.entity;

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
 * Entity class Account
 * 
 * @author shannan
 */
@Entity
@Table(name = "account")
@NamedQueries( {
        @NamedQuery(name = "Account.findById", query = "SELECT a FROM Account a WHERE a.id = :id"),
        @NamedQuery(name = "Account.findByVersionId", query = "SELECT a FROM Account a WHERE a.versionId = :versionId"),
        @NamedQuery(name = "Account.findByAccountId", query = "SELECT a FROM Account a WHERE a.accountId = :accountId"),
        @NamedQuery(name = "Account.findByName", query = "SELECT a FROM Account a WHERE a.name = :name"),
        @NamedQuery(name = "Account.findByWebsite", query = "SELECT a FROM Account a WHERE a.website = :website"),
        @NamedQuery(name = "Account.findByType", query = "SELECT a FROM Account a WHERE a.type = :type"),
        @NamedQuery(name = "Account.findByRating", query = "SELECT a FROM Account a WHERE a.rating = :rating"),
        @NamedQuery(name = "Account.findByDescription", query = "SELECT a FROM Account a WHERE a.description = :description"),
        @NamedQuery(name = "Account.findByCreatedUser", query = "SELECT a FROM Account a WHERE a.createdUser = :createdUser"),
        @NamedQuery(name = "Account.findByCreationDate", query = "SELECT a FROM Account a WHERE a.creationDate = :creationDate"),
        @NamedQuery(name = "Account.findByLastModifiedDate", query = "SELECT a FROM Account a WHERE a.lastModifiedDate = :lastModifiedDate"),
        @NamedQuery(name = "Account.findByLastModifiedUser", query = "SELECT a FROM Account a WHERE a.lastModifiedUser = :lastModifiedUser"),
        @NamedQuery(name = "Account.findByIsEnabled", query = "SELECT a FROM Account a WHERE a.isEnabled = :isEnabled")
    })
public class Account implements Serializable {

    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "versionId", nullable = false)
    private int versionId;

    @Column(name = "accountId", nullable = false)
    private int accountId;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "website", nullable = false)
    private String website;

    @Column(name = "type", nullable = false)
    private String type;

    @Column(name = "rating", nullable = false)
    private String rating;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "createdUser", nullable = false)
    private String createdUser;

    @Column(name = "creationDate", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date creationDate;

    @Column(name = "lastModifiedDate", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModifiedDate;

    @Column(name = "lastModifiedUser", nullable = false)
    private String lastModifiedUser;

    @Column(name = "isEnabled", nullable = false)
    private boolean isEnabled;

    /** Creates a new instance of Account */
    public Account() {
    }

    /**
     * Creates a new instance of Account with the specified values.
     * @param id the id of the Account
     */
    public Account(Integer id) {
        this.id = id;
    }

    /**
     * Creates a new instance of Account with the specified values.
     * @param id the id of the Account
     * @param versionId the versionId of the Account
     * @param accountId the accountId of the Account
     * @param name the name of the Account
     * @param website the website of the Account
     * @param type the type of the Account
     * @param rating the rating of the Account
     * @param description the description of the Account
     * @param createdUser the createdUser of the Account
     * @param creationDate the creationDate of the Account
     * @param lastModifiedDate the lastModifiedDate of the Account
     * @param lastModifiedUser the lastModifiedUser of the Account
     * @param isEnabled the isEnabled of the Account
     */
    public Account(Integer id, int versionId, int accountId, String name, String website, String type, String rating, String description, String createdUser, Date creationDate, Date lastModifiedDate, String lastModifiedUser, boolean isEnabled) {
        this.id = id;
        this.versionId = versionId;
        this.accountId = accountId;
        this.name = name;
        this.website = website;
        this.type = type;
        this.rating = rating;
        this.description = description;
        this.createdUser = createdUser;
        this.creationDate = creationDate;
        this.lastModifiedDate = lastModifiedDate;
        this.lastModifiedUser = lastModifiedUser;
        this.isEnabled = isEnabled;
    }

    /**
     * Gets the id of this Account.
     * @return the id
     */
    public Integer getId() {
        return this.id;
    }

    /**
     * Sets the id of this Account to the specified value.
     * @param id the new id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Gets the versionId of this Account.
     * @return the versionId
     */
    public int getVersionId() {
        return this.versionId;
    }

    /**
     * Sets the versionId of this Account to the specified value.
     * @param versionId the new versionId
     */
    public void setVersionId(int versionId) {
        this.versionId = versionId;
    }

    /**
     * Gets the accountId of this Account.
     * @return the accountId
     */
    public int getAccountId() {
        return this.accountId;
    }

    /**
     * Sets the accountId of this Account to the specified value.
     * @param accountId the new accountId
     */
    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    /**
     * Gets the name of this Account.
     * @return the name
     */
    public String getName() {
        return this.name;
    }

    /**
     * Sets the name of this Account to the specified value.
     * @param name the new name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the website of this Account.
     * @return the website
     */
    public String getWebsite() {
        return this.website;
    }

    /**
     * Sets the website of this Account to the specified value.
     * @param website the new website
     */
    public void setWebsite(String website) {
        this.website = website;
    }

    /**
     * Gets the type of this Account.
     * @return the type
     */
    public String getType() {
        return this.type;
    }

    /**
     * Sets the type of this Account to the specified value.
     * @param type the new type
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * Gets the rating of this Account.
     * @return the rating
     */
    public String getRating() {
        return this.rating;
    }

    /**
     * Sets the rating of this Account to the specified value.
     * @param rating the new rating
     */
    public void setRating(String rating) {
        this.rating = rating;
    }

    /**
     * Gets the description of this Account.
     * @return the description
     */
    public String getDescription() {
        return this.description;
    }

    /**
     * Sets the description of this Account to the specified value.
     * @param description the new description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Gets the createdUser of this Account.
     * @return the createdUser
     */
    public String getCreatedUser() {
        return this.createdUser;
    }

    /**
     * Sets the createdUser of this Account to the specified value.
     * @param createdUser the new createdUser
     */
    public void setCreatedUser(String createdUser) {
        this.createdUser = createdUser;
    }

    /**
     * Gets the creationDate of this Account.
     * @return the creationDate
     */
    public Date getCreationDate() {
        return this.creationDate;
    }

    /**
     * Sets the creationDate of this Account to the specified value.
     * @param creationDate the new creationDate
     */
    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    /**
     * Gets the lastModifiedDate of this Account.
     * @return the lastModifiedDate
     */
    public Date getLastModifiedDate() {
        return this.lastModifiedDate;
    }

    /**
     * Sets the lastModifiedDate of this Account to the specified value.
     * @param lastModifiedDate the new lastModifiedDate
     */
    public void setLastModifiedDate(Date lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    /**
     * Gets the lastModifiedUser of this Account.
     * @return the lastModifiedUser
     */
    public String getLastModifiedUser() {
        return this.lastModifiedUser;
    }

    /**
     * Sets the lastModifiedUser of this Account to the specified value.
     * @param lastModifiedUser the new lastModifiedUser
     */
    public void setLastModifiedUser(String lastModifiedUser) {
        this.lastModifiedUser = lastModifiedUser;
    }

    /**
     * Gets the isEnabled of this Account.
     * @return the isEnabled
     */
    public boolean getIsEnabled() {
        return this.isEnabled;
    }

    /**
     * Sets the isEnabled of this Account to the specified value.
     * @param isEnabled the new isEnabled
     */
    public void setIsEnabled(boolean isEnabled) {
        this.isEnabled = isEnabled;
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
     * Determines whether another object is equal to this Account.  The result is 
     * <code>true</code> if and only if the argument is not null and is a Account object that 
     * has the same id field values as this object.
     * @param object the reference object with which to compare
     * @return <code>true</code> if this object is the same as the argument;
     * <code>false</code> otherwise.
     */
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Account)) {
            return false;
        }
        Account other = (Account)object;
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
        return "com.abbt.crm.entity.Account[id=" + id + "]";
    }

}
