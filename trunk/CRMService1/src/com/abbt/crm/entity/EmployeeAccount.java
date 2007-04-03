/*
 * EmployeeAccount.java
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
 * Entity class EmployeeAccount
 * 
 * @author shannan
 */
@Entity
@Table(name = "employee_account")
@NamedQueries( {
        @NamedQuery(name = "EmployeeAccount.findById", query = "SELECT e FROM EmployeeAccount e WHERE e.id = :id"),
        @NamedQuery(name = "EmployeeAccount.findByVersionId", query = "SELECT e FROM EmployeeAccount e WHERE e.versionId = :versionId"),
        @NamedQuery(name = "EmployeeAccount.findByEmployeeUserName", query = "SELECT e FROM EmployeeAccount e WHERE e.employeeUserName = :employeeUserName"),
        @NamedQuery(name = "EmployeeAccount.findByCreationDate", query = "SELECT e FROM EmployeeAccount e WHERE e.creationDate = :creationDate"),
        @NamedQuery(name = "EmployeeAccount.findByCreatedUser", query = "SELECT e FROM EmployeeAccount e WHERE e.createdUser = :createdUser"),
        @NamedQuery(name = "EmployeeAccount.findByLastModifiedUser", query = "SELECT e FROM EmployeeAccount e WHERE e.lastModifiedUser = :lastModifiedUser"),
        @NamedQuery(name = "EmployeeAccount.findByLastModifiedDate", query = "SELECT e FROM EmployeeAccount e WHERE e.lastModifiedDate = :lastModifiedDate"),
        @NamedQuery(name = "EmployeeAccount.findByEmployeeId", query = "SELECT e FROM EmployeeAccount e WHERE e.employeeId = :employeeId")
    })
public class EmployeeAccount implements Serializable {

    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "versionId", nullable = false)
    private int versionId;

    @Column(name = "employeeUserName", nullable = false)
    private String employeeUserName;

    @Column(name = "creationDate", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date creationDate;

    @Column(name = "createdUser", nullable = false)
    private String createdUser;

    @Column(name = "lastModifiedUser", nullable = false)
    private String lastModifiedUser;

    @Column(name = "lastModifiedDate", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModifiedDate;

    @Column(name = "employeeId", nullable = false)
    private int employeeId;

    /** Creates a new instance of EmployeeAccount */
    public EmployeeAccount() {
    }

    /**
     * Creates a new instance of EmployeeAccount with the specified values.
     * @param id the id of the EmployeeAccount
     */
    public EmployeeAccount(Integer id) {
        this.id = id;
    }

    /**
     * Creates a new instance of EmployeeAccount with the specified values.
     * @param id the id of the EmployeeAccount
     * @param versionId the versionId of the EmployeeAccount
     * @param employeeUserName the employeeUserName of the EmployeeAccount
     * @param creationDate the creationDate of the EmployeeAccount
     * @param createdUser the createdUser of the EmployeeAccount
     * @param lastModifiedUser the lastModifiedUser of the EmployeeAccount
     * @param lastModifiedDate the lastModifiedDate of the EmployeeAccount
     * @param employeeId the employeeId of the EmployeeAccount
     */
    public EmployeeAccount(Integer id, int versionId, String employeeUserName, Date creationDate, String createdUser, String lastModifiedUser, Date lastModifiedDate, int employeeId) {
        this.id = id;
        this.versionId = versionId;
        this.employeeUserName = employeeUserName;
        this.creationDate = creationDate;
        this.createdUser = createdUser;
        this.lastModifiedUser = lastModifiedUser;
        this.lastModifiedDate = lastModifiedDate;
        this.employeeId = employeeId;
    }

    /**
     * Gets the id of this EmployeeAccount.
     * @return the id
     */
    public Integer getId() {
        return this.id;
    }

    /**
     * Sets the id of this EmployeeAccount to the specified value.
     * @param id the new id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Gets the versionId of this EmployeeAccount.
     * @return the versionId
     */
    public int getVersionId() {
        return this.versionId;
    }

    /**
     * Sets the versionId of this EmployeeAccount to the specified value.
     * @param versionId the new versionId
     */
    public void setVersionId(int versionId) {
        this.versionId = versionId;
    }

    /**
     * Gets the employeeUserName of this EmployeeAccount.
     * @return the employeeUserName
     */
    public String getEmployeeUserName() {
        return this.employeeUserName;
    }

    /**
     * Sets the employeeUserName of this EmployeeAccount to the specified value.
     * @param employeeUserName the new employeeUserName
     */
    public void setEmployeeUserName(String employeeUserName) {
        this.employeeUserName = employeeUserName;
    }

    /**
     * Gets the creationDate of this EmployeeAccount.
     * @return the creationDate
     */
    public Date getCreationDate() {
        return this.creationDate;
    }

    /**
     * Sets the creationDate of this EmployeeAccount to the specified value.
     * @param creationDate the new creationDate
     */
    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    /**
     * Gets the createdUser of this EmployeeAccount.
     * @return the createdUser
     */
    public String getCreatedUser() {
        return this.createdUser;
    }

    /**
     * Sets the createdUser of this EmployeeAccount to the specified value.
     * @param createdUser the new createdUser
     */
    public void setCreatedUser(String createdUser) {
        this.createdUser = createdUser;
    }

    /**
     * Gets the lastModifiedUser of this EmployeeAccount.
     * @return the lastModifiedUser
     */
    public String getLastModifiedUser() {
        return this.lastModifiedUser;
    }

    /**
     * Sets the lastModifiedUser of this EmployeeAccount to the specified value.
     * @param lastModifiedUser the new lastModifiedUser
     */
    public void setLastModifiedUser(String lastModifiedUser) {
        this.lastModifiedUser = lastModifiedUser;
    }

    /**
     * Gets the lastModifiedDate of this EmployeeAccount.
     * @return the lastModifiedDate
     */
    public Date getLastModifiedDate() {
        return this.lastModifiedDate;
    }

    /**
     * Sets the lastModifiedDate of this EmployeeAccount to the specified value.
     * @param lastModifiedDate the new lastModifiedDate
     */
    public void setLastModifiedDate(Date lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    /**
     * Gets the employeeId of this EmployeeAccount.
     * @return the employeeId
     */
    public int getEmployeeId() {
        return this.employeeId;
    }

    /**
     * Sets the employeeId of this EmployeeAccount to the specified value.
     * @param employeeId the new employeeId
     */
    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
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
     * Determines whether another object is equal to this EmployeeAccount.  The result is 
     * <code>true</code> if and only if the argument is not null and is a EmployeeAccount object that 
     * has the same id field values as this object.
     * @param object the reference object with which to compare
     * @return <code>true</code> if this object is the same as the argument;
     * <code>false</code> otherwise.
     */
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EmployeeAccount)) {
            return false;
        }
        EmployeeAccount other = (EmployeeAccount)object;
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
        return "com.abbt.crm.entity.EmployeeAccount[id=" + id + "]";
    }

}
