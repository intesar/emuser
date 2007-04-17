/*
 * ContactedUsComments.java
 *
 * Created on April 16, 2007, 6:44 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package com.abbt.training.persistence;

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
 * Entity class ContactedUsComments
 * 
 * @author shannan
 */
@Entity
@Table(name = "contacted_us_comments")
@NamedQueries( {
        @NamedQuery(name = "ContactedUsComments.findById", query = "SELECT c FROM ContactedUsComments c WHERE c.id = :id"),
        @NamedQuery(name = "ContactedUsComments.findByContactEmail", query = "SELECT c FROM ContactedUsComments c WHERE c.contactEmail = :contactEmail"),
        @NamedQuery(name = "ContactedUsComments.findByComments", query = "SELECT c FROM ContactedUsComments c WHERE c.comments = :comments"),
        @NamedQuery(name = "ContactedUsComments.findByCreationDate", query = "SELECT c FROM ContactedUsComments c WHERE c.creationDate = :creationDate"),
        @NamedQuery(name = "ContactedUsComments.findByCreatedUser", query = "SELECT c FROM ContactedUsComments c WHERE c.createdUser = :createdUser")
    })
public class ContactedUsComments implements Serializable {

    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "contact_email", nullable = false)
    private String contactEmail;

    @Column(name = "comments", nullable = false)
    private String comments;

    @Column(name = "creationDate", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date creationDate;

    @Column(name = "createdUser", nullable = false)
    private String createdUser;

    /** Creates a new instance of ContactedUsComments */
    public ContactedUsComments() {
    }

    /**
     * Creates a new instance of ContactedUsComments with the specified values.
     * @param id the id of the ContactedUsComments
     */
    public ContactedUsComments(Integer id) {
        this.id = id;
    }

    /**
     * Creates a new instance of ContactedUsComments with the specified values.
     * @param id the id of the ContactedUsComments
     * @param contactEmail the contactEmail of the ContactedUsComments
     * @param comments the comments of the ContactedUsComments
     * @param creationDate the creationDate of the ContactedUsComments
     * @param createdUser the createdUser of the ContactedUsComments
     */
    public ContactedUsComments(Integer id, String contactEmail, String comments, Date creationDate, String createdUser) {
        this.id = id;
        this.contactEmail = contactEmail;
        this.comments = comments;
        this.creationDate = creationDate;
        this.createdUser = createdUser;
    }

    /**
     * Gets the id of this ContactedUsComments.
     * @return the id
     */
    public Integer getId() {
        return this.id;
    }

    /**
     * Sets the id of this ContactedUsComments to the specified value.
     * @param id the new id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Gets the contactEmail of this ContactedUsComments.
     * @return the contactEmail
     */
    public String getContactEmail() {
        return this.contactEmail;
    }

    /**
     * Sets the contactEmail of this ContactedUsComments to the specified value.
     * @param contactEmail the new contactEmail
     */
    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }

    /**
     * Gets the comments of this ContactedUsComments.
     * @return the comments
     */
    public String getComments() {
        return this.comments;
    }

    /**
     * Sets the comments of this ContactedUsComments to the specified value.
     * @param comments the new comments
     */
    public void setComments(String comments) {
        this.comments = comments;
    }

    /**
     * Gets the creationDate of this ContactedUsComments.
     * @return the creationDate
     */
    public Date getCreationDate() {
        return this.creationDate;
    }

    /**
     * Sets the creationDate of this ContactedUsComments to the specified value.
     * @param creationDate the new creationDate
     */
    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    /**
     * Gets the createdUser of this ContactedUsComments.
     * @return the createdUser
     */
    public String getCreatedUser() {
        return this.createdUser;
    }

    /**
     * Sets the createdUser of this ContactedUsComments to the specified value.
     * @param createdUser the new createdUser
     */
    public void setCreatedUser(String createdUser) {
        this.createdUser = createdUser;
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
     * Determines whether another object is equal to this ContactedUsComments.  The result is 
     * <code>true</code> if and only if the argument is not null and is a ContactedUsComments object that 
     * has the same id field values as this object.
     * @param object the reference object with which to compare
     * @return <code>true</code> if this object is the same as the argument;
     * <code>false</code> otherwise.
     */
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ContactedUsComments)) {
            return false;
        }
        ContactedUsComments other = (ContactedUsComments)object;
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
        return "com.abbt.training.persistence.ContactedUsComments[id=" + id + "]";
    }

}
