/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.bia.counsellingapp.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author intesar
 */
@Entity
@Table(name = "users")
@NamedQueries({
    @NamedQuery(name = "Users.findById", query = "SELECT u FROM Users u WHERE u.id = :id"), 
    @NamedQuery(name = "Users.findAllOrderbyRank", query = "SELECT u FROM Users u order by u.rank "),
    @NamedQuery(name = "Users.findByUsername", query = "SELECT u FROM Users u WHERE u.username = ?1 "), @NamedQuery(name = "Users.findByPassword", query = "SELECT u FROM Users u WHERE u.password = :password"), @NamedQuery(name = "Users.findByEnabled", query = "SELECT u FROM Users u WHERE u.enabled = :enabled"), @NamedQuery(name = "Users.findByName", query = "SELECT u FROM Users u WHERE u.name = :name"), @NamedQuery(name = "Users.findByDob", query = "SELECT u FROM Users u WHERE u.dob = :dob"), @NamedQuery(name = "Users.findByFathersName", query = "SELECT u FROM Users u WHERE u.fathersName = :fathersName"), @NamedQuery(name = "Users.findByGender", query = "SELECT u FROM Users u WHERE u.gender = :gender"), @NamedQuery(name = "Users.findByCaste", query = "SELECT u FROM Users u WHERE u.caste = :caste"), @NamedQuery(name = "Users.findByHallTicketNo", query = "SELECT u FROM Users u WHERE u.hallTicketNo = :hallTicketNo"), @NamedQuery(name = "Users.findByEntranceYear", query = "SELECT u FROM Users u WHERE u.entranceYear = :entranceYear"), @NamedQuery(name = "Users.findByRank", query = "SELECT u FROM Users u WHERE u.rank = :rank"), @NamedQuery(name = "Users.findByUserType", query = "SELECT u FROM Users u WHERE u.userType = :userType")})
public class Users implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;
    @Column(name = "username", nullable = false)
    private String username;
    @Column(name = "password", nullable = false)
    private String password;
    @Column(name = "enabled", nullable = false)
    private boolean enabled;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "dob")
    @Temporal(TemporalType.DATE)
    private Date dob;
    @Column(name = "fathers_name")
    private String fathersName;
    @Column(name = "gender")
    private String gender;
    @Column(name = "caste")
    private String caste;
    @Column(name = "hall_ticket_no", nullable = false)
    private int hallTicketNo;
    @Column(name = "entrance_year")
    private Short entranceYear;
    @Column(name = "rank")
    private Integer rank;
    @Column(name = "user_type")
    private String userType;
    @Column(name = "admitted", nullable = false)
    private boolean admitted;
    @Column(name = "admission_criteria")
    private String admissionCriteria;
    @Column(name = "ncc_acc_certified", nullable = false)
    private boolean nccAccCertified;
    @Column(name = "sport_games_certified", nullable = false)
    private boolean sportGamesCertified;
    @Column(name = "extra_curricular", nullable = false)
    private boolean extraCurricular;
    @Column(name = "parent_ex_servicemen", nullable = false)
    private boolean parentExServicemen;
    @Column(name = "physically_handicap", nullable = false)
    private boolean physicallyHandicap;
    @Column(name = "college")
    private String college;
    @Column(name = "department")
    private String department;
    
    
    public Users() {
    }

    public Users(Integer id) {
        this.id = id;
    }

    public Users(Integer id, String username, String password, boolean enabled, String name, int hallTicketNo) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.enabled = enabled;
        this.name = name;
        this.hallTicketNo = hallTicketNo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getFathersName() {
        return fathersName;
    }

    public void setFathersName(String fathersName) {
        this.fathersName = fathersName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getCaste() {
        return caste;
    }

    public void setCaste(String caste) {
        this.caste = caste;
    }

    public int getHallTicketNo() {
        return hallTicketNo;
    }

    public void setHallTicketNo(int hallTicketNo) {
        this.hallTicketNo = hallTicketNo;
    }

    public Short getEntranceYear() {
        return entranceYear;
    }

    public void setEntranceYear(Short entranceYear) {
        this.entranceYear = entranceYear;
    }

    public Integer getRank() {
        return rank;
    }

    public void setRank(Integer rank) {
        this.rank = rank;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public boolean isAdmitted() {
        return admitted;
    }

    public void setAdmitted(boolean admitted) {
        this.admitted = admitted;
    }

    public String getAdmissionCriteria() {
        return admissionCriteria;
    }

    public void setAdmissionCriteria(String admissionCriteria) {
        this.admissionCriteria = admissionCriteria;
    }

    
    public boolean isExtraCurricular() {
        return extraCurricular;
    }

    public void setExtraCurricular(boolean extraCurricular) {
        this.extraCurricular = extraCurricular;
    }

    public boolean isNccAccCertified() {
        return nccAccCertified;
    }

    public void setNccAccCertified(boolean nccAccCertified) {
        this.nccAccCertified = nccAccCertified;
    }

    public boolean isParentExServicemen() {
        return parentExServicemen;
    }

    public void setParentExServicemen(boolean parentExServicemen) {
        this.parentExServicemen = parentExServicemen;
    }

    public boolean isPhysicallyHandicap() {
        return physicallyHandicap;
    }

    public void setPhysicallyHandicap(boolean physicallyHandicap) {
        this.physicallyHandicap = physicallyHandicap;
    }

    public boolean isSportGamesCertified() {
        return sportGamesCertified;
    }

    public void setSportGamesCertified(boolean sportGamesCertified) {
        this.sportGamesCertified = sportGamesCertified;
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
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Users)) {
            return false;
        }
        Users other = (Users) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bia.counsellingapp.entity.Users[id=" + id + "]";
    }

}
