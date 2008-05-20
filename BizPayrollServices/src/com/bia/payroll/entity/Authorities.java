/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.bia.payroll.entity;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author intesar
 */
@Entity
@Table(name = "authorities")
@NamedQueries({@NamedQuery(name = "Authorities.findByUsername", query = "SELECT a FROM Authorities a WHERE a.authoritiesPK.username = ?1"), @NamedQuery(name = "Authorities.findByAuthority", query = "SELECT a FROM Authorities a WHERE a.authoritiesPK.authority = :authority")})
public class Authorities implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected AuthoritiesPK authoritiesPK;
    @JoinColumn(name = "authority", referencedColumnName = "role", insertable = false, updatable = false)
    @ManyToOne
    private Authority authority1;

    public Authorities() {
    }

    public Authorities(AuthoritiesPK authoritiesPK) {
        this.authoritiesPK = authoritiesPK;
    }

    public Authorities(String username, String authority) {
        this.authoritiesPK = new AuthoritiesPK(username, authority);
    }

    public AuthoritiesPK getAuthoritiesPK() {
        return authoritiesPK;
    }

    public void setAuthoritiesPK(AuthoritiesPK authoritiesPK) {
        this.authoritiesPK = authoritiesPK;
    }

    public Authority getAuthority1() {
        return authority1;
    }

    public void setAuthority1(Authority authority1) {
        this.authority1 = authority1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (authoritiesPK != null ? authoritiesPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Authorities)) {
            return false;
        }
        Authorities other = (Authorities) object;
        if ((this.authoritiesPK == null && other.authoritiesPK != null) || (this.authoritiesPK != null && !this.authoritiesPK.equals(other.authoritiesPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bia.payroll.entity.Authorities[authoritiesPK=" + authoritiesPK + "]";
    }

}
