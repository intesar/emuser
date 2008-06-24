/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.bia.accountmanager.entity;

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
 *
 * @author intesar
 */
@Entity
@Table(name = "organization")
@NamedQueries({@NamedQuery(name = "Organization.findByName", query = "SELECT o FROM Organization o WHERE o.name = :name"), @NamedQuery(name = "Organization.findByLicenceType", query = "SELECT o FROM Organization o WHERE o.licenceType = :licenceType"), @NamedQuery(name = "Organization.findByExpirationDate", query = "SELECT o FROM Organization o WHERE o.expirationDate = :expirationDate"), @NamedQuery(name = "Organization.findByRegisterTo", query = "SELECT o FROM Organization o WHERE o.registerTo = :registerTo"), @NamedQuery(name = "Organization.findByIsExpired", query = "SELECT o FROM Organization o WHERE o.isExpired = :isExpired")})
public class Organization implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "licence_type", nullable = false)
    private String licenceType;
    @Column(name = "expiration_date", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date expirationDate;
    @Column(name = "register_to", nullable = false)
    private String registerTo;
    @Column(name = "is_expired", nullable = false)
    private boolean isExpired;

    public Organization() {
    }

    public Organization(String name) {
        this.name = name;
    }

    public Organization(String name, String licenceType, Date expirationDate, String registerTo, boolean isExpired) {
        this.name = name;
        this.licenceType = licenceType;
        this.expirationDate = expirationDate;
        this.registerTo = registerTo;
        this.isExpired = isExpired;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLicenceType() {
        return licenceType;
    }

    public void setLicenceType(String licenceType) {
        this.licenceType = licenceType;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    public String getRegisterTo() {
        return registerTo;
    }

    public void setRegisterTo(String registerTo) {
        this.registerTo = registerTo;
    }

    public boolean getIsExpired() {
        return isExpired;
    }

    public void setIsExpired(boolean isExpired) {
        this.isExpired = isExpired;
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
        if (!(object instanceof Organization)) {
            return false;
        }
        Organization other = (Organization) object;
        if ((this.name == null && other.name != null) || (this.name != null && !this.name.equals(other.name))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bia.accountmanager.entity.Organization[name=" + name + "]";
    }

}
