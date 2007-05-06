/*
 * UserRole.java
 *
 * Created on May 6, 2007, 3:49 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package com.abbt.timesheet.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * Entity class UserRole
 * 
 * @author shannan
 */
@Entity
@Table(name = "user_role")
@NamedQueries( {
        @NamedQuery(name = "UserRole.findById", query = "SELECT u FROM UserRole u WHERE u.id = :id"),
        @NamedQuery(name = "UserRole.findByUser", query = "SELECT u FROM UserRole u WHERE u.user = :user"),
        @NamedQuery(name = "UserRole.findByUserAndRole", query = "SELECT u FROM UserRole u WHERE u.user = ?1 and u.role = ?2"),
        @NamedQuery(name = "UserRole.findByRole", query = "SELECT u FROM UserRole u WHERE u.role = :role")
    })
public class UserRole implements Serializable {

    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "user", nullable = false)
    private String user;

    @Column(name = "role", nullable = false)
    private String role;
    
    /** Creates a new instance of UserRole */
    public UserRole() {
    }

    /**
     * Creates a new instance of UserRole with the specified values.
     * @param id the id of the UserRole
     */
    public UserRole(Integer id) {
        this.id = id;
    }

    /**
     * Creates a new instance of UserRole with the specified values.
     * @param id the id of the UserRole
     * @param user the user of the UserRole
     * @param role the role of the UserRole
     */
    public UserRole(Integer id, String user, String role) {
        this.id = id;
        this.user = user;
        this.role = role;
    }

    /**
     * Gets the id of this UserRole.
     * @return the id
     */
    public Integer getId() {
        return this.id;
    }

    /**
     * Sets the id of this UserRole to the specified value.
     * @param id the new id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Gets the user of this UserRole.
     * @return the user
     */
    public String getUser() {
        return this.user;
    }

    /**
     * Sets the user of this UserRole to the specified value.
     * @param user the new user
     */
    public void setUser(String user) {
        this.user = user;
    }

    /**
     * Gets the role of this UserRole.
     * @return the role
     */
    public String getRole() {
        return this.role;
    }

    /**
     * Sets the role of this UserRole to the specified value.
     * @param role the new role
     */
    public void setRole(String role) {
        this.role = role;
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
     * Determines whether another object is equal to this UserRole.  The result is 
     * <code>true</code> if and only if the argument is not null and is a UserRole object that 
     * has the same id field values as this object.
     * @param object the reference object with which to compare
     * @return <code>true</code> if this object is the same as the argument;
     * <code>false</code> otherwise.
     */
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UserRole)) {
            return false;
        }
        UserRole other = (UserRole)object;
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
        return "com.abbt.timesheet.entities.UserRole[id=" + id + "]";
    }
    
}
