/*
 * Contact.java
 *
 * Created on April 2, 2007, 8:50 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package com.abbt.crm.entity;

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
 * Entity class Contact
 * 
 * @author shannan
 */
@Entity
@Table(name = "contact")
@NamedQueries( {
        @NamedQuery(name = "Contact.findById", query = "SELECT c FROM Contact c WHERE c.id = :id"),
        @NamedQuery(name = "Contact.findByVersionId", query = "SELECT c FROM Contact c WHERE c.versionId = :versionId"),
        @NamedQuery(name = "Contact.findByFirstName", query = "SELECT c FROM Contact c WHERE c.firstName = :firstName"),
        @NamedQuery(name = "Contact.findByLastName", query = "SELECT c FROM Contact c WHERE c.lastName = :lastName"),
        @NamedQuery(name = "Contact.findByEmail", query = "SELECT c FROM Contact c WHERE c.email = :email"),
        @NamedQuery(name = "Contact.findByTitile", query = "SELECT c FROM Contact c WHERE c.titile = :titile"),
        @NamedQuery(name = "Contact.findByRating", query = "SELECT c FROM Contact c WHERE c.rating = :rating"),
        @NamedQuery(name = "Contact.findByCreationDate", query = "SELECT c FROM Contact c WHERE c.creationDate = :creationDate"),
        @NamedQuery(name = "Contact.findByCreatedUser", query = "SELECT c FROM Contact c WHERE c.createdUser = :createdUser"),
        @NamedQuery(name = "Contact.findByLastModifiedUser", query = "SELECT c FROM Contact c WHERE c.lastModifiedUser = :lastModifiedUser"),
        @NamedQuery(name = "Contact.findByLastModifiedDate", query = "SELECT c FROM Contact c WHERE c.lastModifiedDate = :lastModifiedDate"),
        @NamedQuery(name = "Contact.findByAccountId", query = "SELECT c FROM Contact c WHERE c.accountId = :accountId"),
        @NamedQuery(name = "Contact.findByContactId", query = "SELECT c FROM Contact c WHERE c.contactId = :contactId")
    })
