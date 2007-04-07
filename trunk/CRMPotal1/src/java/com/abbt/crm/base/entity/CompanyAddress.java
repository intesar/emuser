/*
 * CompanyAddress.java
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
 * Entity class CompanyAddress
 * 
 * @author Mohammed Hamed
 */
@Entity
@Table(name = "company_address")
@NamedQueries( {
        @NamedQuery(name = "CompanyAddress.findById", query = "SELECT c FROM CompanyAddress c WHERE c.id = :id"),
        @NamedQuery(name = "CompanyAddress.findByVersionId", query = "SELECT c FROM CompanyAddress c WHERE c.versionId = :versionId"),
        @NamedQuery(name = "CompanyAddress.findByStreet1", query = "SELECT c FROM CompanyAddress c WHERE c.street1 = :street1"),
        @NamedQuery(name = "CompanyAddress.findByCity", query = "SELECT c FROM CompanyAddress c WHERE c.city = :city"),
        @NamedQuery(name = "CompanyAddress.findByState", query = "SELECT c FROM CompanyAddress c WHERE c.state = :state"),
        @NamedQuery(name = "CompanyAddress.findByZipCode", query = "SELECT c FROM CompanyAddress c WHERE c.zipCode = :zipCode"),
        @NamedQuery(name = "CompanyAddress.findByCountry", query = "SELECT c FROM CompanyAddress c WHERE c.country = :country"),
        @NamedQuery(name = "CompanyAddress.findByCreationDate", query = "SELECT c FROM CompanyAddress c WHERE c.creationDate = :creationDate"),
        @NamedQuery(name = "CompanyAddress.findByCreatedUser", query = "SELECT c FROM CompanyAddress c WHERE c.createdUser = :createdUser"),
        @NamedQuery(name = "CompanyAddress.findByLastModifiedDate", query = "SELECT c FROM CompanyAddress c WHERE c.lastModifiedDate = :lastModifiedDate"),
        @NamedQuery(name = "CompanyAddress.findByLastModifiedUser", query = "SELECT c FROM CompanyAddress c WHERE c.lastModifiedUser = :lastModifiedUser"),
        @NamedQuery(name = "CompanyAddress.findByCompanyId", query = "SELECT c FROM CompanyAddress c WHERE c.companyId = :companyId"),
        @NamedQuery(name = "CompanyAddress.findByStreet2", query = "SELECT c FROM CompanyAddress c WHERE c.street2 = :street2"),
        @NamedQuery(name = "CompanyAddress.findByIsDefault", query = "SELECT c FROM CompanyAddress c WHERE c.isDefault = :isDefault")
    })
public class CompanyAddress implements Serializable {

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
    private String zipCode;

    @Column(name = "country", nullable = false)
    private String country;

