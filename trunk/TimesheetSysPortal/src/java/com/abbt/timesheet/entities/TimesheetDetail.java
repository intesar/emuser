/*
 * TimesheetDetail.java
 *
 * Created on April 29, 2007, 9:38 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package com.abbt.timesheet.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Entity class TimesheetDetail
 * 
 * @author shannan
 */
@Entity
@Table(name = "timesheet_detail")
@NamedQueries( {
        @NamedQuery(name = "TimesheetDetail.findByTimesheetId", query = "SELECT t FROM TimesheetDetail t WHERE t.timesheetDetailPK.timesheetId = :timesheetId"),
        @NamedQuery(name = "TimesheetDetail.findByTimesheetDate", query = "SELECT t FROM TimesheetDetail t WHERE t.timesheetDetailPK.timesheetDate = :timesheetDate"),
        @NamedQuery(name = "TimesheetDetail.findByRegularHours", query = "SELECT t FROM TimesheetDetail t WHERE t.regularHours = :regularHours"),
        @NamedQuery(name = "TimesheetDetail.findByOverTimeHours", query = "SELECT t FROM TimesheetDetail t WHERE t.overTimeHours = :overTimeHours"),
        @NamedQuery(name = "TimesheetDetail.findByComments", query = "SELECT t FROM TimesheetDetail t WHERE t.comments = :comments"),
        @NamedQuery(name = "TimesheetDetail.findByCreatedBy", query = "SELECT t FROM TimesheetDetail t WHERE t.createdBy = :createdBy"),
        @NamedQuery(name = "TimesheetDetail.findByCreatedDate", query = "SELECT t FROM TimesheetDetail t WHERE t.createdDate = :createdDate"),
        @NamedQuery(name = "TimesheetDetail.findByLastUpdatedBy", query = "SELECT t FROM TimesheetDetail t WHERE t.lastUpdatedBy = :lastUpdatedBy"),
        @NamedQuery(name = "TimesheetDetail.findByLastUpdatedDate", query = "SELECT t FROM TimesheetDetail t WHERE t.lastUpdatedDate = :lastUpdatedDate"),
        @NamedQuery(name = "TimesheetDetail.findById", query = "SELECT t FROM TimesheetDetail t WHERE t.id = :id")
    })
public class TimesheetDetail implements Serializable {

    /**
     * EmbeddedId primary key field
     */
    @EmbeddedId
    protected TimesheetDetailPK timesheetDetailPK;

    @Column(name = "regularHours", nullable = false)
    private double regularHours;

    @Column(name = "overTimeHours")
    private Double overTimeHours;

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

    @Column(name = "id")
    private Integer id;

