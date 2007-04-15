/*
 * Account.java
 *
 * Created on April 14, 2007, 7:50 PM
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
        @NamedQuery(name = "Account.findByIsEnabled", query = "SELECT a FROM Account a WHERE a.isEnabled = :isEnabled"),
        @NamedQuery(name = "Account.findByPhone1", query = "SELECT a FROM Account a WHERE a.phone1 = :phone1"),
        @NamedQuery(name = "Account.findByPhone2", query = "SELECT a FROM Account a WHERE a.phone2 = :phone2"),
        @NamedQuery(name = "Account.findByPhone3", query = "SELECT a FROM Account a WHERE a.phone3 = :phone3"),
        @NamedQuery(name = "Account.findByPhone4", query = "SELECT a FROM Account a WHERE a.phone4 = :phone4"),
        @NamedQuery(name = "Account.findByFax", query = "SELECT a FROM Account a WHERE a.fax = :fax"),
        @NamedQuery(name = "Account.findByBillingStreet", query = "SELECT a FROM Account a WHERE a.billingStreet = :billingStreet"),
        @NamedQuery(name = "Account.findByBillingCity", query = "SELECT a FROM Account a WHERE a.billingCity = :billingCity"),
        @NamedQuery(name = "Account.findByBillingState", query = "SELECT a FROM Account a WHERE a.billingState = :billingState"),
        @NamedQuery(name = "Account.findByBillingZipcode", query = "SELECT a FROM Account a WHERE a.billingZipcode = :billingZipcode"),
        @NamedQuery(name = "Account.findByBillingCountry", query = "SELECT a FROM Account a WHERE a.billingCountry = :billingCountry"),
        @NamedQuery(name = "Account.findByShippingStreet", query = "SELECT a FROM Account a WHERE a.shippingStreet = :shippingStreet"),
        @NamedQuery(name = "Account.findByShippingCity", query = "SELECT a FROM Account a WHERE a.shippingCity = :shippingCity"),
        @NamedQuery(name = "Account.findByShippingState", query = "SELECT a FROM Account a WHERE a.shippingState = :shippingState"),
        @NamedQuery(name = "Account.findByShippingZipcode", query = "SELECT a FROM Account a WHERE a.shippingZipcode = :shippingZipcode"),
        @NamedQuery(name = "Account.findByShippingCountry", query = "SELECT a FROM Account a WHERE a.shippingCountry = :shippingCountry"),
        @NamedQuery(name = "Account.findByIsShippingSameAsBillingAddress", query = "SELECT a FROM Account a WHERE a.isShippingSameAsBillingAddress = :isShippingSameAsBillingAddress")
    })
public class Account implements Serializable {

    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "versionId")
    private Integer versionId;

    @Column(name = "accountId")
    private Integer accountId;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "website")
    private String website;

    @Column(name = "type")
    private String type;

    @Column(name = "rating")
    private String rating;

    @Column(name = "description")
    private String description;

    @Column(name = "createdUser")
    private String createdUser;

    @Column(name = "creationDate", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date creationDate;

    @Column(name = "lastModifiedDate", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModifiedDate;

    @Column(name = "lastModifiedUser")
    private String lastModifiedUser;

    @Column(name = "isEnabled")
    private Boolean isEnabled;

    @Column(name = "phone1")
    private String phone1;

    @Column(name = "phone2")
    private String phone2;

    @Column(name = "phone3")
    private String phone3;

    @Column(name = "phone4")
    private String phone4;

    @Column(name = "fax")
    private String fax;

    @Column(name = "billingStreet")
    private String billingStreet;

    @Column(name = "billingCity")
    private String billingCity;

    @Column(name = "billingState")
    private String billingState;

    @Column(name = "billingZipcode")
    private String billingZipcode;

    @Column(name = "billingCountry")
    private String billingCountry;

    @Column(name = "shippingStreet")
    private String shippingStreet;

    @Column(name = "shippingCity")
    private String shippingCity;

    @Column(name = "shippingState")
    private String shippingState;

    @Column(name = "shippingZipcode")
    private String shippingZipcode;

    @Column(name = "shippingCountry")
    private String shippingCountry;

    @Column(name = "isShippingSameAsBillingAddress")
    private Short isShippingSameAsBillingAddress;

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
     * @param name the name of the Account
     * @param creationDate the creationDate of the Account
     * @param lastModifiedDate the lastModifiedDate of the Account
     */
    public Account(Integer id, String name, Date creationDate, Date lastModifiedDate) {
        this.id = id;
        this.name = name;
        this.creationDate = creationDate;
        this.lastModifiedDate = lastModifiedDate;
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
    public Integer getVersionId() {
        return this.versionId;
    }

    /**
     * Sets the versionId of this Account to the specified value.
     * @param versionId the new versionId
     */
    public void setVersionId(Integer versionId) {
        this.versionId = versionId;
    }

    /**
     * Gets the accountId of this Account.
     * @return the accountId
     */
    public Integer getAccountId() {
        return this.accountId;
    }

    /**
     * Sets the accountId of this Account to the specified value.
     * @param accountId the new accountId
     */
    public void setAccountId(Integer accountId) {
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
    public Boolean getIsEnabled() {
        return this.isEnabled;
    }

    /**
     * Sets the isEnabled of this Account to the specified value.
     * @param isEnabled the new isEnabled
     */
    public void setIsEnabled(Boolean isEnabled) {
        this.isEnabled = isEnabled;
    }

    /**
     * Gets the phone1 of this Account.
     * @return the phone1
     */
    public String getPhone1() {
        return this.phone1;
    }

    /**
     * Sets the phone1 of this Account to the specified value.
     * @param phone1 the new phone1
     */
    public void setPhone1(String phone1) {
        this.phone1 = phone1;
    }

    /**
     * Gets the phone2 of this Account.
     * @return the phone2
     */
    public String getPhone2() {
        return this.phone2;
    }

    /**
     * Sets the phone2 of this Account to the specified value.
     * @param phone2 the new phone2
     */
    public void setPhone2(String phone2) {
        this.phone2 = phone2;
    }

    /**
     * Gets the phone3 of this Account.
     * @return the phone3
     */
    public String getPhone3() {
        return this.phone3;
    }

    /**
     * Sets the phone3 of this Account to the specified value.
     * @param phone3 the new phone3
     */
    public void setPhone3(String phone3) {
        this.phone3 = phone3;
    }

    /**
     * Gets the phone4 of this Account.
     * @return the phone4
     */
    public String getPhone4() {
        return this.phone4;
    }

    /**
     * Sets the phone4 of this Account to the specified value.
     * @param phone4 the new phone4
     */
    public void setPhone4(String phone4) {
        this.phone4 = phone4;
    }

    /**
     * Gets the fax of this Account.
     * @return the fax
     */
    public String getFax() {
        return this.fax;
    }

    /**
     * Sets the fax of this Account to the specified value.
     * @param fax the new fax
     */
    public void setFax(String fax) {
        this.fax = fax;
    }

    /**
     * Gets the billingStreet of this Account.
     * @return the billingStreet
     */
    public String getBillingStreet() {
        return this.billingStreet;
    }

    /**
     * Sets the billingStreet of this Account to the specified value.
     * @param billingStreet the new billingStreet
     */
    public void setBillingStreet(String billingStreet) {
        this.billingStreet = billingStreet;
    }

    /**
     * Gets the billingCity of this Account.
     * @return the billingCity
     */
    public String getBillingCity() {
        return this.billingCity;
    }

    /**
     * Sets the billingCity of this Account to the specified value.
     * @param billingCity the new billingCity
     */
    public void setBillingCity(String billingCity) {
        this.billingCity = billingCity;
    }

    /**
     * Gets the billingState of this Account.
     * @return the billingState
     */
    public String getBillingState() {
        return this.billingState;
    }

    /**
     * Sets the billingState of this Account to the specified value.
     * @param billingState the new billingState
     */
    public void setBillingState(String billingState) {
        this.billingState = billingState;
    }

    /**
     * Gets the billingZipcode of this Account.
     * @return the billingZipcode
     */
    public String getBillingZipcode() {
        return this.billingZipcode;
    }

    /**
     * Sets the billingZipcode of this Account to the specified value.
     * @param billingZipcode the new billingZipcode
     */
    public void setBillingZipcode(String billingZipcode) {
        this.billingZipcode = billingZipcode;
    }

    /**
     * Gets the billingCountry of this Account.
     * @return the billingCountry
     */
    public String getBillingCountry() {
        return this.billingCountry;
    }

    /**
     * Sets the billingCountry of this Account to the specified value.
     * @param billingCountry the new billingCountry
     */
    public void setBillingCountry(String billingCountry) {
        this.billingCountry = billingCountry;
    }

    /**
     * Gets the shippingStreet of this Account.
     * @return the shippingStreet
     */
    public String getShippingStreet() {
        return this.shippingStreet;
    }

    /**
     * Sets the shippingStreet of this Account to the specified value.
     * @param shippingStreet the new shippingStreet
     */
    public void setShippingStreet(String shippingStreet) {
        this.shippingStreet = shippingStreet;
    }

    /**
     * Gets the shippingCity of this Account.
     * @return the shippingCity
     */
    public String getShippingCity() {
        return this.shippingCity;
    }

    /**
     * Sets the shippingCity of this Account to the specified value.
     * @param shippingCity the new shippingCity
     */
    public void setShippingCity(String shippingCity) {
        this.shippingCity = shippingCity;
    }

    /**
     * Gets the shippingState of this Account.
     * @return the shippingState
     */
    public String getShippingState() {
        return this.shippingState;
    }

    /**
     * Sets the shippingState of this Account to the specified value.
     * @param shippingState the new shippingState
     */
    public void setShippingState(String shippingState) {
        this.shippingState = shippingState;
    }

    /**
     * Gets the shippingZipcode of this Account.
     * @return the shippingZipcode
     */
    public String getShippingZipcode() {
        return this.shippingZipcode;
    }

    /**
     * Sets the shippingZipcode of this Account to the specified value.
     * @param shippingZipcode the new shippingZipcode
     */
    public void setShippingZipcode(String shippingZipcode) {
        this.shippingZipcode = shippingZipcode;
    }

    /**
     * Gets the shippingCountry of this Account.
     * @return the shippingCountry
     */
    public String getShippingCountry() {
        return this.shippingCountry;
    }

    /**
     * Sets the shippingCountry of this Account to the specified value.
     * @param shippingCountry the new shippingCountry
     */
    public void setShippingCountry(String shippingCountry) {
        this.shippingCountry = shippingCountry;
    }

    /**
     * Gets the isShippingSameAsBillingAddress of this Account.
     * @return the isShippingSameAsBillingAddress
     */
    public Short getIsShippingSameAsBillingAddress() {
        return this.isShippingSameAsBillingAddress;
    }

    /**
     * Sets the isShippingSameAsBillingAddress of this Account to the specified value.
     * @param isShippingSameAsBillingAddress the new isShippingSameAsBillingAddress
     */
    public void setIsShippingSameAsBillingAddress(Short isShippingSameAsBillingAddress) {
        this.isShippingSameAsBillingAddress = isShippingSameAsBillingAddress;
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
        return "com.abbt.crm.base.entity.Account[id=" + id + "]";
    }

}
