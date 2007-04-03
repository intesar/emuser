/*
 * AccountAddress.java
 *
 * Created on April 2, 2007, 10:11 PM
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
 * Entity class AccountAddress
 * 
 * @author shannan
 */
@Entity
@Table(name = "account_address")
@NamedQueries( {
        @NamedQuery(name = "AccountAddress.findById", query = "SELECT a FROM AccountAddress a WHERE a.id = :id"),
        @NamedQuery(name = "AccountAddress.findByVersionId", query = "SELECT a FROM AccountAddress a WHERE a.versionId = :versionId"),
        @NamedQuery(name = "AccountAddress.findByStreet1", query = "SELECT a FROM AccountAddress a WHERE a.street1 = :street1"),
        @NamedQuery(name = "AccountAddress.findByCity", query = "SELECT a FROM AccountAddress a WHERE a.city = :city"),
        @NamedQuery(name = "AccountAddress.findByState", query = "SELECT a FROM AccountAddress a WHERE a.state = :state"),
        @NamedQuery(name = "AccountAddress.findByZipCode", query = "SELECT a FROM AccountAddress a WHERE a.zipCode = :zipCode"),
        @NamedQuery(name = "AccountAddress.findByCountry", query = "SELECT a FROM AccountAddress a WHERE a.country = :country"),
        @NamedQuery(name = "AccountAddress.findByCreationDate", query = "SELECT a FROM AccountAddress a WHERE a.creationDate = :creationDate"),
        @NamedQuery(name = "AccountAddress.findByCreatedUser", query = "SELECT a FROM AccountAddress a WHERE a.createdUser = :createdUser"),
        @NamedQuery(name = "AccountAddress.findByLastModifiedDate", query = "SELECT a FROM AccountAddress a WHERE a.lastModifiedDate = :lastModifiedDate"),
        @NamedQuery(name = "AccountAddress.findByLastModifiedUser", query = "SELECT a FROM AccountAddress a WHERE a.lastModifiedUser = :lastModifiedUser"),
        @NamedQuery(name = "AccountAddress.findByAccountId", query = "SELECT a FROM AccountAddress a WHERE a.accountId = :accountId"),
        @NamedQuery(name = "AccountAddress.findByStreet2", query = "SELECT a FROM AccountAddress a WHERE a.street2 = :street2"),
        @NamedQuery(name = "AccountAddress.findByIsDefault", query = "SELECT a FROM AccountAddress a WHERE a.isDefault = :isDefault")
    })
