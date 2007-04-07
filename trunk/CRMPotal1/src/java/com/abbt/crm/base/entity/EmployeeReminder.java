/*
 * EmployeeReminder.java
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
 * Entity class EmployeeReminder
 * 
 * @author Mohammed Hamed
 */
@Entity
@Table(name = "employee_reminder")
@NamedQueries( {
        @NamedQuery(name = "EmployeeReminder.findById", query = "SELECT e FROM EmployeeReminder e WHERE e.id = :id"),
        @NamedQuery(name = "EmployeeReminder.findByVersionId", query = "SELECT e FROM EmployeeReminder e WHERE e.versionId = :versionId"),
        @NamedQuery(name = "EmployeeReminder.findByReminderTimeStamp", query = "SELECT e FROM EmployeeReminder e WHERE e.reminderTimeStamp = :reminderTimeStamp"),
        @NamedQuery(name = "EmployeeReminder.findByTitle", query = "SELECT e FROM EmployeeReminder e WHERE e.title = :title"),
        @NamedQuery(name = "EmployeeReminder.findByDetail", query = "SELECT e FROM EmployeeReminder e WHERE e.detail = :detail"),
        @NamedQuery(name = "EmployeeReminder.findByCreationDate", query = "SELECT e FROM EmployeeReminder e WHERE e.creationDate = :creationDate"),
        @NamedQuery(name = "EmployeeReminder.findByCreatedUser", query = "SELECT e FROM EmployeeReminder e WHERE e.createdUser = :createdUser"),
        @NamedQuery(name = "EmployeeReminder.findByLastModifiedUser", query = "SELECT e FROM EmployeeReminder e WHERE e.lastModifiedUser = :lastModifiedUser"),
        @NamedQuery(name = "EmployeeReminder.findByLastModifiedDate", query = "SELECT e FROM EmployeeReminder e WHERE e.lastModifiedDate = :lastModifiedDate"),
        @NamedQuery(name = "EmployeeReminder.findByEmployeeId", query = "SELECT e FROM EmployeeReminder e WHERE e.employeeId = :employeeId")
    })
