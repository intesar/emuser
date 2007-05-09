/*
 * UserCompanyRole.java
 *
 * Created on May 7, 2007, 11:06 PM
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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Entity class UserCompanyRole
 * 
 * @author shannan
 */
@Entity
@Table(name = "user_company_role")
@NamedQueries( {
        @NamedQuery(name = "UserCompanyRole.findById", query = "SELECT u FROM UserCompanyRole u WHERE u.id = :id"),
        @NamedQuery(name = "UserCompanyRole.findByUser", query = "SELECT u FROM UserCompanyRole u WHERE u.user = :user"),
        @NamedQuery(name = "UserCompanyRole.findByCompany", query = "SELECT u FROM UserCompanyRole u WHERE u.company = :company"),
        @NamedQuery(name = "UserCompanyRole.findByRole", query = "SELECT u FROM UserCompanyRole u WHERE u.role = :role"),
        @NamedQuery(name = "UserCompanyRole.findByAssignedDate", query = "SELECT u FROM UserCompanyRole u WHERE u.assignedDate = :assignedDate"),
        @NamedQuery(name = "UserCompanyRole.findByIsEnabled", query = "SELECT u FROM UserCompanyRole u WHERE u.isEnabled = :isEnabled")
    })
public class UserCompanyRole implements Serializable {

    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "user", nullable = false)
    private String user;

    @Column(name = "company", nullable = false)
    private String company;

    @Column(name = "role", nullable = false)
    private String role;

    @Column(name = "assignedDate", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date assignedDate;

    @Column(name = "isEnabled", nullable = false)
    private short isEnabled;
    
    /** Creates a new instance of UserCompanyRole */
    public UserCompanyRole() {
    }

    /**
     * Creates a new instance of UserCompanyRole with the specified values.
     * @param id the id of the UserCompanyRole
     */
    public UserCompanyRole(Integer id) {
        this.id = id;
    }

    /**
     * Creates a new instance of UserCompanyRole with the specified values.
     * @param id the id of the UserCompanyRole
     * @param user the user of the UserCompanyRole
     * @param company the company of the UserCompanyRole
     * @param role the role of the UserCompanyRole
     * @param assignedDate the assignedDate of the UserCompanyRole
     * @param isEnabled the isEnabled of the UserCompanyRole
     */
    public UserCompanyRole(Integer id, String user, String company, String role, Date assignedDate, short isEnabled) {
        this.id = id;
        this.user = user;
        this.company = company;
        this.role = role;
        this.assignedDate = assignedDate;
        this.isEnabled = isEnabled;
    }

    /**
     * Gets the id of this UserCompanyRole.
     * @return the id
     */
    public Integer getId() {
        return this.id;
    }

    /**
     * Sets the id of this UserCompanyRole to the specified value.
     * @param id the new id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Gets the user of this UserCompanyRole.
     * @return the user
     */
    public String getUser() {
        return this.user;
    }

    /**
     * Sets the user of this UserCompanyRole to the specified value.
     * @param user the new user
     */
    public void setUser(String user) {
        this.user = user;
    }

    /**
     * Gets the company of this UserCompanyRole.
     * @return the company
     */
    public String getCompany() {
        return this.company;
    }

    /**
     * Sets the company of this UserCompanyRole to the specified value.
     * @param company the new company
     */
    public void setCompany(String company) {
        this.company = company;
    }

    /**
     * Gets the role of this UserCompanyRole.
     * @return the role
     */
    public String getRole() {
        return this.role;
    }

    /**
     * Sets the role of this UserCompanyRole to the specified value.
     * @param role the new role
     */
    public void setRole(String role) {
        this.role = role;
    }

    /**
     * Gets the assignedDate of this UserCompanyRole.
     * @return the assignedDate
     */
    public Date getAssignedDate() {
        return this.assignedDate;
    }

    /**
     * Sets the assignedDate of this UserCompanyRole to the specified value.
     * @param assignedDate the new assignedDate
     */
    public void setAssignedDate(Date assignedDate) {
        this.assignedDate = assignedDate;
    }

    /**
     * Gets the isEnabled of this UserCompanyRole.
     * @return the isEnabled
     */
    public short getIsEnabled() {
        return this.isEnabled;
    }

    /**
     * Sets the isEnabled of this UserCompanyRole to the specified value.
     * @param isEnabled the new isEnabled
     */
    public void setIsEnabled(short isEnabled) {
        this.isEnabled = isEnabled;
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
     * Determines whether another object is equal to this UserCompanyRole.  The result is 
     * <code>true</code> if and only if the argument is not null and is a UserCompanyRole object that 
     * has the same id field values as this object.
     * @param object the reference object with which to compare
     * @return <code>true</code> if this object is the same as the argument;
     * <code>false</code> otherwise.
     */
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UserCompanyRole)) {
            return false;
        }
        UserCompanyRole other = (UserCompanyRole)object;
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
        return "com.abbt.timesheet.entities.UserCompanyRole[id=" + id + "]";
    }
    
}
