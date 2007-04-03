/*
 * LeadAddress.java
 *
 * Created on April 2, 2007, 8:50 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package com.abbt.crm.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * Entity class LeadAddress
 * 
 * @author shannan
 */
@Entity
@Table(name = "lead_address")
@NamedQueries( {
        @NamedQuery(name = "LeadAddress.findById", query = "SELECT l FROM LeadAddress l WHERE l.id = :id"),
        @NamedQuery(name = "LeadAddress.findByVersionId", query = "SELECT l FROM LeadAddress l WHERE l.versionId = :versionId"),
        @NamedQuery(name = "LeadAddress.findByStreet1", query = "SELECT l FROM LeadAddress l WHERE l.street1 = :street1"),
        @NamedQuery(name = "LeadAddress.findByCity", query = "SELECT l FROM LeadAddress l WHERE l.city = :city"),
        @NamedQuery(name = "LeadAddress.findByState", query = "SELECT l FROM LeadAddress l WHERE l.state = :state"),
        @NamedQuery(name = "LeadAddress.findByZipCode", query = "SELECT l FROM LeadAddress l WHERE l.zipCode = :zipCode"),
        @NamedQuery(name = "LeadAddress.findByCountry", query = "SELECT l FROM LeadAddress l WHERE l.country = :country"),
        @NamedQuery(name = "LeadAddress.findByCreatedUser", query = "SELECT l FROM LeadAddress l WHERE l.createdUser = :createdUser"),
        @NamedQuery(name = "LeadAddress.findByLastModifiedDate", query = "SELECT l FROM LeadAddress l WHERE l.lastModifiedDate = :lastModifiedDate"),
        @NamedQuery(name = "LeadAddress.findByLastModifiedUser", query = "SELECT l FROM LeadAddress l WHERE l.lastModifiedUser = :lastModifiedUser"),
        @NamedQuery(name = "LeadAddress.findByLeadId", query = "SELECT l FROM LeadAddress l WHERE l.leadId = :leadId"),
        @NamedQuery(name = "LeadAddress.findByStreet2", query = "SELECT l FROM LeadAddress l WHERE l.street2 = :street2"),
        @NamedQuery(name = "LeadAddress.findByIsDefault", query = "SELECT l FROM LeadAddress l WHERE l.isDefault = :isDefault")
    })
public class LeadAddress implements Serializable {

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

    @Column(name = "createdUser", nullable = false)
    private String createdUser;

    @Column(name = "lastModifiedDate", nullable = false)
    private String lastModifiedDate;

    @Column(name = "lastModifiedUser", nullable = false)
    private String lastModifiedUser;

    @Column(name = "leadId", nullable = false)
    private int leadId;

    @Column(name = "street2", nullable = false)
    private String street2;

    @Column(name = "isDefault", nullable = false)
    private boolean isDefault;

    /** Creates a new instance of LeadAddress */
    public LeadAddress() {
    }

    /**
     * Creates a new instance of LeadAddress with the specified values.
     * @param id the id of the LeadAddress
     */
    public LeadAddress(Integer id) {
        this.id = id;
    }

    /**
     * Creates a new instance of LeadAddress with the specified values.
     * @param id the id of the LeadAddress
     * @param versionId the versionId of the LeadAddress
     * @param street1 the street1 of the LeadAddress
     * @param city the city of the LeadAddress
     * @param state the state of the LeadAddress
     * @param zipCode the zipCode of the LeadAddress
     * @param country the country of the LeadAddress
     * @param createdUser the createdUser of the LeadAddress
     * @param lastModifiedDate the lastModifiedDate of the LeadAddress
     * @param lastModifiedUser the lastModifiedUser of the LeadAddress
     * @param leadId the leadId of the LeadAddress
     * @param street2 the street2 of the LeadAddress
     * @param isDefault the isDefault of the LeadAddress
     */
    public LeadAddress(Integer id, int versionId, String street1, String city, String state, String zipCode, String country, String createdUser, String lastModifiedDate, String lastModifiedUser, int leadId, String street2, boolean isDefault) {
        this.id = id;
        this.versionId = versionId;
        this.street1 = street1;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
        this.country = country;
        this.createdUser = createdUser;
        this.lastModifiedDate = lastModifiedDate;
        this.lastModifiedUser = lastModifiedUser;
        this.leadId = leadId;
        this.street2 = street2;
        this.isDefault = isDefault;
    }

    /**
     * Gets the id of this LeadAddress.
     * @return the id
     */
    public Integer getId() {
        return this.id;
    }

