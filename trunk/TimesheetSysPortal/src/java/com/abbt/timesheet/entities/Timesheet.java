/*
 * Timesheet.java
 *
 * Created on May 2, 2007, 7:09 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package com.abbt.timesheet.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Entity class Timesheet
 * 
 * @author shannan
 */
@Entity
@Table(name = "timesheet")
@NamedQueries( {
        @NamedQuery(name = "Timesheet.findById", query = "SELECT t FROM Timesheet t WHERE t.id = :id"),
        @NamedQuery(name = "Timesheet.findByTimesheetDate", query = "SELECT t FROM Timesheet t WHERE t.timesheetDate = :timesheetDate"),
        @NamedQuery(name = "Timesheet.findByDaysFor", query = "SELECT t FROM Timesheet t WHERE t.daysFor = :daysFor"),
        @NamedQuery(name = "Timesheet.findByCreatedBy", query = "SELECT t FROM Timesheet t WHERE t.createdBy = :createdBy"),
        @NamedQuery(name = "Timesheet.findByCreatedDate", query = "SELECT t FROM Timesheet t WHERE t.createdDate = :createdDate"),
        @NamedQuery(name = "Timesheet.findByLastUpdatedBy", query = "SELECT t FROM Timesheet t WHERE t.lastUpdatedBy = :lastUpdatedBy"),
        @NamedQuery(name = "Timesheet.findByLastUpdatedDate", query = "SELECT t FROM Timesheet t WHERE t.lastUpdatedDate = :lastUpdatedDate")
    })
public class Timesheet implements Serializable {

    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "timesheetDate", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date timesheetDate;

    @Column(name = "daysFor", nullable = false)
    private int daysFor;

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

    @OneToMany(mappedBy = "timesheetId")
    private Collection<TimesheetDetail> timesheetDetailCollection;

    @JoinColumn(name = "userEmail", referencedColumnName = "email")
    @ManyToOne
    private User userEmail;

    @JoinColumn(name = "clientCompany", referencedColumnName = "id")
    @ManyToOne
    private UserCompany clientCompany;

    @JoinColumn(name = "status", referencedColumnName = "id")
    @ManyToOne
    private TimesheetStatus status;
    
    /** Creates a new instance of Timesheet */
    public Timesheet() {
    }

    /**
     * Creates a new instance of Timesheet with the specified values.
     * @param id the id of the Timesheet
     */
    public Timesheet(Integer id) {
        this.id = id;
    }

    /**
     * Creates a new instance of Timesheet with the specified values.
     * @param id the id of the Timesheet
     * @param timesheetDate the timesheetDate of the Timesheet
     * @param daysFor the daysFor of the Timesheet
     */
    public Timesheet(Integer id, Date timesheetDate, int daysFor) {
        this.id = id;
        this.timesheetDate = timesheetDate;
        this.daysFor = daysFor;
    }

    /**
     * Gets the id of this Timesheet.
     * @return the id
     */
    public Integer getId() {
        return this.id;
    }

    /**
     * Sets the id of this Timesheet to the specified value.
     * @param id the new id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Gets the timesheetDate of this Timesheet.
     * @return the timesheetDate
     */
    public Date getTimesheetDate() {
        return this.timesheetDate;
    }

    /**
     * Sets the timesheetDate of this Timesheet to the specified value.
     * @param timesheetDate the new timesheetDate
     */
    public void setTimesheetDate(Date timesheetDate) {
        this.timesheetDate = timesheetDate;
    }

    /**
     * Gets the daysFor of this Timesheet.
     * @return the daysFor
     */
    public int getDaysFor() {
        return this.daysFor;
    }

    /**
     * Sets the daysFor of this Timesheet to the specified value.
     * @param daysFor the new daysFor
     */
    public void setDaysFor(int daysFor) {
        this.daysFor = daysFor;
    }

    /**
     * Gets the createdBy of this Timesheet.
     * @return the createdBy
     */
    public String getCreatedBy() {
        return this.createdBy;
    }

    /**
     * Sets the createdBy of this Timesheet to the specified value.
     * @param createdBy the new createdBy
     */
    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    /**
     * Gets the createdDate of this Timesheet.
     * @return the createdDate
     */
    public Date getCreatedDate() {
        return this.createdDate;
    }

    /**
     * Sets the createdDate of this Timesheet to the specified value.
     * @param createdDate the new createdDate
     */
    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    /**
     * Gets the lastUpdatedBy of this Timesheet.
     * @return the lastUpdatedBy
     */
    public String getLastUpdatedBy() {
        return this.lastUpdatedBy;
    }

    /**
     * Sets the lastUpdatedBy of this Timesheet to the specified value.
     * @param lastUpdatedBy the new lastUpdatedBy
     */
    public void setLastUpdatedBy(String lastUpdatedBy) {
        this.lastUpdatedBy = lastUpdatedBy;
    }

    /**
     * Gets the lastUpdatedDate of this Timesheet.
     * @return the lastUpdatedDate
     */
    public Date getLastUpdatedDate() {
        return this.lastUpdatedDate;
    }

    /**
     * Sets the lastUpdatedDate of this Timesheet to the specified value.
     * @param lastUpdatedDate the new lastUpdatedDate
     */
    public void setLastUpdatedDate(Date lastUpdatedDate) {
        this.lastUpdatedDate = lastUpdatedDate;
    }

    /**
     * Gets the timesheetDetailCollection of this Timesheet.
     * @return the timesheetDetailCollection
     */
    public Collection<TimesheetDetail> getTimesheetDetailCollection() {
        return this.timesheetDetailCollection;
    }

    /**
     * Sets the timesheetDetailCollection of this Timesheet to the specified value.
     * @param timesheetDetailCollection the new timesheetDetailCollection
     */
    public void setTimesheetDetailCollection(Collection<TimesheetDetail> timesheetDetailCollection) {
        this.timesheetDetailCollection = timesheetDetailCollection;
    }

    /**
     * Gets the userEmail of this Timesheet.
     * @return the userEmail
     */
    public User getUserEmail() {
        return this.userEmail;
    }

    /**
     * Sets the userEmail of this Timesheet to the specified value.
     * @param userEmail the new userEmail
     */
    public void setUserEmail(User userEmail) {
        this.userEmail = userEmail;
    }

    /**
     * Gets the clientCompany of this Timesheet.
     * @return the clientCompany
     */
    public UserCompany getClientCompany() {
        return this.clientCompany;
    }

    /**
     * Sets the clientCompany of this Timesheet to the specified value.
     * @param clientCompany the new clientCompany
     */
    public void setClientCompany(UserCompany clientCompany) {
        this.clientCompany = clientCompany;
    }

    /**
     * Gets the status of this Timesheet.
     * @return the status
     */
    public TimesheetStatus getStatus() {
        return this.status;
    }

    /**
     * Sets the status of this Timesheet to the specified value.
     * @param status the new status
     */
    public void setStatus(TimesheetStatus status) {
        this.status = status;
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
     * Determines whether another object is equal to this Timesheet.  The result is 
     * <code>true</code> if and only if the argument is not null and is a Timesheet object that 
     * has the same id field values as this object.
     * @param object the reference object with which to compare
     * @return <code>true</code> if this object is the same as the argument;
     * <code>false</code> otherwise.
     */
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Timesheet)) {
            return false;
        }
        Timesheet other = (Timesheet)object;
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
        return "com.abbt.timesheet.entities.Timesheet[id=" + id + "]";
    }
    
}
