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
@Table(name = "college_department_seats_status")
@NamedQueries({
    @NamedQuery(name = "CollegeDepartmentSeatsStatus.findByCollegeName", query = "SELECT c FROM CollegeDepartmentSeatsStatus c WHERE c.collegeDepartmentSeatsStatusPK.college = ?1 "),   
    @NamedQuery(name = "CollegeDepartmentSeatsStatus.findByCollegeAndDepartmentAndName", query = "SELECT c FROM CollegeDepartmentSeatsStatus c WHERE c.collegeDepartmentSeatsStatusPK.college = ?1 and c.collegeDepartmentSeatsStatusPK.department = ?2 and c.collegeDepartmentSeatsStatusPK.reversationName = ?3 "),
    @NamedQuery(name = "CollegeDepartmentSeatsStatus.findByDepartment", query = "SELECT c FROM CollegeDepartmentSeatsStatus c WHERE c.collegeDepartmentSeatsStatusPK.department = :department"), 
    @NamedQuery(name = "CollegeDepartmentSeatsStatus.findByReversationName", query = "SELECT c FROM CollegeDepartmentSeatsStatus c WHERE c.collegeDepartmentSeatsStatusPK.reversationName = :reversationName")})
public class CollegeDepartmentSeatsStatus implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CollegeDepartmentSeatsStatusPK collegeDepartmentSeatsStatusPK;
    @Column(name = "male_total_seats", nullable = false)
    private Integer maleTotalSeats;
    @Column(name = "male_available_seats", nullable = false)
    private Integer maleAvailableSeats;
    @Column(name = "female_total_seats", nullable = false)
    private Integer femaleTotalSeats;
    @Column(name = "female_available_seats", nullable = false)
    private Integer femaleAvailableSeats;

    public CollegeDepartmentSeatsStatus() {
    }

    public CollegeDepartmentSeatsStatus(CollegeDepartmentSeatsStatusPK collegeDepartmentSeatsStatusPK) {
        this.collegeDepartmentSeatsStatusPK = collegeDepartmentSeatsStatusPK;
    }

    public CollegeDepartmentSeatsStatus(CollegeDepartmentSeatsStatusPK collegeDepartmentSeatsStatusPK, String totalSeats, String availableSeats) {
        this.collegeDepartmentSeatsStatusPK = collegeDepartmentSeatsStatusPK;
        
    }

    public CollegeDepartmentSeatsStatus(String college, String department, String reversationName) {
        this.collegeDepartmentSeatsStatusPK = new CollegeDepartmentSeatsStatusPK(college, department, reversationName);
    }

    public CollegeDepartmentSeatsStatusPK getCollegeDepartmentSeatsStatusPK() {
        return collegeDepartmentSeatsStatusPK;
    }

    public void setCollegeDepartmentSeatsStatusPK(CollegeDepartmentSeatsStatusPK collegeDepartmentSeatsStatusPK) {
        this.collegeDepartmentSeatsStatusPK = collegeDepartmentSeatsStatusPK;
    }

    public Integer getFemaleAvailableSeats() {
        return femaleAvailableSeats;
    }

    public void setFemaleAvailableSeats(Integer femaleAvailableSeats) {
        this.femaleAvailableSeats = femaleAvailableSeats;
    }

    public Integer getFemaleTotalSeats() {
        return femaleTotalSeats;
    }

    public void setFemaleTotalSeats(Integer femaleTotalSeats) {
        this.femaleTotalSeats = femaleTotalSeats;
    }

    public Integer getMaleAvailableSeats() {
        return maleAvailableSeats;
    }

    public void setMaleAvailableSeats(Integer maleAvailableSeats) {
        this.maleAvailableSeats = maleAvailableSeats;
    }

    public Integer getMaleTotalSeats() {
        return maleTotalSeats;
    }

    public void setMaleTotalSeats(Integer maleTotalSeats) {
        this.maleTotalSeats = maleTotalSeats;
    }

   

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (collegeDepartmentSeatsStatusPK != null ? collegeDepartmentSeatsStatusPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CollegeDepartmentSeatsStatus)) {
            return false;
        }
        CollegeDepartmentSeatsStatus other = (CollegeDepartmentSeatsStatus) object;
        if ((this.collegeDepartmentSeatsStatusPK == null && other.collegeDepartmentSeatsStatusPK != null) || (this.collegeDepartmentSeatsStatusPK != null && !this.collegeDepartmentSeatsStatusPK.equals(other.collegeDepartmentSeatsStatusPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return  collegeDepartmentSeatsStatusPK.toString() ;
    }

}