public class AccountAddress implements Serializable {

    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "versionId", nullable = false)
    private int versionId;

    @Column(name = "street1", nullable = false)
    private String street1;

    @Column(name = "city", nullable = false)
    private String city;

    @Column(name = "state", nullable = false)
    private String state;

    @Column(name = "zipCode", nullable = false)
    private int zipCode;

    @Column(name = "country", nullable = false)
    private String country;

    @Column(name = "creationDate", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date creationDate;

    @Column(name = "createdUser", nullable = false)
    private String createdUser;

    @Column(name = "lastModifiedDate", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModifiedDate;

    @Column(name = "lastModifiedUser", nullable = false)
    private String lastModifiedUser;

    @Column(name = "accountId", nullable = false)
    private int accountId;

    @Column(name = "street2", nullable = false)
    private String street2;

    @Column(name = "isDefault", nullable = false)
    private boolean isDefault;

    /** Creates a new instance of AccountAddress */
    public AccountAddress() {
    }

    /**
     * Creates a new instance of AccountAddress with the specified values.
     * @param id the id of the AccountAddress
     */
    public AccountAddress(Integer id) {
        this.id = id;
    }

    /**
     * Creates a new instance of AccountAddress with the specified values.
     * @param id the id of the AccountAddress
     * @param versionId the versionId of the AccountAddress
     * @param street1 the street1 of the AccountAddress
     * @param city the city of the AccountAddress
     * @param state the state of the AccountAddress
     * @param zipCode the zipCode of the AccountAddress
     * @param country the country of the AccountAddress
     * @param creationDate the creationDate of the AccountAddress
     * @param createdUser the createdUser of the AccountAddress
     * @param lastModifiedDate the lastModifiedDate of the AccountAddress
     * @param lastModifiedUser the lastModifiedUser of the AccountAddress
     * @param accountId the accountId of the AccountAddress
     * @param street2 the street2 of the AccountAddress
     * @param isDefault the isDefault of the AccountAddress
     */
    public AccountAddress(Integer id, int versionId, String street1, String city, String state, int zipCode, String country, Date creationDate, String createdUser, Date lastModifiedDate, String lastModifiedUser, int accountId, String street2, boolean isDefault) {
        this.id = id;
        this.versionId = versionId;
        this.street1 = street1;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
        this.country = country;
        this.creationDate = creationDate;
        this.createdUser = createdUser;
        this.lastModifiedDate = lastModifiedDate;
        this.lastModifiedUser = lastModifiedUser;
        this.accountId = accountId;
        this.street2 = street2;
        this.isDefault = isDefault;
    }

    /**
     * Gets the id of this AccountAddress.
     * @return the id
     */
    public Integer getId() {
        return this.id;
    }

    /**
     * Sets the id of this AccountAddress to the specified value.
     * @param id the new id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Gets the versionId of this AccountAddress.
     * @return the versionId
     */
    public int getVersionId() {
        return this.versionId;
    }

    /**
     * Sets the versionId of this AccountAddress to the specified value.
     * @param versionId the new versionId
     */
    public void setVersionId(int versionId) {
        this.versionId = versionId;
    }

    /**
     * Gets the street1 of this AccountAddress.
     * @return the street1
     */
    public String getStreet1() {
        return this.street1;
    }

    /**
     * Sets the street1 of this AccountAddress to the specified value.
     * @param street1 the new street1
     */
    public void setStreet1(String street1) {
        this.street1 = street1;
    }

    /**
     * Gets the city of this AccountAddress.
     * @return the city
     */
    public String getCity() {
        return this.city;
    }

    /**
     * Sets the city of this AccountAddress to the specified value.
     * @param city the new city
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * Gets the state of this AccountAddress.
     * @return the state
     */
    public String getState() {
        return this.state;
    }

    /**
     * Sets the state of this AccountAddress to the specified value.
     * @param state the new state
     */
    public void setState(String state) {
        this.state = state;
    }

    /**
     * Gets the zipCode of this AccountAddress.
     * @return the zipCode
     */
    public int getZipCode() {
        return this.zipCode;
    }

    /**
     * Sets the zipCode of this AccountAddress to the specified value.
     * @param zipCode the new zipCode
     */
    public void setZipCode(int zipCode) {
        this.zipCode = zipCode;
    }

    /**
     * Gets the country of this AccountAddress.
     * @return the country
     */
    public String getCountry() {
        return this.country;
    }

    /**
     * Sets the country of this AccountAddress to the specified value.
     * @param country the new country
     */
    public void setCountry(String country) {
        this.country = country;
    }

    /**
     * Gets the creationDate of this AccountAddress.
     * @return the creationDate
     */
    public Date getCreationDate() {
        return this.creationDate;
    }

    /**
     * Sets the creationDate of this AccountAddress to the specified value.
     * @param creationDate the new creationDate
     */
    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    /**
     * Gets the createdUser of this AccountAddress.
     * @return the createdUser
     */
    public String getCreatedUser() {
        return this.createdUser;
    }

    /**
     * Sets the createdUser of this AccountAddress to the specified value.
     * @param createdUser the new createdUser
     */
    public void setCreatedUser(String createdUser) {
        this.createdUser = createdUser;
    }

    /**
     * Gets the lastModifiedDate of this AccountAddress.
     * @return the lastModifiedDate
     */
    public Date getLastModifiedDate() {
        return this.lastModifiedDate;
    }

    /**
     * Sets the lastModifiedDate of this AccountAddress to the specified value.
     * @param lastModifiedDate the new lastModifiedDate
     */
    public void setLastModifiedDate(Date lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    /**
     * Gets the lastModifiedUser of this AccountAddress.
     * @return the lastModifiedUser
     */
    public String getLastModifiedUser() {
        return this.lastModifiedUser;
    }

    /**
     * Sets the lastModifiedUser of this AccountAddress to the specified value.
     * @param lastModifiedUser the new lastModifiedUser
     */
    public void setLastModifiedUser(String lastModifiedUser) {
        this.lastModifiedUser = lastModifiedUser;
    }

    /**
     * Gets the accountId of this AccountAddress.
     * @return the accountId
     */
    public int getAccountId() {
        return this.accountId;
    }

    /**
     * Sets the accountId of this AccountAddress to the specified value.
     * @param accountId the new accountId
     */
    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    /**
     * Gets the street2 of this AccountAddress.
     * @return the street2
     */
    public String getStreet2() {
        return this.street2;
    }

    /**
     * Sets the street2 of this AccountAddress to the specified value.
     * @param street2 the new street2
     */
    public void setStreet2(String street2) {
        this.street2 = street2;
    }

    /**
     * Gets the isDefault of this AccountAddress.
     * @return the isDefault
     */
    public boolean getIsDefault() {
        return this.isDefault;
    }

    /**
     * Sets the isDefault of this AccountAddress to the specified value.
     * @param isDefault the new isDefault
     */
    public void setIsDefault(boolean isDefault) {
        this.isDefault = isDefault;
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
     * Determines whether another object is equal to this AccountAddress.  The result is 
     * <code>true</code> if and only if the argument is not null and is a AccountAddress object that 
     * has the same id field values as this object.
     * @param object the reference object with which to compare
     * @return <code>true</code> if this object is the same as the argument;
     * <code>false</code> otherwise.
     */
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AccountAddress)) {
            return false;
        }
        AccountAddress other = (AccountAddress)object;
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
        return "com.abbt.crm.base.entity.AccountAddress[id=" + id + "]";
    }

}
