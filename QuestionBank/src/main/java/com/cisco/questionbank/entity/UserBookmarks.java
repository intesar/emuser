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
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author inmohamm
 */
@Entity
@Table(name = "user_bookmarks", catalog = "question_bank", schema = "")
@NamedQueries({@NamedQuery(name = "UserBookmarks.findAll", query = "SELECT u FROM UserBookmarks u"), @NamedQuery(name = "UserBookmarks.findById", query = "SELECT u FROM UserBookmarks u WHERE u.id = :id"), @NamedQuery(name = "UserBookmarks.findByUser", query = "SELECT u FROM UserBookmarks u WHERE u.user = :user"), @NamedQuery(name = "UserBookmarks.findByCreateDate", query = "SELECT u FROM UserBookmarks u WHERE u.createDate = :createDate")})
public class UserBookmarks implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Basic(optional = false)
    @Column(name = "user", nullable = false, length = 45)
    private String user;
    @Basic(optional = false)
    @Column(name = "create_date", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;
    @JoinColumn(name = "question_id", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private Question questionId;

    public UserBookmarks() {
    }

    public UserBookmarks(Integer id) {
        this.id = id;
    }

    public UserBookmarks(Integer id, String user, Date createDate) {
        this.id = id;
        this.user = user;
        this.createDate = createDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
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
        if (!(object instanceof UserBookmarks)) {
            return false;
        }
        UserBookmarks other = (UserBookmarks) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.cisco.questionbank.entity.UserBookmarks[id=" + id + "]";
    }

    @PrePersist
    public void prePersist() {
        setCreateDate(new Date());
    }
}
