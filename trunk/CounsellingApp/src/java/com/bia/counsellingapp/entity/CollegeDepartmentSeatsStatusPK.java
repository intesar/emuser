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
public class CollegeDepartmentSeatsStatusPK implements Serializable {
    @Column(name = "college", nullable = false)
    private String college;
    @Column(name = "department", nullable = false)
    private String department;
    @Column(name = "reversation_name", nullable = false)
    private String reversationName;

    public CollegeDepartmentSeatsStatusPK() {
    }

    public CollegeDepartmentSeatsStatusPK(String college, String department, String reversationName) {
        this.college = college;
        this.department = department;
        this.reversationName = reversationName;
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

    public String getReversationName() {
        return reversationName;
    }

    public void setReversationName(String reversationName) {
        this.reversationName = reversationName;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (college != null ? college.hashCode() : 0);
        hash += (department != null ? department.hashCode() : 0);
        hash += (reversationName != null ? reversationName.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CollegeDepartmentSeatsStatusPK)) {
            return false;
        }
        CollegeDepartmentSeatsStatusPK other = (CollegeDepartmentSeatsStatusPK) object;
        if ((this.college == null && other.college != null) || (this.college != null && !this.college.equals(other.college))) {
            return false;
        }
        if ((this.department == null && other.department != null) || (this.department != null && !this.department.equals(other.department))) {
            return false;
        }
        if ((this.reversationName == null && other.reversationName != null) || (this.reversationName != null && !this.reversationName.equals(other.reversationName))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bia.counsellingapp.entity.CollegeDepartmentSeatsStatusPK[college=" + college + ", department=" + department + ", reversationName=" + reversationName + "]";
    }

}
