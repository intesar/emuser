/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.cisco.questionbank.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author inmohamm
 */
@Entity
@Table(name = "question_duplicate", catalog = "question_bank", schema = "")
@NamedQueries({@NamedQuery(name = "QuestionDuplicate.findAll", query = "SELECT q FROM QuestionDuplicate q"), @NamedQuery(name = "QuestionDuplicate.findById", query = "SELECT q FROM QuestionDuplicate q WHERE q.id = :id"), @NamedQuery(name = "QuestionDuplicate.findByIdentifiedUser", query = "SELECT q FROM QuestionDuplicate q WHERE q.identifiedUser = :identifiedUser"), @NamedQuery(name = "QuestionDuplicate.findByCreateDate", query = "SELECT q FROM QuestionDuplicate q WHERE q.createDate = :createDate")})
public class QuestionDuplicate implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Basic(optional = false)
    @Column(name = "identified_user", nullable = false, length = 45)
    private String identifiedUser;
    @Basic(optional = false)
    @Lob
    @Column(name = "duplicate_to", nullable = false, length = 65535)
    private String duplicateTo;
    @Basic(optional = false)
    @Column(name = "create_date", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;
    @JoinColumn(name = "question_id", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private Question questionId;

    public QuestionDuplicate() {
    }

    public QuestionDuplicate(Integer id) {
        this.id = id;
    }

    public QuestionDuplicate(Integer id, String identifiedUser, String duplicateTo, Date createDate) {
        this.id = id;
        this.identifiedUser = identifiedUser;
        this.duplicateTo = duplicateTo;
        this.createDate = createDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIdentifiedUser() {
        return identifiedUser;
    }

    public void setIdentifiedUser(String identifiedUser) {
        this.identifiedUser = identifiedUser;
    }

    public String getDuplicateTo() {
        return duplicateTo;
    }

    public void setDuplicateTo(String duplicateTo) {
        this.duplicateTo = duplicateTo;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Question getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Question questionId) {
        this.questionId = questionId;
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
        if (!(object instanceof QuestionDuplicate)) {
            return false;
        }
        QuestionDuplicate other = (QuestionDuplicate) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.cisco.questionbank.entity.QuestionDuplicate[id=" + id + "]";
    }

}