public class Contact implements Serializable {

    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "versionId", nullable = false)
    private int versionId;

    @Column(name = "firstName", nullable = false)
    private String firstName;

    @Column(name = "lastName", nullable = false)
    private String lastName;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "titile", nullable = false)
    private String titile;

    @Column(name = "rating", nullable = false)
    private String rating;

    @Column(name = "creationDate", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date creationDate;

    @Column(name = "createdUser", nullable = false)
    private String createdUser;

    @Column(name = "lastModifiedUser", nullable = false)
    private String lastModifiedUser;

    @Column(name = "lastModifiedDate", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModifiedDate;

    @Column(name = "accountId", nullable = false)
    private String accountId;

    @Column(name = "contactId", nullable = false)
    private int contactId;

    /** Creates a new instance of Contact */
    public Contact() {
    }

    /**
     * Creates a new instance of Contact with the specified values.
     * @param id the id of the Contact
     */
    public Contact(Integer id) {
        this.id = id;
    }

    /**
     * Creates a new instance of Contact with the specified values.
     * @param id the id of the Contact
     * @param versionId the versionId of the Contact
     * @param firstName the firstName of the Contact
     * @param lastName the lastName of the Contact
     * @param email the email of the Contact
     * @param titile the titile of the Contact
     * @param rating the rating of the Contact
     * @param creationDate the creationDate of the Contact
     * @param createdUser the createdUser of the Contact
     * @param lastModifiedUser the lastModifiedUser of the Contact
     * @param lastModifiedDate the lastModifiedDate of the Contact
     * @param accountId the accountId of the Contact
     * @param contactId the contactId of the Contact
     */
    public Contact(Integer id, int versionId, String firstName, String lastName, String email, String titile, String rating, Date creationDate, String createdUser, String lastModifiedUser, Date lastModifiedDate, String accountId, int contactId) {
        this.id = id;
        this.versionId = versionId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.titile = titile;
        this.rating = rating;
        this.creationDate = creationDate;
        this.createdUser = createdUser;
        this.lastModifiedUser = lastModifiedUser;
        this.lastModifiedDate = lastModifiedDate;
        this.accountId = accountId;
        this.contactId = contactId;
    }

    /**
     * Gets the id of this Contact.
     * @return the id
     */
    public Integer getId() {
        return this.id;
    }

    /**
     * Sets the id of this Contact to the specified value.
     * @param id the new id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Gets the versionId of this Contact.
     * @return the versionId
     */
    public int getVersionId() {
        return this.versionId;
    }

    /**
     * Sets the versionId of this Contact to the specified value.
     * @param versionId the new versionId
     */
    public void setVersionId(int versionId) {
        this.versionId = versionId;
    }

    /**
     * Gets the firstName of this Contact.
     * @return the firstName
     */
    public String getFirstName() {
        return this.firstName;
    }

    /**
     * Sets the firstName of this Contact to the specified value.
     * @param firstName the new firstName
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Gets the lastName of this Contact.
     * @return the lastName
     */
    public String getLastName() {
        return this.lastName;
    }

    /**
     * Sets the lastName of this Contact to the specified value.
     * @param lastName the new lastName
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Gets the email of this Contact.
     * @return the email
     */
    public String getEmail() {
        return this.email;
    }

    /**
     * Sets the email of this Contact to the specified value.
     * @param email the new email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Gets the titile of this Contact.
     * @return the titile
     */
    public String getTitile() {
        return this.titile;
    }

    /**
     * Sets the titile of this Contact to the specified value.
     * @param titile the new titile
     */
    public void setTitile(String titile) {
        this.titile = titile;
    }

    /**
     * Gets the rating of this Contact.
     * @return the rating
     */
    public String getRating() {
        return this.rating;
    }

    /**
     * Sets the rating of this Contact to the specified value.
     * @param rating the new rating
     */
    public void setRating(String rating) {
        this.rating = rating;
    }

    /**
     * Gets the creationDate of this Contact.
     * @return the creationDate
     */
    public Date getCreationDate() {
        return this.creationDate;
    }

    /**
     * Sets the creationDate of this Contact to the specified value.
     * @param creationDate the new creationDate
     */
    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    /**
     * Gets the createdUser of this Contact.
     * @return the createdUser
     */
    public String getCreatedUser() {
        return this.createdUser;
    }

    /**
     * Sets the createdUser of this Contact to the specified value.
     * @param createdUser the new createdUser
     */
    public void setCreatedUser(String createdUser) {
        this.createdUser = createdUser;
    }

    /**
     * Gets the lastModifiedUser of this Contact.
     * @return the lastModifiedUser
     */
    public String getLastModifiedUser() {
        return this.lastModifiedUser;
    }

    /**
     * Sets the lastModifiedUser of this Contact to the specified value.
     * @param lastModifiedUser the new lastModifiedUser
     */
    public void setLastModifiedUser(String lastModifiedUser) {
        this.lastModifiedUser = lastModifiedUser;
    }

    /**
     * Gets the lastModifiedDate of this Contact.
     * @return the lastModifiedDate
     */
    public Date getLastModifiedDate() {
        return this.lastModifiedDate;
    }

    /**
     * Sets the lastModifiedDate of this Contact to the specified value.
     * @param lastModifiedDate the new lastModifiedDate
     */
    public void setLastModifiedDate(Date lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    /**
     * Gets the accountId of this Contact.
     * @return the accountId
     */
    public String getAccountId() {
        return this.accountId;
    }

    /**
     * Sets the accountId of this Contact to the specified value.
     * @param accountId the new accountId
     */
    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    /**
     * Gets the contactId of this Contact.
     * @return the contactId
     */
    public int getContactId() {
        return this.contactId;
    }

    /**
     * Sets the contactId of this Contact to the specified value.
     * @param contactId the new contactId
     */
    public void setContactId(int contactId) {
        this.contactId = contactId;
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
     * Determines whether another object is equal to this Contact.  The result is 
     * <code>true</code> if and only if the argument is not null and is a Contact object that 
     * has the same id field values as this object.
     * @param object the reference object with which to compare
     * @return <code>true</code> if this object is the same as the argument;
     * <code>false</code> otherwise.
     */
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Contact)) {
            return false;
        }
        Contact other = (Contact)object;
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
        return "com.abbt.crm.entity.Contact[id=" + id + "]";
    }

}
