/*
 *  Copyright 2008 intesar.
 * 
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 * 
 *       http://www.apache.org/licenses/LICENSE-2.0
 * 
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 *  under the License.
 */

package com.bizintelapps.promanager.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "organization_users")
@NamedQueries({@NamedQuery(name = "OrganizationUsers.findById", query = "SELECT o FROM OrganizationUsers o WHERE o.id = :id"), @NamedQuery(name = "OrganizationUsers.findByCreateDate", query = "SELECT o FROM OrganizationUsers o WHERE o.createDate = :createDate"), @NamedQuery(name = "OrganizationUsers.findByIsEnabled", query = "SELECT o FROM OrganizationUsers o WHERE o.isEnabled = :isEnabled"), @NamedQuery(name = "OrganizationUsers.findByExpirationDate", query = "SELECT o FROM OrganizationUsers o WHERE o.expirationDate = :expirationDate")})
public class OrganizationUsers implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;
    @Column(name = "create_date", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;
    @Column(name = "is_enabled", nullable = false)
    private boolean isEnabled;
    @Column(name = "expiration_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date expirationDate;
    @JoinColumn(name = "organization", referencedColumnName = "id")
    @ManyToOne
    private Organization organization;
    @JoinColumn(name = "users", referencedColumnName = "id")
    @ManyToOne
    private Users users;
    @JoinColumn(name = "create_user", referencedColumnName = "id")
    @ManyToOne
    private Users createUser;

    public OrganizationUsers() {
    }

    public OrganizationUsers(Integer id) {
        this.id = id;
    }

    public OrganizationUsers(Integer id, Date createDate, boolean isEnabled) {
        this.id = id;
        this.createDate = createDate;
        this.isEnabled = isEnabled;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public boolean getIsEnabled() {
        return isEnabled;
    }

    public void setIsEnabled(boolean isEnabled) {
        this.isEnabled = isEnabled;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    public Organization getOrganization() {
        return organization;
    }

    public void setOrganization(Organization organization) {
        this.organization = organization;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    public Users getCreateUser() {
        return createUser;
    }

    public void setCreateUser(Users createUser) {
        this.createUser = createUser;
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
        if (!(object instanceof OrganizationUsers)) {
            return false;
        }
        OrganizationUsers other = (OrganizationUsers) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bizintelapps.promanager.entity.OrganizationUsers[id=" + id + "]";
    }

}
