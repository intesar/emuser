/*
 * User.java
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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Entity class User
 * 
 * @author shannan
 */
@Entity
@Table(name = "user")
@NamedQueries( {
        @NamedQuery(name = "User.findById", query = "SELECT u FROM User u WHERE u.id = :id"),
        @NamedQuery(name = "User.findByEmail", query = "SELECT u FROM User u WHERE u.email = :email"),
        @NamedQuery(name = "User.findBySecondaryEmail", query = "SELECT u FROM User u WHERE u.secondaryEmail = :secondaryEmail"),
        @NamedQuery(name = "User.findByFirstname", query = "SELECT u FROM User u WHERE u.firstname = :firstname"),
        @NamedQuery(name = "User.findByLastname", query = "SELECT u FROM User u WHERE u.lastname = :lastname"),
        @NamedQuery(name = "User.findBySsn", query = "SELECT u FROM User u WHERE u.ssn = :ssn"),
        @NamedQuery(name = "User.findByDob", query = "SELECT u FROM User u WHERE u.dob = :dob"),
        @NamedQuery(name = "User.findByEmployeeId", query = "SELECT u FROM User u WHERE u.employeeId = :employeeId"),
        @NamedQuery(name = "User.findByMobile", query = "SELECT u FROM User u WHERE u.mobile = :mobile"),
        @NamedQuery(name = "User.findByPhone", query = "SELECT u FROM User u WHERE u.phone = :phone"),
        @NamedQuery(name = "User.findByOfficePhone", query = "SELECT u FROM User u WHERE u.officePhone = :officePhone"),
        @NamedQuery(name = "User.findByFax", query = "SELECT u FROM User u WHERE u.fax = :fax"),
        @NamedQuery(name = "User.findByCreatedBy", query = "SELECT u FROM User u WHERE u.createdBy = :createdBy"),
        @NamedQuery(name = "User.findByCreatedDate", query = "SELECT u FROM User u WHERE u.createdDate = :createdDate"),
        @NamedQuery(name = "User.findByLastUpdatedBy", query = "SELECT u FROM User u WHERE u.lastUpdatedBy = :lastUpdatedBy"),
        @NamedQuery(name = "User.findByLastUpdatedDate", query = "SELECT u FROM User u WHERE u.lastUpdatedDate = :lastUpdatedDate")
    })
public class User implements Serializable {

    @Column(name = "id")
    private Integer id;

