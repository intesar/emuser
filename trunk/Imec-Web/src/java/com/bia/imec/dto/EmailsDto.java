/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bia.imec.dto;

import java.util.Date;

/**
 *
 * @author imran
 */
public class EmailsDto {

    private Integer id;
    private String from;
    private String to;
    private String cc;
    private String bcc;
    private String subject;
    private String contextText;

    public String getAgent() {
        return agent;
    }

    public void setAgent(String agent) {
        this.agent = agent;
    }

    public String getBcc() {
        return bcc;
    }

    public void setBcc(String bcc) {
        this.bcc = bcc;
    }

    public String getCc() {
        return cc;
    }

    public void setCc(String cc) {
        this.cc = cc;
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

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getReplyOf() {
        return replyOf;
    }

    public void setReplyOf(Integer replyOf) {
        this.replyOf = replyOf;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getStatusDate() {
        return statusDate;
    }

    public void setStatusDate(Date statusDate) {
        this.statusDate = statusDate;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }
    private Date emailDate;
    private String status;
    private String agent;
    private Date statusDate;
    private Integer replyOf;
}
