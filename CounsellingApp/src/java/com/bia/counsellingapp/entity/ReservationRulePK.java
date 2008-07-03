/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.bia.counsellingapp.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author intesar
 */
@Embeddable
public class ReservationRulePK implements Serializable {
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "max_seats", nullable = false)
    private int maxSeats;

    public ReservationRulePK() {
    }

    public ReservationRulePK(String name, int maxSeats) {
        this.name = name;
        this.maxSeats = maxSeats;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMaxSeats() {
        return maxSeats;
    }

    public void setMaxSeats(int maxSeats) {
        this.maxSeats = maxSeats;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (name != null ? name.hashCode() : 0);
        hash += (int) maxSeats;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ReservationRulePK)) {
            return false;
        }
        ReservationRulePK other = (ReservationRulePK) object;
        if ((this.name == null && other.name != null) || (this.name != null && !this.name.equals(other.name))) {
            return false;
        }
        if (this.maxSeats != other.maxSeats) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bia.counselling.entity.ReservationRulePK[name=" + name + ", maxSeats=" + maxSeats + "]";
    }

}