    @Id
    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "secondaryEmail")
    private String secondaryEmail;

    @Column(name = "firstname", nullable = false)
    private String firstname;

    @Column(name = "lastname", nullable = false)
    private String lastname;

    @Column(name = "ssn")
    private String ssn;

    @Column(name = "dob")
    @Temporal(TemporalType.DATE)
    private Date dob;

    @Column(name = "employeeId")
    private String employeeId;

    @Column(name = "mobile")
    private String mobile;

    @Column(name = "phone")
    private String phone;

    @Column(name = "officePhone")
    private String officePhone;

    @Column(name = "fax")
    private String fax;

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

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userEmail")
    private Collection<UserCompany> userCompanyCollection;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userEmail")
    private Collection<Timesheet> timesheetCollection;

    @JoinColumn(name = "primaryAddress", referencedColumnName = "id")
    @ManyToOne
    private Address primaryAddress;
    
    /** Creates a new instance of User */
    public User() {
    }

    /**
     * Creates a new instance of User with the specified values.
     * @param email the email of the User
     */
    public User(String email) {
        this.email = email;
    }

    /**
     * Creates a new instance of User with the specified values.
     * @param email the email of the User
     * @param firstname the firstname of the User
     * @param lastname the lastname of the User
     */
    public User(String email, String firstname, String lastname) {
        this.email = email;
        this.firstname = firstname;
        this.lastname = lastname;
    }

    /**
     * Gets the id of this User.
     * @return the id
     */
    public Integer getId() {
        return this.id;
    }

    /**
     * Sets the id of this User to the specified value.
     * @param id the new id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Gets the email of this User.
     * @return the email
     */
    public String getEmail() {
        return this.email;
    }

    /**
     * Sets the email of this User to the specified value.
     * @param email the new email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Gets the secondaryEmail of this User.
     * @return the secondaryEmail
     */
    public String getSecondaryEmail() {
        return this.secondaryEmail;
    }

    /**
     * Sets the secondaryEmail of this User to the specified value.
     * @param secondaryEmail the new secondaryEmail
     */
    public void setSecondaryEmail(String secondaryEmail) {
        this.secondaryEmail = secondaryEmail;
    }

    /**
     * Gets the firstname of this User.
     * @return the firstname
     */
    public String getFirstname() {
        return this.firstname;
    }

    /**
     * Sets the firstname of this User to the specified value.
     * @param firstname the new firstname
     */
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    /**
     * Gets the lastname of this User.
     * @return the lastname
     */
    public String getLastname() {
        return this.lastname;
    }

    /**
     * Sets the lastname of this User to the specified value.
     * @param lastname the new lastname
     */
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    /**
     * Gets the ssn of this User.
     * @return the ssn
     */
    public String getSsn() {
        return this.ssn;
    }

    /**
     * Sets the ssn of this User to the specified value.
     * @param ssn the new ssn
     */
    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    /**
     * Gets the dob of this User.
     * @return the dob
     */
    public Date getDob() {
        return this.dob;
    }

    /**
     * Sets the dob of this User to the specified value.
     * @param dob the new dob
     */
    public void setDob(Date dob) {
        this.dob = dob;
    }

    /**
     * Gets the employeeId of this User.
     * @return the employeeId
     */
    public String getEmployeeId() {
        return this.employeeId;
    }

    /**
     * Sets the employeeId of this User to the specified value.
     * @param employeeId the new employeeId
     */
    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    /**
     * Gets the mobile of this User.
     * @return the mobile
     */
    public String getMobile() {
        return this.mobile;
    }

    /**
     * Sets the mobile of this User to the specified value.
     * @param mobile the new mobile
     */
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    /**
     * Gets the phone of this User.
     * @return the phone
     */
    public String getPhone() {
        return this.phone;
    }

    /**
     * Sets the phone of this User to the specified value.
     * @param phone the new phone
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * Gets the officePhone of this User.
     * @return the officePhone
     */
    public String getOfficePhone() {
        return this.officePhone;
    }

    /**
     * Sets the officePhone of this User to the specified value.
     * @param officePhone the new officePhone
     */
    public void setOfficePhone(String officePhone) {
        this.officePhone = officePhone;
    }

    /**
     * Gets the fax of this User.
     * @return the fax
     */
    public String getFax() {
        return this.fax;
    }

    /**
     * Sets the fax of this User to the specified value.
     * @param fax the new fax
     */
    public void setFax(String fax) {
        this.fax = fax;
    }

    /**
     * Gets the createdBy of this User.
     * @return the createdBy
     */
    public String getCreatedBy() {
        return this.createdBy;
    }

    /**
     * Sets the createdBy of this User to the specified value.
     * @param createdBy the new createdBy
     */
    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    /**
     * Gets the createdDate of this User.
     * @return the createdDate
     */
    public Date getCreatedDate() {
        return this.createdDate;
    }

    /**
     * Sets the createdDate of this User to the specified value.
     * @param createdDate the new createdDate
     */
    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    /**
     * Gets the lastUpdatedBy of this User.
     * @return the lastUpdatedBy
     */
    public String getLastUpdatedBy() {
        return this.lastUpdatedBy;
    }

    /**
     * Sets the lastUpdatedBy of this User to the specified value.
     * @param lastUpdatedBy the new lastUpdatedBy
     */
    public void setLastUpdatedBy(String lastUpdatedBy) {
        this.lastUpdatedBy = lastUpdatedBy;
    }

    /**
     * Gets the lastUpdatedDate of this User.
     * @return the lastUpdatedDate
     */
    public Date getLastUpdatedDate() {
        return this.lastUpdatedDate;
    }

    /**
     * Sets the lastUpdatedDate of this User to the specified value.
     * @param lastUpdatedDate the new lastUpdatedDate
     */
    public void setLastUpdatedDate(Date lastUpdatedDate) {
        this.lastUpdatedDate = lastUpdatedDate;
    }

    /**
     * Gets the userCompanyCollection of this User.
     * @return the userCompanyCollection
     */
    public Collection<UserCompany> getUserCompanyCollection() {
        return this.userCompanyCollection;
    }

    /**
     * Sets the userCompanyCollection of this User to the specified value.
     * @param userCompanyCollection the new userCompanyCollection
     */
    public void setUserCompanyCollection(Collection<UserCompany> userCompanyCollection) {
        this.userCompanyCollection = userCompanyCollection;
    }

    /**
     * Gets the timesheetCollection of this User.
     * @return the timesheetCollection
     */
    public Collection<Timesheet> getTimesheetCollection() {
        return this.timesheetCollection;
    }

    /**
     * Sets the timesheetCollection of this User to the specified value.
     * @param timesheetCollection the new timesheetCollection
     */
    public void setTimesheetCollection(Collection<Timesheet> timesheetCollection) {
        this.timesheetCollection = timesheetCollection;
    }

    /**
     * Gets the primaryAddress of this User.
     * @return the primaryAddress
     */
    public Address getPrimaryAddress() {
        return this.primaryAddress;
    }

    /**
     * Sets the primaryAddress of this User to the specified value.
     * @param primaryAddress the new primaryAddress
     */
    public void setPrimaryAddress(Address primaryAddress) {
        this.primaryAddress = primaryAddress;
    }

    /**
     * Returns a hash code value for the object.  This implementation computes 
     * a hash code value based on the id fields in this object.
     * @return a hash code value for this object.
     */
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (this.email != null ? this.email.hashCode() : 0);
        return hash;
    }

    /**
     * Determines whether another object is equal to this User.  The result is 
     * <code>true</code> if and only if the argument is not null and is a User object that 
     * has the same id field values as this object.
     * @param object the reference object with which to compare
     * @return <code>true</code> if this object is the same as the argument;
     * <code>false</code> otherwise.
     */
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof User)) {
            return false;
        }
        User other = (User)object;
        if (this.email != other.email && (this.email == null || !this.email.equals(other.email))) return false;
        return true;
    }

    /**
     * Returns a string representation of the object.  This implementation constructs 
     * that representation based on the id fields.
     * @return a string representation of the object.
     */
    @Override
    public String toString() {
        return "com.abbt.timesheet.entities.User[email=" + email + "]";
    }
    
}
