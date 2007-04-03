/*
 * Faq.java
 *
 * Created on April 2, 2007, 10:11 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package com.abbt.crm.base.entity;

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
 * Entity class Faq
 * 
 * @author shannan
 */
@Entity
@Table(name = "faq")
@NamedQueries( {
        @NamedQuery(name = "Faq.findById", query = "SELECT f FROM Faq f WHERE f.id = :id"),
        @NamedQuery(name = "Faq.findByVersionId", query = "SELECT f FROM Faq f WHERE f.versionId = :versionId"),
        @NamedQuery(name = "Faq.findByQuestion", query = "SELECT f FROM Faq f WHERE f.question = :question"),
        @NamedQuery(name = "Faq.findByAnswer", query = "SELECT f FROM Faq f WHERE f.answer = :answer"),
        @NamedQuery(name = "Faq.findByType", query = "SELECT f FROM Faq f WHERE f.type = :type"),
        @NamedQuery(name = "Faq.findByCreationDate", query = "SELECT f FROM Faq f WHERE f.creationDate = :creationDate"),
        @NamedQuery(name = "Faq.findByCreatedUser", query = "SELECT f FROM Faq f WHERE f.createdUser = :createdUser"),
        @NamedQuery(name = "Faq.findByLastModifiedDate", query = "SELECT f FROM Faq f WHERE f.lastModifiedDate = :lastModifiedDate"),
        @NamedQuery(name = "Faq.findByLastModifiedUser", query = "SELECT f FROM Faq f WHERE f.lastModifiedUser = :lastModifiedUser")
    })
public class Faq implements Serializable {

    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "versionId", nullable = false)
    private int versionId;

    @Column(name = "question", nullable = false)
    private String question;

    @Column(name = "answer", nullable = false)
    private String answer;

    @Column(name = "type", nullable = false)
    private String type;

    @Column(name = "creationDate", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date creationDate;

    @Column(name = "createdUser", nullable = false)
    private String createdUser;

    @Column(name = "lastModifiedDate", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModifiedDate;

    @Column(name = "lastModifiedUser", nullable = false)
    private String lastModifiedUser;

    /** Creates a new instance of Faq */
    public Faq() {
    }

    /**
     * Creates a new instance of Faq with the specified values.
     * @param id the id of the Faq
     */
    public Faq(Integer id) {
        this.id = id;
    }

    /**
     * Creates a new instance of Faq with the specified values.
     * @param id the id of the Faq
     * @param versionId the versionId of the Faq
     * @param question the question of the Faq
     * @param answer the answer of the Faq
     * @param type the type of the Faq
     * @param creationDate the creationDate of the Faq
     * @param createdUser the createdUser of the Faq
     * @param lastModifiedDate the lastModifiedDate of the Faq
     * @param lastModifiedUser the lastModifiedUser of the Faq
     */
    public Faq(Integer id, int versionId, String question, String answer, String type, Date creationDate, String createdUser, Date lastModifiedDate, String lastModifiedUser) {
        this.id = id;
        this.versionId = versionId;
        this.question = question;
        this.answer = answer;
        this.type = type;
        this.creationDate = creationDate;
        this.createdUser = createdUser;
        this.lastModifiedDate = lastModifiedDate;
        this.lastModifiedUser = lastModifiedUser;
    }

    /**
     * Gets the id of this Faq.
     * @return the id
     */
    public Integer getId() {
        return this.id;
    }

    /**
     * Sets the id of this Faq to the specified value.
     * @param id the new id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Gets the versionId of this Faq.
     * @return the versionId
     */
    public int getVersionId() {
        return this.versionId;
    }

    /**
     * Sets the versionId of this Faq to the specified value.
     * @param versionId the new versionId
     */
    public void setVersionId(int versionId) {
        this.versionId = versionId;
    }

    /**
     * Gets the question of this Faq.
     * @return the question
     */
    public String getQuestion() {
        return this.question;
    }

    /**
     * Sets the question of this Faq to the specified value.
     * @param question the new question
     */
    public void setQuestion(String question) {
        this.question = question;
    }

    /**
     * Gets the answer of this Faq.
     * @return the answer
     */
    public String getAnswer() {
        return this.answer;
    }

    /**
     * Sets the answer of this Faq to the specified value.
     * @param answer the new answer
     */
    public void setAnswer(String answer) {
        this.answer = answer;
    }

    /**
     * Gets the type of this Faq.
     * @return the type
     */
    public String getType() {
        return this.type;
    }

    /**
     * Sets the type of this Faq to the specified value.
     * @param type the new type
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * Gets the creationDate of this Faq.
     * @return the creationDate
     */
    public Date getCreationDate() {
        return this.creationDate;
    }

    /**
     * Sets the creationDate of this Faq to the specified value.
     * @param creationDate the new creationDate
     */
    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    /**
     * Gets the createdUser of this Faq.
     * @return the createdUser
     */
    public String getCreatedUser() {
        return this.createdUser;
    }

    /**
     * Sets the createdUser of this Faq to the specified value.
     * @param createdUser the new createdUser
     */
    public void setCreatedUser(String createdUser) {
        this.createdUser = createdUser;
    }

    /**
     * Gets the lastModifiedDate of this Faq.
     * @return the lastModifiedDate
     */
    public Date getLastModifiedDate() {
        return this.lastModifiedDate;
    }

    /**
     * Sets the lastModifiedDate of this Faq to the specified value.
     * @param lastModifiedDate the new lastModifiedDate
     */
    public void setLastModifiedDate(Date lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    /**
     * Gets the lastModifiedUser of this Faq.
     * @return the lastModifiedUser
     */
    public String getLastModifiedUser() {
        return this.lastModifiedUser;
    }

    /**
     * Sets the lastModifiedUser of this Faq to the specified value.
     * @param lastModifiedUser the new lastModifiedUser
     */
    public void setLastModifiedUser(String lastModifiedUser) {
        this.lastModifiedUser = lastModifiedUser;
    }

    /**
     * Returns a hash code value for the object.  This implementation computes 
     * a hash code value based on the id fields in this object.
     * @return a hash code value for this object.
     */
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (this.id != null ? this.id.hashCode() : 0);
        return hash;
    }

    /**
     * Determines whether another object is equal to this Faq.  The result is 
     * <code>true</code> if and only if the argument is not null and is a Faq object that 
     * has the same id field values as this object.
     * @param object the reference object with which to compare
     * @return <code>true</code> if this object is the same as the argument;
     * <code>false</code> otherwise.
     */
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Faq)) {
            return false;
        }
        Faq other = (Faq)object;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) return false;
        return true;
    }

    /**
     * Returns a string representation of the object.  This implementation constructs 
     * that representation based on the id fields.
     * @return a string representation of the object.
     */
    @Override
    public String toString() {
        return "com.abbt.crm.base.entity.Faq[id=" + id + "]";
    }

}
