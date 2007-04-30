/*
 * TimesheetStatusHistory.java
 *
 * Created on April 29, 2007, 9:38 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package com.abbt.timesheet.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * Entity class TimesheetStatusHistory
 * 
 * @author shannan
 */
@Entity
@Table(name = "timesheet_status_history")
@NamedQueries( {
        @NamedQuery(name = "TimesheetStatusHistory.findById", query = "SELECT t FROM TimesheetStatusHistory t WHERE t.id = :id"),
        @NamedQuery(name = "TimesheetStatusHistory.findByTimesheetId", query = "SELECT t FROM TimesheetStatusHistory t WHERE t.timesheetId = :timesheetId"),
        @NamedQuery(name = "TimesheetStatusHistory.findByStatusKey", query = "SELECT t FROM TimesheetStatusHistory t WHERE t.statusKey = :statusKey"),
        @NamedQuery(name = "TimesheetStatusHistory.findByAssignedUser", query = "SELECT t FROM TimesheetStatusHistory t WHERE t.assignedUser = :assignedUser"),
        @NamedQuery(name = "TimesheetStatusHistory.findByComments", query = "SELECT t FROM TimesheetStatusHistory t WHERE t.comments = :comments")
    })
public class TimesheetStatusHistory implements Serializable {

    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "timesheetId", nullable = false)
    private int timesheetId;

    @Column(name = "statusKey", nullable = false)
    private String statusKey;

    @Column(name = "assignedUser")
    private String assignedUser;

    @Column(name = "comments")
    private String comments;
    
    /** Creates a new instance of TimesheetStatusHistory */
    public TimesheetStatusHistory() {
    }

    /**
     * Creates a new instance of TimesheetStatusHistory with the specified values.
     * @param id the id of the TimesheetStatusHistory
     */
    public TimesheetStatusHistory(Integer id) {
        this.id = id;
    }

    /**
     * Creates a new instance of TimesheetStatusHistory with the specified values.
     * @param id the id of the TimesheetStatusHistory
     * @param timesheetId the timesheetId of the TimesheetStatusHistory
     * @param statusKey the statusKey of the TimesheetStatusHistory
     */
    public TimesheetStatusHistory(Integer id, int timesheetId, String statusKey) {
        this.id = id;
        this.timesheetId = timesheetId;
        this.statusKey = statusKey;
    }

    /**
     * Gets the id of this TimesheetStatusHistory.
     * @return the id
     */
    public Integer getId() {
        return this.id;
    }

    /**
     * Sets the id of this TimesheetStatusHistory to the specified value.
     * @param id the new id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Gets the timesheetId of this TimesheetStatusHistory.
     * @return the timesheetId
     */
    public int getTimesheetId() {
        return this.timesheetId;
    }

    /**
     * Sets the timesheetId of this TimesheetStatusHistory to the specified value.
     * @param timesheetId the new timesheetId
     */
    public void setTimesheetId(int timesheetId) {
        this.timesheetId = timesheetId;
    }

    /**
     * Gets the statusKey of this TimesheetStatusHistory.
     * @return the statusKey
     */
    public String getStatusKey() {
        return this.statusKey;
    }

    /**
     * Sets the statusKey of this TimesheetStatusHistory to the specified value.
     * @param statusKey the new statusKey
     */
    public void setStatusKey(String statusKey) {
        this.statusKey = statusKey;
    }

    /**
     * Gets the assignedUser of this TimesheetStatusHistory.
     * @return the assignedUser
     */
    public String getAssignedUser() {
        return this.assignedUser;
    }

    /**
     * Sets the assignedUser of this TimesheetStatusHistory to the specified value.
     * @param assignedUser the new assignedUser
     */
    public void setAssignedUser(String assignedUser) {
        this.assignedUser = assignedUser;
    }

    /**
     * Gets the comments of this TimesheetStatusHistory.
     * @return the comments
     */
    public String getComments() {
        return this.comments;
    }

    /**
     * Sets the comments of this TimesheetStatusHistory to the specified value.
     * @param comments the new comments
     */
    public void setComments(String comments) {
        this.comments = comments;
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
     * Determines whether another object is equal to this TimesheetStatusHistory.  The result is 
     * <code>true</code> if and only if the argument is not null and is a TimesheetStatusHistory object that 
     * has the same id field values as this object.
     * @param object the reference object with which to compare
     * @return <code>true</code> if this object is the same as the argument;
     * <code>false</code> otherwise.
     */
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TimesheetStatusHistory)) {
            return false;
        }
        TimesheetStatusHistory other = (TimesheetStatusHistory)object;
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
        return "com.abbt.timesheet.entities.TimesheetStatusHistory[id=" + id + "]";
    }
    
}