    /**
     * Sets the id of this LeadAddress to the specified value.
     * @param id the new id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Gets the versionId of this LeadAddress.
     * @return the versionId
     */
    public int getVersionId() {
        return this.versionId;
    }

    /**
     * Sets the versionId of this LeadAddress to the specified value.
     * @param versionId the new versionId
     */
    public void setVersionId(int versionId) {
        this.versionId = versionId;
    }

    /**
     * Gets the street1 of this LeadAddress.
     * @return the street1
     */
    public String getStreet1() {
        return this.street1;
    }

    /**
     * Sets the street1 of this LeadAddress to the specified value.
     * @param street1 the new street1
     */
    public void setStreet1(String street1) {
        this.street1 = street1;
    }

    /**
     * Gets the city of this LeadAddress.
     * @return the city
     */
    public String getCity() {
        return this.city;
    }

    /**
     * Sets the city of this LeadAddress to the specified value.
     * @param city the new city
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * Gets the state of this LeadAddress.
     * @return the state
     */
    public String getState() {
        return this.state;
    }

    /**
     * Sets the state of this LeadAddress to the specified value.
     * @param state the new state
     */
    public void setState(String state) {
        this.state = state;
    }

    /**
     * Gets the zipCode of this LeadAddress.
     * @return the zipCode
     */
    public String getZipCode() {
        return this.zipCode;
    }

    /**
     * Sets the zipCode of this LeadAddress to the specified value.
     * @param zipCode the new zipCode
     */
    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    /**
     * Gets the country of this LeadAddress.
     * @return the country
     */
    public String getCountry() {
        return this.country;
    }

    /**
     * Sets the country of this LeadAddress to the specified value.
     * @param country the new country
     */
    public void setCountry(String country) {
        this.country = country;
    }

    /**
     * Gets the createdUser of this LeadAddress.
     * @return the createdUser
     */
    public String getCreatedUser() {
        return this.createdUser;
    }

    /**
     * Sets the createdUser of this LeadAddress to the specified value.
     * @param createdUser the new createdUser
     */
    public void setCreatedUser(String createdUser) {
        this.createdUser = createdUser;
    }

    /**
     * Gets the lastModifiedDate of this LeadAddress.
     * @return the lastModifiedDate
     */
    public String getLastModifiedDate() {
        return this.lastModifiedDate;
    }

    /**
     * Sets the lastModifiedDate of this LeadAddress to the specified value.
     * @param lastModifiedDate the new lastModifiedDate
     */
    public void setLastModifiedDate(String lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    /**
     * Gets the lastModifiedUser of this LeadAddress.
     * @return the lastModifiedUser
     */
    public String getLastModifiedUser() {
        return this.lastModifiedUser;
    }

    /**
     * Sets the lastModifiedUser of this LeadAddress to the specified value.
     * @param lastModifiedUser the new lastModifiedUser
     */
    public void setLastModifiedUser(String lastModifiedUser) {
        this.lastModifiedUser = lastModifiedUser;
    }

    /**
     * Gets the leadId of this LeadAddress.
     * @return the leadId
     */
    public int getLeadId() {
        return this.leadId;
    }

    /**
     * Sets the leadId of this LeadAddress to the specified value.
     * @param leadId the new leadId
     */
    public void setLeadId(int leadId) {
        this.leadId = leadId;
    }

    /**
     * Gets the street2 of this LeadAddress.
     * @return the street2
     */
    public String getStreet2() {
        return this.street2;
    }

    /**
     * Sets the street2 of this LeadAddress to the specified value.
     * @param street2 the new street2
     */
    public void setStreet2(String street2) {
        this.street2 = street2;
    }

    /**
     * Gets the isDefault of this LeadAddress.
     * @return the isDefault
     */
    public boolean getIsDefault() {
        return this.isDefault;
    }

    /**
     * Sets the isDefault of this LeadAddress to the specified value.
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
     * Determines whether another object is equal to this LeadAddress.  The result is 
     * <code>true</code> if and only if the argument is not null and is a LeadAddress object that 
     * has the same id field values as this object.
     * @param object the reference object with which to compare
     * @return <code>true</code> if this object is the same as the argument;
     * <code>false</code> otherwise.
     */
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LeadAddress)) {
            return false;
        }
        LeadAddress other = (LeadAddress)object;
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
        return "com.abbt.crm.entity.LeadAddress[id=" + id + "]";
    }

}
