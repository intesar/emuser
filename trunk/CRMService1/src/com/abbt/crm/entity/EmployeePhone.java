/*
 * EmployeePhone.java
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
 * Entity class EmployeePhone
 * 
 * @author shannan
 */
@Entity
@Table(name = "employee_phone")
@NamedQueries( {
        @NamedQuery(name = "EmployeePhone.findById", query = "SELECT e FROM EmployeePhone e WHERE e.id = :id"),
        @NamedQuery(name = "EmployeePhone.findByVersionId", query = "SELECT e FROM EmployeePhone e WHERE e.versionId = :versionId"),
        @NamedQuery(name = "EmployeePhone.findByPhoneNo", query = "SELECT e FROM EmployeePhone e WHERE e.phoneNo = :phoneNo"),
        @NamedQuery(name = "EmployeePhone.findByEmployeeUserName", query = "SELECT e FROM EmployeePhone e WHERE e.employeeUserName = :employeeUserName"),
        @NamedQuery(name = "EmployeePhone.findByCreationDate", query = "SELECT e FROM EmployeePhone e WHERE e.creationDate = :creationDate"),
        @NamedQuery(name = "EmployeePhone.findByCreationUser", query = "SELECT e FROM EmployeePhone e WHERE e.creationUser = :creationUser"),
        @NamedQuery(name = "EmployeePhone.findByLastModifiedDate", query = "SELECT e FROM EmployeePhone e WHERE e.lastModifiedDate = :lastModifiedDate"),
        @NamedQuery(name = "EmployeePhone.findByLastModifiedUser", query = "SELECT e FROM EmployeePhone e WHERE e.lastModifiedUser = :lastModifiedUser"),
        @NamedQuery(name = "EmployeePhone.findByType", query = "SELECT e FROM EmployeePhone e WHERE e.type = :type"),
        @NamedQuery(name = "EmployeePhone.findByIsEnabled", query = "SELECT e FROM EmployeePhone e WHERE e.isEnabled = :isEnabled"),
        @NamedQuery(name = "EmployeePhone.findByIsDefault", query = "SELECT e FROM EmployeePhone e WHERE e.isDefault = :isDefault")
    })
