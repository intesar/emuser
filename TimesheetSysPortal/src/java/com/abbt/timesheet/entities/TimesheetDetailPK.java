/*
 * TimesheetDetailPK.java
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
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Primary Key class TimesheetDetailPK for entity class TimesheetDetail
 * 
 * @author shannan
 */
@Embeddable
public class TimesheetDetailPK implements Serializable {

    @Column(name = "timesheetId", nullable = false)
    private int timesheetId;

    @Column(name = "timesheetDate", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date timesheetDate;
    
    /** Creates a new instance of TimesheetDetailPK */
    public TimesheetDetailPK() {
    }

    /**
     * Creates a new instance of TimesheetDetailPK with the specified values.
     * @param timesheetDate the timesheetDate of the TimesheetDetailPK
     * @param timesheetId the timesheetId of the TimesheetDetailPK
     */
    public TimesheetDetailPK(Date timesheetDate, int timesheetId) {
        this.timesheetDate = timesheetDate;
        this.timesheetId = timesheetId;
    }

    /**
     * Gets the timesheetId of this TimesheetDetailPK.
     * @return the timesheetId
     */
    public int getTimesheetId() {
        return this.timesheetId;
    }

    /**
     * Sets the timesheetId of this TimesheetDetailPK to the specified value.
     * @param timesheetId the new timesheetId
     */
    public void setTimesheetId(int timesheetId) {
        this.timesheetId = timesheetId;
    }

    /**
     * Gets the timesheetDate of this TimesheetDetailPK.
     * @return the timesheetDate
     */
    public Date getTimesheetDate() {
        return this.timesheetDate;
    }

    /**
     * Sets the timesheetDate of this TimesheetDetailPK to the specified value.
     * @param timesheetDate the new timesheetDate
     */
    public void setTimesheetDate(Date timesheetDate) {
        this.timesheetDate = timesheetDate;
    }

    /**
     * Returns a hash code value for the object.  This implementation computes 
     * a hash code value based on the id fields in this object.
     * @return a hash code value for this object.
     */
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (this.timesheetDate != null ? this.timesheetDate.hashCode() : 0);
        hash += (int)timesheetId;
        return hash;
    }

    /**
     * Determines whether another object is equal to this TimesheetDetailPK.  The result is 
     * <code>true</code> if and only if the argument is not null and is a TimesheetDetailPK object that 
     * has the same id field values as this object.
     * @param object the reference object with which to compare
     * @return <code>true</code> if this object is the same as the argument;
     * <code>false</code> otherwise.
     */
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TimesheetDetailPK)) {
            return false;
        }
        TimesheetDetailPK other = (TimesheetDetailPK)object;
        if (this.timesheetDate != other.timesheetDate && (this.timesheetDate == null || !this.timesheetDate.equals(other.timesheetDate))) return false;
        if (this.timesheetId != other.timesheetId) return false;
        return true;
    }

    /**
     * Returns a string representation of the object.  This implementation constructs 
     * that representation based on the id fields.
     * @return a string representation of the object.
     */
    @Override
    public String toString() {
        return "com.abbt.timesheet.entities.TimesheetDetailPK[timesheetDate=" + timesheetDate + ", timesheetId=" + timesheetId + "]";
    }
    
}
