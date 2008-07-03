/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.bia.ccm.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author intesar
 */
@Entity
@Table(name = "system_lease")
@NamedQueries({})
public class SystemLease implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;
    @Column(name = "lease_holder_name")
    private String leaseHolderName;
    @Column(name = "start_time", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date startTime;
    @Column(name = "end_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date endTime;
    @Column(name = "payable_amount")
    private Double payableAmount;
    @Column(name = "amount_paid")
    private Double amountPaid;
    @Column(name = "issue_agent", nullable = false)
    private String issueAgent;
    @Column(name = "return_agent")
    private String returnAgent;
    @Column(name = "total_minutes_used")
    private Double totalMinutesUsed;
    @Column(name = "system", nullable = false)
    private int system;
    @Column(name = "is_finished", nullable = false)
    private boolean isFinished;

    public SystemLease() {
    }

    public SystemLease(Integer id) {
        this.id = id;
    }

    public SystemLease(Integer id, Date startTime, String issueAgent, int system, boolean isFinished) {
        this.id = id;
        this.startTime = startTime;
        this.issueAgent = issueAgent;
        this.system = system;
        this.isFinished = isFinished;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLeaseHolderName() {
        return leaseHolderName;
    }

    public void setLeaseHolderName(String leaseHolderName) {
        this.leaseHolderName = leaseHolderName;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Double getPayableAmount() {
        return payableAmount;
    }

    public void setPayableAmount(Double payableAmount) {
        this.payableAmount = payableAmount;
    }

    public Double getAmountPaid() {
        return amountPaid;
    }

    public void setAmountPaid(Double amountPaid) {
        this.amountPaid = amountPaid;
    }

    public String getIssueAgent() {
        return issueAgent;
    }

    public void setIssueAgent(String issueAgent) {
        this.issueAgent = issueAgent;
    }

    public String getReturnAgent() {
        return returnAgent;
    }

    public void setReturnAgent(String returnAgent) {
        this.returnAgent = returnAgent;
    }

    public Double getTotalMinutesUsed() {
        return totalMinutesUsed;
    }

    public void setTotalMinutesUsed(Double totalMinutesUsed) {
        this.totalMinutesUsed = totalMinutesUsed;
    }

    public int getSystem() {
        return system;
    }

    public void setSystem(int system) {
        this.system = system;
    }

    public boolean getIsFinished() {
        return isFinished;
    }

    public void setIsFinished(boolean isFinished) {
        this.isFinished = isFinished;
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
        if (!(object instanceof SystemLease)) {
            return false;
        }
        SystemLease other = (SystemLease) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bia.ccm.entity.SystemLease[id=" + id + "]";
    }

}
