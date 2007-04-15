/*
 * Employee.java
 *
 * Created on April 14, 2007, 7:49 PM
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
 * Entity class Employee
 * 
 * @author shannan
 */
@Entity
@Table(name = "employee")
@NamedQueries( {
        @NamedQuery(name = "Employee.findById", query = "SELECT e FROM Employee e WHERE e.id = :id"),
        @NamedQuery(name = "Employee.findByVersionId", query = "SELECT e FROM Employee e WHERE e.versionId = :versionId"),
        @NamedQuery(name = "Employee.findByEmployeeId", query = "SELECT e FROM Employee e WHERE e.employeeId = :employeeId"),
        @NamedQuery(name = "Employee.findBySsn", query = "SELECT e FROM Employee e WHERE e.ssn = :ssn"),
        @NamedQuery(name = "Employee.findByUserName", query = "SELECT e FROM Employee e WHERE e.userName = :userName"),
        @NamedQuery(name = "Employee.findByTitle", query = "SELECT e FROM Employee e WHERE e.title = :title"),
        @NamedQuery(name = "Employee.findByDescription", query = "SELECT e FROM Employee e WHERE e.description = :description"),
        @NamedQuery(name = "Employee.findByIsEnabled", query = "SELECT e FROM Employee e WHERE e.isEnabled = :isEnabled"),
        @NamedQuery(name = "Employee.findByTerminationDate", query = "SELECT e FROM Employee e WHERE e.terminationDate = :terminationDate"),
        @NamedQuery(name = "Employee.findByJoinedDate", query = "SELECT e FROM Employee e WHERE e.joinedDate = :joinedDate"),
        @NamedQuery(name = "Employee.findByFirstName", query = "SELECT e FROM Employee e WHERE e.firstName = :firstName"),
        @NamedQuery(name = "Employee.findByLastName", query = "SELECT e FROM Employee e WHERE e.lastName = :lastName"),
        @NamedQuery(name = "Employee.findByPrimaryEmail", query = "SELECT e FROM Employee e WHERE e.primaryEmail = :primaryEmail"),
        @NamedQuery(name = "Employee.findByCreatedUser", query = "SELECT e FROM Employee e WHERE e.createdUser = :createdUser"),
        @NamedQuery(name = "Employee.findByCreationDate", query = "SELECT e FROM Employee e WHERE e.creationDate = :creationDate"),
        @NamedQuery(name = "Employee.findByLastModifiedUser", query = "SELECT e FROM Employee e WHERE e.lastModifiedUser = :lastModifiedUser"),
        @NamedQuery(name = "Employee.findByLastModifiedDate", query = "SELECT e FROM Employee e WHERE e.lastModifiedDate = :lastModifiedDate"),
        @NamedQuery(name = "Employee.findByCompanyName", query = "SELECT e FROM Employee e WHERE e.companyName = :companyName"),
        @NamedQuery(name = "Employee.findBySecondaryEmail", query = "SELECT e FROM Employee e WHERE e.secondaryEmail = :secondaryEmail"),
        @NamedQuery(name = "Employee.findByHomePhone", query = "SELECT e FROM Employee e WHERE e.homePhone = :homePhone"),
        @NamedQuery(name = "Employee.findByOfficePhone1", query = "SELECT e FROM Employee e WHERE e.officePhone1 = :officePhone1"),
        @NamedQuery(name = "Employee.findByOfficePhone2", query = "SELECT e FROM Employee e WHERE e.officePhone2 = :officePhone2"),
        @NamedQuery(name = "Employee.findByMobile", query = "SELECT e FROM Employee e WHERE e.mobile = :mobile"),
        @NamedQuery(name = "Employee.findByFax", query = "SELECT e FROM Employee e WHERE e.fax = :fax"),
        @NamedQuery(name = "Employee.findByOtherPhone", query = "SELECT e FROM Employee e WHERE e.otherPhone = :otherPhone"),
        @NamedQuery(name = "Employee.findByMailingStreet", query = "SELECT e FROM Employee e WHERE e.mailingStreet = :mailingStreet"),
        @NamedQuery(name = "Employee.findByMailingCity", query = "SELECT e FROM Employee e WHERE e.mailingCity = :mailingCity"),
        @NamedQuery(name = "Employee.findByMailingState", query = "SELECT e FROM Employee e WHERE e.mailingState = :mailingState"),
        @NamedQuery(name = "Employee.findByMailingZipcode", query = "SELECT e FROM Employee e WHERE e.mailingZipcode = :mailingZipcode"),
        @NamedQuery(name = "Employee.findByMailingCountry", query = "SELECT e FROM Employee e WHERE e.mailingCountry = :mailingCountry"),
        @NamedQuery(name = "Employee.findByHomeStreet", query = "SELECT e FROM Employee e WHERE e.homeStreet = :homeStreet"),
        @NamedQuery(name = "Employee.findByHomeCity", query = "SELECT e FROM Employee e WHERE e.homeCity = :homeCity"),
        @NamedQuery(name = "Employee.findByHomeState", query = "SELECT e FROM Employee e WHERE e.homeState = :homeState"),
        @NamedQuery(name = "Employee.findByHomeZipcode", query = "SELECT e FROM Employee e WHERE e.homeZipcode = :homeZipcode"),
        @NamedQuery(name = "Employee.findByHomeCountry", query = "SELECT e FROM Employee e WHERE e.homeCountry = :homeCountry"),
        @NamedQuery(name = "Employee.findByMailingSameAsHome", query = "SELECT e FROM Employee e WHERE e.mailingSameAsHome = :mailingSameAsHome")
    })