    @JoinColumn(name = "timesheetId", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne
    private Timesheet timesheet;
    
    /** Creates a new instance of TimesheetDetail */
    public TimesheetDetail() {
    }

    /**
     * Creates a new instance of TimesheetDetail with the specified values.
     * @param timesheetDetailPK the timesheetDetailPK of the TimesheetDetail
     */
    public TimesheetDetail(TimesheetDetailPK timesheetDetailPK) {
        this.timesheetDetailPK = timesheetDetailPK;
    }

    /**
     * Creates a new instance of TimesheetDetail with the specified values.
     * @param timesheetDetailPK the timesheetDetailPK of the TimesheetDetail
     * @param regularHours the regularHours of the TimesheetDetail
     */
    public TimesheetDetail(TimesheetDetailPK timesheetDetailPK, double regularHours) {
        this.timesheetDetailPK = timesheetDetailPK;
        this.regularHours = regularHours;
    }

    /**
     * Creates a new instance of TimesheetDetailPK with the specified values.
     * @param timesheetDate the timesheetDate of the TimesheetDetailPK
     * @param timesheetId the timesheetId of the TimesheetDetailPK
     */
    public TimesheetDetail(Date timesheetDate, int timesheetId) {
        this.timesheetDetailPK = new TimesheetDetailPK(timesheetDate, timesheetId);
    }

    /**
     * Gets the timesheetDetailPK of this TimesheetDetail.
     * @return the timesheetDetailPK
     */
    public TimesheetDetailPK getTimesheetDetailPK() {
        return this.timesheetDetailPK;
    }

    /**
     * Sets the timesheetDetailPK of this TimesheetDetail to the specified value.
     * @param timesheetDetailPK the new timesheetDetailPK
     */
    public void setTimesheetDetailPK(TimesheetDetailPK timesheetDetailPK) {
        this.timesheetDetailPK = timesheetDetailPK;
    }

    /**
     * Gets the regularHours of this TimesheetDetail.
     * @return the regularHours
     */
    public double getRegularHours() {
        return this.regularHours;
    }

    /**
     * Sets the regularHours of this TimesheetDetail to the specified value.
     * @param regularHours the new regularHours
     */
    public void setRegularHours(double regularHours) {
        this.regularHours = regularHours;
    }

    /**
     * Gets the overTimeHours of this TimesheetDetail.
     * @return the overTimeHours
     */
    public Double getOverTimeHours() {
        return this.overTimeHours;
    }

    /**
     * Sets the overTimeHours of this TimesheetDetail to the specified value.
     * @param overTimeHours the new overTimeHours
     */
    public void setOverTimeHours(Double overTimeHours) {
        this.overTimeHours = overTimeHours;
    }

    /**
     * Gets the comments of this TimesheetDetail.
     * @return the comments
     */
    public String getComments() {
        return this.comments;
    }

    /**
     * Sets the comments of this TimesheetDetail to the specified value.
     * @param comments the new comments
     */
    public void setComments(String comments) {
        this.comments = comments;
    }

    /**
     * Gets the createdBy of this TimesheetDetail.
     * @return the createdBy
     */
    public String getCreatedBy() {
        return this.createdBy;
    }

    /**
     * Sets the createdBy of this TimesheetDetail to the specified value.
     * @param createdBy the new createdBy
     */
    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    /**
     * Gets the createdDate of this TimesheetDetail.
     * @return the createdDate
     */
    public Date getCreatedDate() {
        return this.createdDate;
    }

    /**
     * Sets the createdDate of this TimesheetDetail to the specified value.
     * @param createdDate the new createdDate
     */
    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    /**
     * Gets the lastUpdatedBy of this TimesheetDetail.
     * @return the lastUpdatedBy
     */
    public String getLastUpdatedBy() {
        return this.lastUpdatedBy;
    }

    /**
     * Sets the lastUpdatedBy of this TimesheetDetail to the specified value.
     * @param lastUpdatedBy the new lastUpdatedBy
     */
    public void setLastUpdatedBy(String lastUpdatedBy) {
        this.lastUpdatedBy = lastUpdatedBy;
    }

    /**
     * Gets the lastUpdatedDate of this TimesheetDetail.
     * @return the lastUpdatedDate
     */
    public Date getLastUpdatedDate() {
        return this.lastUpdatedDate;
    }

    /**
     * Sets the lastUpdatedDate of this TimesheetDetail to the specified value.
     * @param lastUpdatedDate the new lastUpdatedDate
     */
    public void setLastUpdatedDate(Date lastUpdatedDate) {
        this.lastUpdatedDate = lastUpdatedDate;
    }

    /**
     * Gets the id of this TimesheetDetail.
     * @return the id
     */
    public Integer getId() {
        return this.id;
    }

    /**
     * Sets the id of this TimesheetDetail to the specified value.
     * @param id the new id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Gets the timesheet of this TimesheetDetail.
     * @return the timesheet
     */
    public Timesheet getTimesheet() {
        return this.timesheet;
    }

    /**
     * Sets the timesheet of this TimesheetDetail to the specified value.
     * @param timesheet the new timesheet
     */
    public void setTimesheet(Timesheet timesheet) {
        this.timesheet = timesheet;
    }

    /**
     * Returns a hash code value for the object.  This implementation computes 
     * a hash code value based on the id fields in this object.
     * @return a hash code value for this object.
     */
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (this.timesheetDetailPK != null ? this.timesheetDetailPK.hashCode() : 0);
        return hash;
    }

    /**
     * Determines whether another object is equal to this TimesheetDetail.  The result is 
     * <code>true</code> if and only if the argument is not null and is a TimesheetDetail object that 
     * has the same id field values as this object.
     * @param object the reference object with which to compare
     * @return <code>true</code> if this object is the same as the argument;
     * <code>false</code> otherwise.
     */
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TimesheetDetail)) {
            return false;
        }
        TimesheetDetail other = (TimesheetDetail)object;
        if (this.timesheetDetailPK != other.timesheetDetailPK && (this.timesheetDetailPK == null || !this.timesheetDetailPK.equals(other.timesheetDetailPK))) return false;
        return true;
    }

    /**
     * Returns a string representation of the object.  This implementation constructs 
     * that representation based on the id fields.
     * @return a string representation of the object.
     */
    @Override
    public String toString() {
        return "com.abbt.timesheet.entities.TimesheetDetail[timesheetDetailPK=" + timesheetDetailPK + "]";
    }
    
}
