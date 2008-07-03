/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.bia.counsellingapp.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author intesar
 */
@Entity
@Table(name = "reservation_rule")
@NamedQueries({
    @NamedQuery(name = "ReservationRule.findByName", query = "SELECT r FROM ReservationRule r WHERE r.reservationRulePK.name = :name"), 
    @NamedQuery(name = "ReservationRule.findByMaxSeats", query = "SELECT r FROM ReservationRule r WHERE r.reservationRulePK.maxSeats = ?1 "),
    @NamedQuery(name = "ReservationRule.findByReserverSeats", query = "SELECT r FROM ReservationRule r WHERE r.reserverSeats = :reserverSeats"),
    @NamedQuery(name = "ReservationRule.findByNameAndMaxSeats", query = "SELECT r FROM ReservationRule r WHERE r.reservationRulePK.name = ?1 and r.reservationRulePK.maxSeats = ?2 ")
})
public class ReservationRule implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ReservationRulePK reservationRulePK;
    @Column(name = "reserver_seats", nullable = false)
    private int reserverSeats;

    public ReservationRule() {
    }

    public ReservationRule(ReservationRulePK reservationRulePK) {
        this.reservationRulePK = reservationRulePK;
    }

    public ReservationRule(ReservationRulePK reservationRulePK, int reserverSeats) {
        this.reservationRulePK = reservationRulePK;
        this.reserverSeats = reserverSeats;
    }

    public ReservationRule(String name, int maxSeats) {
        this.reservationRulePK = new ReservationRulePK(name, maxSeats);
    }

    public ReservationRulePK getReservationRulePK() {
        return reservationRulePK;
    }

    public void setReservationRulePK(ReservationRulePK reservationRulePK) {
        this.reservationRulePK = reservationRulePK;
    }

    public int getReserverSeats() {
        return reserverSeats;
    }

    public void setReserverSeats(int reserverSeats) {
        this.reserverSeats = reserverSeats;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (reservationRulePK != null ? reservationRulePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ReservationRule)) {
            return false;
        }
        ReservationRule other = (ReservationRule) object;
        if ((this.reservationRulePK == null && other.reservationRulePK != null) || (this.reservationRulePK != null && !this.reservationRulePK.equals(other.reservationRulePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bia.counselling.entity.ReservationRule[reservationRulePK=" + reservationRulePK + "]";
    }

}
