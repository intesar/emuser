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
@Table(name = "question_rank", catalog = "question_bank", schema = "")
@NamedQueries({@NamedQuery(name = "QuestionRank.findAll", query = "SELECT q FROM QuestionRank q"), @NamedQuery(name = "QuestionRank.findById", query = "SELECT q FROM QuestionRank q WHERE q.id = :id"), @NamedQuery(name = "QuestionRank.findByRankedUser", query = "SELECT q FROM QuestionRank q WHERE q.rankedUser = :rankedUser"), @NamedQuery(name = "QuestionRank.findByRankDate", query = "SELECT q FROM QuestionRank q WHERE q.rankDate = :rankDate")})
public class QuestionRank implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Basic(optional = false)
    @Column(name = "ranked_user", nullable = false, length = 45)
    private String rankedUser;
    @Basic(optional = false)
    @Column(name = "rank_date", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date rankDate;
    @JoinColumn(name = "question_id", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private Question questionId;

    public QuestionRank() {
    }

    public QuestionRank(Integer id) {
        this.id = id;
    }

    public QuestionRank(Integer id, String rankedUser, Date rankDate) {
        this.id = id;
        this.rankedUser = rankedUser;
        this.rankDate = rankDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRankedUser() {
        return rankedUser;
    }

    public void setRankedUser(String rankedUser) {
        this.rankedUser = rankedUser;
    }

    public Date getRankDate() {
        return rankDate;
    }

    public void setRankDate(Date rankDate) {
        this.rankDate = rankDate;
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
        if (!(object instanceof QuestionRank)) {
            return false;
        }
        QuestionRank other = (QuestionRank) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.cisco.questionbank.entity.QuestionRank[id=" + id + "]";
    }

}