public class Employee implements Serializable {

    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "versionId")
    private Integer versionId;

    @Column(name = "employeeId")
    private Integer employeeId;

    @Column(name = "ssn")
    private Integer ssn;

    @Column(name = "userName", nullable = false)
    private String userName;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "isEnabled")
    private Boolean isEnabled;

    @Column(name = "terminationDate", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date terminationDate;

    @Column(name = "joinedDate", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date joinedDate;

    @Column(name = "firstName", nullable = false)
    private String firstName;

    @Column(name = "lastName", nullable = false)
    private String lastName;

    @Column(name = "primaryEmail")
    private String primaryEmail;

    @Column(name = "createdUser", nullable = false)
    private String createdUser;

    @Column(name = "creationDate", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date creationDate;

    @Column(name = "lastModifiedUser", nullable = false)
    private String lastModifiedUser;

    @Column(name = "lastModifiedDate", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModifiedDate;

    @Column(name = "companyName")
    private String companyName;

    @Column(name = "secondaryEmail")
    private String secondaryEmail;

    @Column(name = "homePhone")
    private String homePhone;

    @Column(name = "officePhone1")
    private String officePhone1;

    @Column(name = "officePhone2")
    private String officePhone2;

    @Column(name = "mobile")
    private String mobile;

    @Column(name = "fax")
    private String fax;

    @Column(name = "otherPhone")
    private String otherPhone;

    @Column(name = "mailingStreet")
    private String mailingStreet;

    @Column(name = "mailingCity")
    private String mailingCity;

    @Column(name = "mailingState")
    private String mailingState;

    @Column(name = "mailingZipcode")
    private String mailingZipcode;

    @Column(name = "mailingCountry")
    private String mailingCountry;

    @Column(name = "homeStreet")
    private String homeStreet;

    @Column(name = "homeCity")
    private String homeCity;

    @Column(name = "homeState")
    private String homeState;

    @Column(name = "homeZipcode")
    private String homeZipcode;

    @Column(name = "homeCountry")
    private String homeCountry;

    @Column(name = "mailingSameAsHome")
    private Short mailingSameAsHome;

    /** Creates a new instance of Employee */
    public Employee() {
    }

    /**
     * Creates a new instance of Employee with the specified values.
     * @param id the id of the Employee
     */
    public Employee(Integer id) {
        this.id = id;
    }

    /**
     * Creates a new instance of Employee with the specified values.
     * @param id the id of the Employee
     * @param userName the userName of the Employee
     * @param terminationDate the terminationDate of the Employee
     * @param joinedDate the joinedDate of the Employee
     * @param firstName the firstName of the Employee
     * @param lastName the lastName of the Employee
     * @param createdUser the createdUser of the Employee
     * @param creationDate the creationDate of the Employee
     * @param lastModifiedUser the lastModifiedUser of the Employee
     * @param lastModifiedDate the lastModifiedDate of the Employee
     */
    public Employee(Integer id, String userName, Date terminationDate, Date joinedDate, String firstName, String lastName, String createdUser, Date creationDate, String lastModifiedUser, Date lastModifiedDate) {
        this.id = id;
        this.userName = userName;
        this.terminationDate = terminationDate;
        this.joinedDate = joinedDate;
        this.firstName = firstName;
        this.lastName = lastName;
        this.createdUser = createdUser;
        this.creationDate = creationDate;
        this.lastModifiedUser = lastModifiedUser;
        this.lastModifiedDate = lastModifiedDate;
    }

    /**
     * Gets the id of this Employee.
     * @return the id
     */
    public Integer getId() {
        return this.id;
    }

    /**
     * Sets the id of this Employee to the specified value.
     * @param id the new id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Gets the versionId of this Employee.
     * @return the versionId
     */
    public Integer getVersionId() {
        return this.versionId;
    }

    /**
     * Sets the versionId of this Employee to the specified value.
     * @param versionId the new versionId
     */
    public void setVersionId(Integer versionId) {
        this.versionId = versionId;
    }

    /**
     * Gets the employeeId of this Employee.
     * @return the employeeId
     */
    public Integer getEmployeeId() {
        return this.employeeId;
    }

    /**
     * Sets the employeeId of this Employee to the specified value.
     * @param employeeId the new employeeId
     */
    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    /**
     * Gets the ssn of this Employee.
     * @return the ssn
     */
    public Integer getSsn() {
        return this.ssn;
    }

    /**
     * Sets the ssn of this Employee to the specified value.
     * @param ssn the new ssn
     */
    public void setSsn(Integer ssn) {
        this.ssn = ssn;
    }

    /**
     * Gets the userName of this Employee.
     * @return the userName
     */
    public String getUserName() {
        return this.userName;
    }

    /**
     * Sets the userName of this Employee to the specified value.
     * @param userName the new userName
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * Gets the title of this Employee.
     * @return the title
     */
    public String getTitle() {
        return this.title;
    }

    /**
     * Sets the title of this Employee to the specified value.
     * @param title the new title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Gets the description of this Employee.
     * @return the description
     */
    public String getDescription() {
        return this.description;
    }

    /**
     * Sets the description of this Employee to the specified value.
     * @param description the new description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Gets the isEnabled of this Employee.
     * @return the isEnabled
     */
    public Boolean getIsEnabled() {
        return this.isEnabled;
    }

    /**
     * Sets the isEnabled of this Employee to the specified value.
     * @param isEnabled the new isEnabled
     */
    public void setIsEnabled(Boolean isEnabled) {
        this.isEnabled = isEnabled;
    }

    /**
     * Gets the terminationDate of this Employee.
     * @return the terminationDate
     */
    public Date getTerminationDate() {
        return this.terminationDate;
    }

    /**
     * Sets the terminationDate of this Employee to the specified value.
     * @param terminationDate the new terminationDate
     */
    public void setTerminationDate(Date terminationDate) {
        this.terminationDate = terminationDate;
    }

    /**
     * Gets the joinedDate of this Employee.
     * @return the joinedDate
     */
    public Date getJoinedDate() {
        return this.joinedDate;
    }

    /**
     * Sets the joinedDate of this Employee to the specified value.
     * @param joinedDate the new joinedDate
     */
    public void setJoinedDate(Date joinedDate) {
        this.joinedDate = joinedDate;
    }

    /**
     * Gets the firstName of this Employee.
     * @return the firstName
     */
    public String getFirstName() {
        return this.firstName;
    }

    /**
     * Sets the firstName of this Employee to the specified value.
     * @param firstName the new firstName
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Gets the lastName of this Employee.
     * @return the lastName
     */
    public String getLastName() {
        return this.lastName;
    }

    /**
     * Sets the lastName of this Employee to the specified value.
     * @param lastName the new lastName
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Gets the primaryEmail of this Employee.
     * @return the primaryEmail
     */
    public String getPrimaryEmail() {
        return this.primaryEmail;
    }

    /**
     * Sets the primaryEmail of this Employee to the specified value.
     * @param primaryEmail the new primaryEmail
     */
    public void setPrimaryEmail(String primaryEmail) {
        this.primaryEmail = primaryEmail;
    }

    /**
     * Gets the createdUser of this Employee.
     * @return the createdUser
     */
    public String getCreatedUser() {
        return this.createdUser;
    }

    /**
     * Sets the createdUser of this Employee to the specified value.
     * @param createdUser the new createdUser
     */
    public void setCreatedUser(String createdUser) {
        this.createdUser = createdUser;
    }

    /**
     * Gets the creationDate of this Employee.
     * @return the creationDate
     */
    public Date getCreationDate() {
        return this.creationDate;
    }

    /**
     * Sets the creationDate of this Employee to the specified value.
     * @param creationDate the new creationDate
     */
    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    /**
     * Gets the lastModifiedUser of this Employee.
     * @return the lastModifiedUser
     */
    public String getLastModifiedUser() {
        return this.lastModifiedUser;
    }

    /**
     * Sets the lastModifiedUser of this Employee to the specified value.
     * @param lastModifiedUser the new lastModifiedUser
     */
    public void setLastModifiedUser(String lastModifiedUser) {
        this.lastModifiedUser = lastModifiedUser;
    }

    /**
     * Gets the lastModifiedDate of this Employee.
     * @return the lastModifiedDate
     */
    public Date getLastModifiedDate() {
        return this.lastModifiedDate;
    }

    /**
     * Sets the lastModifiedDate of this Employee to the specified value.
     * @param lastModifiedDate the new lastModifiedDate
     */
    public void setLastModifiedDate(Date lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    /**
     * Gets the companyName of this Employee.
     * @return the companyName
     */
    public String getCompanyName() {
        return this.companyName;
    }

    /**
     * Sets the companyName of this Employee to the specified value.
     * @param companyName the new companyName
     */
    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    /**
     * Gets the secondaryEmail of this Employee.
     * @return the secondaryEmail
     */
    public String getSecondaryEmail() {
        return this.secondaryEmail;
    }

    /**
     * Sets the secondaryEmail of this Employee to the specified value.
     * @param secondaryEmail the new secondaryEmail
     */
    public void setSecondaryEmail(String secondaryEmail) {
        this.secondaryEmail = secondaryEmail;
    }

    /**
     * Gets the homePhone of this Employee.
     * @return the homePhone
     */
    public String getHomePhone() {
        return this.homePhone;
    }

    /**
     * Sets the homePhone of this Employee to the specified value.
     * @param homePhone the new homePhone
     */
    public void setHomePhone(String homePhone) {
        this.homePhone = homePhone;
    }

    /**
     * Gets the officePhone1 of this Employee.
     * @return the officePhone1
     */
    public String getOfficePhone1() {
        return this.officePhone1;
    }

    /**
     * Sets the officePhone1 of this Employee to the specified value.
     * @param officePhone1 the new officePhone1
     */
    public void setOfficePhone1(String officePhone1) {
        this.officePhone1 = officePhone1;
    }

    /**
     * Gets the officePhone2 of this Employee.
     * @return the officePhone2
     */
    public String getOfficePhone2() {
        return this.officePhone2;
    }

    /**
     * Sets the officePhone2 of this Employee to the specified value.
     * @param officePhone2 the new officePhone2
     */
    public void setOfficePhone2(String officePhone2) {
        this.officePhone2 = officePhone2;
    }

    /**
     * Gets the mobile of this Employee.
     * @return the mobile
     */
    public String getMobile() {
        return this.mobile;
    }

    /**
     * Sets the mobile of this Employee to the specified value.
     * @param mobile the new mobile
     */
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    /**
     * Gets the fax of this Employee.
     * @return the fax
     */
    public String getFax() {
        return this.fax;
    }

    /**
     * Sets the fax of this Employee to the specified value.
     * @param fax the new fax
     */
    public void setFax(String fax) {
        this.fax = fax;
    }

    /**
     * Gets the otherPhone of this Employee.
     * @return the otherPhone
     */
    public String getOtherPhone() {
        return this.otherPhone;
    }

    /**
     * Sets the otherPhone of this Employee to the specified value.
     * @param otherPhone the new otherPhone
     */
    public void setOtherPhone(String otherPhone) {
        this.otherPhone = otherPhone;
    }

    /**
     * Gets the mailingStreet of this Employee.
     * @return the mailingStreet
     */
    public String getMailingStreet() {
        return this.mailingStreet;
    }

    /**
     * Sets the mailingStreet of this Employee to the specified value.
     * @param mailingStreet the new mailingStreet
     */
    public void setMailingStreet(String mailingStreet) {
        this.mailingStreet = mailingStreet;
    }

    /**
     * Gets the mailingCity of this Employee.
     * @return the mailingCity
     */
    public String getMailingCity() {
        return this.mailingCity;
    }

    /**
     * Sets the mailingCity of this Employee to the specified value.
     * @param mailingCity the new mailingCity
     */
    public void setMailingCity(String mailingCity) {
        this.mailingCity = mailingCity;
    }

    /**
     * Gets the mailingState of this Employee.
     * @return the mailingState
     */
    public String getMailingState() {
        return this.mailingState;
    }

    /**
     * Sets the mailingState of this Employee to the specified value.
     * @param mailingState the new mailingState
     */
    public void setMailingState(String mailingState) {
        this.mailingState = mailingState;
    }

    /**
     * Gets the mailingZipcode of this Employee.
     * @return the mailingZipcode
     */
    public String getMailingZipcode() {
        return this.mailingZipcode;
    }

    /**
     * Sets the mailingZipcode of this Employee to the specified value.
     * @param mailingZipcode the new mailingZipcode
     */
    public void setMailingZipcode(String mailingZipcode) {
        this.mailingZipcode = mailingZipcode;
    }

    /**
     * Gets the mailingCountry of this Employee.
     * @return the mailingCountry
     */
    public String getMailingCountry() {
        return this.mailingCountry;
    }

    /**
     * Sets the mailingCountry of this Employee to the specified value.
     * @param mailingCountry the new mailingCountry
     */
    public void setMailingCountry(String mailingCountry) {
        this.mailingCountry = mailingCountry;
    }

    /**
     * Gets the homeStreet of this Employee.
     * @return the homeStreet
     */
    public String getHomeStreet() {
        return this.homeStreet;
    }

    /**
     * Sets the homeStreet of this Employee to the specified value.
     * @param homeStreet the new homeStreet
     */
    public void setHomeStreet(String homeStreet) {
        this.homeStreet = homeStreet;
    }

    /**
     * Gets the homeCity of this Employee.
     * @return the homeCity
     */
    public String getHomeCity() {
        return this.homeCity;
    }

    /**
     * Sets the homeCity of this Employee to the specified value.
     * @param homeCity the new homeCity
     */
    public void setHomeCity(String homeCity) {
        this.homeCity = homeCity;
    }

    /**
     * Gets the homeState of this Employee.
     * @return the homeState
     */
    public String getHomeState() {
        return this.homeState;
    }

    /**
     * Sets the homeState of this Employee to the specified value.
     * @param homeState the new homeState
     */
    public void setHomeState(String homeState) {
        this.homeState = homeState;
    }

    /**
     * Gets the homeZipcode of this Employee.
     * @return the homeZipcode
     */
    public String getHomeZipcode() {
        return this.homeZipcode;
    }

    /**
     * Sets the homeZipcode of this Employee to the specified value.
     * @param homeZipcode the new homeZipcode
     */
    public void setHomeZipcode(String homeZipcode) {
        this.homeZipcode = homeZipcode;
    }

    /**
     * Gets the homeCountry of this Employee.
     * @return the homeCountry
     */
    public String getHomeCountry() {
        return this.homeCountry;
    }

    /**
     * Sets the homeCountry of this Employee to the specified value.
     * @param homeCountry the new homeCountry
     */
    public void setHomeCountry(String homeCountry) {
        this.homeCountry = homeCountry;
    }

    /**
     * Gets the mailingSameAsHome of this Employee.
     * @return the mailingSameAsHome
     */
    public Short getMailingSameAsHome() {
        return this.mailingSameAsHome;
    }

    /**
     * Sets the mailingSameAsHome of this Employee to the specified value.
     * @param mailingSameAsHome the new mailingSameAsHome
     */
    public void setMailingSameAsHome(Short mailingSameAsHome) {
        this.mailingSameAsHome = mailingSameAsHome;
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
     * Determines whether another object is equal to this Employee.  The result is 
     * <code>true</code> if and only if the argument is not null and is a Employee object that 
     * has the same id field values as this object.
     * @param object the reference object with which to compare
     * @return <code>true</code> if this object is the same as the argument;
     * <code>false</code> otherwise.
     */
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Employee)) {
            return false;
        }
        Employee other = (Employee)object;
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
        return "com.abbt.crm.base.entity.Employee[id=" + id + "]";
    }

}
