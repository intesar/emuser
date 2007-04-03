/*
 * Lead.java
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
 * Entity class Lead
 * 
 * @author shannan
 */
@Entity
@Table(name = "lead")
@NamedQueries( {
        @NamedQuery(name = "Lead.findById", query = "SELECT l FROM Lead l WHERE l.id = :id"),
        @NamedQuery(name = "Lead.findByVersionId", query = "SELECT l FROM Lead l WHERE l.versionId = :versionId"),
        @NamedQuery(name = "Lead.findByFirstName", query = "SELECT l FROM Lead l WHERE l.firstName = :firstName"),
        @NamedQuery(name = "Lead.findByLastName", query = "SELECT l FROM Lead l WHERE l.lastName = :lastName"),
        @NamedQuery(name = "Lead.findByEmail", query = "SELECT l FROM Lead l WHERE l.email = :email"),
        @NamedQuery(name = "Lead.findByCompany", query = "SELECT l FROM Lead l WHERE l.company = :company"),
        @NamedQuery(name = "Lead.findByWebsite", query = "SELECT l FROM Lead l WHERE l.website = :website"),
        @NamedQuery(name = "Lead.findByDescription", query = "SELECT l FROM Lead l WHERE l.description = :description"),
        @NamedQuery(name = "Lead.findByTitle", query = "SELECT l FROM Lead l WHERE l.title = :title"),
        @NamedQuery(name = "Lead.findByCreationDate", query = "SELECT l FROM Lead l WHERE l.creationDate = :creationDate"),
        @NamedQuery(name = "Lead.findByCreatedUser", query = "SELECT l FROM Lead l WHERE l.createdUser = :createdUser"),
        @NamedQuery(name = "Lead.findByLastModifiedUser", query = "SELECT l FROM Lead l WHERE l.lastModifiedUser = :lastModifiedUser"),
        @NamedQuery(name = "Lead.findByLastModifiedDate", query = "SELECT l FROM Lead l WHERE l.lastModifiedDate = :lastModifiedDate")
    })
public class Lead implements Serializable {

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

    @Column(name = "company", nullable = false)
    private String company;

    @Column(name = "website", nullable = false)
    private String website;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "title", nullable = false)
    private String title;

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

    /** Creates a new instance of Lead */
    public Lead() {
    }

    /**
     * Creates a new instance of Lead with the specified values.
     * @param id the id of the Lead
     */
    public Lead(Integer id) {
        this.id = id;
    }

    /**
     * Creates a new instance of Lead with the specified values.
     * @param id the id of the Lead
     * @param versionId the versionId of the Lead
     * @param firstName the firstName of the Lead
     * @param lastName the lastName of the Lead
     * @param email the email of the Lead
     * @param company the company of the Lead
     * @param website the website of the Lead
     * @param description the description of the Lead
     * @param title the title of the Lead
     * @param creationDate the creationDate of the Lead
     * @param createdUser the createdUser of the Lead
     * @param lastModifiedUser the lastModifiedUser of the Lead
     * @param lastModifiedDate the lastModifiedDate of the Lead
     */
    public Lead(Integer id, int versionId, String firstName, String lastName, String email, String company, String website, String description, String title, Date creationDate, String createdUser, String lastModifiedUser, Date lastModifiedDate) {
        this.id = id;
        this.versionId = versionId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.company = company;
        this.website = website;
        this.description = description;
        this.title = title;
        this.creationDate = creationDate;
        this.createdUser = createdUser;
        this.lastModifiedUser = lastModifiedUser;
        this.lastModifiedDate = lastModifiedDate;
    }

    /**
     * Gets the id of this Lead.
     * @return the id
     */
    public Integer getId() {
        return this.id;
    }

    /**
     * Sets the id of this Lead to the specified value.
     * @param id the new id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Gets the versionId of this Lead.
     * @return the versionId
     */
    public int getVersionId() {
        return this.versionId;
    }

    /**
     * Sets the versionId of this Lead to the specified value.
     * @param versionId the new versionId
     */
    public void setVersionId(int versionId) {
        this.versionId = versionId;
    }

    /**
     * Gets the firstName of this Lead.
     * @return the firstName
     */
    public String getFirstName() {
        return this.firstName;
    }

    /**
     * Sets the firstName of this Lead to the specified value.
     * @param firstName the new firstName
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Gets the lastName of this Lead.
     * @return the lastName
     */
    public String getLastName() {
        return this.lastName;
    }

    /**
     * Sets the lastName of this Lead to the specified value.
     * @param lastName the new lastName
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Gets the email of this Lead.
     * @return the email
     */
    public String getEmail() {
        return this.email;
    }

    /**
     * Sets the email of this Lead to the specified value.
     * @param email the new email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Gets the company of this Lead.
     * @return the company
     */
    public String getCompany() {
        return this.company;
    }

    /**
     * Sets the company of this Lead to the specified value.
     * @param company the new company
     */
    public void setCompany(String company) {
        this.company = company;
    }

    /**
     * Gets the website of this Lead.
     * @return the website
     */
    public String getWebsite() {
        return this.website;
    }

    /**
     * Sets the website of this Lead to the specified value.
     * @param website the new website
     */
    public void setWebsite(String website) {
        this.website = website;
    }

    /**
     * Gets the description of this Lead.
     * @return the description
     */
    public String getDescription() {
        return this.description;
    }

    /**
     * Sets the description of this Lead to the specified value.
     * @param description the new description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Gets the title of this Lead.
     * @return the title
     */
    public String getTitle() {
        return this.title;
    }

    /**
     * Sets the title of this Lead to the specified value.
     * @param title the new title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Gets the creationDate of this Lead.
     * @return the creationDate
     */
    public Date getCreationDate() {
        return this.creationDate;
    }

    /**
     * Sets the creationDate of this Lead to the specified value.
     * @param creationDate the new creationDate
     */
    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    /**
     * Gets the createdUser of this Lead.
     * @return the createdUser
     */
    public String getCreatedUser() {
        return this.createdUser;
    }

    /**
     * Sets the createdUser of this Lead to the specified value.
     * @param createdUser the new createdUser
     */
    public void setCreatedUser(String createdUser) {
        this.createdUser = createdUser;
    }

    /**
     * Gets the lastModifiedUser of this Lead.
     * @return the lastModifiedUser
     */
    public String getLastModifiedUser() {
        return this.lastModifiedUser;
    }

    /**
     * Sets the lastModifiedUser of this Lead to the specified value.
     * @param lastModifiedUser the new lastModifiedUser
     */
    public void setLastModifiedUser(String lastModifiedUser) {
        this.lastModifiedUser = lastModifiedUser;
    }

    /**
     * Gets the lastModifiedDate of this Lead.
     * @return the lastModifiedDate
     */
    public Date getLastModifiedDate() {
        return this.lastModifiedDate;
    }

    /**
     * Sets the lastModifiedDate of this Lead to the specified value.
     * @param lastModifiedDate the new lastModifiedDate
     */
    public void setLastModifiedDate(Date lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
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
     * Determines whether another object is equal to this Lead.  The result is 
     * <code>true</code> if and only if the argument is not null and is a Lead object that 
     * has the same id field values as this object.
     * @param object the reference object with which to compare
     * @return <code>true</code> if this object is the same as the argument;
     * <code>false</code> otherwise.
     */
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Lead)) {
            return false;
        }
        Lead other = (Lead)object;
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
        return "com.abbt.crm.entity.Lead[id=" + id + "]";
    }

}
