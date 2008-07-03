/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bia.counsellingapp.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

/**
 *
 * @author intesar
 */
@Entity
@Table(name = "user_applied_department")
@NamedQueries({
    @NamedQuery(name = "UserAppliedDepartment.findByUserId", query = "SELECT u FROM UserAppliedDepartment u WHERE u.userId = ?1 "),
    @NamedQuery(name = "UserAppliedDepartment.findByUserIdAndPriority", query = " SELECT u FROM UserAppliedDepartment u where u.userId = ?1 and u.priority = ?2 "),
    @NamedQuery(name = "UserAppliedDepartment.findByUserIdAndCollegeAndDepartment", query = "SELECT u FROM UserAppliedDepartment u where u.userId = ?1 and u.college = ?2 and u.department = ?3 "),
    @NamedQuery(name = "UserAppliedDepartment.findByUserIdAndTopPriority", query = "select u from UserAppliedDepartment u where u.userId = ?1 and u.priority = ( select min(u1.priority) from UserAppliedDepartment u1 where u1.userId = ?2 )"),
    @NamedQuery(name = "UserAppliedDepartment.findByCollege", query = "SELECT u FROM UserAppliedDepartment u WHERE u.college = :college"), 
    @NamedQuery(name = "UserAppliedDepartment.findByDepartment", query = "SELECT u FROM UserAppliedDepartment u WHERE u.department = :department"),
    @NamedQuery(name = "UserAppliedDepartment.findByPriority", query = "SELECT u FROM UserAppliedDepartment u WHERE u.priority = :priority"),
    @NamedQuery(name = "UserAppliedDepartment.findByRegisterDate", query = "SELECT u FROM UserAppliedDepartment u WHERE u.registerDate = :registerDate"), 
    @NamedQuery(name = "UserAppliedDepartment.findById", query = "SELECT u FROM UserAppliedDepartment u WHERE u.id = :id"),
    @NamedQuery(name = "UserAppliedDepartment.findByIdOrderByPriority", query = "SELECT u FROM UserAppliedDepartment u WHERE u.userId = ?1 order by u.priority")
})
public class UserAppliedDepartment implements Serializable {

    private static final long serialVersionUID = 1L;
    @Column(name = "user_id", nullable = false)
    private int userId;
    @Column(name = "college", nullable = false)
    private String college;
    @Column(name = "department", nullable = false)
    private String department;
    @Column(name = "priority", nullable = false)
    private Integer priority;
    @Column(name = "register_date", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date registerDate;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Column(name = "decision")
    private String decision;
    @Transient
    private String priorityString;

    public UserAppliedDepartment() {
    }

    public UserAppliedDepartment(Integer id) {
        this.id = id;
    }

    public UserAppliedDepartment(Integer id, int userId, String college, String department, int priority, Date registerDate) {
        this.id = id;
        this.userId = userId;
        this.college = college;
        this.department = department;
        this.priority = priority;
        this.registerDate = registerDate;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
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

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public Date getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(Date registerDate) {
        this.registerDate = registerDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDecision() {
        return decision;
    }

    public void setDecision(String decision) {
        this.decision = decision;
    }

    public String getPriorityString() {
        return this.priority + "";
    }

    public void setPriorityString(String priorityString) {
        this.priorityString = priorityString;
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
        if (!(object instanceof UserAppliedDepartment)) {
            return false;
        }
        UserAppliedDepartment other = (UserAppliedDepartment) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bia.counsellingapp.entity.UserAppliedDepartment[id=" + id + "]";
    }
}
