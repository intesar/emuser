/*
 * EmployeeContacts.java
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
 * Entity class EmployeeContacts
 * 
 * @author shannan
 */
@Entity
@Table(name = "employee_contacts")
@NamedQueries( {
        @NamedQuery(name = "EmployeeContacts.findByEmployeeUsername", query = "SELECT e FROM EmployeeContacts e WHERE e.employeeUsername = :employeeUsername"),
        @NamedQuery(name = "EmployeeContacts.findById", query = "SELECT e FROM EmployeeContacts e WHERE e.id = :id"),
        @NamedQuery(name = "EmployeeContacts.findByVersionId", query = "SELECT e FROM EmployeeContacts e WHERE e.versionId = :versionId"),
        @NamedQuery(name = "EmployeeContacts.findByContactId", query = "SELECT e FROM EmployeeContacts e WHERE e.contactId = :contactId"),
        @NamedQuery(name = "EmployeeContacts.findByCreatedUser", query = "SELECT e FROM EmployeeContacts e WHERE e.createdUser = :createdUser"),
        @NamedQuery(name = "EmployeeContacts.findByCreationDate", query = "SELECT e FROM EmployeeContacts e WHERE e.creationDate = :creationDate")
    })
public class EmployeeContacts implements Serializable {

    @Column(name = "employeeUsername", nullable = false)
    private String employeeUsername;

    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "versionId", nullable = false)
    private int versionId;

    @Column(name = "contactId", nullable = false)
    private int contactId;

    @Column(name = "createdUser", nullable = false)
    private String createdUser;

    @Column(name = "creationDate", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date creationDate;

    /** Creates a new instance of EmployeeContacts */
    public EmployeeContacts() {
    }

    /**
     * Creates a new instance of EmployeeContacts with the specified values.
     * @param id the id of the EmployeeContacts
     */
    public EmployeeContacts(Integer id) {
        this.id = id;
    }

    /**
     * Creates a new instance of EmployeeContacts with the specified values.
     * @param id the id of the EmployeeContacts
     * @param employeeUsername the employeeUsername of the EmployeeContacts
     * @param versionId the versionId of the EmployeeContacts
     * @param contactId the contactId of the EmployeeContacts
     * @param createdUser the createdUser of the EmployeeContacts
     * @param creationDate the creationDate of the EmployeeContacts
     */
    public EmployeeContacts(Integer id, String employeeUsername, int versionId, int contactId, String createdUser, Date creationDate) {
        this.id = id;
        this.employeeUsername = employeeUsername;
        this.versionId = versionId;
        this.contactId = contactId;
        this.createdUser = createdUser;
        this.creationDate = creationDate;
    }

    /**
     * Gets the employeeUsername of this EmployeeContacts.
     * @return the employeeUsername
     */
    public String getEmployeeUsername() {
        return this.employeeUsername;
    }

    /**
     * Sets the employeeUsername of this EmployeeContacts to the specified value.
     * @param employeeUsername the new employeeUsername
     */
    public void setEmployeeUsername(String employeeUsername) {
        this.employeeUsername = employeeUsername;
    }

    /**
     * Gets the id of this EmployeeContacts.
     * @return the id
     */
    public Integer getId() {
        return this.id;
    }

    /**
     * Sets the id of this EmployeeContacts to the specified value.
     * @param id the new id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Gets the versionId of this EmployeeContacts.
     * @return the versionId
     */
    public int getVersionId() {
        return this.versionId;
    }

    /**
     * Sets the versionId of this EmployeeContacts to the specified value.
     * @param versionId the new versionId
     */
    public void setVersionId(int versionId) {
        this.versionId = versionId;
    }

    /**
     * Gets the contactId of this EmployeeContacts.
     * @return the contactId
     */
    public int getContactId() {
        return this.contactId;
    }

    /**
     * Sets the contactId of this EmployeeContacts to the specified value.
     * @param contactId the new contactId
     */
    public void setContactId(int contactId) {
        this.contactId = contactId;
    }

    /**
     * Gets the createdUser of this EmployeeContacts.
     * @return the createdUser
     */
    public String getCreatedUser() {
        return this.createdUser;
    }

    /**
     * Sets the createdUser of this EmployeeContacts to the specified value.
     * @param createdUser the new createdUser
     */
    public void setCreatedUser(String createdUser) {
        this.createdUser = createdUser;
    }

    /**
     * Gets the creationDate of this EmployeeContacts.
     * @return the creationDate
     */
    public Date getCreationDate() {
        return this.creationDate;
    }

    /**
     * Sets the creationDate of this EmployeeContacts to the specified value.
     * @param creationDate the new creationDate
     */
    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
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
     * Determines whether another object is equal to this EmployeeContacts.  The result is 
     * <code>true</code> if and only if the argument is not null and is a EmployeeContacts object that 
     * has the same id field values as this object.
     * @param object the reference object with which to compare
     * @return <code>true</code> if this object is the same as the argument;
     * <code>false</code> otherwise.
     */
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EmployeeContacts)) {
            return false;
        }
        EmployeeContacts other = (EmployeeContacts)object;
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
        return "com.abbt.crm.base.entity.EmployeeContacts[id=" + id + "]";
    }

}
