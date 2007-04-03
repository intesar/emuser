/*
 * Employee.java
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
        @NamedQuery(name = "Employee.findByEmail", query = "SELECT e FROM Employee e WHERE e.email = :email"),
        @NamedQuery(name = "Employee.findByCreatedUser", query = "SELECT e FROM Employee e WHERE e.createdUser = :createdUser"),
        @NamedQuery(name = "Employee.findByCreationDate", query = "SELECT e FROM Employee e WHERE e.creationDate = :creationDate"),
        @NamedQuery(name = "Employee.findByLastModifiedUser", query = "SELECT e FROM Employee e WHERE e.lastModifiedUser = :lastModifiedUser"),
        @NamedQuery(name = "Employee.findByLastModifiedDate", query = "SELECT e FROM Employee e WHERE e.lastModifiedDate = :lastModifiedDate"),
        @NamedQuery(name = "Employee.findByCompanyId", query = "SELECT e FROM Employee e WHERE e.companyId = :companyId"),
        @NamedQuery(name = "Employee.findByManagerId", query = "SELECT e FROM Employee e WHERE e.managerId = :managerId")
    })
public class Employee implements Serializable {

    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "versionId", nullable = false)
    private int versionId;

    @Column(name = "employeeId", nullable = false)
    private int employeeId;

    @Column(name = "ssn", nullable = false)
    private int ssn;

    @Column(name = "userName", nullable = false)
    private String userName;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "isEnabled", nullable = false)
    private boolean isEnabled;

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

    @Column(name = "email", nullable = false)
    private String email;

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

    @Column(name = "companyId", nullable = false)
    private int companyId;

    @Column(name = "managerId", nullable = false)
    private int managerId;

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
     * @param versionId the versionId of the Employee
     * @param employeeId the employeeId of the Employee
     * @param ssn the ssn of the Employee
     * @param userName the userName of the Employee
     * @param title the title of the Employee
     * @param description the description of the Employee
     * @param isEnabled the isEnabled of the Employee
     * @param terminationDate the terminationDate of the Employee
     * @param joinedDate the joinedDate of the Employee
     * @param firstName the firstName of the Employee
     * @param lastName the lastName of the Employee
     * @param email the email of the Employee
     * @param createdUser the createdUser of the Employee
     * @param creationDate the creationDate of the Employee
     * @param lastModifiedUser the lastModifiedUser of the Employee
     * @param lastModifiedDate the lastModifiedDate of the Employee
     * @param companyId the companyId of the Employee
     * @param managerId the managerId of the Employee
     */
    public Employee(Integer id, int versionId, int employeeId, int ssn, String userName, String title, String description, boolean isEnabled, Date terminationDate, Date joinedDate, String firstName, String lastName, String email, String createdUser, Date creationDate, String lastModifiedUser, Date lastModifiedDate, int companyId, int managerId) {
        this.id = id;
        this.versionId = versionId;
        this.employeeId = employeeId;
        this.ssn = ssn;
        this.userName = userName;
        this.title = title;
        this.description = description;
        this.isEnabled = isEnabled;
        this.terminationDate = terminationDate;
        this.joinedDate = joinedDate;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.createdUser = createdUser;
        this.creationDate = creationDate;
        this.lastModifiedUser = lastModifiedUser;
        this.lastModifiedDate = lastModifiedDate;
        this.companyId = companyId;
        this.managerId = managerId;
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
    public int getVersionId() {
        return this.versionId;
    }

    /**
     * Sets the versionId of this Employee to the specified value.
     * @param versionId the new versionId
     */
    public void setVersionId(int versionId) {
        this.versionId = versionId;
    }

    /**
     * Gets the employeeId of this Employee.
     * @return the employeeId
     */
    public int getEmployeeId() {
        return this.employeeId;
    }

    /**
     * Sets the employeeId of this Employee to the specified value.
     * @param employeeId the new employeeId
     */
    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    /**
     * Gets the ssn of this Employee.
     * @return the ssn
     */
    public int getSsn() {
        return this.ssn;
    }

    /**
     * Sets the ssn of this Employee to the specified value.
     * @param ssn the new ssn
     */
    public void setSsn(int ssn) {
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
    public boolean getIsEnabled() {
        return this.isEnabled;
    }

    /**
     * Sets the isEnabled of this Employee to the specified value.
     * @param isEnabled the new isEnabled
     */
    public void setIsEnabled(boolean isEnabled) {
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
     * Gets the email of this Employee.
     * @return the email
     */
    public String getEmail() {
        return this.email;
    }

    /**
     * Sets the email of this Employee to the specified value.
     * @param email the new email
     */
    public void setEmail(String email) {
        this.email = email;
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
     * Gets the companyId of this Employee.
     * @return the companyId
     */
    public int getCompanyId() {
        return this.companyId;
    }

    /**
     * Sets the companyId of this Employee to the specified value.
     * @param companyId the new companyId
     */
    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }

    /**
     * Gets the managerId of this Employee.
     * @return the managerId
     */
    public int getManagerId() {
        return this.managerId;
    }

    /**
     * Sets the managerId of this Employee to the specified value.
     * @param managerId the new managerId
     */
    public void setManagerId(int managerId) {
        this.managerId = managerId;
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