public class EmployeeReminder implements Serializable {

    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "versionId", nullable = false)
    private int versionId;

    @Column(name = "reminderTimeStamp")
    @Temporal(TemporalType.TIMESTAMP)
    private Date reminderTimeStamp;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "detail", nullable = false)
    private String detail;

    @Column(name = "creationDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date creationDate;

    @Column(name = "createdUser", nullable = false)
    private String createdUser;

    @Column(name = "lastModifiedUser", nullable = false)
    private String lastModifiedUser;

    @Column(name = "lastModifiedDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModifiedDate;

    @Column(name = "employeeId", nullable = false)
    private String employeeId;
    
    /** Creates a new instance of EmployeeReminder */
    public EmployeeReminder() {
    }

    /**
     * Creates a new instance of EmployeeReminder with the specified values.
     * @param id the id of the EmployeeReminder
     */
    public EmployeeReminder(Integer id) {
        this.id = id;
    }

    /**
     * Creates a new instance of EmployeeReminder with the specified values.
     * @param id the id of the EmployeeReminder
     * @param versionId the versionId of the EmployeeReminder
     * @param title the title of the EmployeeReminder
     * @param detail the detail of the EmployeeReminder
     * @param createdUser the createdUser of the EmployeeReminder
     * @param lastModifiedUser the lastModifiedUser of the EmployeeReminder
     * @param employeeId the employeeId of the EmployeeReminder
     */
    public EmployeeReminder(Integer id, int versionId, String title, String detail, String createdUser, String lastModifiedUser, String employeeId) {
        this.id = id;
        this.versionId = versionId;
        this.title = title;
        this.detail = detail;
        this.createdUser = createdUser;
        this.lastModifiedUser = lastModifiedUser;
        this.employeeId = employeeId;
    }

    /**
     * Gets the id of this EmployeeReminder.
     * @return the id
     */
    public Integer getId() {
        return this.id;
    }

    /**
     * Sets the id of this EmployeeReminder to the specified value.
     * @param id the new id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Gets the versionId of this EmployeeReminder.
     * @return the versionId
     */
    public int getVersionId() {
        return this.versionId;
    }

    /**
     * Sets the versionId of this EmployeeReminder to the specified value.
     * @param versionId the new versionId
     */
    public void setVersionId(int versionId) {
        this.versionId = versionId;
    }

    /**
     * Gets the reminderTimeStamp of this EmployeeReminder.
     * @return the reminderTimeStamp
     */
    public Date getReminderTimeStamp() {
        return this.reminderTimeStamp;
    }

    /**
     * Sets the reminderTimeStamp of this EmployeeReminder to the specified value.
     * @param reminderTimeStamp the new reminderTimeStamp
     */
    public void setReminderTimeStamp(Date reminderTimeStamp) {
        this.reminderTimeStamp = reminderTimeStamp;
    }

    /**
     * Gets the title of this EmployeeReminder.
     * @return the title
     */
    public String getTitle() {
        return this.title;
    }

    /**
     * Sets the title of this EmployeeReminder to the specified value.
     * @param title the new title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Gets the detail of this EmployeeReminder.
     * @return the detail
     */
    public String getDetail() {
        return this.detail;
    }

    /**
     * Sets the detail of this EmployeeReminder to the specified value.
     * @param detail the new detail
     */
    public void setDetail(String detail) {
        this.detail = detail;
    }

    /**
     * Gets the creationDate of this EmployeeReminder.
     * @return the creationDate
     */
    public Date getCreationDate() {
        return this.creationDate;
    }

    /**
     * Sets the creationDate of this EmployeeReminder to the specified value.
     * @param creationDate the new creationDate
     */
    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    /**
     * Gets the createdUser of this EmployeeReminder.
     * @return the createdUser
     */
    public String getCreatedUser() {
        return this.createdUser;
    }

    /**
     * Sets the createdUser of this EmployeeReminder to the specified value.
     * @param createdUser the new createdUser
     */
    public void setCreatedUser(String createdUser) {
        this.createdUser = createdUser;
    }

    /**
     * Gets the lastModifiedUser of this EmployeeReminder.
     * @return the lastModifiedUser
     */
    public String getLastModifiedUser() {
        return this.lastModifiedUser;
    }

    /**
     * Sets the lastModifiedUser of this EmployeeReminder to the specified value.
     * @param lastModifiedUser the new lastModifiedUser
     */
    public void setLastModifiedUser(String lastModifiedUser) {
        this.lastModifiedUser = lastModifiedUser;
    }

    /**
     * Gets the lastModifiedDate of this EmployeeReminder.
     * @return the lastModifiedDate
     */
    public Date getLastModifiedDate() {
        return this.lastModifiedDate;
    }

    /**
     * Sets the lastModifiedDate of this EmployeeReminder to the specified value.
     * @param lastModifiedDate the new lastModifiedDate
     */
    public void setLastModifiedDate(Date lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    /**
     * Gets the employeeId of this EmployeeReminder.
     * @return the employeeId
     */
    public String getEmployeeId() {
        return this.employeeId;
    }

    /**
     * Sets the employeeId of this EmployeeReminder to the specified value.
     * @param employeeId the new employeeId
     */
    public void setEmployeeId(String employeeId) {
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
     * Determines whether another object is equal to this EmployeeReminder.  The result is 
     * <code>true</code> if and only if the argument is not null and is a EmployeeReminder object that 
     * has the same id field values as this object.
     * @param object the reference object with which to compare
     * @return <code>true</code> if this object is the same as the argument;
     * <code>false</code> otherwise.
     */
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EmployeeReminder)) {
            return false;
        }
        EmployeeReminder other = (EmployeeReminder)object;
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
        return "com.abbt.crm.base.entity.EmployeeReminder[id=" + id + "]";
    }
    
}
