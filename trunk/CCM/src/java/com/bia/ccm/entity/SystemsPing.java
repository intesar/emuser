/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.bia.ccm.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author intesar
 */
@Entity
@Table(name = "systems_ping")
@NamedQueries({})
public class SystemsPing implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;
    @Column(name = "message", nullable = false)
    private String message;
    @Column(name = "message_time", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date messageTime;
    @JoinColumn(name = "systems", referencedColumnName = "id")
    @ManyToOne
    private Systems systems;

    public SystemsPing() {
    }

    public SystemsPing(Integer id) {
        this.id = id;
    }

    public SystemsPing(Integer id, String message, Date messageTime) {
        this.id = id;
        this.message = message;
        this.messageTime = messageTime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getMessageTime() {
        return messageTime;
    }

    public void setMessageTime(Date messageTime) {
        this.messageTime = messageTime;
    }

    public Systems getSystems() {
        return systems;
    }

    public void setSystems(Systems systems) {
        this.systems = systems;
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
        if (!(object instanceof SystemsPing)) {
            return false;
        }
        SystemsPing other = (SystemsPing) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bia.ccm.entity.SystemsPing[id=" + id + "]";
    }

}
