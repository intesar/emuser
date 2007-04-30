/*
 * UserCompany.java
 *
 * Created on April 29, 2007, 9:37 PM
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
 * Entity class UserCompany
 * 
 * @author shannan
 */
@Entity
@Table(name = "user_company")
@NamedQueries( {
        @NamedQuery(name = "UserCompany.findById", query = "SELECT u FROM UserCompany u WHERE u.id = :id"),
        @NamedQuery(name = "UserCompany.findByClientBillingRate", query = "SELECT u FROM UserCompany u WHERE u.clientBillingRate = :clientBillingRate"),
        @NamedQuery(name = "UserCompany.findByPercentage", query = "SELECT u FROM UserCompany u WHERE u.percentage = :percentage"),
        @NamedQuery(name = "UserCompany.findByUserPayedRate", query = "SELECT u FROM UserCompany u WHERE u.userPayedRate = :userPayedRate"),
        @NamedQuery(name = "UserCompany.findByParentCompany1", query = "SELECT u FROM UserCompany u WHERE u.parentCompany1 = :parentCompany1"),
        @NamedQuery(name = "UserCompany.findByParentCompany2", query = "SELECT u FROM UserCompany u WHERE u.parentCompany2 = :parentCompany2"),
        @NamedQuery(name = "UserCompany.findByParentCompany3", query = "SELECT u FROM UserCompany u WHERE u.parentCompany3 = :parentCompany3"),
        @NamedQuery(name = "UserCompany.findByCreatedBy", query = "SELECT u FROM UserCompany u WHERE u.createdBy = :createdBy"),
        @NamedQuery(name = "UserCompany.findByCreatedDate", query = "SELECT u FROM UserCompany u WHERE u.createdDate = :createdDate"),
        @NamedQuery(name = "UserCompany.findByLastUpdatedBy", query = "SELECT u FROM UserCompany u WHERE u.lastUpdatedBy = :lastUpdatedBy"),
        @NamedQuery(name = "UserCompany.findByLastUpdatedDate", query = "SELECT u FROM UserCompany u WHERE u.lastUpdatedDate = :lastUpdatedDate")
    })
