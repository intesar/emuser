/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.bia.payroll.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "timesheet_detail")
@NamedQueries({@NamedQuery(name = "TimesheetDetail.findById", query = "SELECT t FROM TimesheetDetail t WHERE t.id = :id"), @NamedQuery(name = "TimesheetDetail.findByCurrentDate", query = "SELECT t FROM TimesheetDetail t WHERE t.currentDate = :currentDate"), @NamedQuery(name = "TimesheetDetail.findByRegularHour", query = "SELECT t FROM TimesheetDetail t WHERE t.regularHour = :regularHour"), @NamedQuery(name = "TimesheetDetail.findByOverTimeHour", query = "SELECT t FROM TimesheetDetail t WHERE t.overTimeHour = :overTimeHour"), @NamedQuery(name = "TimesheetDetail.findByDay", query = "SELECT t FROM TimesheetDetail t WHERE t.day = :day"), @NamedQuery(name = "TimesheetDetail.findByLastUser", query = "SELECT t FROM TimesheetDetail t WHERE t.lastUser = :lastUser"), @NamedQuery(name = "TimesheetDetail.findByLastAction", query = "SELECT t FROM TimesheetDetail t WHERE t.lastAction = :lastAction")})
public class TimesheetDetail implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;
    @Column(name = "current_date", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date currentDate;
    @Column(name = "regular_hour", nullable = false)
    private double regularHour;
    @Column(name = "over_time_hour", nullable = false)
    private double overTimeHour;
    @Column(name = "day", nullable = false)
    private String day;
    @Column(name = "last_user", nullable = false)
    private String lastUser;
    @Column(name = "last_action", nullable = false)
    private String lastAction;
    @JoinColumn(name = "timesheet", referencedColumnName = "id")
    @ManyToOne
    private Timesheet timesheet;

    public TimesheetDetail() {
    }

    public TimesheetDetail(Integer id) {
        this.id = id;
    }

    public TimesheetDetail(Integer id, Date currentDate, double regularHour, double overTimeHour, String day, String lastUser, String lastAction) {
        this.id = id;
        this.currentDate = currentDate;
        this.regularHour = regularHour;
        this.overTimeHour = overTimeHour;
        this.day = day;
        this.lastUser = lastUser;
        this.lastAction = lastAction;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getCurrentDate() {
        return currentDate;
    }

    public void setCurrentDate(Date currentDate) {
        this.currentDate = currentDate;
    }

    public double getRegularHour() {
        return regularHour;
    }

    public void setRegularHour(double regularHour) {
        this.regularHour = regularHour;
    }

    public double getOverTimeHour() {
        return overTimeHour;
    }

    public void setOverTimeHour(double overTimeHour) {
        this.overTimeHour = overTimeHour;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getLastUser() {
        return lastUser;
    }

    public void setLastUser(String lastUser) {
        this.lastUser = lastUser;
    }

    public String getLastAction() {
        return lastAction;
    }

    public void setLastAction(String lastAction) {
        this.lastAction = lastAction;
    }

    public Timesheet getTimesheet() {
        return timesheet;
    }

    public void setTimesheet(Timesheet timesheet) {
        this.timesheet = timesheet;
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
        if (!(object instanceof TimesheetDetail)) {
            return false;
        }
        TimesheetDetail other = (TimesheetDetail) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bia.payroll.entity.TimesheetDetail[id=" + id + "]";
    }

}
