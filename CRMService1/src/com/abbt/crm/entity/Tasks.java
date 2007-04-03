/*
 * Tasks.java
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
 * Entity class Tasks
 * 
 * @author shannan
 */
@Entity
@Table(name = "tasks")
@NamedQueries( {
        @NamedQuery(name = "Tasks.findById", query = "SELECT t FROM Tasks t WHERE t.id = :id"),
        @NamedQuery(name = "Tasks.findByVersionId", query = "SELECT t FROM Tasks t WHERE t.versionId = :versionId"),
        @NamedQuery(name = "Tasks.findByTitle", query = "SELECT t FROM Tasks t WHERE t.title = :title"),
        @NamedQuery(name = "Tasks.findByDescription", query = "SELECT t FROM Tasks t WHERE t.description = :description"),
        @NamedQuery(name = "Tasks.findByType", query = "SELECT t FROM Tasks t WHERE t.type = :type"),
        @NamedQuery(name = "Tasks.findByAssignedBy", query = "SELECT t FROM Tasks t WHERE t.assignedBy = :assignedBy"),
        @NamedQuery(name = "Tasks.findByAssignedTo", query = "SELECT t FROM Tasks t WHERE t.assignedTo = :assignedTo"),
        @NamedQuery(name = "Tasks.findByStatus", query = "SELECT t FROM Tasks t WHERE t.status = :status"),
        @NamedQuery(name = "Tasks.findByExplaination", query = "SELECT t FROM Tasks t WHERE t.explaination = :explaination"),
        @NamedQuery(name = "Tasks.findByParentTaskId", query = "SELECT t FROM Tasks t WHERE t.parentTaskId = :parentTaskId"),
        @NamedQuery(name = "Tasks.findByCreatedUser", query = "SELECT t FROM Tasks t WHERE t.createdUser = :createdUser"),
        @NamedQuery(name = "Tasks.findByCreationDate", query = "SELECT t FROM Tasks t WHERE t.creationDate = :creationDate"),
        @NamedQuery(name = "Tasks.findByLastModifiedUser", query = "SELECT t FROM Tasks t WHERE t.lastModifiedUser = :lastModifiedUser"),
        @NamedQuery(name = "Tasks.findByLastModifiedDate", query = "SELECT t FROM Tasks t WHERE t.lastModifiedDate = :lastModifiedDate"),
        @NamedQuery(name = "Tasks.findByTaskId", query = "SELECT t FROM Tasks t WHERE t.taskId = :taskId")
    })
