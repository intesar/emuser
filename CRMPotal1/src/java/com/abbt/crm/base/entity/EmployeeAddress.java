/*
 * EmployeeAddress.java
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
 * Entity class EmployeeAddress
 * 
 * @author Mohammed Hamed
 */
@Entity
@Table(name = "employee_address")
@NamedQueries( {
        @NamedQuery(name = "EmployeeAddress.findById", query = "SELECT e FROM EmployeeAddress e WHERE e.id = :id"),
        @NamedQuery(name = "EmployeeAddress.findByVersionId", query = "SELECT e FROM EmployeeAddress e WHERE e.versionId = :versionId"),
        @NamedQuery(name = "EmployeeAddress.findByStreet1", query = "SELECT e FROM EmployeeAddress e WHERE e.street1 = :street1"),
        @NamedQuery(name = "EmployeeAddress.findByCity", query = "SELECT e FROM EmployeeAddress e WHERE e.city = :city"),
        @NamedQuery(name = "EmployeeAddress.findByState", query = "SELECT e FROM EmployeeAddress e WHERE e.state = :state"),
        @NamedQuery(name = "EmployeeAddress.findByZipCode", query = "SELECT e FROM EmployeeAddress e WHERE e.zipCode = :zipCode"),
        @NamedQuery(name = "EmployeeAddress.findByCountry", query = "SELECT e FROM EmployeeAddress e WHERE e.country = :country"),
        @NamedQuery(name = "EmployeeAddress.findByCreationDate", query = "SELECT e FROM EmployeeAddress e WHERE e.creationDate = :creationDate"),
        @NamedQuery(name = "EmployeeAddress.findByCreatedUser", query = "SELECT e FROM EmployeeAddress e WHERE e.createdUser = :createdUser"),
        @NamedQuery(name = "EmployeeAddress.findByLastModifiedDate", query = "SELECT e FROM EmployeeAddress e WHERE e.lastModifiedDate = :lastModifiedDate"),
        @NamedQuery(name = "EmployeeAddress.findByLastModifiedUser", query = "SELECT e FROM EmployeeAddress e WHERE e.lastModifiedUser = :lastModifiedUser"),
        @NamedQuery(name = "EmployeeAddress.findByEmployeeUserName", query = "SELECT e FROM EmployeeAddress e WHERE e.employeeUserName = :employeeUserName"),
        @NamedQuery(name = "EmployeeAddress.findByType", query = "SELECT e FROM EmployeeAddress e WHERE e.type = :type"),
        @NamedQuery(name = "EmployeeAddress.findByIsDefault", query = "SELECT e FROM EmployeeAddress e WHERE e.isDefault = :isDefault"),
        @NamedQuery(name = "EmployeeAddress.findByStreet2", query = "SELECT e FROM EmployeeAddress e WHERE e.street2 = :street2")
    })
public class EmployeeAddress implements Serializable {

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

    @Column(name = "employeeUserName", nullable = false)
    private String employeeUserName;

    @Column(name = "type", nullable = false)
    private String type;

    @Column(name = "isDefault", nullable = false)
    private boolean isDefault;

    @Column(name = "street2", nullable = false)
    private String street2;
    
    /** Creates a new instance of EmployeeAddress */
    public EmployeeAddress() {
    }

    /**
     * Creates a new instance of EmployeeAddress with the specified values.
     * @param id the id of the EmployeeAddress
     */
    public EmployeeAddress(Integer id) {
        this.id = id;
    }

    /**
     * Creates a new instance of EmployeeAddress with the specified values.
     * @param id the id of the EmployeeAddress
     * @param versionId the versionId of the EmployeeAddress
     * @param street1 the street1 of the EmployeeAddress
     * @param city the city of the EmployeeAddress
     * @param state the state of the EmployeeAddress
     * @param zipCode the zipCode of the EmployeeAddress
     * @param country the country of the EmployeeAddress
     * @param createdUser the createdUser of the EmployeeAddress
     * @param lastModifiedUser the lastModifiedUser of the EmployeeAddress
     * @param employeeUserName the employeeUserName of the EmployeeAddress
     * @param type the type of the EmployeeAddress
     * @param isDefault the isDefault of the EmployeeAddress
     * @param street2 the street2 of the EmployeeAddress
     */
    public EmployeeAddress(Integer id, int versionId, String street1, String city, String state, int zipCode, String country, String createdUser, String lastModifiedUser, String employeeUserName, String type, boolean isDefault, String street2) {
        this.id = id;
        this.versionId = versionId;
        this.street1 = street1;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
        this.country = country;
        this.createdUser = createdUser;
        this.lastModifiedUser = lastModifiedUser;
        this.employeeUserName = employeeUserName;
        this.type = type;
        this.isDefault = isDefault;
        this.street2 = street2;
    }

    /**
     * Gets the id of this EmployeeAddress.
     * @return the id
     */
    public Integer getId() {
        return this.id;
    }

    /**
     * Sets the id of this EmployeeAddress to the specified value.
     * @param id the new id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Gets the versionId of this EmployeeAddress.
     * @return the versionId
     */
    public int getVersionId() {
        return this.versionId;
    }