public class UserCompany implements Serializable {

    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "clientBillingRate")
    private Integer clientBillingRate;

    @Column(name = "percentage")
    private Integer percentage;

    @Column(name = "userPayedRate")
    private Integer userPayedRate;

    @Column(name = "parentCompany1")
    private String parentCompany1;

    @Column(name = "parentCompany2")
    private String parentCompany2;

    @Column(name = "parentCompany3")
    private String parentCompany3;

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

    @JoinColumn(name = "companyName", referencedColumnName = "name")
    @ManyToOne
    private Company companyName;

    @JoinColumn(name = "userEmail", referencedColumnName = "email")
    @ManyToOne
    private User userEmail;

    @OneToMany(mappedBy = "clientCompany")
    private Collection<Timesheet> timesheetCollection;
    
    /** Creates a new instance of UserCompany */
    public UserCompany() {
    }

    /**
     * Creates a new instance of UserCompany with the specified values.
     * @param id the id of the UserCompany
     */
    public UserCompany(Integer id) {
        this.id = id;
    }

    /**
     * Gets the id of this UserCompany.
     * @return the id
     */
    public Integer getId() {
        return this.id;
    }

    /**
     * Sets the id of this UserCompany to the specified value.
     * @param id the new id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Gets the clientBillingRate of this UserCompany.
     * @return the clientBillingRate
     */
    public Integer getClientBillingRate() {
        return this.clientBillingRate;
    }

    /**
     * Sets the clientBillingRate of this UserCompany to the specified value.
     * @param clientBillingRate the new clientBillingRate
     */
    public void setClientBillingRate(Integer clientBillingRate) {
        this.clientBillingRate = clientBillingRate;
    }

    /**
     * Gets the percentage of this UserCompany.
     * @return the percentage
     */
    public Integer getPercentage() {
        return this.percentage;
    }

    /**
     * Sets the percentage of this UserCompany to the specified value.
     * @param percentage the new percentage
     */
    public void setPercentage(Integer percentage) {
        this.percentage = percentage;
    }

    /**
     * Gets the userPayedRate of this UserCompany.
     * @return the userPayedRate
     */
    public Integer getUserPayedRate() {
        return this.userPayedRate;
    }

    /**
     * Sets the userPayedRate of this UserCompany to the specified value.
     * @param userPayedRate the new userPayedRate
     */
    public void setUserPayedRate(Integer userPayedRate) {
        this.userPayedRate = userPayedRate;
    }

    /**
     * Gets the parentCompany1 of this UserCompany.
     * @return the parentCompany1
     */
    public String getParentCompany1() {
        return this.parentCompany1;
    }

    /**
     * Sets the parentCompany1 of this UserCompany to the specified value.
     * @param parentCompany1 the new parentCompany1
     */
    public void setParentCompany1(String parentCompany1) {
        this.parentCompany1 = parentCompany1;
    }

    /**
     * Gets the parentCompany2 of this UserCompany.
     * @return the parentCompany2
     */
    public String getParentCompany2() {
        return this.parentCompany2;
    }

    /**
     * Sets the parentCompany2 of this UserCompany to the specified value.
     * @param parentCompany2 the new parentCompany2
     */
    public void setParentCompany2(String parentCompany2) {
        this.parentCompany2 = parentCompany2;
    }

    /**
     * Gets the parentCompany3 of this UserCompany.
     * @return the parentCompany3
     */
    public String getParentCompany3() {
        return this.parentCompany3;
    }

    /**
     * Sets the parentCompany3 of this UserCompany to the specified value.
     * @param parentCompany3 the new parentCompany3
     */
    public void setParentCompany3(String parentCompany3) {
        this.parentCompany3 = parentCompany3;
    }

    /**
     * Gets the createdBy of this UserCompany.
     * @return the createdBy
     */
    public String getCreatedBy() {
        return this.createdBy;
    }

    /**
     * Sets the createdBy of this UserCompany to the specified value.
     * @param createdBy the new createdBy
     */
    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    /**
     * Gets the createdDate of this UserCompany.
     * @return the createdDate
     */
    public Date getCreatedDate() {
        return this.createdDate;
    }

    /**
     * Sets the createdDate of this UserCompany to the specified value.
     * @param createdDate the new createdDate
     */
    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    /**
     * Gets the lastUpdatedBy of this UserCompany.
     * @return the lastUpdatedBy
     */
    public String getLastUpdatedBy() {
        return this.lastUpdatedBy;
    }

    /**
     * Sets the lastUpdatedBy of this UserCompany to the specified value.
     * @param lastUpdatedBy the new lastUpdatedBy
     */
    public void setLastUpdatedBy(String lastUpdatedBy) {
        this.lastUpdatedBy = lastUpdatedBy;
    }

    /**
     * Gets the lastUpdatedDate of this UserCompany.
     * @return the lastUpdatedDate
     */
    public Date getLastUpdatedDate() {
        return this.lastUpdatedDate;
    }

    /**
     * Sets the lastUpdatedDate of this UserCompany to the specified value.
     * @param lastUpdatedDate the new lastUpdatedDate
     */
    public void setLastUpdatedDate(Date lastUpdatedDate) {
        this.lastUpdatedDate = lastUpdatedDate;
    }

    /**
     * Gets the companyName of this UserCompany.
     * @return the companyName
     */
    public Company getCompanyName() {
        return this.companyName;
    }

    /**
     * Sets the companyName of this UserCompany to the specified value.
     * @param companyName the new companyName
     */
    public void setCompanyName(Company companyName) {
        this.companyName = companyName;
    }

    /**
     * Gets the userEmail of this UserCompany.
     * @return the userEmail
     */
    public User getUserEmail() {
        return this.userEmail;
    }

    /**
     * Sets the userEmail of this UserCompany to the specified value.
     * @param userEmail the new userEmail
     */
    public void setUserEmail(User userEmail) {
        this.userEmail = userEmail;
    }

    /**
     * Gets the timesheetCollection of this UserCompany.
     * @return the timesheetCollection
     */
    public Collection<Timesheet> getTimesheetCollection() {
        return this.timesheetCollection;
    }

    /**
     * Sets the timesheetCollection of this UserCompany to the specified value.
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
     * Determines whether another object is equal to this UserCompany.  The result is 
     * <code>true</code> if and only if the argument is not null and is a UserCompany object that 
     * has the same id field values as this object.
     * @param object the reference object with which to compare
     * @return <code>true</code> if this object is the same as the argument;
     * <code>false</code> otherwise.
     */
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UserCompany)) {
            return false;
        }
        UserCompany other = (UserCompany)object;
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
        return "com.abbt.timesheet.entities.UserCompany[id=" + id + "]";
    }
    
}
