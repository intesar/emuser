/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.bia.imec.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author intesar
 */
@Entity
@Table(name = "users")
@NamedQueries({
    @NamedQuery(name = "User.findByUsersname", query = "SELECT u FROM User u WHERE u.usersname = ?1 "), 
    @NamedQuery(name = "User.findByPassword", query = "SELECT u FROM User u WHERE u.password = :password"), 
    @NamedQuery(name = "User.findByFirstname", query = "SELECT u FROM User u WHERE u.firstname = :firstname"),
    @NamedQuery(name = "User.findByLastname", query = "SELECT u FROM User u WHERE u.lastname = :lastname"),
    @NamedQuery(name = "User.findByEnable", query = "SELECT u FROM User u WHERE u.enable = :enable"), 
    @NamedQuery(name = "User.findByIsadmin", query = "SELECT u FROM User u WHERE u.isadmin = :isadmin")
})
public class User implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "username", nullable = false)
    private String usersname;
    @Column(name = "password", nullable = false)
    private String password;
    @Column(name = "firstname")
    private String firstname;
    @Column(name = "lastname")
    private String lastname;
    @Column(name = "enabled")
    private Short enable;
    @Column(name = "Is_admin")
    private Short isadmin;

    public User() {
    }

    public User(String usersname) {
        this.usersname = usersname;
    }

    public User(String usersname, String password) {
        this.usersname = usersname;
        this.password = password;
    }

    public String getUsersname() {
        return usersname;
    }

    public void setUsersname(String usersname) {
        this.usersname = usersname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Short getEnable() {
        return enable;
    }

    public void setEnable(Short enable) {
        this.enable = enable;
    }

    public Short getIsadmin() {
        return isadmin;
    }

    public void setIsadmin(Short isadmin) {
        this.isadmin = isadmin;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (usersname != null ? usersname.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof User)) {
            return false;
        }
        User other = (User) object;
        if ((this.usersname == null && other.usersname != null) || (this.usersname != null && !this.usersname.equals(other.usersname))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bia.imec.entity.User[usersname=" + usersname + "]";
    }

}
