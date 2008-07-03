/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.bia.counsellingapp.entity;

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
@Table(name = "reversation")
@NamedQueries({
    @NamedQuery(name = "Reversation.findByName", query = "SELECT r FROM Reversation r WHERE r.name = :name"),
    @NamedQuery(name = "Reversation.findAllByPriority", query = "select r from Reversation r order by r.priority "),
    @NamedQuery(name = "Reversation.findByPercentage", query = "SELECT r FROM Reversation r WHERE r.percentage = :percentage"), 
    @NamedQuery(name = "Reversation.findByPriority", query = "SELECT r FROM Reversation r WHERE r.priority = :priority")
})
public class Reversation implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "percentage", nullable = false)
    private double percentage;
    @Column(name = "priority", nullable = false)
    private int priority;

    public Reversation() {
    }

    public Reversation(String name) {
        this.name = name;
    }

    public Reversation(String name, double percentage, int priority) {
        this.name = name;
        this.percentage = percentage;
        this.priority = priority;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPercentage() {
        return percentage;
    }

    public void setPercentage(double percentage) {
        this.percentage = percentage;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
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
        if (!(object instanceof Reversation)) {
            return false;
        }
        Reversation other = (Reversation) object;
        if ((this.name == null && other.name != null) || (this.name != null && !this.name.equals(other.name))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bia.counselling.entity.Reversation[name=" + name + "]";
    }

}
