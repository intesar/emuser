/*
 * TasksActivity.java
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
 * Entity class TasksActivity
 * 
 * @author Mohammed Hamed
 */
@Entity
@Table(name = "tasks_activity")
@NamedQueries( {
        @NamedQuery(name = "TasksActivity.findById", query = "SELECT t FROM TasksActivity t WHERE t.id = :id"),
        @NamedQuery(name = "TasksActivity.findByVersion", query = "SELECT t FROM TasksActivity t WHERE t.version = :version"),
        @NamedQuery(name = "TasksActivity.findByActivity", query = "SELECT t FROM TasksActivity t WHERE t.activity = :activity"),
        @NamedQuery(name = "TasksActivity.findByCreationDate", query = "SELECT t FROM TasksActivity t WHERE t.creationDate = :creationDate"),
        @NamedQuery(name = "TasksActivity.findByCreatedUser", query = "SELECT t FROM TasksActivity t WHERE t.createdUser = :createdUser"),
        @NamedQuery(name = "TasksActivity.findByLastModifiedDate", query = "SELECT t FROM TasksActivity t WHERE t.lastModifiedDate = :lastModifiedDate"),
        @NamedQuery(name = "TasksActivity.findByLastModifiedUser", query = "SELECT t FROM TasksActivity t WHERE t.lastModifiedUser = :lastModifiedUser")
    })
public class TasksActivity implements Serializable {

    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "version", nullable = false)
    private int version;

    @Column(name = "activity", nullable = false)
    private String activity;

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
    
    /** Creates a new instance of TasksActivity */
    public TasksActivity() {
    }

    /**
     * Creates a new instance of TasksActivity with the specified values.
     * @param id the id of the TasksActivity
     */
    public TasksActivity(Integer id) {
        this.id = id;
    }

    /**
     * Creates a new instance of TasksActivity with the specified values.
     * @param id the id of the TasksActivity
     * @param version the version of the TasksActivity
     * @param activity the activity of the TasksActivity
     * @param createdUser the createdUser of the TasksActivity
     * @param lastModifiedUser the lastModifiedUser of the TasksActivity
     */
    public TasksActivity(Integer id, int version, String activity, String createdUser, String lastModifiedUser) {
        this.id = id;
        this.version = version;
        this.activity = activity;
        this.createdUser = createdUser;
        this.lastModifiedUser = lastModifiedUser;
    }

    /**
     * Gets the id of this TasksActivity.
     * @return the id
     */
    public Integer getId() {
        return this.id;
    }

    /**
     * Sets the id of this TasksActivity to the specified value.
     * @param id the new id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Gets the version of this TasksActivity.
     * @return the version
     */
    public int getVersion() {
        return this.version;
    }

    /**
     * Sets the version of this TasksActivity to the specified value.
     * @param version the new version
     */
    public void setVersion(int version) {
        this.version = version;
    }

    /**
     * Gets the activity of this TasksActivity.
     * @return the activity
     */
    public String getActivity() {
        return this.activity;
    }

    /**
     * Sets the activity of this TasksActivity to the specified value.
     * @param activity the new activity
     */
    public void setActivity(String activity) {
        this.activity = activity;
    }

    /**
     * Gets the creationDate of this TasksActivity.
     * @return the creationDate
     */
    public Date getCreationDate() {
        return this.creationDate;
    }

    /**
     * Sets the creationDate of this TasksActivity to the specified value.
     * @param creationDate the new creationDate
     */
    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    /**
     * Gets the createdUser of this TasksActivity.
     * @return the createdUser
     */
    public String getCreatedUser() {
        return this.createdUser;
    }

    /**
     * Sets the createdUser of this TasksActivity to the specified value.
     * @param createdUser the new createdUser
     */
    public void setCreatedUser(String createdUser) {
        this.createdUser = createdUser;
    }

    /**
     * Gets the lastModifiedDate of this TasksActivity.
     * @return the lastModifiedDate
     */
    public Date getLastModifiedDate() {
        return this.lastModifiedDate;
    }

    /**
     * Sets the lastModifiedDate of this TasksActivity to the specified value.
     * @param lastModifiedDate the new lastModifiedDate
     */
    public void setLastModifiedDate(Date lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    /**
     * Gets the lastModifiedUser of this TasksActivity.
     * @return the lastModifiedUser
     */
    public String getLastModifiedUser() {
        return this.lastModifiedUser;
    }

    /**
     * Sets the lastModifiedUser of this TasksActivity to the specified value.
     * @param lastModifiedUser the new lastModifiedUser
     */
    public void setLastModifiedUser(String lastModifiedUser) {
        this.lastModifiedUser = lastModifiedUser;
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
     * Determines whether another object is equal to this TasksActivity.  The result is 
     * <code>true</code> if and only if the argument is not null and is a TasksActivity object that 
     * has the same id field values as this object.
     * @param object the reference object with which to compare
     * @return <code>true</code> if this object is the same as the argument;
     * <code>false</code> otherwise.
     */
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TasksActivity)) {
            return false;
        }
        TasksActivity other = (TasksActivity)object;
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
        return "com.abbt.crm.base.entity.TasksActivity[id=" + id + "]";
    }
    
}
