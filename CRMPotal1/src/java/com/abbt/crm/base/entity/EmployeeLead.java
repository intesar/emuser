/*
 * EmployeeLead.java
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
 * Entity class EmployeeLead
 * 
 * @author shannan
 */
@Entity
@Table(name = "employee_lead")
@NamedQueries( {
        @NamedQuery(name = "EmployeeLead.findById", query = "SELECT e FROM EmployeeLead e WHERE e.id = :id"),
        @NamedQuery(name = "EmployeeLead.findByVersionId", query = "SELECT e FROM EmployeeLead e WHERE e.versionId = :versionId"),
        @NamedQuery(name = "EmployeeLead.findByEmployeeUserName", query = "SELECT e FROM EmployeeLead e WHERE e.employeeUserName = :employeeUserName"),
        @NamedQuery(name = "EmployeeLead.findByLeadCompanyName", query = "SELECT e FROM EmployeeLead e WHERE e.leadCompanyName = :leadCompanyName"),
        @NamedQuery(name = "EmployeeLead.findByCreationDate", query = "SELECT e FROM EmployeeLead e WHERE e.creationDate = :creationDate"),
        @NamedQuery(name = "EmployeeLead.findByCreatedUser", query = "SELECT e FROM EmployeeLead e WHERE e.createdUser = :createdUser"),
        @NamedQuery(name = "EmployeeLead.findByLastModifiedUser", query = "SELECT e FROM EmployeeLead e WHERE e.lastModifiedUser = :lastModifiedUser"),
        @NamedQuery(name = "EmployeeLead.findByLastModifiedDate", query = "SELECT e FROM EmployeeLead e WHERE e.lastModifiedDate = :lastModifiedDate"),
        @NamedQuery(name = "EmployeeLead.findByTaskId", query = "SELECT e FROM EmployeeLead e WHERE e.taskId = :taskId")
    })
public class EmployeeLead implements Serializable {

    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "versionId", nullable = false)
    private int versionId;

    @Column(name = "employeeUserName", nullable = false)
    private String employeeUserName;

    @Column(name = "leadCompanyName", nullable = false)
    private String leadCompanyName;

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

    @Column(name = "taskId", nullable = false)
    private int taskId;

    /** Creates a new instance of EmployeeLead */
    public EmployeeLead() {
    }

    /**
     * Creates a new instance of EmployeeLead with the specified values.
     * @param id the id of the EmployeeLead
     */
    public EmployeeLead(Integer id) {
        this.id = id;
    }

    /**
     * Creates a new instance of EmployeeLead with the specified values.
     * @param id the id of the EmployeeLead
     * @param versionId the versionId of the EmployeeLead
     * @param employeeUserName the employeeUserName of the EmployeeLead
     * @param leadCompanyName the leadCompanyName of the EmployeeLead
     * @param creationDate the creationDate of the EmployeeLead
     * @param createdUser the createdUser of the EmployeeLead
     * @param lastModifiedUser the lastModifiedUser of the EmployeeLead
     * @param lastModifiedDate the lastModifiedDate of the EmployeeLead
     * @param taskId the taskId of the EmployeeLead
     */
    public EmployeeLead(Integer id, int versionId, String employeeUserName, String leadCompanyName, Date creationDate, String createdUser, String lastModifiedUser, Date lastModifiedDate, int taskId) {
        this.id = id;
        this.versionId = versionId;
        this.employeeUserName = employeeUserName;
        this.leadCompanyName = leadCompanyName;
        this.creationDate = creationDate;
        this.createdUser = createdUser;
        this.lastModifiedUser = lastModifiedUser;
        this.lastModifiedDate = lastModifiedDate;
        this.taskId = taskId;
    }

    /**
     * Gets the id of this EmployeeLead.
     * @return the id
     */
    public Integer getId() {
        return this.id;
    }

    /**
     * Sets the id of this EmployeeLead to the specified value.
     * @param id the new id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Gets the versionId of this EmployeeLead.
     * @return the versionId
     */
    public int getVersionId() {
        return this.versionId;
    }

    /**
     * Sets the versionId of this EmployeeLead to the specified value.
     * @param versionId the new versionId
     */
    public void setVersionId(int versionId) {
        this.versionId = versionId;
    }

    /**
     * Gets the employeeUserName of this EmployeeLead.
     * @return the employeeUserName
     */
    public String getEmployeeUserName() {
        return this.employeeUserName;
    }

    /**
     * Sets the employeeUserName of this EmployeeLead to the specified value.
     * @param employeeUserName the new employeeUserName
     */
    public void setEmployeeUserName(String employeeUserName) {
        this.employeeUserName = employeeUserName;
    }

    /**
     * Gets the leadCompanyName of this EmployeeLead.
     * @return the leadCompanyName
     */
    public String getLeadCompanyName() {
        return this.leadCompanyName;
    }

    /**
     * Sets the leadCompanyName of this EmployeeLead to the specified value.
     * @param leadCompanyName the new leadCompanyName
     */
    public void setLeadCompanyName(String leadCompanyName) {
        this.leadCompanyName = leadCompanyName;
    }

    /**
     * Gets the creationDate of this EmployeeLead.
     * @return the creationDate
     */
    public Date getCreationDate() {
        return this.creationDate;
    }

    /**
     * Sets the creationDate of this EmployeeLead to the specified value.
     * @param creationDate the new creationDate
     */
    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    /**
     * Gets the createdUser of this EmployeeLead.
     * @return the createdUser
     */
    public String getCreatedUser() {
        return this.createdUser;
    }

    /**
     * Sets the createdUser of this EmployeeLead to the specified value.
     * @param createdUser the new createdUser
     */
    public void setCreatedUser(String createdUser) {
        this.createdUser = createdUser;
    }

    /**
     * Gets the lastModifiedUser of this EmployeeLead.
     * @return the lastModifiedUser
     */
    public String getLastModifiedUser() {
        return this.lastModifiedUser;
    }

    /**
     * Sets the lastModifiedUser of this EmployeeLead to the specified value.
     * @param lastModifiedUser the new lastModifiedUser
     */
    public void setLastModifiedUser(String lastModifiedUser) {
        this.lastModifiedUser = lastModifiedUser;
    }

    /**
     * Gets the lastModifiedDate of this EmployeeLead.
     * @return the lastModifiedDate
     */
    public Date getLastModifiedDate() {
        return this.lastModifiedDate;
    }

    /**
     * Sets the lastModifiedDate of this EmployeeLead to the specified value.
     * @param lastModifiedDate the new lastModifiedDate
     */
    public void setLastModifiedDate(Date lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    /**
     * Gets the taskId of this EmployeeLead.
     * @return the taskId
     */
    public int getTaskId() {
        return this.taskId;
    }

    /**
     * Sets the taskId of this EmployeeLead to the specified value.
     * @param taskId the new taskId
     */
    public void setTaskId(int taskId) {
        this.taskId = taskId;
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
     * Determines whether another object is equal to this EmployeeLead.  The result is 
     * <code>true</code> if and only if the argument is not null and is a EmployeeLead object that 
     * has the same id field values as this object.
     * @param object the reference object with which to compare
     * @return <code>true</code> if this object is the same as the argument;
     * <code>false</code> otherwise.
     */
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EmployeeLead)) {
            return false;
        }
        EmployeeLead other = (EmployeeLead)object;
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
        return "com.abbt.crm.base.entity.EmployeeLead[id=" + id + "]";
    }

}