public class Tasks implements Serializable {

    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "versionId", nullable = false)
    private int versionId;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "type", nullable = false)
    private String type;

    @Column(name = "assignedBy", nullable = false)
    private String assignedBy;

    @Column(name = "assignedTo", nullable = false)
    private String assignedTo;

    @Column(name = "status", nullable = false)
    private String status;

    @Column(name = "explaination", nullable = false)
    private String explaination;

    @Column(name = "parentTaskId", nullable = false)
    private int parentTaskId;

    @Column(name = "createdUser", nullable = false)
    private String createdUser;

    @Column(name = "creationDate", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date creationDate;

    @Column(name = "lastModifiedUser", nullable = false)
    private String lastModifiedUser;

    @Column(name = "lastModifiedDate", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModifiedDate;

    @Column(name = "taskId", nullable = false)
    private int taskId;

    /** Creates a new instance of Tasks */
    public Tasks() {
    }

    /**
     * Creates a new instance of Tasks with the specified values.
     * @param id the id of the Tasks
     */
    public Tasks(Integer id) {
        this.id = id;
    }

    /**
     * Creates a new instance of Tasks with the specified values.
     * @param id the id of the Tasks
     * @param versionId the versionId of the Tasks
     * @param title the title of the Tasks
     * @param description the description of the Tasks
     * @param type the type of the Tasks
     * @param assignedBy the assignedBy of the Tasks
     * @param assignedTo the assignedTo of the Tasks
     * @param status the status of the Tasks
     * @param explaination the explaination of the Tasks
     * @param parentTaskId the parentTaskId of the Tasks
     * @param createdUser the createdUser of the Tasks
     * @param creationDate the creationDate of the Tasks
     * @param lastModifiedUser the lastModifiedUser of the Tasks
     * @param lastModifiedDate the lastModifiedDate of the Tasks
     * @param taskId the taskId of the Tasks
     */
    public Tasks(Integer id, int versionId, String title, String description, String type, String assignedBy, String assignedTo, String status, String explaination, int parentTaskId, String createdUser, Date creationDate, String lastModifiedUser, Date lastModifiedDate, int taskId) {
        this.id = id;
        this.versionId = versionId;
        this.title = title;
        this.description = description;
        this.type = type;
        this.assignedBy = assignedBy;
        this.assignedTo = assignedTo;
        this.status = status;
        this.explaination = explaination;
        this.parentTaskId = parentTaskId;
        this.createdUser = createdUser;
        this.creationDate = creationDate;
        this.lastModifiedUser = lastModifiedUser;
        this.lastModifiedDate = lastModifiedDate;
        this.taskId = taskId;
    }

    /**
     * Gets the id of this Tasks.
     * @return the id
     */
    public Integer getId() {
        return this.id;
    }

    /**
     * Sets the id of this Tasks to the specified value.
     * @param id the new id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Gets the versionId of this Tasks.
     * @return the versionId
     */
    public int getVersionId() {
        return this.versionId;
    }

    /**
     * Sets the versionId of this Tasks to the specified value.
     * @param versionId the new versionId
     */
    public void setVersionId(int versionId) {
        this.versionId = versionId;
    }

    /**
     * Gets the title of this Tasks.
     * @return the title
     */
    public String getTitle() {
        return this.title;
    }

    /**
     * Sets the title of this Tasks to the specified value.
     * @param title the new title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Gets the description of this Tasks.
     * @return the description
     */
    public String getDescription() {
        return this.description;
    }

    /**
     * Sets the description of this Tasks to the specified value.
     * @param description the new description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Gets the type of this Tasks.
     * @return the type
     */
    public String getType() {
        return this.type;
    }

    /**
     * Sets the type of this Tasks to the specified value.
     * @param type the new type
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * Gets the assignedBy of this Tasks.
     * @return the assignedBy
     */
    public String getAssignedBy() {
        return this.assignedBy;
    }

    /**
     * Sets the assignedBy of this Tasks to the specified value.
     * @param assignedBy the new assignedBy
     */
    public void setAssignedBy(String assignedBy) {
        this.assignedBy = assignedBy;
    }

    /**
     * Gets the assignedTo of this Tasks.
     * @return the assignedTo
     */
    public String getAssignedTo() {
        return this.assignedTo;
    }

    /**
     * Sets the assignedTo of this Tasks to the specified value.
     * @param assignedTo the new assignedTo
     */
    public void setAssignedTo(String assignedTo) {
        this.assignedTo = assignedTo;
    }

    /**
     * Gets the status of this Tasks.
     * @return the status
     */
    public String getStatus() {
        return this.status;
    }

    /**
     * Sets the status of this Tasks to the specified value.
     * @param status the new status
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * Gets the explaination of this Tasks.
     * @return the explaination
     */
    public String getExplaination() {
        return this.explaination;
    }

    /**
     * Sets the explaination of this Tasks to the specified value.
     * @param explaination the new explaination
     */
    public void setExplaination(String explaination) {
        this.explaination = explaination;
    }

    /**
     * Gets the parentTaskId of this Tasks.
     * @return the parentTaskId
     */
    public int getParentTaskId() {
        return this.parentTaskId;
    }

    /**
     * Sets the parentTaskId of this Tasks to the specified value.
     * @param parentTaskId the new parentTaskId
     */
    public void setParentTaskId(int parentTaskId) {
        this.parentTaskId = parentTaskId;
    }

    /**
     * Gets the createdUser of this Tasks.
     * @return the createdUser
     */
    public String getCreatedUser() {
        return this.createdUser;
    }

    /**
     * Sets the createdUser of this Tasks to the specified value.
     * @param createdUser the new createdUser
     */
    public void setCreatedUser(String createdUser) {
        this.createdUser = createdUser;
    }

    /**
     * Gets the creationDate of this Tasks.
     * @return the creationDate
     */
    public Date getCreationDate() {
        return this.creationDate;
    }

    /**
     * Sets the creationDate of this Tasks to the specified value.
     * @param creationDate the new creationDate
     */
    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    /**
     * Gets the lastModifiedUser of this Tasks.
     * @return the lastModifiedUser
     */
    public String getLastModifiedUser() {
        return this.lastModifiedUser;
    }

    /**
     * Sets the lastModifiedUser of this Tasks to the specified value.
     * @param lastModifiedUser the new lastModifiedUser
     */
    public void setLastModifiedUser(String lastModifiedUser) {
        this.lastModifiedUser = lastModifiedUser;
    }

    /**
     * Gets the lastModifiedDate of this Tasks.
     * @return the lastModifiedDate
     */
    public Date getLastModifiedDate() {
        return this.lastModifiedDate;
    }

    /**
     * Sets the lastModifiedDate of this Tasks to the specified value.
     * @param lastModifiedDate the new lastModifiedDate
     */
    public void setLastModifiedDate(Date lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    /**
     * Gets the taskId of this Tasks.
     * @return the taskId
     */
    public int getTaskId() {
        return this.taskId;
    }

    /**
     * Sets the taskId of this Tasks to the specified value.
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
     * Determines whether another object is equal to this Tasks.  The result is 
     * <code>true</code> if and only if the argument is not null and is a Tasks object that 
     * has the same id field values as this object.
     * @param object the reference object with which to compare
     * @return <code>true</code> if this object is the same as the argument;
     * <code>false</code> otherwise.
     */
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tasks)) {
            return false;
        }
        Tasks other = (Tasks)object;
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
        return "com.abbt.crm.entity.Tasks[id=" + id + "]";
    }

}
