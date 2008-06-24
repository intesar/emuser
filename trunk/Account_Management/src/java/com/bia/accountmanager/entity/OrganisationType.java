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
@Table(name = "organisation_type")
@NamedQueries({@NamedQuery(name = "OrganisationType.findByName", query = "SELECT o FROM OrganisationType o WHERE o.name = :name")})
public class OrganisationType implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "name", nullable = false)
    private String name;

    public OrganisationType() {
    }

    public OrganisationType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
        if (!(object instanceof OrganisationType)) {
            return false;
        }
        OrganisationType other = (OrganisationType) object;
        if ((this.name == null && other.name != null) || (this.name != null && !this.name.equals(other.name))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bia.accountmanager.entity.OrganisationType[name=" + name + "]";
    }

}
