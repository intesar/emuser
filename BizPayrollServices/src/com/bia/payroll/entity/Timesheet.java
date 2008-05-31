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
import javax.persistence.FetchType;
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
@Table(name = "timesheet")
@NamedQueries({
    @NamedQuery(name = "Timesheet.findById", query = "SELECT t FROM Timesheet t WHERE t.id = :id"),
    @NamedQuery(name = "Timesheet.findByUserIdAndStatus", query = "SELECT t FROM Timesheet t WHERE t.user.id = ?1 and t.status like ?2 "),
    @NamedQuery(name = "Timesheet.findByStartDate", query = "SELECT t FROM Timesheet t WHERE t.startDate = :startDate"),
    @NamedQuery(name = "Timesheet.findByEndDate", query = "SELECT t FROM Timesheet t WHERE t.endDate = :endDate"),
    @NamedQuery(name = "Timesheet.findBySubmisionDate", query = "SELECT t FROM Timesheet t WHERE t.submisionDate = :submisionDate"),
    @NamedQuery(name = "Timesheet.findByStatus", query = "SELECT t FROM Timesheet t WHERE t.status like ?1 "),
    @NamedQuery(name = "Timesheet.findByPaidAmount", query = "SELECT t FROM Timesheet t WHERE t.paidAmount = :paidAmount"),
    @NamedQuery(name = "Timesheet.findByStatusDate", query = "SELECT t FROM Timesheet t WHERE t.statusDate = :statusDate"),
    @NamedQuery(name = "Timesheet.findByComment", query = "SELECT t FROM Timesheet t WHERE t.comment = :comment"),
    @NamedQuery(name = "Timesheet.findByLastUser", query = "SELECT t FROM Timesheet t WHERE t.lastUser = :lastUser"),
    @NamedQuery(name = "Timesheet.findByLastAction", query = "SELECT t FROM Timesheet t WHERE t.lastAction = :lastAction"),
    @NamedQuery(name = "Timesheet.findMaxStartDate", query = " select max(t1.startDate) from Timesheet t1 where t1.user.id = ?1 "),
    @NamedQuery(name = "Timesheet.findByStartDateAndUserId", query = " select t from Timesheet t where t.startDate = ?1 and t.user.id = ?2 "),
    @NamedQuery(name = "Timesheet.findMaxOfId", query = " select max(t.id) from Timesheet t ")
})
public class Timesheet implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;
    @Column(name = "start_date", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date startDate;
    @Column(name = "end_date", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date endDate;
    @Column(name = "submision_date", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date submisionDate;
    @Column(name = "status", nullable = false)
    private String status;
    @Column(name = "paid_status", nullable = false)
    private String paidStatus;
    @Column(name = "paid_amount", nullable = false)
    private int paidAmount;
    @Column(name = "status_date", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date statusDate;
    @Column(name = "comment", nullable = false)
    private String comment;
    @Column(name = "last_user", nullable = false)
    private String lastUser;
    @Column(name = "last_action", nullable = false)
    private String lastAction;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "timesheet", fetch=FetchType.EAGER)
    private Collection<TimesheetDetail> timesheetDetailCollection;

    public Timesheet() {
    }

    public Timesheet(Integer id) {
        this.id = id;
    }

    public Timesheet(Integer id, Date startDate, Date endDate, Date submisionDate, String status, String paidStatus, int paidAmount, Date statusDate, String comment, String lastUser, String lastAction) {
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

    public int getPaidAmount() {
        return paidAmount;
    }

    public void setPaidAmount(int paidAmount) {
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
        if (!(object instanceof Timesheet)) {
            return false;
        }
        Timesheet other = (Timesheet) object;
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
