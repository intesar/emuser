/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.bia.imec.entity;

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
@Table(name = "emails")
@NamedQueries({@NamedQuery(name = "Emails.findById", query = "SELECT e FROM Emails e WHERE e.id = :id"), @NamedQuery(name = "Emails.findByFrom", query = "SELECT e FROM Emails e WHERE e.from = :from"), @NamedQuery(name = "Emails.findByTo", query = "SELECT e FROM Emails e WHERE e.to = :to"), @NamedQuery(name = "Emails.findByCc", query = "SELECT e FROM Emails e WHERE e.cc = :cc"), @NamedQuery(name = "Emails.findByBcc", query = "SELECT e FROM Emails e WHERE e.bcc = :bcc"), @NamedQuery(name = "Emails.findBySubject", query = "SELECT e FROM Emails e WHERE e.subject = :subject"), @NamedQuery(name = "Emails.findByContextText", query = "SELECT e FROM Emails e WHERE e.contextText = :contextText"), @NamedQuery(name = "Emails.findByEmailDate", query = "SELECT e FROM Emails e WHERE e.emailDate = :emailDate"), @NamedQuery(name = "Emails.findByStatus", query = "SELECT e FROM Emails e WHERE e.status = :status"), @NamedQuery(name = "Emails.findByAgent", query = "SELECT e FROM Emails e WHERE e.agent = :agent"), @NamedQuery(name = "Emails.findByStatusDate", query = "SELECT e FROM Emails e WHERE e.statusDate = :statusDate"), @NamedQuery(name = "Emails.findByReplyOf", query = "SELECT e FROM Emails e WHERE e.replyOf = :replyOf")})
public class Emails implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;
    @Column(name = "_from")
    private String from;
    @Column(name = "_to")
    private String to;
    @Column(name = "cc")
    private String cc;
    @Column(name = "bcc")
    private String bcc;
    @Column(name = "_subject")
    private String subject;
    @Column(name = "context_text")
    private String contextText;
    @Column(name = "email_date")
    @Temporal(TemporalType.DATE)
    private Date emailDate;
    @Column(name = "_status")
    private String status;
    @Column(name = "agent")
    private String agent;
    @Column(name = "status_date")
    @Temporal(TemporalType.DATE)
    private Date statusDate;
    @Column(name = "reply_of")
    private Integer replyOf;

    public Emails() {
    }

    public Emails(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getCc() {
        return cc;
    }

    public void setCc(String cc) {
        this.cc = cc;
    }

    public String getBcc() {
        return bcc;
    }

    public void setBcc(String bcc) {
        this.bcc = bcc;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getContextText() {
        return contextText;
    }

    public void setContextText(String contextText) {
        this.contextText = contextText;
    }

    public Date getEmailDate() {
        return emailDate;
    }

    public void setEmailDate(Date emailDate) {
        this.emailDate = emailDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAgent() {
        return agent;
    }

    public void setAgent(String agent) {
        this.agent = agent;
    }

    public Date getStatusDate() {
        return statusDate;
    }

    public void setStatusDate(Date statusDate) {
        this.statusDate = statusDate;
    }

    public Integer getReplyOf() {
        return replyOf;
    }

    public void setReplyOf(Integer replyOf) {
        this.replyOf = replyOf;
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
        if (!(object instanceof Emails)) {
            return false;
        }
        Emails other = (Emails) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bia.imec.entity.Emails[id=" + id + "]";
    }

}
