/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.bia.accountmanager.entity;

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
@Table(name = "payees")
@NamedQueries({@NamedQuery(name = "Payees.findByName", query = "SELECT p FROM Payees p WHERE p.name = :name"), @NamedQuery(name = "Payees.findByDescription", query = "SELECT p FROM Payees p WHERE p.description = :description"), @NamedQuery(name = "Payees.findByOrganization", query = "SELECT p FROM Payees p WHERE p.organization = :organization"), @NamedQuery(name = "Payees.findByGlobal", query = "SELECT p FROM Payees p WHERE p.global = :global")})
public class Payees implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "description")
    private String description;
    @Column(name = "organization", nullable = false)
    private String organization;
    @Column(name = "global")
    private Boolean global;

    public Payees() {
    }

    public Payees(String name) {
        this.name = name;
    }

    public Payees(String name, String organization) {
        this.name = name;
        this.organization = organization;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getOrganization() {
        return organization;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }

    public Boolean getGlobal() {
        return global;
    }

    public void setGlobal(Boolean global) {
        this.global = global;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (name != null ? name.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Payees)) {
            return false;
        }
        Payees other = (Payees) object;
        if ((this.name == null && other.name != null) || (this.name != null && !this.name.equals(other.name))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bia.accountmanager.entity.Payees[name=" + name + "]";
    }

}
