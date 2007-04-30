/*
 * TimesheetStatus.java
 *
 * Created on April 29, 2007, 9:38 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package com.abbt.timesheet.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Entity class TimesheetStatus
 * 
 * @author shannan
 */
@Entity
@Table(name = "timesheet_status")
@NamedQueries( {
        @NamedQuery(name = "TimesheetStatus.findById", query = "SELECT t FROM TimesheetStatus t WHERE t.id = :id"),
        @NamedQuery(name = "TimesheetStatus.findByStatusKey", query = "SELECT t FROM TimesheetStatus t WHERE t.statusKey = :statusKey"),
        @NamedQuery(name = "TimesheetStatus.findByEditable", query = "SELECT t FROM TimesheetStatus t WHERE t.editable = :editable"),
        @NamedQuery(name = "TimesheetStatus.findByAssignedBy", query = "SELECT t FROM TimesheetStatus t WHERE t.assignedBy = :assignedBy"),
        @NamedQuery(name = "TimesheetStatus.findByComments", query = "SELECT t FROM TimesheetStatus t WHERE t.comments = :comments"),
        @NamedQuery(name = "TimesheetStatus.findByCreatedBy", query = "SELECT t FROM TimesheetStatus t WHERE t.createdBy = :createdBy"),
        @NamedQuery(name = "TimesheetStatus.findByCreatedDate", query = "SELECT t FROM TimesheetStatus t WHERE t.createdDate = :createdDate"),
        @NamedQuery(name = "TimesheetStatus.findByLastUpdatedBy", query = "SELECT t FROM TimesheetStatus t WHERE t.lastUpdatedBy = :lastUpdatedBy"),
        @NamedQuery(name = "TimesheetStatus.findByLastUpdatedDate", query = "SELECT t FROM TimesheetStatus t WHERE t.lastUpdatedDate = :lastUpdatedDate")
    })
public class TimesheetStatus implements Serializable {

    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "statusKey", nullable = false)
    private String statusKey;

    @Column(name = "editable", nullable = false)
    private boolean editable;

    @Column(name = "assignedBy", nullable = false)
    private String assignedBy;

    @Column(name = "comments")
    private String comments;

    @Column(name = "createdBy")
    private String createdBy;

    @Column(name = "createdDate")
    @Temporal(TemporalType.DATE)
    private Date createdDate;

    @Column(name = "lastUpdatedBy")
    private String lastUpdatedBy;

    @Column(name = "lastUpdatedDate")
    @Temporal(TemporalType.DATE)
    private Date lastUpdatedDate;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "status")
    private Collection<Timesheet> timesheetCollection;
    
    /** Creates a new instance of TimesheetStatus */
    public TimesheetStatus() {
    }

    /**
     * Creates a new instance of TimesheetStatus with the specified values.
     * @param id the id of the TimesheetStatus
     */
    public TimesheetStatus(Integer id) {
        this.id = id;
    }

    /**
     * Creates a new instance of TimesheetStatus with the specified values.
     * @param id the id of the TimesheetStatus
     * @param statusKey the statusKey of the TimesheetStatus
     * @param editable the editable of the TimesheetStatus
     * @param assignedBy the assignedBy of the TimesheetStatus
     */
    public TimesheetStatus(Integer id, String statusKey, boolean editable, String assignedBy) {
        this.id = id;
        this.statusKey = statusKey;
        this.editable = editable;
        this.assignedBy = assignedBy;
    }

    /**
     * Gets the id of this TimesheetStatus.
     * @return the id
     */
    public Integer getId() {
        return this.id;
    }

    /**
     * Sets the id of this TimesheetStatus to the specified value.
     * @param id the new id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Gets the statusKey of this TimesheetStatus.
     * @return the statusKey
     */
    public String getStatusKey() {
        return this.statusKey;
    }

    /**
     * Sets the statusKey of this TimesheetStatus to the specified value.
     * @param statusKey the new statusKey
     */
    public void setStatusKey(String statusKey) {
        this.statusKey = statusKey;
    }

    /**
     * Gets the editable of this TimesheetStatus.
     * @return the editable
     */
    public boolean getEditable() {
        return this.editable;
    }

    /**
     * Sets the editable of this TimesheetStatus to the specified value.
     * @param editable the new editable
     */
    public void setEditable(boolean editable) {
        this.editable = editable;
    }

    /**
     * Gets the assignedBy of this TimesheetStatus.
     * @return the assignedBy
     */
    public String getAssignedBy() {
        return this.assignedBy;
    }

    /**
     * Sets the assignedBy of this TimesheetStatus to the specified value.
     * @param assignedBy the new assignedBy
     */
    public void setAssignedBy(String assignedBy) {
        this.assignedBy = assignedBy;
    }

    /**
     * Gets the comments of this TimesheetStatus.
     * @return the comments
     */
    public String getComments() {
        return this.comments;
    }

    /**
     * Sets the comments of this TimesheetStatus to the specified value.
     * @param comments the new comments
     */
    public void setComments(String comments) {
        this.comments = comments;
    }

    /**
     * Gets the createdBy of this TimesheetStatus.
     * @return the createdBy
     */
    public String getCreatedBy() {
        return this.createdBy;
    }

    /**
     * Sets the createdBy of this TimesheetStatus to the specified value.
     * @param createdBy the new createdBy
     */
    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    /**
     * Gets the createdDate of this TimesheetStatus.
     * @return the createdDate
     */
    public Date getCreatedDate() {
        return this.createdDate;
    }

    /**
     * Sets the createdDate of this TimesheetStatus to the specified value.
     * @param createdDate the new createdDate
     */
    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    /**
     * Gets the lastUpdatedBy of this TimesheetStatus.
     * @return the lastUpdatedBy
     */
    public String getLastUpdatedBy() {
        return this.lastUpdatedBy;
    }

    /**
     * Sets the lastUpdatedBy of this TimesheetStatus to the specified value.
     * @param lastUpdatedBy the new lastUpdatedBy
     */
    public void setLastUpdatedBy(String lastUpdatedBy) {
        this.lastUpdatedBy = lastUpdatedBy;
    }

    /**
     * Gets the lastUpdatedDate of this TimesheetStatus.
     * @return the lastUpdatedDate
     */
    public Date getLastUpdatedDate() {
        return this.lastUpdatedDate;
    }

    /**
     * Sets the lastUpdatedDate of this TimesheetStatus to the specified value.
     * @param lastUpdatedDate the new lastUpdatedDate
     */
    public void setLastUpdatedDate(Date lastUpdatedDate) {
        this.lastUpdatedDate = lastUpdatedDate;
    }

    /**
     * Gets the timesheetCollection of this TimesheetStatus.
     * @return the timesheetCollection
     */
    public Collection<Timesheet> getTimesheetCollection() {
        return this.timesheetCollection;
    }

    /**
     * Sets the timesheetCollection of this TimesheetStatus to the specified value.
     * @param timesheetCollection the new timesheetCollection
     */
    public void setTimesheetCollection(Collection<Timesheet> timesheetCollection) {
        this.timesheetCollection = timesheetCollection;
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
     * Determines whether another object is equal to this TimesheetStatus.  The result is 
     * <code>true</code> if and only if the argument is not null and is a TimesheetStatus object that 
     * has the same id field values as this object.
     * @param object the reference object with which to compare
     * @return <code>true</code> if this object is the same as the argument;
     * <code>false</code> otherwise.
     */
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TimesheetStatus)) {
            return false;
        }
        TimesheetStatus other = (TimesheetStatus)object;
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
        return "com.abbt.timesheet.entities.TimesheetStatus[id=" + id + "]";
    }
    
}
