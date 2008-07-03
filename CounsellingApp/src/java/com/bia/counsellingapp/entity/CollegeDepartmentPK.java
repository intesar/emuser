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
public class CollegeDepartmentPK implements Serializable {
    @Column(name = "college", nullable = false)
    private String college;
    @Column(name = "department", nullable = false)
    private String department;

    public CollegeDepartmentPK() {
    }

    public CollegeDepartmentPK(String college, String department) {
        this.college = college;
        this.department = department;
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (college != null ? college.hashCode() : 0);
        hash += (department != null ? department.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CollegeDepartmentPK)) {
            return false;
        }
        CollegeDepartmentPK other = (CollegeDepartmentPK) object;
        if ((this.college == null && other.college != null) || (this.college != null && !this.college.equals(other.college))) {
            return false;
        }
        if ((this.department == null && other.department != null) || (this.department != null && !this.department.equals(other.department))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bia.counsellingapp.entity.CollegeDepartmentPK[college=" + college + ", department=" + department + "]";
    }

}
