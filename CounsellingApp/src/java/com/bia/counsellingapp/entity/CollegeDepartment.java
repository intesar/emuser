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
@Table(name = "college_department")
@NamedQueries({
    @NamedQuery(name = "CollegeDepartment.findByCollege", query = "SELECT c.collegeDepartmentPK.department FROM CollegeDepartment c WHERE c.collegeDepartmentPK.college = ?1 "),
    @NamedQuery(name = "CollegeDepartment.findByCollegeName", query = "SELECT c FROM CollegeDepartment c WHERE c.collegeDepartmentPK.college = ?1 "),
    @NamedQuery(name = "CollegeDepartment.findByCollegeAndDepartment", query = "SELECT c from CollegeDepartment c where c.collegeDepartmentPK.college = ?1 and c.collegeDepartmentPK.department = ?2 "),
    @NamedQuery(name = "CollegeDepartment.findByDepartment", query = "SELECT c FROM CollegeDepartment c WHERE c.collegeDepartmentPK.department = :department"), 
    @NamedQuery(name = "CollegeDepartment.findByMaxSeats", query = "SELECT c FROM CollegeDepartment c WHERE c.maxSeats = :maxSeats"),
    @NamedQuery(name = "CollegeDepartment.findById", query = "select c from CollegeDepartment c where c.id = ?1 ")
})
public class CollegeDepartment implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CollegeDepartmentPK collegeDepartmentPK;
    @Column(name = "max_seats")
    private Integer maxSeats;
    @Column(name = "filled_seats", nullable = false)
    private int filledSeats;
    @Column(name= "id")
    private Integer id;

    public CollegeDepartment() {
    }

    public CollegeDepartment(CollegeDepartmentPK collegeDepartmentPK) {
        this.collegeDepartmentPK = collegeDepartmentPK;
    }

    public CollegeDepartment(String college, String department) {
        this.collegeDepartmentPK = new CollegeDepartmentPK(college, department);
    }

    public CollegeDepartmentPK getCollegeDepartmentPK() {
        return collegeDepartmentPK;
    }

    public void setCollegeDepartmentPK(CollegeDepartmentPK collegeDepartmentPK) {
        this.collegeDepartmentPK = collegeDepartmentPK;
    }

    public Integer getMaxSeats() {
        return maxSeats;
    }

    public void setMaxSeats(Integer maxSeats) {
        this.maxSeats = maxSeats;
    }

     public int getFilledSeats() {
        return filledSeats;
    }

    public void setFilledSeats(int filledSeats) {
        this.filledSeats = filledSeats;
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
        hash += (collegeDepartmentPK != null ? collegeDepartmentPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CollegeDepartment)) {
            return false;
        }
        CollegeDepartment other = (CollegeDepartment) object;
        if ((this.collegeDepartmentPK == null && other.collegeDepartmentPK != null) || (this.collegeDepartmentPK != null && !this.collegeDepartmentPK.equals(other.collegeDepartmentPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bia.counsellingapp.entity.CollegeDepartment[collegeDepartmentPK=" + collegeDepartmentPK + "]";
    }

}