public class EmployeePhone implements Serializable {

    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "versionId", nullable = false)
    private int versionId;

    @Column(name = "phoneNo", nullable = false)
    private String phoneNo;

    @Column(name = "employeeUserName", nullable = false)
    private String employeeUserName;

    @Column(name = "creationDate", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date creationDate;

    @Column(name = "creationUser", nullable = false)
    private String creationUser;

    @Column(name = "lastModifiedDate", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModifiedDate;

    @Column(name = "lastModifiedUser", nullable = false)
    private String lastModifiedUser;

    @Column(name = "type", nullable = false)
    private String type;

    @Column(name = "isEnabled", nullable = false)
    private boolean isEnabled;

    @Column(name = "isDefault", nullable = false)
    private boolean isDefault;

    /** Creates a new instance of EmployeePhone */
    public EmployeePhone() {
    }

    /**
     * Creates a new instance of EmployeePhone with the specified values.
     * @param id the id of the EmployeePhone
     */
    public EmployeePhone(Integer id) {
        this.id = id;
    }

    /**
     * Creates a new instance of EmployeePhone with the specified values.
     * @param id the id of the EmployeePhone
     * @param versionId the versionId of the EmployeePhone
     * @param phoneNo the phoneNo of the EmployeePhone
     * @param employeeUserName the employeeUserName of the EmployeePhone
     * @param creationDate the creationDate of the EmployeePhone
     * @param creationUser the creationUser of the EmployeePhone
     * @param lastModifiedDate the lastModifiedDate of the EmployeePhone
     * @param lastModifiedUser the lastModifiedUser of the EmployeePhone
     * @param type the type of the EmployeePhone
     * @param isEnabled the isEnabled of the EmployeePhone
     * @param isDefault the isDefault of the EmployeePhone
     */
    public EmployeePhone(Integer id, int versionId, String phoneNo, String employeeUserName, Date creationDate, String creationUser, Date lastModifiedDate, String lastModifiedUser, String type, boolean isEnabled, boolean isDefault) {
        this.id = id;
        this.versionId = versionId;
        this.phoneNo = phoneNo;
        this.employeeUserName = employeeUserName;
        this.creationDate = creationDate;
        this.creationUser = creationUser;
        this.lastModifiedDate = lastModifiedDate;
        this.lastModifiedUser = lastModifiedUser;
        this.type = type;
        this.isEnabled = isEnabled;
        this.isDefault = isDefault;
    }

    /**
     * Gets the id of this EmployeePhone.
     * @return the id
     */
    public Integer getId() {
        return this.id;
    }

    /**
     * Sets the id of this EmployeePhone to the specified value.
     * @param id the new id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Gets the versionId of this EmployeePhone.
     * @return the versionId
     */
    public int getVersionId() {
        return this.versionId;
    }

    /**
     * Sets the versionId of this EmployeePhone to the specified value.
     * @param versionId the new versionId
     */
    public void setVersionId(int versionId) {
        this.versionId = versionId;
    }

    /**
     * Gets the phoneNo of this EmployeePhone.
     * @return the phoneNo
     */
    public String getPhoneNo() {
        return this.phoneNo;
    }

    /**
     * Sets the phoneNo of this EmployeePhone to the specified value.
     * @param phoneNo the new phoneNo
     */
    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    /**
     * Gets the employeeUserName of this EmployeePhone.
     * @return the employeeUserName
     */
    public String getEmployeeUserName() {
        return this.employeeUserName;
    }

    /**
     * Sets the employeeUserName of this EmployeePhone to the specified value.
     * @param employeeUserName the new employeeUserName
     */
    public void setEmployeeUserName(String employeeUserName) {
        this.employeeUserName = employeeUserName;
    }

    /**
     * Gets the creationDate of this EmployeePhone.
     * @return the creationDate
     */
    public Date getCreationDate() {
        return this.creationDate;
    }

    /**
     * Sets the creationDate of this EmployeePhone to the specified value.
     * @param creationDate the new creationDate
     */
    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    /**
     * Gets the creationUser of this EmployeePhone.
     * @return the creationUser
     */
    public String getCreationUser() {
        return this.creationUser;
    }

    /**
     * Sets the creationUser of this EmployeePhone to the specified value.
     * @param creationUser the new creationUser
     */
    public void setCreationUser(String creationUser) {
        this.creationUser = creationUser;
    }

    /**
     * Gets the lastModifiedDate of this EmployeePhone.
     * @return the lastModifiedDate
     */
    public Date getLastModifiedDate() {
        return this.lastModifiedDate;
    }

    /**
     * Sets the lastModifiedDate of this EmployeePhone to the specified value.
     * @param lastModifiedDate the new lastModifiedDate
     */
    public void setLastModifiedDate(Date lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    /**
     * Gets the lastModifiedUser of this EmployeePhone.
     * @return the lastModifiedUser
     */
    public String getLastModifiedUser() {
        return this.lastModifiedUser;
    }

    /**
     * Sets the lastModifiedUser of this EmployeePhone to the specified value.
     * @param lastModifiedUser the new lastModifiedUser
     */
    public void setLastModifiedUser(String lastModifiedUser) {
        this.lastModifiedUser = lastModifiedUser;
    }

    /**
     * Gets the type of this EmployeePhone.
     * @return the type
     */
    public String getType() {
        return this.type;
    }

    /**
     * Sets the type of this EmployeePhone to the specified value.
     * @param type the new type
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * Gets the isEnabled of this EmployeePhone.
     * @return the isEnabled
     */
    public boolean getIsEnabled() {
        return this.isEnabled;
    }

    /**
     * Sets the isEnabled of this EmployeePhone to the specified value.
     * @param isEnabled the new isEnabled
     */
    public void setIsEnabled(boolean isEnabled) {
        this.isEnabled = isEnabled;
    }

    /**
     * Gets the isDefault of this EmployeePhone.
     * @return the isDefault
     */
    public boolean getIsDefault() {
        return this.isDefault;
    }

    /**
     * Sets the isDefault of this EmployeePhone to the specified value.
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
     * Determines whether another object is equal to this EmployeePhone.  The result is 
     * <code>true</code> if and only if the argument is not null and is a EmployeePhone object that 
     * has the same id field values as this object.
     * @param object the reference object with which to compare
     * @return <code>true</code> if this object is the same as the argument;
     * <code>false</code> otherwise.
     */
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EmployeePhone)) {
            return false;
        }
        EmployeePhone other = (EmployeePhone)object;
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
        return "com.abbt.crm.entity.EmployeePhone[id=" + id + "]";
    }

}
