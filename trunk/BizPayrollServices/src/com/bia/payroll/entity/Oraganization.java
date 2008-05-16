/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.bia.payroll.entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author intesar
 */
@Entity
@Table(name = "oraganization")
@NamedQueries({@NamedQuery(name = "Oraganization.findById", query = "SELECT o FROM Oraganization o WHERE o.id = :id"), @NamedQuery(name = "Oraganization.findByName", query = "SELECT o FROM Oraganization o WHERE o.name = :name"), @NamedQuery(name = "Oraganization.findByType", query = "SELECT o FROM Oraganization o WHERE o.type = :type"), @NamedQuery(name = "Oraganization.findByDescription", query = "SELECT o FROM Oraganization o WHERE o.description = :description"), @NamedQuery(name = "Oraganization.findByLastUser", query = "SELECT o FROM Oraganization o WHERE o.lastUser = :lastUser"), @NamedQuery(name = "Oraganization.findByLastAction", query = "SELECT o FROM Oraganization o WHERE o.lastAction = :lastAction")})
public class Oraganization implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "type", nullable = false)
    private String type;
    @Column(name = "description", nullable = false)
    private String description;
    @Column(name = "last_user", nullable = false)
    private String lastUser;
    @Column(name = "last_action", nullable = false)
    private String lastAction;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "organization")
    private Collection<Users> usersCollection;

    public Oraganization() {
    }

    public Oraganization(Integer id) {
        this.id = id;
    }

    public Oraganization(Integer id, String name, String type, String description, String lastUser, String lastAction) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.description = description;
        this.lastUser = lastUser;
        this.lastAction = lastAction;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLastUser() {
        return lastUser;
    }

    public void setLastUser(String lastUser) {
        this.lastUser = lastUser;
    }

    public String getLastAction() {
        return lastAction;
    }

    public void setLastAction(String lastAction) {
        this.lastAction = lastAction;
    }

    public Collection<Users> getUsersCollection() {
        return usersCollection;
    }

    public void setUsersCollection(Collection<Users> usersCollection) {
        this.usersCollection = usersCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Oraganization)) {
            return false;
        }
        Oraganization other = (Oraganization) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bia.payroll.entity.Oraganization[id=" + id + "]";
    }

}
