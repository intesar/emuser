/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.cisco.questionbank.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author inmohamm
 */
@Entity
@Table(name = "question", catalog = "question_bank", schema = "")
@NamedQueries({
    @NamedQuery(name = "Question.findAll", query = "SELECT q FROM Question q"),
    @NamedQuery(name = "Question.findById", query = "SELECT q FROM Question q WHERE q.id = :id"),
    @NamedQuery(name = "Question.findByCreateDate", query = "SELECT q FROM Question q WHERE q.createDate = :createDate"),
    @NamedQuery(name = "Question.findByModifiedDate", query = "SELECT q FROM Question q WHERE q.modifiedDate = :modifiedDate"),
    @NamedQuery(name = "Question.findByCreatedBy", query = "SELECT q FROM Question q WHERE q.createdBy = :createdBy"),
    @NamedQuery(name = "Question.findByRank", query = "SELECT q FROM Question q WHERE q.rank = :rank"),
    @NamedQuery(name = "Question.findByIsDeleted", query = "SELECT q FROM Question q WHERE q.isDeleted = :isDeleted")
})
public class Question implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Basic(optional = false)
    @Lob
    @Column(name = "question_text", nullable = false, length = 65535)
    private String questionText;
    @Basic(optional = false)
    @Lob
    @Column(name = "correct_choice", nullable = false, length = 65535)
    private String correctChoice;
    @Lob
    @Column(name = "incorrect_choice_1", length = 65535)
    private String incorrectChoice1;
    @Lob
    @Column(name = "incorrect_choice_2", length = 65535)
    private String incorrectChoice2;
    @Lob
    @Column(name = "incorrect_choice_3", length = 65535)
    private String incorrectChoice3;
    @Lob
    @Column(name = "explanation", length = 65535)
    private String explanation;
    @Basic(optional = false)
    @Column(name = "create_date", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;
    @Basic(optional = false)
    @Column(name = "modified_date", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifiedDate;
    @Basic(optional = false)
    @Column(name = "created_by", nullable = false, length = 45)
    private String createdBy;
    @Basic(optional = false)
    @Column(name = "rank", nullable = false)
    private int rank;
    @Basic(optional = false)
    @Column(name = "is_deleted", nullable = false)
    private short isDeleted;
    @Lob
    @Column(name = "delete_reason", length = 65535)
    private String deleteReason;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "questionId")
    private List<QuestionTag> questionTagList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "questionId")
    private List<QuestionComment> questionCommentList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "questionId")
    private List<QuestionRank> questionRankList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "questionId")
    private List<QuestionDuplicate> questionDuplicateList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "questionId")
    private List<UserBookmarks> userBookmarksList;

    public Question() {
    }

    public Question(Integer id) {
        this.id = id;
    }

    public Question(Integer id, String questionText, String correctChoice, Date createDate, Date modifiedDate, String createdBy, int rank, short isDeleted) {
        this.id = id;
        this.questionText = questionText;
        this.correctChoice = correctChoice;
        this.createDate = createDate;
        this.modifiedDate = modifiedDate;
        this.createdBy = createdBy;
        this.rank = rank;
        this.isDeleted = isDeleted;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getQuestionText() {
        return questionText;
    }

    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }

    public String getCorrectChoice() {
        return correctChoice;
    }

    public void setCorrectChoice(String correctChoice) {
        this.correctChoice = correctChoice;
    }

    public String getIncorrectChoice1() {
        return incorrectChoice1;
    }

    public void setIncorrectChoice1(String incorrectChoice1) {
        this.incorrectChoice1 = incorrectChoice1;
    }

    public String getIncorrectChoice2() {
        return incorrectChoice2;
    }

    public void setIncorrectChoice2(String incorrectChoice2) {
        this.incorrectChoice2 = incorrectChoice2;
    }

    public String getIncorrectChoice3() {
        return incorrectChoice3;
    }

    public void setIncorrectChoice3(String incorrectChoice3) {
        this.incorrectChoice3 = incorrectChoice3;
    }

    public String getExplanation() {
        return explanation;
    }

    public void setExplanation(String explanation) {
        this.explanation = explanation;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public short getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(short isDeleted) {
        this.isDeleted = isDeleted;
    }

    public String getDeleteReason() {
        return deleteReason;
    }

    public void setDeleteReason(String deleteReason) {
        this.deleteReason = deleteReason;
    }

    public List<QuestionTag> getQuestionTagList() {
        return questionTagList;
    }

    public void setQuestionTagList(List<QuestionTag> questionTagList) {
        this.questionTagList = questionTagList;
    }

    public List<QuestionComment> getQuestionCommentList() {
        return questionCommentList;
    }

    public void setQuestionCommentList(List<QuestionComment> questionCommentList) {
        this.questionCommentList = questionCommentList;
    }

    public List<QuestionRank> getQuestionRankList() {
        return questionRankList;
    }

    public void setQuestionRankList(List<QuestionRank> questionRankList) {
        this.questionRankList = questionRankList;
    }

    public List<QuestionDuplicate> getQuestionDuplicateList() {
        return questionDuplicateList;
    }

    public void setQuestionDuplicateList(List<QuestionDuplicate> questionDuplicateList) {
        this.questionDuplicateList = questionDuplicateList;
    }

    public List<UserBookmarks> getUserBookmarksList() {
        return userBookmarksList;
    }

    public void setUserBookmarksList(List<UserBookmarks> userBookmarksList) {
        this.userBookmarksList = userBookmarksList;
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
        if (!(object instanceof Question)) {
            return false;
        }
        Question other = (Question) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.cisco.questionbank.entity.Question[id=" + id + "]";
    }

    @PrePersist
    public void prePersist() {
        setCreateDate(new Date());
        setModifiedDate(new Date());
    }

    @PreUpdate
    public void preUpdate() {
        setModifiedDate(new Date());
    }

}