    /**
     * Sets the versionId of this EmployeeAddress to the specified value.
     * @param versionId the new versionId
     */
    public void setVersionId(int versionId) {
        this.versionId = versionId;
    }

    /**
     * Gets the street1 of this EmployeeAddress.
     * @return the street1
     */
    public String getStreet1() {
        return this.street1;
    }

    /**
     * Sets the street1 of this EmployeeAddress to the specified value.
     * @param street1 the new street1
     */
    public void setStreet1(String street1) {
        this.street1 = street1;
    }

    /**
     * Gets the city of this EmployeeAddress.
     * @return the city
     */
    public String getCity() {
        return this.city;
    }

    /**
     * Sets the city of this EmployeeAddress to the specified value.
     * @param city the new city
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * Gets the state of this EmployeeAddress.
     * @return the state
     */
    public String getState() {
        return this.state;
    }

    /**
     * Sets the state of this EmployeeAddress to the specified value.
     * @param state the new state
     */
    public void setState(String state) {
        this.state = state;
    }

    /**
     * Gets the zipCode of this EmployeeAddress.
     * @return the zipCode
     */
    public int getZipCode() {
        return this.zipCode;
    }

    /**
     * Sets the zipCode of this EmployeeAddress to the specified value.
     * @param zipCode the new zipCode
     */
    public void setZipCode(int zipCode) {
        this.zipCode = zipCode;
    }

    /**
     * Gets the country of this EmployeeAddress.
     * @return the country
     */
    public String getCountry() {
        return this.country;
    }

    /**
     * Sets the country of this EmployeeAddress to the specified value.
     * @param country the new country
     */
    public void setCountry(String country) {
        this.country = country;
    }

    /**
     * Gets the creationDate of this EmployeeAddress.
     * @return the creationDate
     */
    public Date getCreationDate() {
        return this.creationDate;
    }

    /**
     * Sets the creationDate of this EmployeeAddress to the specified value.
     * @param creationDate the new creationDate
     */
    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    /**
     * Gets the createdUser of this EmployeeAddress.
     * @return the createdUser
     */
    public String getCreatedUser() {
        return this.createdUser;
    }

    /**
     * Sets the createdUser of this EmployeeAddress to the specified value.
     * @param createdUser the new createdUser
     */
    public void setCreatedUser(String createdUser) {
        this.createdUser = createdUser;
    }

    /**
     * Gets the lastModifiedDate of this EmployeeAddress.
     * @return the lastModifiedDate
     */
    public Date getLastModifiedDate() {
        return this.lastModifiedDate;
    }

    /**
     * Sets the lastModifiedDate of this EmployeeAddress to the specified value.
     * @param lastModifiedDate the new lastModifiedDate
     */
    public void setLastModifiedDate(Date lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    /**
     * Gets the lastModifiedUser of this EmployeeAddress.
     * @return the lastModifiedUser
     */
    public String getLastModifiedUser() {
        return this.lastModifiedUser;
    }

    /**
     * Sets the lastModifiedUser of this EmployeeAddress to the specified value.
     * @param lastModifiedUser the new lastModifiedUser
     */
    public void setLastModifiedUser(String lastModifiedUser) {
        this.lastModifiedUser = lastModifiedUser;
    }

    /**
     * Gets the employeeUserName of this EmployeeAddress.
     * @return the employeeUserName
     */
    public String getEmployeeUserName() {
        return this.employeeUserName;
    }

    /**
     * Sets the employeeUserName of this EmployeeAddress to the specified value.
     * @param employeeUserName the new employeeUserName
     */
    public void setEmployeeUserName(String employeeUserName) {
        this.employeeUserName = employeeUserName;
    }

    /**
     * Gets the type of this EmployeeAddress.
     * @return the type
     */
    public String getType() {
        return this.type;
    }

    /**
     * Sets the type of this EmployeeAddress to the specified value.
     * @param type the new type
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * Gets the isDefault of this EmployeeAddress.
     * @return the isDefault
     */
    public boolean getIsDefault() {
        return this.isDefault;
    }

    /**
     * Sets the isDefault of this EmployeeAddress to the specified value.
     * @param isDefault the new isDefault
     */
    public void setIsDefault(boolean isDefault) {
        this.isDefault = isDefault;
    }

    /**
     * Gets the street2 of this EmployeeAddress.
     * @return the street2
     */
    public String getStreet2() {
        return this.street2;
    }

    /**
     * Sets the street2 of this EmployeeAddress to the specified value.
     * @param street2 the new street2
     */
    public void setStreet2(String street2) {
        this.street2 = street2;
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
     * Determines whether another object is equal to this EmployeeAddress.  The result is 
     * <code>true</code> if and only if the argument is not null and is a EmployeeAddress object that 
     * has the same id field values as this object.
     * @param object the reference object with which to compare
     * @return <code>true</code> if this object is the same as the argument;
     * <code>false</code> otherwise.
     */
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EmployeeAddress)) {
            return false;
        }
        EmployeeAddress other = (EmployeeAddress)object;
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
        return "com.abbt.crm.base.entity.EmployeeAddress[id=" + id + "]";
    }
    
}
