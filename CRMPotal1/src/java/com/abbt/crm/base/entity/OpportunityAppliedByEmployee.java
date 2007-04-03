/*
 * OpportunityAppliedByEmployee.java
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
 * Entity class OpportunityAppliedByEmployee
 * 
 * @author shannan
 */
@Entity
@Table(name = "opportunity_applied_by_employee")
@NamedQueries( {
        @NamedQuery(name = "OpportunityAppliedByEmployee.findById", query = "SELECT o FROM OpportunityAppliedByEmployee o WHERE o.id = :id"),
        @NamedQuery(name = "OpportunityAppliedByEmployee.findByVersionId", query = "SELECT o FROM OpportunityAppliedByEmployee o WHERE o.versionId = :versionId"),
        @NamedQuery(name = "OpportunityAppliedByEmployee.findByOpportunityId", query = "SELECT o FROM OpportunityAppliedByEmployee o WHERE o.opportunityId = :opportunityId"),
        @NamedQuery(name = "OpportunityAppliedByEmployee.findByEmployeeUserName", query = "SELECT o FROM OpportunityAppliedByEmployee o WHERE o.employeeUserName = :employeeUserName"),
        @NamedQuery(name = "OpportunityAppliedByEmployee.findByTimeStamp", query = "SELECT o FROM OpportunityAppliedByEmployee o WHERE o.timeStamp = :timeStamp"),
        @NamedQuery(name = "OpportunityAppliedByEmployee.findByCreationDate", query = "SELECT o FROM OpportunityAppliedByEmployee o WHERE o.creationDate = :creationDate"),
        @NamedQuery(name = "OpportunityAppliedByEmployee.findByCreatedUser", query = "SELECT o FROM OpportunityAppliedByEmployee o WHERE o.createdUser = :createdUser"),
        @NamedQuery(name = "OpportunityAppliedByEmployee.findByLastModifiedDate", query = "SELECT o FROM OpportunityAppliedByEmployee o WHERE o.lastModifiedDate = :lastModifiedDate"),
        @NamedQuery(name = "OpportunityAppliedByEmployee.findByLastModifiedUser", query = "SELECT o FROM OpportunityAppliedByEmployee o WHERE o.lastModifiedUser = :lastModifiedUser"),
        @NamedQuery(name = "OpportunityAppliedByEmployee.findByDetails", query = "SELECT o FROM OpportunityAppliedByEmployee o WHERE o.details = :details")
    })