    @Column(name = "creationDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date creationDate;

    @Column(name = "createdUser", nullable = false)
    private String createdUser;

    @Column(name = "lastModifiedDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModifiedDate;

    @Column(name = "lastModifiedUser", nullable = false)
    private String lastModifiedUser;

    @Column(name = "companyId", nullable = false)
    private int companyId;

    @Column(name = "street2", nullable = false)
    private String street2;

    @Column(name = "isDefault", nullable = false)
    private boolean isDefault;
    
    /** Creates a new instance of CompanyAddress */
    public CompanyAddress() {
    }

    /**
     * Creates a new instance of CompanyAddress with the specified values.
     * @param id the id of the CompanyAddress
     */
    public CompanyAddress(Integer id) {
        this.id = id;
    }

    /**
     * Creates a new instance of CompanyAddress with the specified values.
     * @param id the id of the CompanyAddress
     * @param versionId the versionId of the CompanyAddress
     * @param street1 the street1 of the CompanyAddress
     * @param city the city of the CompanyAddress
     * @param state the state of the CompanyAddress
     * @param zipCode the zipCode of the CompanyAddress
     * @param country the country of the CompanyAddress
     * @param createdUser the createdUser of the CompanyAddress
     * @param lastModifiedUser the lastModifiedUser of the CompanyAddress
     * @param companyId the companyId of the CompanyAddress
     * @param street2 the street2 of the CompanyAddress
     * @param isDefault the isDefault of the CompanyAddress
     */
    public CompanyAddress(Integer id, int versionId, String street1, String city, String state, String zipCode, String country, String createdUser, String lastModifiedUser, int companyId, String street2, boolean isDefault) {
        this.id = id;
        this.versionId = versionId;
        this.street1 = street1;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
        this.country = country;
        this.createdUser = createdUser;
        this.lastModifiedUser = lastModifiedUser;
        this.companyId = companyId;
        this.street2 = street2;
        this.isDefault = isDefault;
    }

    /**
     * Gets the id of this CompanyAddress.
     * @return the id
     */
    public Integer getId() {
        return this.id;
    }

    /**
     * Sets the id of this CompanyAddress to the specified value.
     * @param id the new id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Gets the versionId of this CompanyAddress.
     * @return the versionId
     */
    public int getVersionId() {
        return this.versionId;
    }

    /**
     * Sets the versionId of this CompanyAddress to the specified value.
     * @param versionId the new versionId
     */
    public void setVersionId(int versionId) {
        this.versionId = versionId;
    }

    /**
     * Gets the street1 of this CompanyAddress.
     * @return the street1
     */
    public String getStreet1() {
        return this.street1;
    }

    /**
     * Sets the street1 of this CompanyAddress to the specified value.
     * @param street1 the new street1
     */
    public void setStreet1(String street1) {
        this.street1 = street1;
    }

    /**
     * Gets the city of this CompanyAddress.
     * @return the city
     */
    public String getCity() {
        return this.city;
    }

    /**
     * Sets the city of this CompanyAddress to the specified value.
     * @param city the new city
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * Gets the state of this CompanyAddress.
     * @return the state
     */
    public String getState() {
        return this.state;
    }

    /**
     * Sets the state of this CompanyAddress to the specified value.
     * @param state the new state
     */
    public void setState(String state) {
        this.state = state;
    }

    /**
     * Gets the zipCode of this CompanyAddress.
     * @return the zipCode
     */
    public String getZipCode() {
        return this.zipCode;
    }

    /**
     * Sets the zipCode of this CompanyAddress to the specified value.
     * @param zipCode the new zipCode
     */
    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    /**
     * Gets the country of this CompanyAddress.
     * @return the country
     */
    public String getCountry() {
        return this.country;
    }

    /**
     * Sets the country of this CompanyAddress to the specified value.
     * @param country the new country
     */
    public void setCountry(String country) {
        this.country = country;
    }

    /**
     * Gets the creationDate of this CompanyAddress.
     * @return the creationDate
     */
    public Date getCreationDate() {
        return this.creationDate;
    }

    /**
     * Sets the creationDate of this CompanyAddress to the specified value.
     * @param creationDate the new creationDate
     */
    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    /**
     * Gets the createdUser of this CompanyAddress.
     * @return the createdUser
     */
    public String getCreatedUser() {
        return this.createdUser;
    }

    /**
     * Sets the createdUser of this CompanyAddress to the specified value.
     * @param createdUser the new createdUser
     */
    public void setCreatedUser(String createdUser) {
        this.createdUser = createdUser;
    }

    /**
     * Gets the lastModifiedDate of this CompanyAddress.
     * @return the lastModifiedDate
     */
    public Date getLastModifiedDate() {
        return this.lastModifiedDate;
    }

    /**
     * Sets the lastModifiedDate of this CompanyAddress to the specified value.
     * @param lastModifiedDate the new lastModifiedDate
     */
    public void setLastModifiedDate(Date lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    /**
     * Gets the lastModifiedUser of this CompanyAddress.
     * @return the lastModifiedUser
     */
    public String getLastModifiedUser() {
        return this.lastModifiedUser;
    }

    /**
     * Sets the lastModifiedUser of this CompanyAddress to the specified value.
     * @param lastModifiedUser the new lastModifiedUser
     */
    public void setLastModifiedUser(String lastModifiedUser) {
        this.lastModifiedUser = lastModifiedUser;
    }

    /**
     * Gets the companyId of this CompanyAddress.
     * @return the companyId
     */
    public int getCompanyId() {
        return this.companyId;
    }

    /**
     * Sets the companyId of this CompanyAddress to the specified value.
     * @param companyId the new companyId
     */
    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }

    /**
     * Gets the street2 of this CompanyAddress.
     * @return the street2
     */
    public String getStreet2() {
        return this.street2;
    }

    /**
     * Sets the street2 of this CompanyAddress to the specified value.
     * @param street2 the new street2
     */
    public void setStreet2(String street2) {
        this.street2 = street2;
    }

    /**
     * Gets the isDefault of this CompanyAddress.
     * @return the isDefault
     */
    public boolean getIsDefault() {
        return this.isDefault;
    }

    /**
     * Sets the isDefault of this CompanyAddress to the specified value.
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
     * Determines whether another object is equal to this CompanyAddress.  The result is 
     * <code>true</code> if and only if the argument is not null and is a CompanyAddress object that 
     * has the same id field values as this object.
     * @param object the reference object with which to compare
     * @return <code>true</code> if this object is the same as the argument;
     * <code>false</code> otherwise.
     */
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CompanyAddress)) {
            return false;
        }
        CompanyAddress other = (CompanyAddress)object;
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
        return "com.abbt.crm.base.entity.CompanyAddress[id=" + id + "]";
    }
    
}
