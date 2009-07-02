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
@Table(name = "question_comment", catalog = "question_bank", schema = "")
@NamedQueries({@NamedQuery(name = "QuestionComment.findAll", query = "SELECT q FROM QuestionComment q"), @NamedQuery(name = "QuestionComment.findById", query = "SELECT q FROM QuestionComment q WHERE q.id = :id"), @NamedQuery(name = "QuestionComment.findByCommentedUser", query = "SELECT q FROM QuestionComment q WHERE q.commentedUser = :commentedUser"), @NamedQuery(name = "QuestionComment.findByCommentDate", query = "SELECT q FROM QuestionComment q WHERE q.commentDate = :commentDate")})
public class QuestionComment implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Basic(optional = false)
    @Lob
    @Column(name = "comment_text", nullable = false, length = 65535)
    private String commentText;
    @Basic(optional = false)
    @Column(name = "commented_user", nullable = false, length = 45)
    private String commentedUser;
    @Basic(optional = false)
    @Column(name = "comment_date", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date commentDate;
    @JoinColumn(name = "question_id", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private Question questionId;

    public QuestionComment() {
    }

    public QuestionComment(Integer id) {
        this.id = id;
    }

    public QuestionComment(Integer id, String commentText, String commentedUser, Date commentDate) {
        this.id = id;
        this.commentText = commentText;
        this.commentedUser = commentedUser;
        this.commentDate = commentDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCommentText() {
        return commentText;
    }

    public void setCommentText(String commentText) {
        this.commentText = commentText;
    }

    public String getCommentedUser() {
        return commentedUser;
    }

    public void setCommentedUser(String commentedUser) {
        this.commentedUser = commentedUser;
    }

    public Date getCommentDate() {
        return commentDate;
    }

    public void setCommentDate(Date commentDate) {
        this.commentDate = commentDate;
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
        if (!(object instanceof QuestionComment)) {
            return false;
        }
        QuestionComment other = (QuestionComment) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.cisco.questionbank.entity.QuestionComment[id=" + id + "]";
    }

}
