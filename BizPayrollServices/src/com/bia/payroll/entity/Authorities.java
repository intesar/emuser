/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.bia.payroll.entity;

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
@Table(name = "authorities")
@NamedQueries({
    @NamedQuery(name = "Authorities.findByUsername", query = "SELECT a FROM Authorities a WHERE a.username = ?1 "), 
    @NamedQuery(name = "Authorities.findByAuthority", query = "SELECT a FROM Authorities a WHERE a.authority = :authority"), 
    @NamedQuery(name = "Authorities.findById", query = "SELECT a FROM Authorities a WHERE a.id = :id"),
    @NamedQuery(name = "Authorities.findByUsernameAndAuthority", query = "SELECT a FROM Authorities a WHERE a.username = ?1 and a.authority = ?2 "),
    @NamedQuery(name = "Authorities.findAndDeleteByUsernameAndAuthority", query = " delete from Authorities a where a.username = ?1 and a.authority = ?2 ")
})
public class Authorities implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(name = "username", nullable = false)
    private String username;
    @Column(name = "authority", nullable = false)
    private String authority;
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    public Authorities() {
    }

    public Authorities(Integer id) {
        this.id = id;
    }

    public Authorities( String username, String authority) {        
        this.username = username;
        this.authority = authority;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
        if (!(object instanceof Authorities)) {
            return false;
        }
        Authorities other = (Authorities) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bia.payroll.entity.Authorities[id=" + id + "]";
    }

}
