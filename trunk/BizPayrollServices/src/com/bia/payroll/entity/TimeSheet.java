/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.bia.payroll.entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author intesar
 */
@Entity
@Table(name = "time_sheet")
@NamedQueries({@NamedQuery(name = "TimeSheet.findById", query = "SELECT t FROM TimeSheet t WHERE t.id = :id"), @NamedQuery(name = "TimeSheet.findByStartDate", query = "SELECT t FROM TimeSheet t WHERE t.startDate = :startDate"), @NamedQuery(name = "TimeSheet.findByEndDate", query = "SELECT t FROM TimeSheet t WHERE t.endDate = :endDate"), @NamedQuery(name = "TimeSheet.findBySubmisionDate", query = "SELECT t FROM TimeSheet t WHERE t.submisionDate = :submisionDate"), @NamedQuery(name = "TimeSheet.findByStatus", query = "SELECT t FROM TimeSheet t WHERE t.status = :status"), @NamedQuery(name = "TimeSheet.findByPaidStatus", query = "SELECT t FROM TimeSheet t WHERE t.paidStatus = :paidStatus"), @NamedQuery(name = "TimeSheet.findByPaidAmount", query = "SELECT t FROM TimeSheet t WHERE t.paidAmount = :paidAmount"), @NamedQuery(name = "TimeSheet.findByStatusDate", query = "SELECT t FROM TimeSheet t WHERE t.statusDate = :statusDate"), @NamedQuery(name = "TimeSheet.findByComment", query = "SELECT t FROM TimeSheet t WHERE t.comment = :comment"), @NamedQuery(name = "TimeSheet.findByLastUser", query = "SELECT t FROM TimeSheet t WHERE t.lastUser = :lastUser"), @NamedQuery(name = "TimeSheet.findByLastAction", query = "SELECT t FROM TimeSheet t WHERE t.lastAction = :lastAction")})
public class TimeSheet implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;
    @Column(name = "start_date", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date startDate;
    @Column(name = "end_date", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date endDate;
    @Column(name = "submision_date", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date submisionDate;
    @Column(name = "status", nullable = false)
    private String status;
    @Column(name = "paid_status", nullable = false)
    private String paidStatus;
    @Column(name = "paid_amount", nullable = false)
    private Double paidAmount;
    @Column(name = "status_date", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date statusDate;
    @Column(name = "comment", nullable = false)
    private String comment;
    @Column(name = "last_user", nullable = false)
    private String lastUser;
    @Column(name = "last_action", nullable = false)
    private String lastAction;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "timesheet")
    private Collection<TimesheetDetail> timesheetDetailCollection;

    public TimeSheet() {
    }

    public TimeSheet(Integer id) {
        this.id = id;
    }

    public TimeSheet(Integer id, Date startDate, Date endDate, Date submisionDate, String status, String paidStatus, Double paidAmount, Date statusDate, String comment, String lastUser, String lastAction) {
        this.id = id;
        this.startDate = startDate;
        this.endDate = endDate;
        this.submisionDate = submisionDate;
        this.status = status;
        this.paidStatus = paidStatus;
        this.paidAmount = paidAmount;
        this.statusDate = statusDate;
        this.comment = comment;
        this.lastUser = lastUser;
        this.lastAction = lastAction;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Date getSubmisionDate() {
        return submisionDate;
    }

    public void setSubmisionDate(Date submisionDate) {
        this.submisionDate = submisionDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPaidStatus() {
        return paidStatus;
    }

    public void setPaidStatus(String paidStatus) {
        this.paidStatus = paidStatus;
    }

    public Double getPaidAmount() {
        return paidAmount;
    }

    public void setPaidAmount(Double paidAmount) {
        this.paidAmount = paidAmount;
    }

    public Date getStatusDate() {
        return statusDate;
    }

    public void setStatusDate(Date statusDate) {
        this.statusDate = statusDate;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
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

    public Collection<TimesheetDetail> getTimesheetDetailCollection() {
        return timesheetDetailCollection;
    }

    public void setTimesheetDetailCollection(Collection<TimesheetDetail> timesheetDetailCollection) {
        this.timesheetDetailCollection = timesheetDetailCollection;
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
        if (!(object instanceof TimeSheet)) {
            return false;
        }
        TimeSheet other = (TimeSheet) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bia.payroll.entity.TimeSheet[id=" + id + "]";
    }

}
