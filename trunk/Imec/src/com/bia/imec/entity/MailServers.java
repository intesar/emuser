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
@Table(name = "mail_servers")
@NamedQueries({@NamedQuery(name = "MailServers.findById", query = "SELECT m FROM MailServers m WHERE m.id = :id"), @NamedQuery(name = "MailServers.findByHost", query = "SELECT m FROM MailServers m WHERE m.host = :host"), @NamedQuery(name = "MailServers.findByUsername", query = "SELECT m FROM MailServers m WHERE m.username = :username"), @NamedQuery(name = "MailServers.findByPassword", query = "SELECT m FROM MailServers m WHERE m.password = :password")})
public class MailServers implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;
    @Column(name = "host")
    private String host;
    @Column(name = "username")
    private String username;
    @Column(name = "password")
    private String password;

    public MailServers() {
    }

    public MailServers(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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
        if (!(object instanceof MailServers)) {
            return false;
        }
        MailServers other = (MailServers) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bia.imec.entity.MailServers[id=" + id + "]";
    }

}
