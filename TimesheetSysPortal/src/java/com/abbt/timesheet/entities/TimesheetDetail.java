/*
 * TimesheetDetail.java
 *
 * Created on May 2, 2007, 7:09 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package com.abbt.timesheet.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
        @NamedQuery(name = "TimesheetDetail.findByRegularHours", query = "SELECT t FROM TimesheetDetail t WHERE t.regularHours = :regularHours"),
        @NamedQuery(name = "TimesheetDetail.findByOverTimeHours", query = "SELECT t FROM TimesheetDetail t WHERE t.overTimeHours = :overTimeHours"),
        @NamedQuery(name = "TimesheetDetail.findByComments", query = "SELECT t FROM TimesheetDetail t WHERE t.comments = :comments"),
        @NamedQuery(name = "TimesheetDetail.findByCreatedBy", query = "SELECT t FROM TimesheetDetail t WHERE t.createdBy = :createdBy"),
        @NamedQuery(name = "TimesheetDetail.findByCreatedDate", query = "SELECT t FROM TimesheetDetail t WHERE t.createdDate = :createdDate"),
        @NamedQuery(name = "TimesheetDetail.findByLastUpdatedBy", query = "SELECT t FROM TimesheetDetail t WHERE t.lastUpdatedBy = :lastUpdatedBy"),
        @NamedQuery(name = "TimesheetDetail.findByLastUpdatedDate", query = "SELECT t FROM TimesheetDetail t WHERE t.lastUpdatedDate = :lastUpdatedDate"),
        @NamedQuery(name = "TimesheetDetail.findById", query = "SELECT t FROM TimesheetDetail t WHERE t.id = :id"),
        @NamedQuery(name = "TimesheetDetail.findByTimesheetDate", query = "SELECT t FROM TimesheetDetail t WHERE t.timesheetDate = :timesheetDate"),
        @NamedQuery(name = "TimesheetDetail.findByTimesheetUser", query = "SELECT t FROM TimesheetDetail t WHERE t.timesheetUser = :timesheetUser"),
        @NamedQuery(name = "TimesheetDetail.findByTimesheetDetailDate", query = "SELECT t FROM TimesheetDetail t WHERE t.timesheetDetailDate = :timesheetDetailDate"),
        @NamedQuery(name = "TimesheetDetail.findByVid", query = "SELECT t FROM TimesheetDetail t WHERE t.vid = :vid"),
        @NamedQuery(name = "TimesheetDetail.findByEnabled", query = "SELECT t FROM TimesheetDetail t WHERE t.enabled = :enabled"),
        @NamedQuery(name = "TimesheetDetail.findByDay", query = "SELECT t FROM TimesheetDetail t WHERE t.day = :day")
    })
public class TimesheetDetail implements Serializable {

    @Column(name = "regularHours")
    private Double regularHours;

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

    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "timesheetDate", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date timesheetDate;

    @Column(name = "timesheetUser", nullable = false)
    private String timesheetUser;

    @Column(name = "timesheetDetailDate", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date timesheetDetailDate;

    @Column(name = "vid")
    private Integer vid;

    @Column(name = "enabled")
    private Boolean enabled;

    @Column(name = "day")
    private String day;

    @JoinColumn(name = "timesheetId", referencedColumnName = "id")
    @ManyToOne
    private Timesheet timesheetId;
    
    /** Creates a new instance of TimesheetDetail */
    public TimesheetDetail() {
    }

    /**
     * Creates a new instance of TimesheetDetail with the specified values.
     * @param id the id of the TimesheetDetail
     */
    public TimesheetDetail(Integer id) {
        this.id = id;
    }

    /**
     * Creates a new instance of TimesheetDetail with the specified values.
     * @param id the id of the TimesheetDetail
     * @param timesheetDate the timesheetDate of the TimesheetDetail
     * @param timesheetUser the timesheetUser of the TimesheetDetail
     * @param timesheetDetailDate the timesheetDetailDate of the TimesheetDetail
     */
    public TimesheetDetail(Integer id, Date timesheetDate, String timesheetUser, Date timesheetDetailDate) {
        this.id = id;
        this.timesheetDate = timesheetDate;
        this.timesheetUser = timesheetUser;
        this.timesheetDetailDate = timesheetDetailDate;
    }

    /**
     * Gets the regularHours of this TimesheetDetail.
     * @return the regularHours
     */
    public Double getRegularHours() {
        return this.regularHours;
    }

    /**
     * Sets the regularHours of this TimesheetDetail to the specified value.
     * @param regularHours the new regularHours
     */
    public void setRegularHours(Double regularHours) {
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
     * Gets the timesheetDate of this TimesheetDetail.
     * @return the timesheetDate
     */
    public Date getTimesheetDate() {
        return this.timesheetDate;
    }

    /**
     * Sets the timesheetDate of this TimesheetDetail to the specified value.
     * @param timesheetDate the new timesheetDate
     */
    public void setTimesheetDate(Date timesheetDate) {
        this.timesheetDate = timesheetDate;
    }

    /**
     * Gets the timesheetUser of this TimesheetDetail.
     * @return the timesheetUser
     */
    public String getTimesheetUser() {
        return this.timesheetUser;
    }

    /**
     * Sets the timesheetUser of this TimesheetDetail to the specified value.
     * @param timesheetUser the new timesheetUser
     */
    public void setTimesheetUser(String timesheetUser) {
        this.timesheetUser = timesheetUser;
    }

    /**
     * Gets the timesheetDetailDate of this TimesheetDetail.
     * @return the timesheetDetailDate
     */
    public Date getTimesheetDetailDate() {
        return this.timesheetDetailDate;
    }

    /**
     * Sets the timesheetDetailDate of this TimesheetDetail to the specified value.
     * @param timesheetDetailDate the new timesheetDetailDate
     */
    public void setTimesheetDetailDate(Date timesheetDetailDate) {
        this.timesheetDetailDate = timesheetDetailDate;
    }

    /**
     * Gets the vid of this TimesheetDetail.
     * @return the vid
     */
    public Integer getVid() {
        return this.vid;
    }

    /**
     * Sets the vid of this TimesheetDetail to the specified value.
     * @param vid the new vid
     */
    public void setVid(Integer vid) {
        this.vid = vid;
    }

    /**
     * Gets the enabled of this TimesheetDetail.
     * @return the enabled
     */
    public Boolean getEnabled() {
        return this.enabled;
    }

    /**
     * Sets the enabled of this TimesheetDetail to the specified value.
     * @param enabled the new enabled
     */
    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    /**
     * Gets the day of this TimesheetDetail.
     * @return the day
     */
    public String getDay() {
        return this.day;
    }

    /**
     * Sets the day of this TimesheetDetail to the specified value.
     * @param day the new day
     */
    public void setDay(String day) {
        this.day = day;
    }

    /**
     * Gets the timesheetId of this TimesheetDetail.
     * @return the timesheetId
     */
    public Timesheet getTimesheetId() {
        return this.timesheetId;
    }

    /**
     * Sets the timesheetId of this TimesheetDetail to the specified value.
     * @param timesheetId the new timesheetId
     */
    public void setTimesheetId(Timesheet timesheetId) {
        this.timesheetId = timesheetId;
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
        return "com.abbt.timesheet.entities.TimesheetDetail[id=" + id + "]";
    }
    
}