public class OpportunityAppliedByEmployee implements Serializable {

    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "versionId", nullable = false)
    private String versionId;

    @Column(name = "opportunityId", nullable = false)
    private String opportunityId;

    @Column(name = "employeeUserName", nullable = false)
    private String employeeUserName;

    @Column(name = "timeStamp", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date timeStamp;

    @Column(name = "creationDate", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date creationDate;

    @Column(name = "createdUser", nullable = false)
    private String createdUser;

    @Column(name = "lastModifiedDate", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModifiedDate;

    @Column(name = "lastModifiedUser", nullable = false)
    private String lastModifiedUser;

    @Column(name = "details", nullable = false)
    private String details;

    /** Creates a new instance of OpportunityAppliedByEmployee */
    public OpportunityAppliedByEmployee() {
    }

    /**
     * Creates a new instance of OpportunityAppliedByEmployee with the specified values.
     * @param id the id of the OpportunityAppliedByEmployee
     */
    public OpportunityAppliedByEmployee(Integer id) {
        this.id = id;
    }

    /**
     * Creates a new instance of OpportunityAppliedByEmployee with the specified values.
     * @param id the id of the OpportunityAppliedByEmployee
     * @param versionId the versionId of the OpportunityAppliedByEmployee
     * @param opportunityId the opportunityId of the OpportunityAppliedByEmployee
     * @param employeeUserName the employeeUserName of the OpportunityAppliedByEmployee
     * @param timeStamp the timeStamp of the OpportunityAppliedByEmployee
     * @param creationDate the creationDate of the OpportunityAppliedByEmployee
     * @param createdUser the createdUser of the OpportunityAppliedByEmployee
     * @param lastModifiedDate the lastModifiedDate of the OpportunityAppliedByEmployee
     * @param lastModifiedUser the lastModifiedUser of the OpportunityAppliedByEmployee
     * @param details the details of the OpportunityAppliedByEmployee
     */
    public OpportunityAppliedByEmployee(Integer id, String versionId, String opportunityId, String employeeUserName, Date timeStamp, Date creationDate, String createdUser, Date lastModifiedDate, String lastModifiedUser, String details) {
        this.id = id;
        this.versionId = versionId;
        this.opportunityId = opportunityId;
        this.employeeUserName = employeeUserName;
        this.timeStamp = timeStamp;
        this.creationDate = creationDate;
        this.createdUser = createdUser;
        this.lastModifiedDate = lastModifiedDate;
        this.lastModifiedUser = lastModifiedUser;
        this.details = details;
    }

    /**
     * Gets the id of this OpportunityAppliedByEmployee.
     * @return the id
     */
    public Integer getId() {
        return this.id;
    }

    /**
     * Sets the id of this OpportunityAppliedByEmployee to the specified value.
     * @param id the new id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Gets the versionId of this OpportunityAppliedByEmployee.
     * @return the versionId
     */
    public String getVersionId() {
        return this.versionId;
    }

    /**
     * Sets the versionId of this OpportunityAppliedByEmployee to the specified value.
     * @param versionId the new versionId
     */
    public void setVersionId(String versionId) {
        this.versionId = versionId;
    }

    /**
     * Gets the opportunityId of this OpportunityAppliedByEmployee.
     * @return the opportunityId
     */
    public String getOpportunityId() {
        return this.opportunityId;
    }

    /**
     * Sets the opportunityId of this OpportunityAppliedByEmployee to the specified value.
     * @param opportunityId the new opportunityId
     */
    public void setOpportunityId(String opportunityId) {
        this.opportunityId = opportunityId;
    }

    /**
     * Gets the employeeUserName of this OpportunityAppliedByEmployee.
     * @return the employeeUserName
     */
    public String getEmployeeUserName() {
        return this.employeeUserName;
    }

    /**
     * Sets the employeeUserName of this OpportunityAppliedByEmployee to the specified value.
     * @param employeeUserName the new employeeUserName
     */
    public void setEmployeeUserName(String employeeUserName) {
        this.employeeUserName = employeeUserName;
    }

    /**
     * Gets the timeStamp of this OpportunityAppliedByEmployee.
     * @return the timeStamp
     */
    public Date getTimeStamp() {
        return this.timeStamp;
    }

    /**
     * Sets the timeStamp of this OpportunityAppliedByEmployee to the specified value.
     * @param timeStamp the new timeStamp
     */
    public void setTimeStamp(Date timeStamp) {
        this.timeStamp = timeStamp;
    }

    /**
     * Gets the creationDate of this OpportunityAppliedByEmployee.
     * @return the creationDate
     */
    public Date getCreationDate() {
        return this.creationDate;
    }

    /**
     * Sets the creationDate of this OpportunityAppliedByEmployee to the specified value.
     * @param creationDate the new creationDate
     */
    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    /**
     * Gets the createdUser of this OpportunityAppliedByEmployee.
     * @return the createdUser
     */
    public String getCreatedUser() {
        return this.createdUser;
    }

    /**
     * Sets the createdUser of this OpportunityAppliedByEmployee to the specified value.
     * @param createdUser the new createdUser
     */
    public void setCreatedUser(String createdUser) {
        this.createdUser = createdUser;
    }

    /**
     * Gets the lastModifiedDate of this OpportunityAppliedByEmployee.
     * @return the lastModifiedDate
     */
    public Date getLastModifiedDate() {
        return this.lastModifiedDate;
    }

    /**
     * Sets the lastModifiedDate of this OpportunityAppliedByEmployee to the specified value.
     * @param lastModifiedDate the new lastModifiedDate
     */
    public void setLastModifiedDate(Date lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    /**
     * Gets the lastModifiedUser of this OpportunityAppliedByEmployee.
     * @return the lastModifiedUser
     */
    public String getLastModifiedUser() {
        return this.lastModifiedUser;
    }

    /**
     * Sets the lastModifiedUser of this OpportunityAppliedByEmployee to the specified value.
     * @param lastModifiedUser the new lastModifiedUser
     */
    public void setLastModifiedUser(String lastModifiedUser) {
        this.lastModifiedUser = lastModifiedUser;
    }

    /**
     * Gets the details of this OpportunityAppliedByEmployee.
     * @return the details
     */
    public String getDetails() {
        return this.details;
    }

    /**
     * Sets the details of this OpportunityAppliedByEmployee to the specified value.
     * @param details the new details
     */
    public void setDetails(String details) {
        this.details = details;
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
     * Determines whether another object is equal to this OpportunityAppliedByEmployee.  The result is 
     * <code>true</code> if and only if the argument is not null and is a OpportunityAppliedByEmployee object that 
     * has the same id field values as this object.
     * @param object the reference object with which to compare
     * @return <code>true</code> if this object is the same as the argument;
     * <code>false</code> otherwise.
     */
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OpportunityAppliedByEmployee)) {
            return false;
        }
        OpportunityAppliedByEmployee other = (OpportunityAppliedByEmployee)object;
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
        return "com.abbt.crm.base.entity.OpportunityAppliedByEmployee[id=" + id + "]";
    }

}
